package com.example.community.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "email", length = 60, nullable = false)
    private String email;
 
    @Column(name = "telephone", length = 34)
    private String telephone;

    @OneToMany(mappedBy= "user", cascade = CascadeType.PERSIST)
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Claim> claims;

public UUID getId() {
    return id;
}

public void setId(UUID id) {
    this.id = id;
}


public List<Role> getRoles() {
    return roles;
}

public void setRoles(List<Role> roles) {
    this.roles = roles;
}

public List<Claim> getClaims() {
    return claims;
}

public void setClaims(List<Claim> claims) {
    this.claims = claims;
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

public String getTelephone() {
    return telephone;
}

public void setTelephone(String telephone) {
    this.telephone = telephone;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((claims == null) ? 0 : claims.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((roles == null) ? 0 : roles.hashCode());
    result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
    User other = (User) obj;
    if (claims == null) {
        if (other.claims != null)
            return false;
    } else if (!claims.equals(other.claims))
        return false;
    if (email == null) {
        if (other.email != null)
            return false;
    } else if (!email.equals(other.email))
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
    if (roles == null) {
        if (other.roles != null)
            return false;
    } else if (!roles.equals(other.roles))
        return false;
    if (telephone == null) {
        if (other.telephone != null)
            return false;
    } else if (!telephone.equals(other.telephone))
        return false;
    return true;
}

   
}
