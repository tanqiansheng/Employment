package com.ruoyi.project.employment.information.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.information.domain.Information;
import com.ruoyi.project.employment.information.mapper.InformationMapper;
import com.ruoyi.project.employment.information.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 招聘信息Service业务层处理
 * 
 * @author June
 * @date 2020-11-13
 */
@Service
public class InformationServiceImpl implements IInformationService 
{
    @Autowired
    private InformationMapper informationMapper;

    /**
     * 查询招聘信息
     * 
     * @param id 招聘信息ID
     * @return 招聘信息
     */
    @Override
    public Information selectInformationById(Long id)
    {
        return informationMapper.selectInformationById(id);
    }

    /**
     * 查询招聘信息列表
     * 
     * @param information 招聘信息
     * @return 招聘信息
     */
    @Override
    public List<Information> selectInformationList(Information information)
    {
        return informationMapper.selectInformationList(information);
    }

    /**
     * 新增招聘信息
     * 
     * @param information 招聘信息
     * @return 结果
     */
    @Override
    public int insertInformation(Information information)
    {
        information.setCreateTime(DateUtils.getNowDate());
        return informationMapper.insertInformation(information);
    }

    /**
     * 修改招聘信息
     * 
     * @param information 招聘信息
     * @return 结果
     */
    @Override
    public int updateInformation(Information information)
    {
        information.setUpdateTime(DateUtils.getNowDate());
        return informationMapper.updateInformation(information);
    }

    /**
     * 删除招聘信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInformationByIds(String ids)
    {
        return informationMapper.deleteInformationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招聘信息信息
     * 
     * @param id 招聘信息ID
     * @return 结果
     */
    @Override
    public int deleteInformationById(Long id)
    {
        return informationMapper.deleteInformationById(id);
    }

    @Override
    public int updateVisitTimes(Long id) {
    return informationMapper.updateVisitTimes(id);
}

    @Override
    public List<Information> selectNormalInformationList(Information information) {
        return informationMapper.selectNormalInformationList();
    }
}
