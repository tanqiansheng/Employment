package com.ruoyi.project.employment.calendar.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.calendar.domain.Calendar;
import com.ruoyi.project.employment.calendar.service.ICalendarService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

/**
 * 就业日历Controller
 * 
 * @author tqs
 * @date 2020-12-02
 */
@Controller
@RequestMapping("/employment/calendar")
public class CalendarController extends BaseController
{
    private String prefix = "employment/calendar";

    @Autowired
    private ICalendarService calendarService;

    @RequiresPermissions("employment:calendar:view")
    @GetMapping()
    public String calendar()
    {
        return prefix + "/calendar";
    }

    /**
     * 查询就业日历列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Calendar calendar)
    {
        startPage();
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        return getDataTable(list);
    }
    /**
     * 查询就业日历列表无分页
     */
    @PostMapping("/listNoPage")
    @ResponseBody
    public List<Calendar> listNoPage(Calendar calendar)
    {
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        return list;
    }
    /**
     * 查询就业日历列表无分页日期和title
     */
    @PostMapping("/listNoPageAttr")
    @ResponseBody
    public HashMap<String, String> listNoPageAttr(Calendar calendar)
    {
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        HashMap<String, String> hmap= new HashMap<String, String>();
        for(Calendar item :list ){
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = sdf.format(item.getRecruitTime());
            hmap.put(formatDate,item.getTitle());
        }
        return hmap;
    }
    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        Calendar calendar = calendarService.selectCalendarById(id);
        mmap.addAttribute("calendar", calendar);
        return prefix + "/content";
    }

    /**
     * 导出就业日历列表
     */
    @RequiresPermissions("employment:calendar:export")
    @Log(title = "就业日历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Calendar calendar)
    {
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        ExcelUtil<Calendar> util = new ExcelUtil<Calendar>(Calendar.class);
        return util.exportExcel(list, "calendar");
    }

    /**
     * 新增就业日历
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存就业日历
     */
    @RequiresPermissions("employment:calendar:add")
    @Log(title = "就业日历", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Calendar calendar)
    {
        calendar.setReleaseTime(DateUtils.getNowDate());
        calendar.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(calendarService.insertCalendar(calendar));
    }

    /**
     * 修改就业日历
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Calendar calendar = calendarService.selectCalendarById(id);
        mmap.put("calendar", calendar);
        return prefix + "/edit";
    }

    /**
     * 修改保存就业日历
     */
    @RequiresPermissions("employment:calendar:edit")
    @Log(title = "就业日历", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Calendar calendar)
    {
        return toAjax(calendarService.updateCalendar(calendar));
    }

    /**
     * 删除就业日历
     */
    @RequiresPermissions("employment:calendar:remove")
    @Log(title = "就业日历", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(calendarService.deleteCalendarByIds(ids));
    }
}
