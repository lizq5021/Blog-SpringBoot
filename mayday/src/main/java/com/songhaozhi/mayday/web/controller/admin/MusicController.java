package com.songhaozhi.mayday.web.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.domain.Music;
import com.songhaozhi.mayday.model.domain.Theme;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.MusicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Auther: 李志强
 * @Date: 2019/4/14 03:33
 * @Description:
 */
@RequestMapping(value = "/admin/music")
@Controller
public class MusicController extends BaseController {

    @Autowired
    private MusicService musicService;

    /**
     * Description:分页查询
     *
     * @auther: 李志强
     * @param: [model, page, limit, status]
     * @return: java.lang.String
     * @date: 2019/4/14 3:37
     */
    @GetMapping
    public String findMusics(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "limit", defaultValue = "10") int limi) {
        PageInfo<Music> pageInfo = musicService.findMusics(page, limi);
        model.addAttribute("musics", pageInfo);
        return "admin/admin_music";
    }

    /**
     * Description: 修改、保存音乐
     *
     * @auther: 李志强
     * @param: [music, request]
     * @return: com.songhaozhi.mayday.model.dto.JsonResult
     * @date: 2019/4/14 21:57
     */
    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Music music, HttpServletRequest request) {
        try {
            //如果id是null说明是保存
            if (music.getmId() == null) {
                musicService.save(music);
            } else {
                musicService.update(music);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(), MaydayEnums.PRESERVE_ERROR.getMessage());
        }
        return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
    }

    /**
     * Description: 根据id查询一个
     *
     * @auther: 李志强
     * @param: [mId]
     * @return: com.songhaozhi.mayday.model.dto.JsonResult
     * @date: 2019/4/15 0:25
     */
    @GetMapping(value = "edit")
    @ResponseBody
    public JsonResult edit(int mId) {
        Music music = musicService.findOneById(mId);
        return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), music);
    }

    /**
     * Description: 根据id删除
     *
     * @auther: 李志强
     * @param: [mId]
     * @return: java.lang.String
     * @date: 2019/4/15 1:41
     */
    @GetMapping(value = "remove")
    public String remove(int mId) {
        try {
            musicService.removeById(mId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/admin/music";
    }
}
