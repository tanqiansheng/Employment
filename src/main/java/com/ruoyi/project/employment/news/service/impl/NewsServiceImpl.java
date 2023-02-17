package com.ruoyi.project.employment.news.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.news.domain.News;
import com.ruoyi.project.employment.news.mapper.NewsMapper;
import com.ruoyi.project.employment.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 就业新闻Service业务层处理
 * 
 * @author June
 * @date 2020-05-20
 */
@Service
public class NewsServiceImpl implements INewsService 
{
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询就业新闻
     * 
     * @param id 就业新闻ID
     * @return 就业新闻
     */
    @Override
    public News selectNewsById(Long id)
    {
        return newsMapper.selectNewsById(id);
    }

    /**
     * 查询就业新闻列表
     * 
     * @param news 就业新闻
     * @return 就业新闻
     */
    @Override
    public List<News> selectNewsList(News news)
    {
        return newsMapper.selectNewsList(news);
    }

    /**
     * 新增就业新闻
     * 
     * @param news 就业新闻
     * @return 结果
     */
    @Override
    public int insertNews(News news)
    {
        news.setCreateTime(DateUtils.getNowDate());
        return newsMapper.insertNews(news);
    }

    /**
     * 修改就业新闻
     * 
     * @param news 就业新闻
     * @return 结果
     */
    @Override
    public int updateNews(News news)
    {
        news.setUpdateTime(DateUtils.getNowDate());
        return newsMapper.updateNews(news);
    }

    /**
     * 删除就业新闻对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsByIds(String ids)
    {
        return newsMapper.deleteNewsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除就业新闻信息
     * 
     * @param id 就业新闻ID
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long id)
    {
        return newsMapper.deleteNewsById(id);
    }

    @Override
    public int updateVisitTimes(Long id) {
        return newsMapper.updateVisitTimes(id);
    }

    @Override
    public List<News> selectNewsNormalList(News news) {
        return newsMapper.selectNewsNormalList(news);
    }
}
