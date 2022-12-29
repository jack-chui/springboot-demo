package com.example.demo.repositories.entities;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Log4j2
public abstract class BaseEntity implements Serializable {
    @CreatedDate        // set this date when insert
    private Date createdAt;

    @LastModifiedDate   // set this date when upsert
    private Date updatedAt;

    @PrePersist
    @PreUpdate
    @PreRemove
    private void preOperation() {
        // you add data when the DB record update, like createdAt, updatedAt
        log.info("Entity update");
    }
}
