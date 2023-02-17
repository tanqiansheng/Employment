package com.ruoyi.project.employment.policy.mapper;

import com.ruoyi.project.employment.policy.domain.Policy;

import java.util.List;

/**
 * 就业政策Mapper接口
 *
 * @author tqs
 * @date 2020-11-24
 */
public interface PolicyMapper {
    /**
     * 查询就业政策
     *
     * @param id 就业政策ID
     * @return 就业政策
     */
    public Policy selectPolicyById(Long id);

    /**
     * 查询就业政策列表
     *
     * @param policy 就业政策
     * @return 就业政策集合
     */
    public List<Policy> selectPolicyList(Policy policy);

    /**
     * 新增就业政策
     *
     * @param policy 就业政策
     * @return 结果
     */
    public int insertPolicy(Policy policy);

    /**
     * 修改就业政策
     *
     * @param policy 就业政策
     * @return 结果
     */
    public int updatePolicy(Policy policy);

    /**
     * 删除就业政策
     *
     * @param id 就业政策ID
     * @return 结果
     */
    public int deletePolicyById(Long id);

    /**
     * 批量删除就业政策
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePolicyByIds(String[] ids);

    public int updateVisitTimes(Long id);

    List<Policy> selectNormalPolicyList(Policy policy);
}
