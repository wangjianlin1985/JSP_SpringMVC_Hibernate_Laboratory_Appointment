// 
// 
// 

package controller;

import entity.user_lab_reservation;
import java.util.Calendar;
import java.util.GregorianCalendar;
import entity.Laboratory;
import entity.lab_schedule;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.lang.StringUtils;
import entity.Reservation;
import other.ExecResult;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.Course;
import entity.Term;
import entity.lab_reservation;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import service.UserService;
import service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import service.ReserveLaboratoryService;
import org.springframework.stereotype.Controller;

@Controller
public class ReserveController
{
    @Autowired
    private ReserveLaboratoryService reserveLaboratoryService;
    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private UserService userService;
    
    @RequestMapping({ "getLabReserveById" })
    public ModelAndView getLabReserveById(final HttpServletRequest request, final HttpSession session) {
        final ModelAndView view = new ModelAndView("reservation");
        final int lab_id = Integer.parseInt(request.getParameter("lab_id"));
        final int user_id = Integer.parseInt(request.getParameter("user_id"));
        final List<lab_reservation> lab_reservation_list = this.reserveLaboratoryService.getLab_reservations(lab_id);
        view.addObject("lab_reservation_list", (Object)lab_reservation_list);
        view.addObject("lab_id", (Object)lab_id);
        final List<Term> termList = this.userService.getTermList();
        view.addObject("termList", (Object)termList);
        final List<Course> courseList = this.userService.getCourseList(user_id);
        view.addObject("courseList", (Object)courseList);
        return view;
    }
    
