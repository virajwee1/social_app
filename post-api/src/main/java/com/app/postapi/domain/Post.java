package com.app.postapi.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "post")
public class Post extends BaseEntity{

    @Column(name = "user_profile_id",nullable = false)
    private String user_profile_id;

    @Column(name = "content",nullable = false)
    private String content;
}
