package com.mgmetehan.WeTalk.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @CreatedDate
    @Column(nullable = false)
    protected Date createdDate;

    @LastModifiedDate
    protected Date lastModifiedDate;

    private boolean enable = true;

    private boolean isDeleted = false;

    @PrePersist
    public void onCreate() {
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedDate = new Date();
    }

    public abstract <T extends BaseEntity> void update(T entity);

}