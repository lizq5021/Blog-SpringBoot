package com.songhaozhi.mayday.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.generator.MusicMapper;
import com.songhaozhi.mayday.model.domain.Music;
import com.songhaozhi.mayday.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Auther: 李志强
 * @Date: 2019/4/14 04:14
 * @Description: 音乐控制层
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class MusciServiceImpl implements MusicService {

    /**
     * 缓存的名称
     */
    private static final String MUSIC_CACHE_NAME = "musics";

    /**
     * 前端页面查询缓存的key
     */
    private static final String MUSIC_CACHE_KEY = "'musicAll'";

    /**
     * 歌曲链接前缀
     */
    private static final String MUSIC_URL = "http://music.163.com/song/media/outer/url?id=";

    @Autowired
    private MusicMapper musicMapper;

    @Override
    @Cacheable(value = MUSIC_CACHE_NAME, key = "'findMusic'+ #page + #limit")
    public PageInfo<Music> findMusics(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Music> list = musicMapper.findMusics();
        return new PageInfo<Music>(list);
    }

    @Override
    @CacheEvict(value = MUSIC_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void save(Music music) {
        Date date = new Date();
        //拼接歌曲地址
        music.setmUrl(this.MUSIC_URL + music.getmUrl());
        music.setCreateTime(date);
        music.setUpdateTime(date);
        musicMapper.save(music);
    }

    @Override
    @CacheEvict(value = MUSIC_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void update(Music music) {
        music.setUpdateTime(new Date());
        int num = musicMapper.updateById(music);
    }

    @Override
    @Cacheable(value = MUSIC_CACHE_NAME, key = MUSIC_CACHE_KEY)
    public List<Music> findAll() {
        List<Music> list = musicMapper.findMusics();
        return list;
    }

    @Override
    public Music findOneById(Integer mId) {
        Music music = musicMapper.findOneById(mId);
        return music;
    }

    @Override
    @CacheEvict(value = MUSIC_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void removeById(Integer mId) {
        int num = musicMapper.removeById(mId);
    }
}
