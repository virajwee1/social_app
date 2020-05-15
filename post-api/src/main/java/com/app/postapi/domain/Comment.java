package com.app.postapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "user_profile_id", nullable = false)
    private String userProfileId;

    @Column(name = "comment", nullable = false)
    private String commentText;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
