package com.ruoyi.project.employment.calendar.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.calendar.domain.Calendar;
import com.ruoyi.project.employment.calendar.mapper.CalendarMapper;
import com.ruoyi.project.employment.calendar.service.ICalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 就业日历Service业务层处理
 * 
 * @author tqs
 * @date 2020-12-02
 */
@Service
public class CalendarServiceImpl implements ICalendarService 
{
    @Autowired
    private CalendarMapper calendarMapper;

    /**
     * 查询就业日历
     * 
     * @param id 就业日历ID
     * @return 就业日历
     */
    @Override
    public Calendar selectCalendarById(Long id)
    {
        return calendarMapper.selectCalendarById(id);
    }

    /**
     * 查询就业日历列表
     * 
     * @param calendar 就业日历
     * @return 就业日历
     */
    @Override
    public List<Calendar> selectCalendarList(Calendar calendar)
    {
        return calendarMapper.selectCalendarList(calendar);
    }

    /**
     * 新增就业日历
     * 
     * @param calendar 就业日历
     * @return 结果
     */
    @Override
    public int insertCalendar(Calendar calendar)
    {
        calendar.setCreateTime(DateUtils.getNowDate());
        return calendarMapper.insertCalendar(calendar);
    }

    /**
     * 修改就业日历
     * 
     * @param calendar 就业日历
     * @return 结果
     */
    @Override
    public int updateCalendar(Calendar calendar)
    {
        calendar.setUpdateTime(DateUtils.getNowDate());
        return calendarMapper.updateCalendar(calendar);
    }

    /**
     * 删除就业日历对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCalendarByIds(String ids)
    {
        return calendarMapper.deleteCalendarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除就业日历信息
     * 
     * @param id 就业日历ID
     * @return 结果
     */
    @Override
    public int deleteCalendarById(Long id)
    {
        return calendarMapper.deleteCalendarById(id);
    }

    @Override
    public int updateVisitTimes(Long id) {
        return calendarMapper.updateVisitTimes(id);
    }

    @Override
    public List<Calendar> selectNormalCalendarList(Calendar calendar) {
        return calendarMapper.selectNormalCalendarList(calendar);
    }
}
