package org.libbrechtjordy.rabbitsbreedsjavaee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JordyL
 */
@Entity
@Table(name = "RABBITSBREED")
public class RabbitsBreed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "RABR_SEQ")
    @SequenceGenerator(name = "RABR_SEQ", sequenceName = "RABR_SEQ")
    @Column(name = "RABR_ID")
    private Long id;
    
    @Column(name = "BREED")
    @Size(min=1, message="{rabbitsBreed.breed.size}")
    private String breed;
    
    @Column(name = "WEIGHT")
    @NotNull(message="{rabbitsBreed.weight.notNull}")  
    private Double weight;
    
    @Temporal(TemporalType.DATE)
    private Date dateAdded; 

    public RabbitsBreed(){
        this.setDateAdded(new Date());
    }
    
    /*public RabbitsBreed(String breed, double weight) {
        this.breed = breed;
        this.weight = weight;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RabbitsBreed)) {
            return false;
        }
        RabbitsBreed other = (RabbitsBreed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.libbrechtjordy.rabbitsbreedsjavaee.entities.Rabbit[ id=" + id + " ]";
    }
    
}
