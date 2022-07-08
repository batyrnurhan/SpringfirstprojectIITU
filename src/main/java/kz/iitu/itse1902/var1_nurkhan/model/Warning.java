package kz.iitu.itse1902.var1_nurkhan.model;

import javax.persistence.*;

@Entity
@Table(name = "warning")
public class Warning {
    @Id
    @Column(name = "warning_id")
    private Long Id;
    @Column(name = "warning_title")
    private String title;
    @Column(name = "warning_desc")
    private String description;
    @Column(name = "warning_comp")
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User userWarning;

    public Warning() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUserWarning() {
        return userWarning;
    }

    public void setUserWarning(User userWarning) {
        this.userWarning = userWarning;
    }
}
