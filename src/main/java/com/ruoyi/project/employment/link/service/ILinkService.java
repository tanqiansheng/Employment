package com.ruoyi.project.employment.link.service;

import com.ruoyi.project.employment.link.domain.Link;

import java.util.List;

/**
 * 友情链接Service接口
 * 
 * @author June
 * @date 2020-11-24
 */
public interface ILinkService 
{
    /**
     * 查询友情链接
     * 
     * @param id 友情链接ID
     * @return 友情链接
     */
    public Link selectLinkById(Long id);

    /**
     * 查询友情链接列表
     * 
     * @param link 友情链接
     * @return 友情链接集合
     */
    public List<Link> selectLinkList(Link link);

    /**
     * 新增友情链接
     * 
     * @param link 友情链接
     * @return 结果
     */
    public int insertLink(Link link);

    /**
     * 修改友情链接
     * 
     * @param link 友情链接
     * @return 结果
     */
    public int updateLink(Link link);

    /**
     * 批量删除友情链接
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLinkByIds(String ids);

    /**
     * 删除友情链接信息
     * 
     * @param id 友情链接ID
     * @return 结果
     */
    public int deleteLinkById(Long id);

    public List<Link> selectNormalLinkList(Link link);
}
