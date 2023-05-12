// 
// 
// 

package daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import entity.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import dao.CourseDao;

@Repository
public class CourseDaoImpl implements CourseDao
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Course> getAllCourse(final int user_id) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Course where js_id=?");
        final Query query = session.createQuery(hql.toString());
        query.setString(0, Integer.toString(user_id));
        return (List<Course>)query.list();
    }
    
    @Override
    public int addCourse(final Course course) {
        final Session session = this.sessionFactory.getCurrentSession();
        int result = 0;
        final StringBuffer hql = new StringBuffer("from Course where courseNumber=? and js_id=?");
        final Query query = session.createQuery(hql.toString());
        query.setString(0, course.getCourseNumber());
        query.setInteger(1, course.getJs_id());
        if (query.list().size() != 0) {
            return 3;
        }
        result = (int)session.save((Object)course);
        return result;
    }
    
    @Override
    public Course getCourseById(final int course_id) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Course where course_id=?");
        final Query query = session.createQuery(hql.toString());
        query.setInteger(0, course_id);
        return (Course)query.uniqueResult();
    }
    
    @Override
    public boolean updateCourse(final Course course) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("update Course set courseName=?,person_number=?,courseDescription=? where course_id=?");
        final Query query = session.createQuery(hql.toString());
        query.setString(0, course.getCourseName());
        query.setInteger(1, course.getPerson_number());
        query.setString(2, course.getCourseDescription());
        query.setInteger(3, course.getCourse_id());
        return query.executeUpdate() > 0;
    }
    
    @Override
    public boolean deleteCourse(final int course_id) {
        final StringBuffer hql = new StringBuffer("delete Course  where course_id=?");
        final Query query = this.sessionFactory.getCurrentSession().createQuery(hql.toString());
        query.setInteger(0, course_id);
        return query.executeUpdate() > 0;
    }
}
