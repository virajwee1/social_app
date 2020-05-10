package com.app.postapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    @Column(name = "user_profile_id", nullable = false)
    private String userProfileId;

    @Column(name = "content", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "privacy")
    private Privacy privacy;

    @Enumerated(EnumType.STRING)
    @Column(name = "reaction")
    private Reaction reaction;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private List<Comment> commentList = new ArrayList<>();
}
