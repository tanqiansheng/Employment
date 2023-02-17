package com.ruoyi.project.employment.announcement.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.announcement.domain.Announcement;
import com.ruoyi.project.employment.announcement.mapper.AnnouncementMapper;
import com.ruoyi.project.employment.announcement.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通知公告Service业务层处理
 * 
 * @author June
 * @date 2020-11-20
 */
@Service
public class AnnouncementServiceImpl implements IAnnouncementService 
{
    @Autowired
    private AnnouncementMapper announcementMapper ;
    /**
     * 查询通知公告
     * 
     * @param id 通知公告ID
     * @return 通知公告
     */
    @Override
    public Announcement selectAnnouncementById(Long id)
    {
        return announcementMapper.selectAnnouncementById(id);
    }

    /**
     * 查询通知公告列表
     * 
     * @param announcement 通知公告
     * @return 通知公告
     */
    @Override
    public List<Announcement> selectAnnouncementList(Announcement announcement)
    {
        return announcementMapper.selectAnnouncementList(announcement);
    }

    /**
     * 新增通知公告
     * 
     * @param announcement 通知公告
     * @return 结果
     */
    @Override
    public int insertAnnouncement(Announcement announcement)
    {
        announcement.setCreateTime(DateUtils.getNowDate());
        return announcementMapper.insertAnnouncement(announcement);
    }

    /**
     * 修改通知公告
     * 
     * @param announcement 通知公告
     * @return 结果
     */
    @Override
    public int updateAnnouncement(Announcement announcement)
    {
        announcement.setUpdateTime(DateUtils.getNowDate());
        return announcementMapper.updateAnnouncement(announcement);
    }

    /**
     * 删除通知公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAnnouncementByIds(String ids)
    {
        return announcementMapper.deleteAnnouncementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除通知公告信息
     * 
     * @param id 通知公告ID
     * @return 结果
     */
    @Override
    public int deleteAnnouncementById(Long id)
    {
        return announcementMapper.deleteAnnouncementById(id);
    }

    @Override
    public int updateVisitTimes(Long id) {
        return announcementMapper.updateVisitTimes(id);
    }

    @Override
    public List<Announcement> selectNormalAnnouncementList(Announcement announcement) {
        return announcementMapper.selectNormalAnnouncementList(announcement);
    }
}
