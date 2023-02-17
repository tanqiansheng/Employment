package com.ruoyi.project.employment.news.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 就业新闻对象 employment_news
 * 
 * @author June
 * @date 2020-05-20
 */
public class News extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 发布人 */
    @Excel(name = "发布人")
    private String releasePeople;

    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 访问次数 */
    @Excel(name = "访问次数")
    private Integer visitTimes;

    /** 状态（0正常 1关闭） */
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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setVisitTimes(Integer visitTimes) 
    {
        this.visitTimes = visitTimes;
    }

    public Integer getVisitTimes() 
    {
        return visitTimes;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("releasePeople", getReleasePeople())
            .append("releaseTime", getReleaseTime())
            .append("content", getContent())
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
