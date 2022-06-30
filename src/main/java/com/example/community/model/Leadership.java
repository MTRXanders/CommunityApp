package com.example.community.model;

import java.util.UUID;

public class Leadership {
    private UUID id;

    private String name;

    private UUID comunityId;

    private UUID userId;
    
    public Leadership(UUID comunityId, UUID userId) {
        this.comunityId = comunityId;
        this.userId = userId;
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

    public UUID getComunityId() {
        return comunityId;
    }

    public void setComunityId(UUID comunityId) {
        this.comunityId = comunityId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comunityId == null) ? 0 : comunityId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        if (comunityId == null) {
            if (other.comunityId != null)
                return false;
        } else if (!comunityId.equals(other.comunityId))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    
}
