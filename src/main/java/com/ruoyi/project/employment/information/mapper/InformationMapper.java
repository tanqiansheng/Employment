package com.ruoyi.project.employment.information.mapper;

import com.ruoyi.project.employment.information.domain.Information;

import java.util.List;

/**
 * 招聘信息Mapper接口
 * 
 * @author June
 * @date 2020-11-13
 */
public interface InformationMapper 
{
    /**
     * 查询招聘信息
     * 
     * @param id 招聘信息ID
     * @return 招聘信息
     */
    public Information selectInformationById(Long id);

    /**
     * 查询招聘信息列表
     * 
     * @param information 招聘信息
     * @return 招聘信息集合
     */
    public List<Information> selectInformationList(Information information);

    /**
     * 新增招聘信息
     * 
     * @param information 招聘信息
     * @return 结果
     */
    public int insertInformation(Information information);

    /**
     * 修改招聘信息
     * 
     * @param information 招聘信息
     * @return 结果
     */
    public int updateInformation(Information information);

    /**
     * 删除招聘信息
     * 
     * @param id 招聘信息ID
     * @return 结果
     */
    public int deleteInformationById(Long id);

    /**
     * 批量删除招聘信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInformationByIds(String[] ids);


    public int updateVisitTimes(Long id);

    List<Information> selectNormalInformationList();
}
