package com.example.community.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "leaderships")
public class Leadership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "leadership_id")
    private UUID id;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "community_id")
    private Community comunity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public Leadership(Community comunity, User user) {
        this.comunity = comunity;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Community getComunity() {
        return comunity;
    }

    public void setComunity(Community comunity) {
        this.comunity = comunity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comunity == null) ? 0 : comunity.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Leadership other = (Leadership) obj;
        if (comunity == null) {
            if (other.comunity != null)
                return false;
        } else if (!comunity.equals(other.comunity))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    

    
}
