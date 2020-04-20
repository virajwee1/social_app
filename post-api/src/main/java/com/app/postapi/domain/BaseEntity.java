package com.app.postapi.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id",length = 36)
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private String id;

    @CreatedDate
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}
