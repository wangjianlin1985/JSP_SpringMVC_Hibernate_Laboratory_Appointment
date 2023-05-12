// 
// 
// 

package serviceimpl;

import java.io.IOException;
import entity.Course;
import entity.Term;
import entity.Announcement;
import java.util.List;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import dao.UserDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    
    @Override
    public User login(final User user) {
        System.out.println("UserServiceImpl");
        final User loginUser = this.userDao.login(user);
        if (loginUser != null && loginUser.getIs_firstlogin() == 0) {
            this.userDao.update(loginUser);
        }
        return loginUser;
    }
    
    @Override
    public boolean update(final User user) {
        user.setIs_firstlogin(1);
        final boolean isupdate = this.userDao.update(user);
        return isupdate;
    }
    
    @Override
    public List<User> getAllUser(final User user) {
        return this.userDao.getAllUser(user);
    }
    
    @Override
    public boolean delUser(final User user) {
        final boolean isDel = this.userDao.delUser(user);
        return isDel;
    }
    
    @Override
    public int addAnnouncement(final Announcement announcement) {
        final int result = this.userDao.addAnnouncement(announcement);
        return result;
    }
    
    @Override
    public List<Announcement> getAnnouncement() {
        return this.userDao.getAnnouncement();
    }
    
    @Override
    public int addTerm(final Term term) {
        return this.userDao.addTerm(term);
    }
    
    @Override
    public List<Term> getTermList() {
        return this.userDao.getTermList();
    }
    
    @Override
    public List<Course> getCourseList(final int user_id) {
        return this.userDao.getCourseList(user_id);
    }
    
    @Override
    public int uploadCourse_User(final int js_id, final String courseNumber, final String courseName, final String fileName) throws IOException {
        return this.userDao.uploadCourse_User(js_id, courseNumber, courseName, fileName);
    }
    
    @Override
    public int deleteAnnouncement(final int publish_id) {
        return this.userDao.deleteAnnouncement(publish_id);
    }
}
