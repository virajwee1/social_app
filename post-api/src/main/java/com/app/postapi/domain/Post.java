package com.app.postapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "post")
public class Post extends BaseEntity {

    @Column(name = "user_profile_id", nullable = false)
    private String userProfileId;

    @Column(name = "content", nullable = false)
    private String content;
}
