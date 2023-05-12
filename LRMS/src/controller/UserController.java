// 
// 
// 

package controller;

import java.io.IOException;
import entity.Term;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import entity.Announcement;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import other.ExecResult;
import javax.servlet.http.HttpSession;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping({ "login" })
    @ResponseBody
    public ExecResult login(final User user, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final User loginuser = this.userService.login(user);
        System.out.println(loginuser);
        if (loginuser == null) {
            er.setMsg("\u7528\u6237\u540d\u6216\u8005\u5bc6\u7801\u9519\u8bef");
            er.setSuccess(false);
        }
        else {
            session.setAttribute("loginuser", (Object)loginuser);
            er.setMsg("\u606d\u559c\u60a8\uff0c\u767b\u9646\u6210\u529f\uff01");
            er.setSuccess(true);
        }
        return er;
    }
    
    @RequestMapping({ "index" })
    public ModelAndView toMain() {
        final ModelAndView view = new ModelAndView("index");
        final List<Announcement> announcementList = this.userService.getAnnouncement();
        view.addObject("announcementList", (Object)announcementList);
        return view;
    }
    
    @RequestMapping({ "toLogin" })
    public ModelAndView toLogin() {
        final ModelAndView view = new ModelAndView("login");
        return view;
    }
    
    @RequestMapping({ "AnnouncementList" })
    public ModelAndView AnnouncementList() {
        final ModelAndView view = new ModelAndView("AnnouncementList");
        final List<Announcement> announcementList = this.userService.getAnnouncement();
        view.addObject("list", (Object)announcementList);
        return view;
    }
    
    @RequestMapping({ "changePwd" })
    @ResponseBody
    public ExecResult changePwd(final User user, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final boolean isupdate = this.userService.update(user);
        if (isupdate) {
            er.setMsg("\u606d\u559c\u4eb2\uff0c\u4f60\u662f\u7b2c\u4e00\u4e2a\u5bc6\u7801\u4fee\u6539\u6210\u529f\u7684\u4eba\u54df\uff01");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u4fee\u6539\u5931\u8d25\uff0c\u4eb2\uff0c\u4e0d\u8981\u4f24\u5fc3\uff0c\u4e0b\u6b21\u8fd8\u53ef\u4ee5\u4fee\u6539");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "userList" })
    public ModelAndView getAllUser(final User user, final int user_type) {
        final ModelAndView view = new ModelAndView("userList");
        user.setUser_type(user_type);
        final List<User> userList = this.userService.getAllUser(user);
        view.addObject("userList", (Object)userList);
        view.addObject("user_type", (Object)user_type);
        return view;
    }
    
    @RequestMapping({ "deleteUser" })
    @ResponseBody
    public ExecResult deleteUser(final User user, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final boolean isDel = this.userService.delUser(user);
        if (isDel) {
            er.setMsg("\u5220\u9664\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u5220\u9664\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "addAnnouncement" })
    @ResponseBody
    public ExecResult addAnnouncement(final HttpServletRequest request, final HttpSession session) throws ParseException {
        final ExecResult er = new ExecResult();
        final Announcement announcement = new Announcement();
        final String title = request.getParameter("title");
        final String content = request.getParameter("content");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date create_time = sdf.parse(request.getParameter("create_time"));
        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setCreate_time(create_time);
        final int result = this.userService.addAnnouncement(announcement);
        if (result > 0) {
            er.setMsg("\u516c\u544a\u53d1\u5e03\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u516c\u544a\u53d1\u5e03\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "addTerm" })
    @ResponseBody
    public ExecResult addTerm(final HttpServletRequest request, final HttpSession session) throws ParseException {
        final ExecResult er = new ExecResult();
        final Term term = new Term();
        final String term_name = request.getParameter("term_name");
        final String description = request.getParameter("description");
        final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        final Date from = sdf1.parse(request.getParameter("from"));
        final Date end = sdf1.parse(request.getParameter("end"));
        term.setTerm_name(term_name);
        term.setFrom_date(request.getParameter("from"));
        term.setEnd_date(request.getParameter("end"));
        term.setDescription(description);
        final int result = this.userService.addTerm(term);
        if (result > 0) {
            er.setMsg("\u65b0\u589e\u5b66\u671f\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u65b0\u589e\u5b66\u671f\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "uploadCourse_User" })
    @ResponseBody
    public ExecResult uploadCourse_User(final HttpServletRequest request, final HttpSession session) throws IOException {
        final ExecResult er = new ExecResult();
        System.out.println("uploadCourse_User:");
        final int js_id = Integer.parseInt(request.getParameter("js_id"));
        final String courseNumber = request.getParameter("courseNumber");
        final String courseName = request.getParameter("courseName");
        final String fileName = request.getParameter("fileName");
        System.out.println("user_id:" + js_id);
        System.out.println("courseName:" + courseName);
        System.out.println("fileName:" + fileName);
        final int result = this.userService.uploadCourse_User(js_id, courseNumber, courseName, fileName);
        if (result > 0) {
            er.setMsg("\u4e0a\u4f20\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u60a8\u672a\u6559\u6388\u6b64\u8bfe\u7a0b\uff0c\u6545\u4e0d\u80fd\u4e0a\u4f20\u76f8\u5173\u82b1\u540d\u518c");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "ManageAnnouncementList" })
    public ModelAndView ManageAnnouncementList() {
        final ModelAndView view = new ModelAndView("deleteAnnouncementList");
        final List<Announcement> announcementList = this.userService.getAnnouncement();
        view.addObject("list", (Object)announcementList);
        return view;
    }
    
    @RequestMapping({ "deleteAnnouncement" })
    @ResponseBody
    public ExecResult deleteAnnouncement(final HttpServletRequest request, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final int publish_id = Integer.parseInt(request.getParameter("publish_id"));
        final int result = this.userService.deleteAnnouncement(publish_id);
        if (result > 0) {
            er.setMsg("\u5220\u9664\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u5220\u9664\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
}
