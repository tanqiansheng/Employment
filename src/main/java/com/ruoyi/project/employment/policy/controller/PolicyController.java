package com.ruoyi.project.employment.policy.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.policy.domain.Policy;
import com.ruoyi.project.employment.policy.service.IPolicyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 就业政策Controller
 * 
 * @author tqs
 * @date 2020-11-24
 */
@Controller
@RequestMapping("/employment/policy")
public class PolicyController extends BaseController
{
    private String prefix = "employment/policy";

    @Autowired
    private IPolicyService policyService;

    @RequiresPermissions("employment:policy:view")
    @GetMapping()
    public String policy()
    {
        return prefix + "/policy";
    }

    /**
     * 查询就业政策列表
     */
    @RequiresPermissions("employment:policy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Policy policy)
    {
        startPage();
        List<Policy> list = policyService.selectPolicyList(policy);
        return getDataTable(list);
    }


    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        Policy policy = policyService.selectPolicyById(id);
        mmap.addAttribute("policy", policy);
        return prefix + "/content";
    }

    /**
     * 导出就业政策列表
     */
    @RequiresPermissions("employment:policy:export")
    @Log(title = "就业政策", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Policy policy)
    {
        List<Policy> list = policyService.selectPolicyList(policy);
        ExcelUtil<Policy> util = new ExcelUtil<Policy>(Policy.class);
        return util.exportExcel(list, "policy");
    }

    /**
     * 新增就业政策
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存就业政策
     */
    @RequiresPermissions("employment:policy:add")
    @Log(title = "就业政策", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Policy policy)
    {
        policy.setReleaseTime(DateUtils.getNowDate());
        policy.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(policyService.insertPolicy(policy));
    }

    /**
     * 修改就业政策
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Policy policy = policyService.selectPolicyById(id);
        mmap.put("policy", policy);
        return prefix + "/edit";
    }

    /**
     * 修改保存就业政策
     */
    @RequiresPermissions("employment:policy:edit")
    @Log(title = "就业政策", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Policy policy)
    {
        return toAjax(policyService.updatePolicy(policy));
    }

    /**
     * 删除就业政策
     */
    @RequiresPermissions("employment:policy:remove")
    @Log(title = "就业政策", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(policyService.deletePolicyByIds(ids));
    }
}
