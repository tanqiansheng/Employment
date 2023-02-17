package com.ruoyi.project.employment.skill.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.skill.domain.Skill;
import com.ruoyi.project.employment.skill.mapper.SkillMapper;
import com.ruoyi.project.employment.skill.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 求职技巧Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-25
 */
@Service
public class SkillServiceImpl implements ISkillService 
{
    @Autowired
    private SkillMapper skillMapper;

    /**
     * 查询求职技巧
     * 
     * @param id 求职技巧ID
     * @return 求职技巧
     */
    @Override
    public Skill selectSkillById(Long id)
    {
        return skillMapper.selectSkillById(id);
    }

    /**
     * 查询求职技巧列表
     * 
     * @param skill 求职技巧
     * @return 求职技巧
     */
    @Override
    public List<Skill> selectSkillList(Skill skill)
    {
        return skillMapper.selectSkillList(skill);
    }

    /**
     * 新增求职技巧
     * 
     * @param skill 求职技巧
     * @return 结果
     */
    @Override
    public int insertSkill(Skill skill)
    {
        skill.setCreateTime(DateUtils.getNowDate());
        return skillMapper.insertSkill(skill);
    }

    /**
     * 修改求职技巧
     * 
     * @param skill 求职技巧
     * @return 结果
     */
    @Override
    public int updateSkill(Skill skill)
    {
        skill.setUpdateTime(DateUtils.getNowDate());
        return skillMapper.updateSkill(skill);
    }

    /**
     * 删除求职技巧对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkillByIds(String ids)
    {
        return skillMapper.deleteSkillByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除求职技巧信息
     * 
     * @param id 求职技巧ID
     * @return 结果
     */
    @Override
    public int deleteSkillById(Long id)
    {
        return skillMapper.deleteSkillById(id);
    }

    @Override
    public int updateVisitTimes(Long id) {
        return skillMapper.updateVisitTimes(id);
    }

    @Override
    public List<Skill> selectNormalSkillList(Skill skill) {
        return skillMapper.selectNormalSkillList(skill);
    }
}
