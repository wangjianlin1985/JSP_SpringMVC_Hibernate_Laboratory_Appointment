// 
// 
// 

package service;

import java.io.IOException;
import entity.Course;
import entity.Term;
import entity.Announcement;
import java.util.List;
import entity.User;

public interface UserService
{
    User login(User p0);
    
    boolean update(User p0);
    
    List<User> getAllUser(User p0);
    
    boolean delUser(User p0);
    
    int addAnnouncement(Announcement p0);
    
    List<Announcement> getAnnouncement();
    
    int addTerm(Term p0);
    
    List<Term> getTermList();
    
    List<Course> getCourseList(int p0);
    
    int uploadCourse_User(int p0, String p1, String p2, String p3) throws IOException;
    
    int deleteAnnouncement(int p0);
}
