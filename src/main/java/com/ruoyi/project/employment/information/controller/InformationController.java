package com.ruoyi.project.employment.information.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.information.domain.Information;
import com.ruoyi.project.employment.information.service.IInformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 招聘信息Controller
 *
 * @author June
 * @date 2020-11-13
 */
@Controller
@RequestMapping("/employment/information")
public class InformationController extends BaseController {
    private String prefix = "employment/information";

    @Autowired
    private IInformationService informationService;

    @RequiresPermissions("employment:information:view")
    @GetMapping()
    public String information() {
        return prefix + "/information";
    }

    /**
     * 查询招聘信息列表
     */
    @RequiresPermissions("employment:information:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Information information) {
        startPage();
        List<Information> list = informationService.selectInformationList(information);
        return getDataTable(list);
    }

    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        Information information = informationService.selectInformationById(id);
        mmap.addAttribute("information", information);
        return prefix + "/content";
    }

    /**
     * 导出招聘信息列表
     */
    @RequiresPermissions("employment:information:export")
    @Log(title = "招聘信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Information information) {
        List<Information> list = informationService.selectInformationList(information);
        ExcelUtil<Information> util = new ExcelUtil<Information>(Information.class);
        return util.exportExcel(list, "information");
    }

    /**
     * 新增招聘信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存招聘信息
     */
    @RequiresPermissions("employment:information:add")
    @Log(title = "招聘信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Information information) {
        information.setReleaseTime(DateUtils.getNowDate());
        information.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(informationService.insertInformation(information));
    }

    /**
     * 修改招聘信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Information information = informationService.selectInformationById(id);
        mmap.put("information", information);
        return prefix + "/edit";
    }

    /**
     * 修改保存招聘信息
     */
    @RequiresPermissions("employment:information:edit")
    @Log(title = "招聘信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Information information) {

        return toAjax(informationService.updateInformation(information));
    }

    /**
     * 删除招聘信息
     */
    @RequiresPermissions("employment:information:remove")
    @Log(title = "招聘信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(informationService.deleteInformationByIds(ids));
    }
}
