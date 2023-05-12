// 
// 
// 

package entity;

import java.util.Date;

public class user_lab_reservation
{
    private int lab_id;
    private String building_name;
    private int room_number;
    private int reserve_id;
    private int reserve_type;
    private int course_id;
    private String course_name;
    private Date reserve_date;
    private int time_interval;
    private int weekday;
    private int person_number;
    private String description;
    private Date create_time;
    private int user_id;
    private String login_name;
    private String user_name;
    private int user_type;
    
    public user_lab_reservation(final int lab_id, final String building_name, final int room_number, final int reserve_id, final int reserve_type, final int course_id, final String course_name, final Date reserve_date, final int time_interval, final int person_number, final String description, final Date create_time, final String login_name, final String user_name, final int user_type) {
        this.lab_id = lab_id;
        this.building_name = building_name;
        this.room_number = room_number;
        this.reserve_id = reserve_id;
        this.reserve_type = reserve_type;
        this.course_id = course_id;
        this.course_name = course_name;
        this.reserve_date = reserve_date;
        this.time_interval = time_interval;
        this.person_number = person_number;
        this.description = description;
        this.create_time = create_time;
        this.login_name = login_name;
        this.user_name = user_name;
        this.user_type = user_type;
    }
    
    public int getLab_id() {
        return this.lab_id;
    }
    
    public void setLab_id(final int lab_id) {
        this.lab_id = lab_id;
    }
    
    public String getBuilding_name() {
        return this.building_name;
    }
    
    public void setBuilding_name(final String building_name) {
        this.building_name = building_name;
    }
    
    public int getRoom_number() {
        return this.room_number;
    }
    
    public void setRoom_number(final int room_number) {
        this.room_number = room_number;
    }
    
    public int getReserve_id() {
        return this.reserve_id;
    }
    
    public void setReserve_id(final int reserve_id) {
        this.reserve_id = reserve_id;
    }
    
    public int getReserve_type() {
        return this.reserve_type;
    }
    
    public void setReserve_type(final int reserve_type) {
        this.reserve_type = reserve_type;
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
    
    public Date getReserve_date() {
        return this.reserve_date;
    }
    
    public void setReserve_date(final Date reserve_date) {
        this.reserve_date = reserve_date;
    }
    
    public int getTime_interval() {
        return this.time_interval;
    }
    
    public void setTime_interval(final int time_interval) {
        this.time_interval = time_interval;
    }
    
    public int getWeekday() {
        return this.weekday;
    }
    
    public void setWeekday(final int weekday) {
        this.weekday = weekday;
    }
    
    public int getPerson_number() {
        return this.person_number;
    }
    
    public void setPerson_number(final int person_number) {
        this.person_number = person_number;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public Date getCreate_time() {
        return this.create_time;
    }
    
    public void setCreate_time(final Date create_time) {
        this.create_time = create_time;
    }
    
    public int getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final int user_id) {
        this.user_id = user_id;
    }
    
    public String getLogin_name() {
        return this.login_name;
    }
    
    public void setLogin_name(final String login_name) {
        this.login_name = login_name;
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
