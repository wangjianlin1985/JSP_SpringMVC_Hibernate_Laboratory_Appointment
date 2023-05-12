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
@Table(name = "User")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    private int user_id;
    @Column(name = "Age")
    private int age;
    @Column(name = "Institute")
    private String institute;
    @Column(name = "Is_firstlogin")
    private int is_firstlogin;
    @Column(name = "Login_name")
    private String login_name;
    @Column(name = "Major")
    private String major;
    @Column(name = "Password")
    private String password;
    @Column(name = "Sex")
    private int sex;
    @Column(name = "User_name")
    private String user_name;
    @Column(name = "User_type")
    private int user_type;
    
    public int getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final int user_id) {
        this.user_id = user_id;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(final int age) {
        this.age = age;
    }
    
    public String getInstitute() {
        return this.institute;
    }
    
    public void setInstitute(final String institute) {
        this.institute = institute;
    }
    
    public int getIs_firstlogin() {
        return this.is_firstlogin;
    }
    
    public void setIs_firstlogin(final int is_firstlogin) {
        this.is_firstlogin = is_firstlogin;
    }
    
    public String getLogin_name() {
        return this.login_name;
    }
    
    public void setLogin_name(final String login_name) {
        this.login_name = login_name;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(final String major) {
        this.major = major;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public int getSex() {
        return this.sex;
    }
    
    public void setSex(final int sex) {
        this.sex = sex;
    }
    
    public String getUser_name() {
        return this.user_name;
    }
    
    public void setUser_name(final String user_name) {
        this.user_name = user_name;
    }
    
    public int getUser_type() {
        return this.user_type;
    }
    
    public void setUser_type(final int user_type) {
        this.user_type = user_type;
    }
}
