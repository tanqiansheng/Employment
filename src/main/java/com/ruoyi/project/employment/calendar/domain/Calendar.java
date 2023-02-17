package com.ruoyi.project.employment.calendar.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 就业日历对象 employment_calendar
 * 
 * @author tqs
 * @date 2020-12-02
 */
public class Calendar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 链接 */
    @Excel(name = "链接")
    private String src;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String unitName;

    /** 地点 */
    @Excel(name = "地点")
    private String place;

    /** 招聘会类型 */
    @Excel(name = "招聘会类型")
    private String jobFair;

    /** 招聘会时间 */
    @Excel(name = "招聘会时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recruitTime;

    /** 发布人 */
    @Excel(name = "发布人")
    private String releasePeople;

    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 访问次数 */
    @Excel(name = "访问次数")
    private Long visitTimes;

    /** 状态（0正常 1关闭） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSrc(String src) 
    {
        this.src = src;
    }

    public String getSrc() 
    {
        return src;
    }
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setJobFair(String jobFair) 
    {
        this.jobFair = jobFair;
    }

    public String getJobFair() 
    {
        return jobFair;
    }
    public void setRecruitTime(Date recruitTime) 
    {
        this.recruitTime = recruitTime;
    }

    public Date getRecruitTime() 
    {
        return recruitTime;
    }
    public void setReleasePeople(String releasePeople) 
    {
        this.releasePeople = releasePeople;
    }

    public String getReleasePeople() 
    {
        return releasePeople;
    }
    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }
    public void setVisitTimes(Long visitTimes) 
    {
        this.visitTimes = visitTimes;
    }

    public Long getVisitTimes() 
    {
        return visitTimes;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("src", getSrc())
            .append("unitName", getUnitName())
            .append("place", getPlace())
            .append("jobFair", getJobFair())
            .append("recruitTime", getRecruitTime())
            .append("releasePeople", getReleasePeople())
            .append("releaseTime", getReleaseTime())
            .append("visitTimes", getVisitTimes())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
