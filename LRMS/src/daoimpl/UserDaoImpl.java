// 
// 
// 

package daoimpl;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.util.Iterator;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import entity.Course_user;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import entity.Course;
import entity.Term;
import entity.Announcement;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public User login(final User user) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from User where login_name=? and password=? ");
        final Query query = session.createQuery(hql.toString());
        query.setString(0, user.getLogin_name());
        query.setString(1, user.getPassword());
        return (User)query.uniqueResult();
    }
    
    @Override
    public boolean update(final User user) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("update User set");
        System.out.println(user.getIs_firstlogin() == 0);
        if (user.getIs_firstlogin() == 1) {
            hql.append(" password='" + user.getPassword() + "'");
        }
        else {
            hql.append(" is_firstlogin=1");
        }
        if (user.getUser_id() != 0) {
            hql.append("  where User_id=" + user.getUser_id());
        }
        else {
            hql.append("  where Login_name='" + user.getLogin_name() + "'");
        }
        final Query query = session.createQuery(hql.toString());
        return query.executeUpdate() > 0;
    }
    
    @Override
    public List<User> getAllUser(final User user) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from User where user_type='" + user.getUser_type() + "'");
        final Query query = session.createQuery(hql.toString());
        return (List<User>)query.list();
    }
    
    @Override
    public boolean delUser(final User user) {
        final StringBuffer hql = new StringBuffer("delete User  where user_id=?");
        final Query query = this.sessionFactory.getCurrentSession().createQuery(hql.toString());
        query.setInteger(0, user.getUser_id());
        return query.executeUpdate() > 0;
    }
    
    @Override
    public int addAnnouncement(final Announcement announcement) {
        final Session session = this.sessionFactory.getCurrentSession();
        final int result = (int)session.save((Object)announcement);
        return result;
    }
    
    @Override
    public List<Announcement> getAnnouncement() {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Announcement order by create_time DESC");
        final Query query = session.createQuery(hql.toString());
        return (List<Announcement>)query.list();
    }
    
    @Override
    public int addTerm(final Term term) {
        final Session session = this.sessionFactory.getCurrentSession();
        final int result = (int)session.save((Object)term);
        return result;
    }
    
    @Override
    public List<Term> getTermList() {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Term where end_date>curdate()");
        final Query query = session.createQuery(hql.toString());
        return (List<Term>)query.list();
    }
    
    @Override
    public List<Course> getCourseList(final int user_id) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Course where js_id=" + user_id);
        final Query query = session.createQuery(hql.toString());
        return (List<Course>)query.list();
    }
    
    @Override
    public int uploadCourse_User(final int js_id, final String courseNumber, final String courseName, final String fileName) throws IOException {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Course where js_id=" + js_id + " and courseNumber=" + courseNumber);
        final Query query = session.createQuery(hql.toString());
        if (query.list().size() == 0) {
            return 0;
        }
        int result = 0;
        final InputStream is = new FileInputStream("");
        final XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        final ArrayList<Course_user> list = new ArrayList<Course_user>();
        for (final XSSFSheet xssfSheet : xssfWorkbook) {
            if (xssfSheet == null) {
                continue;
            }
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); ++rowNum) {
                final XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                final int minColIx = xssfRow.getFirstCellNum();
                final int maxColIx = xssfRow.getLastCellNum();
                if (xssfRow != null) {
                    final Course_user course_user = new Course_user();
                    final Course course = this.getCourseByNumber(courseNumber);
                    course_user.setCourse_id(course.getCourse_id());
                    course_user.setCourse_name(course.getCourseName());
                    final User user = this.getUserByLoginName(xssfRow.getCell(0).toString());
                    course_user.setUser_id(user.getUser_id());
                    course_user.setUser_name(xssfRow.getCell(1).toString());
                    course_user.setSumscore(0);
                    result = (int)session.save((Object)course_user);
                }
            }
        }
        return result;
    }
    
    public Course getCourseByNumber(final String courseNumber) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Course where courseNumber='" + courseNumber + "'");
        final Query query = session.createQuery(hql.toString());
        return (Course)query.uniqueResult();
    }
    
    public User getUserByLoginName(final String login_name) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from User where login_name=" + login_name);
        final Query query = session.createQuery(hql.toString());
        return (User)query.uniqueResult();
    }
    
    @Override
    public int deleteAnnouncement(final int publish_id) {
        final StringBuffer hql = new StringBuffer("delete Announcement  where publish_id=?");
        final Query query = this.sessionFactory.getCurrentSession().createQuery(hql.toString());
        query.setInteger(0, publish_id);
        return query.executeUpdate();
    }
}
