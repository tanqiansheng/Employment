package com.ruoyi.project.employment.news.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.news.domain.News;
import com.ruoyi.project.employment.news.service.INewsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 就业新闻Controller
 *
 * @author June
 * @date 2020-05-20
 */
@Controller
@RequestMapping("/employment/news")
public class NewsController extends BaseController {
    private String prefix = "employment/news";

    @Autowired
    private INewsService newsService;

    @RequiresPermissions("employment:news:view")
    @GetMapping()
    public String news() {
        return prefix + "/news";
    }

    /**
     * 查询就业新闻列表
     */
    @RequiresPermissions("employment:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(News news) {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        News news = newsService.selectNewsById(id);
        mmap.addAttribute("news", news);
        return prefix + "/content";
    }

    /**
     * 导出就业新闻列表
     */
    @RequiresPermissions("employment:n" +
            "ews:export")
    @Log(title = "就业新闻", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(News news) {
        List<News> list = newsService.selectNewsList(news);
        ExcelUtil<News> util = new ExcelUtil<News>(News.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 新增就业新闻
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存就业新闻
     */
    @RequiresPermissions("employment:news:add")
    @Log(title = "就业新闻", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(News news) {
        news.setReleaseTime(DateUtils.getNowDate());
        news.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改就业新闻
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        News news = newsService.selectNewsById(id);
        mmap.put("news", news);
        return prefix + "/edit";
    }

    /**
     * 修改保存就业新闻
     */
    @RequiresPermissions("employment:news:edit")
    @Log(title = "就业新闻", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(News news) {
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 删除就业新闻
     */
    @RequiresPermissions("employment:news:remove")
    @Log(title = "就业新闻", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(newsService.deleteNewsByIds(ids));
    }
}
