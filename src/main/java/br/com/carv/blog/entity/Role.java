package br.com.carv.blog.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_role")
@Entity
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(nullable = false, length = 50)
    private String description;
    public Role() {}
    public Role(String description) {
        this.description = description;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