    @RequestMapping({ "reserveLab" })
    @ResponseBody
    public ExecResult reserveLab(final HttpSession session, final HttpServletRequest request) throws ParseException {
        final ExecResult er = new ExecResult();
        System.out.println("LaboratoryController - addLab");
        final Reservation reservation = new Reservation();
        if (StringUtils.isNotBlank(request.getParameter("course_id"))) {
            reservation.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
        }
        if (StringUtils.isNotBlank(request.getParameter("lab_id"))) {
            reservation.setLab_id(Integer.parseInt(request.getParameter("lab_id")));
        }
        if (StringUtils.isNotBlank(request.getParameter("user_id"))) {
            reservation.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        }
        if (StringUtils.isNotBlank(request.getParameter("reserve_type"))) {
            reservation.setReserve_type(Integer.parseInt(request.getParameter("reserve_type")));
        }
        if (StringUtils.isNotBlank(request.getParameter("time_interval"))) {
            reservation.setTime_interval(Integer.parseInt(request.getParameter("time_interval")));
        }
        if (StringUtils.isNotBlank(request.getParameter("weekday"))) {
            reservation.setWeekday(Integer.parseInt(request.getParameter("weekday")));
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date create_time = sdf.parse(request.getParameter("create_time"));
        reservation.setCreate_time(create_time);
        final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        if (Integer.parseInt(request.getParameter("reserve_type")) == 1) {
            if (StringUtils.isNotBlank(request.getParameter("person_number"))) {
                reservation.setPerson_number(Integer.parseInt(request.getParameter("person_number")));
            }
            final Date reserve_date = sdf2.parse(request.getParameter("reserve_date"));
            reservation.setReserve_date(reserve_date);
        }
        else {
            if (StringUtils.isNotBlank(request.getParameter("person_number2"))) {
                reservation.setPerson_number(Integer.parseInt(request.getParameter("person_number2")));
            }
            final Date reserve_date = sdf2.parse(request.getParameter("reserve_date2"));
            reservation.setReserve_date(reserve_date);
        }
        if (StringUtils.isNotBlank(request.getParameter("modify_time"))) {
            final Date modify_time = sdf.parse(request.getParameter("modify_time"));
            reservation.setModify_time(modify_time);
        }
        if (StringUtils.isNotBlank(request.getParameter("courseName"))) {
            reservation.setCourseName(request.getParameter("courseName"));
        }
        if (StringUtils.isNotBlank(request.getParameter("description"))) {
            reservation.setDescription(request.getParameter("description"));
        }
        final int result = this.reserveLaboratoryService.reserveLab(reservation);
        if (result > 0) {
            er.setMsg("\u606d\u559c\u60a8\uff0c\u9884\u7ea6\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u5b9e\u9a8c\u5ba4\u53ef\u4f9b\u9884\u7ea6\u4eba\u6570\u4e0d\u591f");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "schedule_table" })
    public ModelAndView schedule_table(final HttpServletRequest request, final HttpSession session) {
        final ModelAndView view = new ModelAndView("schedule_table");
        final int lab_id = Integer.parseInt(request.getParameter("lab_id"));
        final List<lab_schedule> list = this.reserveLaboratoryService.getSchedule_table(lab_id);
        final List<Laboratory> labList = this.laboratoryService.getAllLab();
        view.addObject("labList", (Object)labList);
        view.addObject("list", (Object)list);
        return view;
    }
    
    @RequestMapping({ "reservationByUser" })
    public ModelAndView reservationByUser(final HttpServletRequest request, final HttpSession session) {
        final ModelAndView view = new ModelAndView("manage_reservation_info");
        final int user_id = Integer.parseInt(request.getParameter("user_id"));
        final int user_type = Integer.parseInt(request.getParameter("user_type"));
        final List<lab_reservation> list = this.reserveLaboratoryService.reservationByUser(user_id);
        view.addObject("list", (Object)list);
        if (user_type == 2) {
            final List<lab_reservation> list2 = this.reserveLaboratoryService.ReservationTeacherForStudent(user_id);
            view.addObject("list2", (Object)list2);
        }
        return view;
    }
    
    @RequestMapping({ "deleteReservation" })
    @ResponseBody
    public ExecResult deleteReservation(final HttpSession session, final HttpServletRequest request) {
        final ExecResult er = new ExecResult();
        final int reserve_id = Integer.parseInt(request.getParameter("reserve_id"));
        final int result = this.reserveLaboratoryService.deleteReservation(reserve_id);
        if (result > 0) {
            er.setMsg("\u606d\u559c\u60a8\uff0c\u6210\u529f\u53d6\u6d88\u9884\u7ea6");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u53d6\u6d88\u9884\u7ea6\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "reserveLab2" })
    @ResponseBody
    public ExecResult reserveLab2(final HttpSession session, final HttpServletRequest request) throws ParseException {
        final ExecResult er = new ExecResult();
        int result = 0;
        final Reservation reservation = new Reservation();
        if (StringUtils.isNotBlank(request.getParameter("lab_id"))) {
            reservation.setLab_id(Integer.parseInt(request.getParameter("lab_id")));
        }
        if (StringUtils.isNotBlank(request.getParameter("user_id"))) {
            reservation.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        }
        if (StringUtils.isNotBlank(request.getParameter("reserve_type"))) {
            reservation.setReserve_type(Integer.parseInt(request.getParameter("reserve_type")));
        }
        if (StringUtils.isNotBlank(request.getParameter("course_id"))) {
            reservation.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
        }
        if (StringUtils.isNotBlank(request.getParameter("time_interval"))) {
            reservation.setTime_interval(Integer.parseInt(request.getParameter("time_interval")));
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date create_time = sdf.parse(request.getParameter("create_time"));
        reservation.setCreate_time(create_time);
        if (StringUtils.isNotBlank(request.getParameter("modify_time"))) {
            final Date modify_time = sdf.parse(request.getParameter("modify_time"));
            reservation.setModify_time(modify_time);
        }
        if (StringUtils.isNotBlank(request.getParameter("description"))) {
            reservation.setDescription(request.getParameter("description"));
        }
        if (StringUtils.isNotBlank(request.getParameter("from")) && StringUtils.isNotBlank(request.getParameter("end"))) {
            final String from = request.getParameter("from");
            final String end = request.getParameter("end");
            final int year1 = Integer.parseInt(from.substring(0, 4));
            final int month1 = Integer.parseInt(from.substring(5, 7));
            final int day1 = Integer.parseInt(from.substring(8, 10));
            final int year2 = Integer.parseInt(end.substring(0, 4));
            final int month2 = Integer.parseInt(end.substring(5, 7));
            final int day2 = Integer.parseInt(end.substring(8, 10));
            if (StringUtils.isNotBlank(request.getParameter("weekday"))) {
                final int weekday = Integer.parseInt(request.getParameter("weekday"));
                final Calendar calendar = new GregorianCalendar();
                final Calendar calendarEnd = new GregorianCalendar();
                calendar.set(1, year1);
                calendar.set(2, month1 - 1);
                calendar.set(5, day1 - 1);
                calendarEnd.set(1, year2);
                calendarEnd.set(2, month2 - 1);
                calendarEnd.set(5, day2 - 1);
                final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                while (calendar.getTime().getTime() <= calendarEnd.getTime().getTime()) {
                    if (calendar.get(7) == weekday + 1) {
                        final String date1 = sf.format(calendar.getTime());
                        final Date date2 = sf.parse(date1);
                        reservation.setReserve_date(date2);
                        reservation.setWeekday(weekday);
                        result = this.reserveLaboratoryService.reserveLab(reservation);
                    }
                    calendar.add(5, 1);
                }
            }
        }
        if (result > 0) {
            er.setMsg("\u606d\u559c\u60a8\uff0c\u9884\u7ea6\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u5b9e\u9a8c\u5ba4\u53ef\u4f9b\u9884\u7ea6\u4eba\u6570\u4e0d\u591f\uff0c\u8bf7\u8c03\u6574\u9884\u7ea6\u533a\u95f4\u6216\u8bfe\u5802");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "selectReservation" })
    public ModelAndView selectReservation(final HttpServletRequest request, final HttpSession session) {
        final ModelAndView view = new ModelAndView("selectReservation");
        int user_type = 0;
        String user_name = null;
        int reserve_type = 0;
        String from = null;
        String end = null;
        final int user_id = Integer.parseInt(request.getParameter("user_id"));
        if (StringUtils.isNotBlank(request.getParameter("user_type"))) {
            user_type = Integer.parseInt(request.getParameter("user_type"));
        }
        if (StringUtils.isNotBlank(request.getParameter("user_name"))) {
            user_name = request.getParameter("user_name");
        }
        if (StringUtils.isNotBlank(request.getParameter("reserve_type"))) {
            reserve_type = Integer.parseInt(request.getParameter("reserve_type"));
        }
        if (StringUtils.isNotBlank(request.getParameter("from"))) {
            from = request.getParameter("from");
        }
        if (StringUtils.isNotBlank(request.getParameter("end"))) {
            end = request.getParameter("end");
        }
        System.out.println("bjhed");
        final List<user_lab_reservation> list = this.reserveLaboratoryService.selectReservation(user_id, user_type, user_name, reserve_type, from, end);
        view.addObject("list1", (Object)list);
        return view;
    }
}
