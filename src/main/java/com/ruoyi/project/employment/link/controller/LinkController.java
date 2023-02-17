package com.ruoyi.project.employment.link.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.link.domain.Link;
import com.ruoyi.project.employment.link.service.ILinkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 友情链接Controller
 * 
 * @author June
 * @date 2020-11-24
 */
@Controller
@RequestMapping("/employment/link")
public class LinkController extends BaseController
{
    private String prefix = "employment/link";

    @Autowired
    private ILinkService linkService;

    @RequiresPermissions("employment:link:view")
    @GetMapping()
    public String link()
    {
        return prefix + "/link";
    }

    /**
     * 查询友情链接列表
     */
    @RequiresPermissions("employment:link:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Link link)
    {
        startPage();
        List<Link> list = linkService.selectLinkList(link);
        return getDataTable(list);
    }

    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        Link link = linkService.selectLinkById(id);
        mmap.addAttribute("link", link);
        return prefix + "/content";
    }
    /**
     * 导出友情链接列表
     */
    @RequiresPermissions("employment:link:export")
    @Log(title = "友情链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Link link)
    {
        List<Link> list = linkService.selectLinkList(link);
        ExcelUtil<Link> util = new ExcelUtil<Link>(Link.class);
        return util.exportExcel(list, "link");
    }

    /**
     * 新增友情链接
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存友情链接
     */
    @RequiresPermissions("employment:link:add")
    @Log(title = "友情链接", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Link link)
    {
        link.setReleaseTime(DateUtils.getNowDate());
        link.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(linkService.insertLink(link));
    }

    /**
     * 修改友情链接
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Link link = linkService.selectLinkById(id);
        mmap.put("link", link);
        return prefix + "/edit";
    }

    /**
     * 修改保存友情链接
     */
    @RequiresPermissions("employment:link:edit")
    @Log(title = "友情链接", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Link link)
    {
        return toAjax(linkService.updateLink(link));
    }

    /**
     * 删除友情链接
     */
    @RequiresPermissions("employment:link:remove")
    @Log(title = "友情链接", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(linkService.deleteLinkByIds(ids));
    }
}
