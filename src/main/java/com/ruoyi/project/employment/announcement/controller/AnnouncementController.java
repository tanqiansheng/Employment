package com.ruoyi.project.employment.announcement.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.announcement.domain.Announcement;
import com.ruoyi.project.employment.announcement.service.IAnnouncementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通知公告Controller
 * 
 * @author June
 * @date 2020-11-20
 */
@Controller
@RequestMapping("/employment/announcement")
public class AnnouncementController extends BaseController
{
    private String prefix = "employment/announcement";

    @Autowired
    private IAnnouncementService announcementService;

    @RequiresPermissions("employment:announcement:view")
    @GetMapping()
    public String announcement()
    {
        return prefix + "/announcement";
    }

    /**
     * 查询通知公告列表
     */
    @RequiresPermissions("employment:announcement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Announcement announcement)
    {
        System.out.println(announcement);
        startPage();
        List<Announcement> list = announcementService.selectAnnouncementList(announcement);
        return getDataTable(list);
    }
    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        Announcement announcement = announcementService.selectAnnouncementById(id);
        mmap.addAttribute("announcement", announcement);
        return prefix + "/content";
    }


    /**
     * 导出通知公告列表
     */
    @RequiresPermissions("employment:announcement:export")
    @Log(title = "通知公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Announcement announcement)
    {
        List<Announcement> list = announcementService.selectAnnouncementList(announcement);
        ExcelUtil<Announcement> util = new ExcelUtil<Announcement>(Announcement.class);
        return util.exportExcel(list, "announcement");
    }

    /**
     * 新增通知公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存通知公告
     */
    @RequiresPermissions("employment:announcement:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Announcement announcement)
    {
        announcement.setReleaseTime(DateUtils.getNowDate());
        announcement.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(announcementService.insertAnnouncement(announcement));
    }

    /**
     * 修改通知公告
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Announcement announcement = announcementService.selectAnnouncementById(id);
        mmap.put("announcement", announcement);
        return prefix + "/edit";
    }

    /**
     * 修改保存通知公告
     */
    @RequiresPermissions("employment:announcement:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Announcement announcement)
    {
        return toAjax(announcementService.updateAnnouncement(announcement));
    }

    /**
     * 删除通知公告
     */
    @RequiresPermissions("employment:announcement:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(announcementService.deleteAnnouncementByIds(ids));
    }
}
