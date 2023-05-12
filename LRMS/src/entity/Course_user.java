// 
// 
// 

package entity;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "Course_user")
public class Course_user implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Course_id")
    private int course_id;
    @Column(name = "Course_name")
    private String course_name;
    @Column(name = "User_id")
    private int user_id;
    @Column(name = "User_name")
    private String user_name;
    @Column(name = "Sumscore")
    private int sumscore;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getCourse_id() {
        return this.course_id;
    }
    
    public void setCourse_id(final int course_id) {
        this.course_id = course_id;
    }
    
    public String getCourse_name() {
        return this.course_name;
    }
    
    public void setCourse_name(final String course_name) {
        this.course_name = course_name;
    }
    
    public int getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final int user_id) {
        this.user_id = user_id;
    }
    
    public String getUser_name() {
        return this.user_name;
    }
    
    public void setUser_name(final String user_name) {
        this.user_name = user_name;
    }
    
    public int getSumscore() {
        return this.sumscore;
    }
    
    public void setSumscore(final int sumscore) {
        this.sumscore = sumscore;
    }
}
