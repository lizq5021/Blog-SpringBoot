package com.songhaozhi.mayday.service;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Music;

import java.util.List;

/**
 * @version 1.0
 * @Auther: 李志强
 * @Date: 2019/4/14 04:05
 * @Description:
 */
public interface MusicService {
    /**
     * Description:分页查询音乐列表
     * @auther: 李志强
     * @param: [page, limit]
     * @return: com.github.pagehelper.PageInfo<com.songhaozhi.mayday.model.domain.Music>
     * @date: 2019/4/14 4:08
     */
    public PageInfo<Music> findMusics(int page, int limit);

    /**
     * Description: 保存功能
     * @auther: 李志强
     * @param: [music]
     * @return: void
     * @date: 2019/4/14 17:06
     */
    public void save(Music music);

    /**
     * Description: 修改功能
     * @auther: 李志强
     * @param: [music]
     * @return: void
     * @date: 2019/4/14 17:07
     */
    public void update(Music music);

    /**
     * Description: 查询所有音乐
     * @auther: 李志强
     * @param: []
     * @return: java.util.List<com.songhaozhi.mayday.model.domain.Music>
     * @date: 2019/4/14 22:07
     */
    public List<Music> findAll();

    /**
     * Description: 根据id查询
     * @auther: 李志强
     * @param: [mId]
     * @return: com.songhaozhi.mayday.model.domain.Music
     * @date: 2019/4/15 0:08
     */
    public Music findOneById(Integer mId);

    /**
     * Description: 根据id删除
     * @auther: 李志强
     * @param: [mId]
     * @return: void
     * @date: 2019/4/15 0:10
     */
    public void removeById(Integer mId);
}
