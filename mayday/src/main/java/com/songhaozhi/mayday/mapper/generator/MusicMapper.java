package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @Auther: 李志强
 * @Date: 2019/4/14 04:17
 * @Description:
 */
@Repository
public interface MusicMapper {
    /**
     * Description: 查询所有
     *
     * @auther: 李志强
     * @param: []
     * @return: java.util.List<com.songhaozhi.mayday.model.domain.Music>
     * @date: 2019/4/14 4:26
     */
    public List<Music> findMusics();

    /**
     * Description: 保存音乐
     *
     * @auther: 李志强
     * @param: [music]
     * @return: int
     * @date: 2019/4/14 17:13
     */
    public int save(Music music);

    /**
     * Description:根据id查询
     *
     * @auther: 李志强
     * @param: [id]
     * @return: com.songhaozhi.mayday.model.domain.Music
     * @date: 2019/4/15 0:11
     */
    public Music findOneById(Integer id);

    /**
     * Description: 根据id删除
     * @auther: 李志强
     * @param: [id]
     * @return: int
     * @date: 2019/4/15 0:12
     */
    public int removeById(Integer id);

    /**
     * Description: 根据id修改
     * @auther: 李志强
     * @param: [music]
     * @return: int
     * @date: 2019/4/15 0:44
     */
    public int updateById(Music music);
}
