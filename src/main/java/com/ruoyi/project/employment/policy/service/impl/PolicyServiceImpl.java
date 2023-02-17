package com.ruoyi.project.employment.policy.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.policy.domain.Policy;
import com.ruoyi.project.employment.policy.mapper.PolicyMapper;
import com.ruoyi.project.employment.policy.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 就业政策Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-24
 */
@Service
public class PolicyServiceImpl implements IPolicyService 
{
    @Autowired
    private PolicyMapper policyMapper;

    /**
     * 查询就业政策
     * 
     * @param id 就业政策ID
     * @return 就业政策
     */
    @Override
    public Policy selectPolicyById(Long id)
    {
        return policyMapper.selectPolicyById(id);
    }

    /**
     * 查询就业政策列表
     * 
     * @param policy 就业政策
     * @return 就业政策
     */
    @Override
    public List<Policy> selectPolicyList(Policy policy)
    {
        return policyMapper.selectPolicyList(policy);
    }

    /**
     * 新增就业政策
     * 
     * @param policy 就业政策
     * @return 结果
     */
    @Override
    public int insertPolicy(Policy policy)
    {
        policy.setCreateTime(DateUtils.getNowDate());
        return policyMapper.insertPolicy(policy);
    }

    /**
     * 修改就业政策
     * 
     * @param policy 就业政策
     * @return 结果
     */
    @Override
    public int updatePolicy(Policy policy)
    {
        policy.setUpdateTime(DateUtils.getNowDate());
        return policyMapper.updatePolicy(policy);
    }

    /**
     * 删除就业政策对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePolicyByIds(String ids)
    {
        return policyMapper.deletePolicyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除就业政策信息
     * 
     * @param id 就业政策ID
     * @return 结果
     */
    @Override
    public int deletePolicyById(Long id)
    {
        return policyMapper.deletePolicyById(id);
    }

    @Override
    public int updateVisitTimes(Long id) {
        return policyMapper.updateVisitTimes(id);

    }

    @Override
    public List<Policy> selectNormalPolicyList(Policy policy) {
        return policyMapper.selectNormalPolicyList(policy);
    }
}
