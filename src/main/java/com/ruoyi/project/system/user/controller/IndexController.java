package com.ruoyi.project.system.user.controller;

import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.employment.announcement.domain.Announcement;
import com.ruoyi.project.employment.announcement.service.IAnnouncementService;
import com.ruoyi.project.employment.information.domain.Information;
import com.ruoyi.project.employment.information.service.IInformationService;
import com.ruoyi.project.employment.link.domain.Link;
import com.ruoyi.project.employment.link.service.ILinkService;
import com.ruoyi.project.employment.news.domain.News;
import com.ruoyi.project.employment.news.service.INewsService;
import com.ruoyi.project.employment.policy.domain.Policy;
import com.ruoyi.project.employment.policy.service.IPolicyService;
import com.ruoyi.project.employment.skill.service.ISkillService;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.system.menu.domain.Menu;
import com.ruoyi.project.system.menu.service.IMenuService;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private IConfigService configService;

    @Autowired
    private RuoYiConfig ruoYiConfig;

    @Autowired
    private INewsService newsService;
    @Autowired
    private IInformationService informationService;
    @Autowired
    private IAnnouncementService announcementService;
    @Autowired
    private ILinkService linkService;
    @Autowired
    private IPolicyService policyService;
    @Autowired
    private ISkillService skillService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
        mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
        mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
        mmap.put("demoEnabled", ruoYiConfig.isDemoEnabled());
        return "index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap) {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        List<News> newsList = newsService.selectNewsList(new News());
        if (newsList.size() >= 8) {
            mmap.put("newsList", newsList.subList(0, 8));
        } else {
            mmap.put("newsList", newsList);
        }

        List<Information> informationList = informationService.selectInformationList(new Information());
        if (informationList.size() >= 8) {
            mmap.put("informationList", informationList.subList(0, 8));
        } else {
            mmap.put("informationList", informationList);
        }

        List<Announcement> announcementList = announcementService.selectAnnouncementList(new Announcement());
        if (announcementList.size() >= 8) {
            mmap.put("announcementList", announcementList.subList(0, 8));
        } else {
            mmap.put("announcementList", announcementList);
        }

        List<Policy> policyList = policyService.selectPolicyList(new Policy());
        if (policyList.size() >= 8) {
            mmap.put("policyList", policyList.subList(0, 8));
        } else {
            mmap.put("policyList", policyList);
        }

        List<Link> LinkList = linkService.selectLinkList(new Link());
        if (LinkList.size() >= 8) {
            mmap.put("linkList", LinkList.subList(0, 8));
        } else {
            mmap.put("linkList", LinkList);
        }
        return "portal/home";
    }
}
