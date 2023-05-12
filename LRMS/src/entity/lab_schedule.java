// 
// 
// 

package entity;

import java.util.Date;

public class lab_schedule
{
    private int lab_id;
    private String building_name;
    private int room_number;
    private int person_number;
    private Date schedule_date;
    private int t1;
    private int t1_free;
    private int t2;
    private int t2_free;
    private int t3;
    private int t3_free;
    private int t4;
    private int t4_free;
    private int t5;
    private int t5_free;
    
    public lab_schedule(final int lab_id, final String building_name, final int room_number, final int person_number) {
        this.lab_id = lab_id;
        this.building_name = building_name;
        this.room_number = room_number;
        this.person_number = person_number;
    }
    
    public lab_schedule(final int lab_id, final String building_name, final int room_number, final int person_number, final Date schedule_date, final int t1, final int t1_free, final int t2, final int t2_free, final int t3, final int t3_free, final int t4, final int t4_free, final int t5, final int t5_free) {
        this.lab_id = lab_id;
        this.building_name = building_name;
        this.room_number = room_number;
        this.person_number = person_number;
        this.schedule_date = schedule_date;
        this.t1 = t1;
        this.t1_free = t1_free;
        this.t2 = t2;
        this.t2_free = t2_free;
        this.t3 = t3;
        this.t3_free = t3_free;
        this.t4 = t4;
        this.t4_free = t4_free;
        this.t5 = t5;
        this.t5_free = t5_free;
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
    
    public int getPerson_number() {
        return this.person_number;
    }
    
    public void setPerson_number(final int person_number) {
        this.person_number = person_number;
    }
    
    public Date getSchedule_date() {
        return this.schedule_date;
    }
    
    public void setSchedule_date(final Date schedule_date) {
        this.schedule_date = schedule_date;
    }
    
    public int getT1() {
        return this.t1;
    }
    
    public void setT1(final int t1) {
        this.t1 = t1;
    }
    
    public int getT1_free() {
        return this.t1_free;
    }
    
    public void setT1_free(final int t1_free) {
        this.t1_free = t1_free;
    }
    
    public int getT2() {
        return this.t2;
    }
    
    public void setT2(final int t2) {
        this.t2 = t2;
    }
    
    public int getT2_free() {
        return this.t2_free;
    }
    
    public void setT2_free(final int t2_free) {
        this.t2_free = t2_free;
    }
    
    public int getT3() {
        return this.t3;
    }
    
    public void setT3(final int t3) {
        this.t3 = t3;
    }
    
    public int getT3_free() {
        return this.t3_free;
    }
    
    public void setT3_free(final int t3_free) {
        this.t3_free = t3_free;
    }
    
    public int getT4() {
        return this.t4;
    }
    
    public void setT4(final int t4) {
        this.t4 = t4;
    }
    
    public int getT4_free() {
        return this.t4_free;
    }
    
    public void setT4_free(final int t4_free) {
        this.t4_free = t4_free;
    }
    
    public int getT5() {
        return this.t5;
    }
    
    public void setT5(final int t5) {
        this.t5 = t5;
    }
    
    public int getT5_free() {
        return this.t5_free;
    }
    
    public void setT5_free(final int t5_free) {
        this.t5_free = t5_free;
    }
}
