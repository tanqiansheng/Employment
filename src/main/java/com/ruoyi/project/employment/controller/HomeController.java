package com.ruoyi.project.employment.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.employment.announcement.domain.Announcement;
import com.ruoyi.project.employment.announcement.service.IAnnouncementService;
import com.ruoyi.project.employment.calendar.domain.Calendar;
import com.ruoyi.project.employment.calendar.service.ICalendarService;
import com.ruoyi.project.employment.information.domain.Information;
import com.ruoyi.project.employment.information.service.IInformationService;
import com.ruoyi.project.employment.link.domain.Link;
import com.ruoyi.project.employment.link.service.ILinkService;
import com.ruoyi.project.employment.news.domain.News;
import com.ruoyi.project.employment.news.service.INewsService;
import com.ruoyi.project.employment.policy.domain.Policy;
import com.ruoyi.project.employment.policy.service.IPolicyService;
import com.ruoyi.project.employment.skill.domain.Skill;
import com.ruoyi.project.employment.skill.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author June
 * @description
 */
@Controller
public class HomeController extends BaseController {
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
    @Autowired
    private ICalendarService calendarService;
    @GetMapping("/home")
    public String home(ModelMap mmap) {
        List<News> newsList = newsService.selectNewsNormalList(new News());
        if(newsList.size()>=8){
            mmap.put("newsList", newsList.subList(0, 8));
        }
        else{
            mmap.put("newsList", newsList);
        }

        List<Information> informationList = informationService.selectNormalInformationList(new Information());
        if(informationList.size()>=8){
            mmap.put("informationList",informationList.subList(0, 8));
        }
        else{
            mmap.put("informationList",informationList);
        }


        List<Announcement> announcementList = announcementService.selectNormalAnnouncementList( new Announcement());
        if(announcementList.size()>=8){
            mmap.put("announcementList",announcementList.subList(0, 8));
        }
        else{
            mmap.put("announcementList",announcementList);
        }

        List<Policy> policyList = policyService.selectNormalPolicyList(new Policy());
        if(policyList.size()>=8){
            mmap.put("policyList",policyList.subList(0, 8));
        }
        else{
            mmap.put("policyList",policyList);
        }


        List<Link> LinkList = linkService.selectNormalLinkList( new Link());
        if(LinkList.size()>=8){
            mmap.put("linkList",LinkList.subList(0, 8));
        }
        else{
            mmap.put("linkList",LinkList);
        }


        List<Calendar> calendarList = calendarService.selectNormalCalendarList( new Calendar());
        if(calendarList.size()>=8){
            mmap.put("calendarList",calendarList.subList(0, 8));
        }
        else{
            mmap.put("calendarList",calendarList);
        }
        return "portal/home";
    }


    @GetMapping("/news")
    public String news(ModelMap mmap) {
        return "portal/news/newsList";
    }


    @GetMapping("/showNews")
    public String showNews(ModelMap mmap, Long id) {
        News news = newsService.selectNewsById(id);
        newsService.updateVisitTimes(id);
        mmap.addAttribute("news", news);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, news.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/news/newsDetails";
    }


    @PostMapping("/newsList")
    @ResponseBody
    public TableDataInfo list(News news) {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }




    @GetMapping("/information")
    public String information(ModelMap mmap) {
        return "portal/information/informationList";
    }


    @GetMapping("/showInformation")
    public String showInformation(ModelMap mmap, Long id) {
        Information information = informationService.selectInformationById(id);
        informationService.updateVisitTimes(id);
        mmap.addAttribute("information", information);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, information.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/information/informationDetails";
    }


    @PostMapping("/informationList")
    @ResponseBody
    public TableDataInfo list(Information information) {
        startPage();
        List<Information> list = informationService.selectInformationList(information);
        return getDataTable(list);
    }


    @GetMapping("/announcement")
    public String announcement(ModelMap mmap) {
        return "portal/announcement/announcementList";
    }


    @GetMapping("/showAnnouncement")
    public String showAnnouncement(ModelMap mmap, Long id) {
        Announcement announcement = announcementService.selectAnnouncementById(id);
        announcementService.updateVisitTimes(id);
        mmap.addAttribute("announcement", announcement);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, announcement.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/announcement/announcementDetails";
    }


    @PostMapping("/announcementList")
    @ResponseBody
    public TableDataInfo list(Announcement announcement) {
        startPage();
        List<Announcement> list = announcementService.selectAnnouncementList(announcement);
        return getDataTable(list);
    }


    @GetMapping("/link")
    public String link(ModelMap mmap) {
        return "portal/link/linkList";
    }


    @GetMapping("/showLink")
    public String showLink(ModelMap mmap, Long id) {
        Link link = linkService.selectLinkById(id);
        mmap.addAttribute("link", link);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, link.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/link/linkDetails";
    }


    @PostMapping("/linkList")
    @ResponseBody
    public TableDataInfo list(Link link) {
        startPage();
        List<Link> list = linkService.selectLinkList(link);
        return getDataTable(list);
    }


    @GetMapping("/policy")
    public String policy(ModelMap mmap) {
        return "portal/policy/policyList";
    }


    @GetMapping("/showPolicy")
    public String showpolicy(ModelMap mmap, Long id) {
        Policy policy = policyService.selectPolicyById(id);
        policyService.updateVisitTimes(id);
        mmap.addAttribute("policy", policy);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, policy.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/policy/policyDetails";
    }


    @PostMapping("/policyList")
    @ResponseBody
    public TableDataInfo list(Policy policy) {
        startPage();
        List<Policy> list = policyService.selectPolicyList(policy);
        return getDataTable(list);
    }


    @GetMapping("/skill")
    public String skill(ModelMap mmap) {
        return "portal/skill/skillList";
    }


    @GetMapping("/showSkill")
    public String showSkill(ModelMap mmap, Long id) {
        Skill skill = skillService.selectSkillById(id);
        skillService.updateVisitTimes(id);
        mmap.addAttribute("skill", skill);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, skill.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/skill/skillDetails";
    }
    @PostMapping("/skillList")
    @ResponseBody
    public TableDataInfo list(Skill skill) {
        startPage();
        List<Skill> list = skillService.selectSkillList(skill);
        return getDataTable(list);
    }

    @GetMapping("/calendar")
    public String calendar(ModelMap mmap) {
        return "portal/calendar/calendarList";
    }


    @GetMapping("/showCalendar")
    public String showCalendar(ModelMap mmap, Long id) {
        Calendar calendar = calendarService.selectCalendarById(id);
        calendarService.updateVisitTimes(id);
        mmap.addAttribute("calendar", calendar);
        String releaseTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, calendar.getReleaseTime());
        mmap.addAttribute("releaseTime", releaseTime);
        return "portal/calendar/calendarDetails";
    }
    @PostMapping("calendarList")
    @ResponseBody
    public TableDataInfo list(Calendar calendar) {
        startPage();
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        return getDataTable(list);
    }
}
