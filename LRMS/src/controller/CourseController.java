// 
// 
// 

package controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import other.ExecResult;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.Course;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import service.CourseService;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController
{
    @Autowired
    private CourseService courseService;
    
    @RequestMapping({ "courseList" })
    public ModelAndView getAllCourse(final int user_id) {
        final ModelAndView view = new ModelAndView("courseList");
        final List<Course> courseList = this.courseService.getAllCourse(user_id);
        view.addObject("courseList", (Object)courseList);
        return view;
    }
    
    @RequestMapping({ "addCourse" })
    @ResponseBody
    public ExecResult addCourse(final Course course, final HttpSession session) throws ParseException {
        final ExecResult er = new ExecResult();
        final int result = this.courseService.addCourse(course);
        if (result == 3) {
            er.setMsg("\u60a8\u5df2\u7ecf\u6709\u8be5\u8bfe\u7a0b\uff0c\u8bf7\u52ff\u91cd\u590d\u6dfb\u52a0\uff01");
            er.setSuccess(false);
        }
        else if (result > 0) {
            er.setMsg("\u6dfb\u52a0\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u6dfb\u52a0\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "getCourseById" })
    public ModelAndView getCourseById(final int course_id, final HttpSession session) {
        final ModelAndView view = new ModelAndView("updateCourse");
        final Course course = this.courseService.getCourseById(course_id);
        view.addObject("course", (Object)course);
        return view;
    }
    
    @RequestMapping({ "updateCourse" })
    @ResponseBody
    public ExecResult updateCourse(final Course course, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final boolean isUpdate = this.courseService.updateCourse(course);
        if (isUpdate) {
            er.setMsg("\u66f4\u65b0\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u66f4\u65b0\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "deleteCourse" })
    @ResponseBody
    public ExecResult deleteCourse(final int course_id, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final boolean isDel = this.courseService.deleteCourse(course_id);
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
}
