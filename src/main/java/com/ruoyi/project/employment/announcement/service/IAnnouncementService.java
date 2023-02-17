package com.ruoyi.project.employment.announcement.service;

import com.ruoyi.project.employment.announcement.domain.Announcement;

import java.util.List;

/**
 * 通知公告Service接口
 * 
 * @author June
 * @date 2020-11-20
 */
public interface IAnnouncementService 
{
    /**
     * 查询通知公告
     * 
     * @param id 通知公告ID
     * @return 通知公告
     */
    public Announcement selectAnnouncementById(Long id);

    /**
     * 查询通知公告列表
     * 
     * @param announcement 通知公告
     * @return 通知公告集合
     */
    public List<Announcement> selectAnnouncementList(Announcement announcement);

    /**
     * 新增通知公告
     * 
     * @param announcement 通知公告
     * @return 结果
     */
    public int insertAnnouncement(Announcement announcement);

    /**
     * 修改通知公告
     * 
     * @param announcement 通知公告
     * @return 结果
     */
    public int updateAnnouncement(Announcement announcement);

    /**
     * 批量删除通知公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnnouncementByIds(String ids);

    /**
     * 删除通知公告信息
     * 
     * @param id 通知公告ID
     * @return 结果
     */
    public int deleteAnnouncementById(Long id);

    public int updateVisitTimes(Long id);

    public List<Announcement> selectNormalAnnouncementList(Announcement announcement);

}
