package com.ruoyi.project.employment.calendar.service;

import com.ruoyi.project.employment.calendar.domain.Calendar;

import java.util.List;

/**
 * 就业日历Service接口
 * 
 * @author tqs
 * @date 2020-12-02
 */
public interface ICalendarService 
{
    /**
     * 查询就业日历
     * 
     * @param id 就业日历ID
     * @return 就业日历
     */
    public Calendar selectCalendarById(Long id);

    /**
     * 查询就业日历列表
     * 
     * @param calendar 就业日历
     * @return 就业日历集合
     */
    public List<Calendar> selectCalendarList(Calendar calendar);

    /**
     * 新增就业日历
     * 
     * @param calendar 就业日历
     * @return 结果
     */
    public int insertCalendar(Calendar calendar);

    /**
     * 修改就业日历
     * 
     * @param calendar 就业日历
     * @return 结果
     */
    public int updateCalendar(Calendar calendar);

    /**
     * 批量删除就业日历
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCalendarByIds(String ids);

    /**
     * 删除就业日历信息
     * 
     * @param id 就业日历ID
     * @return 结果
     */
    public int deleteCalendarById(Long id);

    int updateVisitTimes(Long id);

    public List<Calendar> selectNormalCalendarList(Calendar calendar);

}
