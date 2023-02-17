package com.ruoyi.project.employment.skill.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.skill.domain.Skill;
import com.ruoyi.project.employment.skill.service.ISkillService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 求职技巧Controller
 * 
 * @author tqs
 * @date 2020-11-25
 */
@Controller
@RequestMapping("/employment/skill")
public class SkillController extends BaseController
{
    private String prefix = "employment/skill";

    @Autowired
    private ISkillService skillService;

    @RequiresPermissions("employment:skill:view")
    @GetMapping()
    public String skill()
    {
        return prefix + "/skill";
    }

    /**
     * 查询求职技巧列表
     */
    @RequiresPermissions("employment:skill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Skill skill)
    {
        startPage();
        List<Skill> list = skillService.selectSkillList(skill);
        return getDataTable(list);
    }

    /**
     * 导出求职技巧列表
     */
    @RequiresPermissions("employment:skill:export")
    @Log(title = "求职技巧", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Skill skill)
    {
        List<Skill> list = skillService.selectSkillList(skill);
        ExcelUtil<Skill> util = new ExcelUtil<Skill>(Skill.class);
        return util.exportExcel(list, "skill");
    }
    //查看内容详细
    @GetMapping("/showContent")
    public String showContent(Long id, ModelMap mmap) {
        Skill skill = skillService.selectSkillById(id);
        mmap.addAttribute("skill", skill);
        return prefix + "/content";
    }
    /**
     * 新增求职技巧
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存求职技巧
     */
    @RequiresPermissions("employment:skill:add")
    @Log(title = "求职技巧", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Skill skill)
    {
        skill.setReleaseTime(DateUtils.getNowDate());
        skill.setReleasePeople(ShiroUtils.getSysUser().getUserName());
        return toAjax(skillService.insertSkill(skill));
    }

    /**
     * 修改求职技巧
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Skill skill = skillService.selectSkillById(id);
        mmap.put("skill", skill);
        return prefix + "/edit";
    }

    /**
     * 修改保存求职技巧
     */
    @RequiresPermissions("employment:skill:edit")
    @Log(title = "求职技巧", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Skill skill)
    {
        return toAjax(skillService.updateSkill(skill));
    }

    /**
     * 删除求职技巧
     */
    @RequiresPermissions("employment:skill:remove")
    @Log(title = "求职技巧", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skillService.deleteSkillByIds(ids));
    }
}
