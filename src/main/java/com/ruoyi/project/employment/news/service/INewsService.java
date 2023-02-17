package com.ruoyi.project.employment.news.service;

import com.ruoyi.project.employment.news.domain.News;

import java.util.List;

/**
 * 就业新闻Service接口
 *
 * @author June
 * @date 2020-05-20
 */
public interface INewsService {
    /**
     * 查询就业新闻
     *
     * @param id 就业新闻ID
     *
     * @return 就业新闻
     */
    public News selectNewsById(Long id);

    /**
     * 查询就业新闻列表
     *
     * @param news 就业新闻
     *
     * @return 就业新闻集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 新增就业新闻
     *
     * @param news 就业新闻
     *
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改就业新闻
     *
     * @param news 就业新闻
     *
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 批量删除就业新闻
     *
     * @param ids 需要删除的数据ID
     *
     * @return 结果
     */
    public int deleteNewsByIds(String ids);

    /**
     * 删除就业新闻信息
     *
     * @param id 就业新闻ID
     *
     * @return 结果
     */
    public int deleteNewsById(Long id);

    public int updateVisitTimes(Long id);
    public List<News> selectNewsNormalList(News news);
}
