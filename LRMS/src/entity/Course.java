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
@Table(name = "Course")
public class Course implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Course_id")
    private int course_id;
    @Column(name = "CourseDescription")
    private String courseDescription;
    @Column(name = "CourseName")
    private String courseName;
    @Column(name = "CourseNumber")
    private String courseNumber;
    @Column(name = "Js_id")
    private int js_id;
    @Column(name = "Person_number")
    private int person_number;
    
    public int getPerson_number() {
        return this.person_number;
    }
    
    public void setPerson_number(final int person_number) {
        this.person_number = person_number;
    }
    
    public int getCourse_id() {
        return this.course_id;
    }
    
    public void setCourse_id(final int course_id) {
        this.course_id = course_id;
    }
    
    public String getCourseDescription() {
        return this.courseDescription;
    }
    
    public void setCourseDescription(final String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(final String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseNumber() {
        return this.courseNumber;
    }
    
    public void setCourseNumber(final String courseNumber) {
        this.courseNumber = courseNumber;
    }
    
    public int getJs_id() {
        return this.js_id;
    }
    
    public void setJs_id(final int js_id) {
        this.js_id = js_id;
    }
}
