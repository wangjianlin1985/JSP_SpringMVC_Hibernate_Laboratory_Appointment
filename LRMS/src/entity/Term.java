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
@Table(name = "Term")
public class Term implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Term_id")
    private int term_id;
    @Column(name = "Term_name")
    private String term_name;
    @Column(name = "From_date")
    private String from_date;
    @Column(name = "End_date")
    private String end_date;
    @Column(name = "Description")
    private String description;
    
    public int getTerm_id() {
        return this.term_id;
    }
    
    public void setTerm_id(final int term_id) {
        this.term_id = term_id;
    }
    
    public String getTerm_name() {
        return this.term_name;
    }
    
    public void setTerm_name(final String term_name) {
        this.term_name = term_name;
    }
    
    public String getFrom_date() {
        return this.from_date;
    }
    
    public void setFrom_date(final String from) {
        this.from_date = from;
    }
    
    public String getEnd_date() {
        return this.end_date;
    }
    
    public void setEnd_date(final String end) {
        this.end_date = end;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String Description) {
        this.description = Description;
    }
}
