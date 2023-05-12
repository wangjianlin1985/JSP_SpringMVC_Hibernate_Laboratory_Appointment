// 
// 
// 

package entity;

import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "Schedule")
public class Schedule implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Schedule_id")
    private int schedule_id;
    @Column(name = "Lab_id")
    private int lab_id;
    @Column(name = "Schedule_date")
    @Temporal(TemporalType.DATE)
    private Date schedule_date;
    @Column(name = "T1")
    private int t1;
    @Column(name = "T2")
    private int t2;
    @Column(name = "T3")
    private int t3;
    @Column(name = "T4")
    private int t4;
    @Column(name = "T5")
    private int t5;
    
    public int getSchedule_id() {
        return this.schedule_id;
    }
    
    public void setSchedule_id(final int schedule_id) {
        this.schedule_id = schedule_id;
    }
    
    public int getLab_id() {
        return this.lab_id;
    }
    
    public void setLab_id(final int lab_id) {
        this.lab_id = lab_id;
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
    
    public int getT2() {
        return this.t2;
    }
    
    public void setT2(final int t2) {
        this.t2 = t2;
    }
    
    public int getT3() {
        return this.t3;
    }
    
    public void setT3(final int t3) {
        this.t3 = t3;
    }
    
    public int getT4() {
        return this.t4;
    }
    
    public void setT4(final int t4) {
        this.t4 = t4;
    }
    
    public int getT5() {
        return this.t5;
    }
    
    public void setT5(final int t5) {
        this.t5 = t5;
    }
}
