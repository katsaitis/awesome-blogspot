package com.owl.awesomeblogspot.domain.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name="body")
    private String body;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Post() {
        this.createdAt = new Date();
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = new Date();
    }
}
