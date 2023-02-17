package com.ruoyi.project.employment.slideshow.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.employment.slideshow.domain.Slideshow;
import com.ruoyi.project.employment.slideshow.mapper.SlideshowMapper;
import com.ruoyi.project.employment.slideshow.service.ISlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图Service业务层处理
 * 
 * @author tqs
 * @date 2020-11-30
 */
@Service
public class SlideshowServiceImpl implements ISlideshowService 
{
    @Autowired
    private SlideshowMapper slideshowMapper;

    /**
     * 查询轮播图
     * 
     * @param fileId 轮播图ID
     * @return 轮播图
     */
    @Override
    public Slideshow selectSlideshowById(Long fileId)
    {
        return slideshowMapper.selectSlideshowById(fileId);
    }

    /**
     * 查询轮播图列表
     * 
     * @param slideshow 轮播图
     * @return 轮播图
     */
    @Override
    public List<Slideshow> selectSlideshowList(Slideshow slideshow)
    {
        return slideshowMapper.selectSlideshowList(slideshow);
    }

    /**
     * 新增轮播图
     * 
     * @param slideshow 轮播图
     * @return 结果
     */
    @Override
    public int insertSlideshow(Slideshow slideshow)
    {
        slideshow.setCreateTime(DateUtils.getNowDate());
        return slideshowMapper.insertSlideshow(slideshow);
    }

    /**
     * 修改轮播图
     * 
     * @param slideshow 轮播图
     * @return 结果
     */
    @Override
    public int updateSlideshow(Slideshow slideshow)
    {
        slideshow.setUpdateTime(DateUtils.getNowDate());
        return slideshowMapper.updateSlideshow(slideshow);
    }

    /**
     * 删除轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSlideshowByIds(String ids)
    {
        return slideshowMapper.deleteSlideshowByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除轮播图信息
     * 
     * @param fileId 轮播图ID
     * @return 结果
     */
    @Override
    public int deleteSlideshowById(Long fileId)
    {
        return slideshowMapper.deleteSlideshowById(fileId);
    }

    @Override
    public List<Slideshow> selectNormalSlideshowList(Slideshow slideshow) {
        return slideshowMapper.selectNormalSlideshowList(slideshow);
    }
}
