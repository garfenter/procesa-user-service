package com.procesa.user.service.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author Juan Luis Cano <garfenter at adstter.com>
 */
@Entity
@NamedQueries(
        @NamedQuery(name = "User.findByNit", query = "SELECT u FROM User u WHERE u.email = :nit")
)
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    private Long dbid;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column
    private String status;

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
