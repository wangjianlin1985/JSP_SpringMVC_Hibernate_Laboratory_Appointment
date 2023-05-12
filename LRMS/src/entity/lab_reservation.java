// 
// 
// 

package entity;

import java.util.Date;

public class lab_reservation
{
    private int lab_id;
    private String building_name;
    private int room_number;
    private int lab_person_number;
    private int is_free;
    private String lab_description;
    private int reserve_id;
    private int reserve_type;
    private int course_id;
    private String course_name;
    private String js_name;
    private Date reserve_date;
    private int time_interval;
    private int weekday;
    private int r_person_number;
    private String r_description;
    private Date create_time;
    private long remain_person_number;
    
    public String getJs_name() {
        return this.js_name;
    }
    
    public void setJs_name(final String js_name) {
        this.js_name = js_name;
    }
    
    public lab_reservation(final int lab_id, final String building_name, final int room_number, final int lab_person_number, final int reserve_id, final int reserve_type, final int course_id, final String course_name, final Date reserve_date, final int time_interval, final int weekday, final int r_person_number, final String r_description, final Date create_time) {
        this.lab_id = lab_id;
        this.building_name = building_name;
        this.room_number = room_number;
        this.lab_person_number = lab_person_number;
        this.reserve_id = reserve_id;
        this.reserve_type = reserve_type;
        this.course_id = course_id;
        this.course_name = course_name;
        this.reserve_date = reserve_date;
        this.time_interval = time_interval;
        this.weekday = weekday;
        this.r_person_number = r_person_number;
        this.r_description = r_description;
        this.create_time = create_time;
    }
    
    public lab_reservation(final int lab_id, final String building_name, final int room_number, final int lab_person_number, final int is_free, final String lab_description, final int reserve_id, final int reserve_type, final int course_id, final Date reserve_date, final int time_interval, final int weekday, final int r_person_number, final String r_description, final Date create_time) {
        this.lab_id = lab_id;
        this.building_name = building_name;
        this.room_number = room_number;
        this.lab_person_number = lab_person_number;
        this.is_free = is_free;
        this.lab_description = lab_description;
        this.reserve_id = reserve_id;
        this.reserve_type = reserve_type;
        this.course_id = course_id;
        this.reserve_date = reserve_date;
        this.time_interval = time_interval;
        this.weekday = weekday;
        this.r_person_number = r_person_number;
        this.r_description = r_description;
        this.create_time = create_time;
    }
    
    public lab_reservation(final int lab_id, final String building_name, final int room_number, final int reserve_type, final Date reserve_date, final int time_interval, final long remain_person_number, final int is_free) {
        this.lab_id = lab_id;
        this.building_name = building_name;
        this.room_number = room_number;
        this.reserve_type = reserve_type;
        this.reserve_date = reserve_date;
        this.time_interval = time_interval;
        this.remain_person_number = remain_person_number;
        this.is_free = is_free;
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
    
    public Date getReserve_date() {
        return this.reserve_date;
    }
    
    public void setReserve_date(final Date reserve_date) {
        this.reserve_date = reserve_date;
    }
    
    public int getReserve_type() {
        return this.reserve_type;
    }
    
    public void setReserve_type(final int reserve_type) {
        this.reserve_type = reserve_type;
    }
    
    public int getTime_interval() {
        return this.time_interval;
    }
    
    public void setTime_interval(final int time_interval) {
        this.time_interval = time_interval;
    }
    
    public long getRemain_person_number() {
        return this.remain_person_number;
    }
    
    public void setRemain_person_number(final long remain_person_number) {
        this.remain_person_number = remain_person_number;
    }
    
    public int getIs_free() {
        return this.is_free;
    }
    
    public void setIs_free(final int is_free) {
        this.is_free = is_free;
    }
    
    public int getLab_person_number() {
        return this.lab_person_number;
    }
    
    public void setLab_person_number(final int lab_person_number) {
        this.lab_person_number = lab_person_number;
    }
    
    public String getLab_description() {
        return this.lab_description;
    }
    
    public void setLab_description(final String lab_description) {
        this.lab_description = lab_description;
    }
    
    public int getReserve_id() {
        return this.reserve_id;
    }
    
    public void setReserve_id(final int reserve_id) {
        this.reserve_id = reserve_id;
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
    
    public int getWeekday() {
        return this.weekday;
    }
    
    public void setWeekday(final int weekday) {
        this.weekday = weekday;
    }
    
    public int getR_person_number() {
        return this.r_person_number;
    }
    
    public void setR_person_number(final int r_person_number) {
        this.r_person_number = r_person_number;
    }
    
    public String getR_description() {
        return this.r_description;
    }
    
    public void setR_description(final String r_description) {
        this.r_description = r_description;
    }
    
    public Date getCreate_time() {
        return this.create_time;
    }
    
    public void setCreate_time(final Date create_time) {
        this.create_time = create_time;
    }
}
