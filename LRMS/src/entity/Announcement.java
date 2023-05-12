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
@Table(name = "Announcement")
public class Announcement implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Publish_id")
    private int publish_id;
    @Column(name = "Content")
    private String content;
    @Column(name = "Title")
    private String title;
    @Column(name = "Create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;
    
    public int getPublish_id() {
        return this.publish_id;
    }
    
    public Date getCreate_time() {
        return this.create_time;
    }
    
    public void setCreate_time(final Date create_time) {
        this.create_time = create_time;
    }
    
    public void setPublish_id(final int publish_id) {
        this.publish_id = publish_id;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
}
