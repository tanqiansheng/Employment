package com.ruoyi.project.employment.link.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.link.domain.Link;
import com.ruoyi.project.employment.link.mapper.LinkMapper;
import com.ruoyi.project.employment.link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友情链接Service业务层处理
 * 
 * @author June
 * @date 2020-11-24
 */
@Service
public class LinkServiceImpl implements ILinkService 
{
    @Autowired
    private LinkMapper linkMapper;

    /**
     * 查询友情链接
     * 
     * @param id 友情链接ID
     * @return 友情链接
     */
    @Override
    public Link selectLinkById(Long id)
    {
        return linkMapper.selectLinkById(id);
    }

    /**
     * 查询友情链接列表
     * 
     * @param link 友情链接
     * @return 友情链接
     */
    @Override
    public List<Link> selectLinkList(Link link)
    {
        return linkMapper.selectLinkList(link);
    }

    /**
     * 新增友情链接
     * 
     * @param link 友情链接
     * @return 结果
     */
    @Override
    public int insertLink(Link link)
    {
        link.setCreateTime(DateUtils.getNowDate());
        return linkMapper.insertLink(link);
    }

    /**
     * 修改友情链接
     * 
     * @param link 友情链接
     * @return 结果
     */
    @Override
    public int updateLink(Link link)
    {
        link.setUpdateTime(DateUtils.getNowDate());
        return linkMapper.updateLink(link);
    }

    /**
     * 删除友情链接对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLinkByIds(String ids)
    {
        return linkMapper.deleteLinkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除友情链接信息
     * 
     * @param id 友情链接ID
     * @return 结果
     */
    @Override
    public int deleteLinkById(Long id)
    {
        return linkMapper.deleteLinkById(id);
    }

    @Override
    public List<Link> selectNormalLinkList(Link link) {
        return linkMapper.selectNormalLinkList(link);
    }
}
