package com.ruoyi.project.employment.skill.service;

import com.ruoyi.project.employment.skill.domain.Skill;

import java.util.List;

/**
 * 求职技巧Service接口
 * 
 * @author tqs
 * @date 2020-11-25
 */
public interface ISkillService 
{
    /**
     * 查询求职技巧
     * 
     * @param id 求职技巧ID
     * @return 求职技巧
     */
    public Skill selectSkillById(Long id);

    /**
     * 查询求职技巧列表
     * 
     * @param skill 求职技巧
     * @return 求职技巧集合
     */
    public List<Skill> selectSkillList(Skill skill);

    /**
     * 新增求职技巧
     * 
     * @param skill 求职技巧
     * @return 结果
     */
    public int insertSkill(Skill skill);

    /**
     * 修改求职技巧
     * 
     * @param skill 求职技巧
     * @return 结果
     */
    public int updateSkill(Skill skill);

    /**
     * 批量删除求职技巧
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkillByIds(String ids);

    /**
     * 删除求职技巧信息
     * 
     * @param id 求职技巧ID
     * @return 结果
     */
    public int deleteSkillById(Long id);

    int updateVisitTimes(Long id);

    public List<Skill> selectNormalSkillList(Skill skill);
}
