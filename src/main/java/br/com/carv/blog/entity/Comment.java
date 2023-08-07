package br.com.carv.blog.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table(name = "tb_comment")
@Entity
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    @Lob
    @Column(nullable = false)
    private String body;
    @ManyToOne
    @JoinColumn(updatable = false)
    private Post post;

    public Comment() {}

    public Comment(UUID uuid, String name, String email, String body) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Comment(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return Objects.equals(uuid, comment.uuid);
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }
}
