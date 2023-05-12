// 
// 
// 

package serviceimpl;

import entity.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.CourseDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import service.CourseService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseDao courseDao;
    
    @Override
    public List<Course> getAllCourse(final int user_id) {
        final List<Course> courseList = this.courseDao.getAllCourse(user_id);
        return courseList;
    }
    
    @Override
    public int addCourse(final Course course) {
        return this.courseDao.addCourse(course);
    }
    
    @Override
    public Course getCourseById(final int course_id) {
        return this.courseDao.getCourseById(course_id);
    }
    
    @Override
    public boolean updateCourse(final Course course) {
        return this.courseDao.updateCourse(course);
    }
    
    @Override
    public boolean deleteCourse(final int course_id) {
        return this.courseDao.deleteCourse(course_id);
    }
}
