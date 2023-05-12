// 
// 
// 

package service;

import entity.Course;
import java.util.List;

public interface CourseService
{
    List<Course> getAllCourse(int p0);
    
    int addCourse(Course p0);
    
    Course getCourseById(int p0);
    
    boolean updateCourse(Course p0);
    
    boolean deleteCourse(int p0);
}
