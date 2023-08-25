package com.taskmanager.taskmanager.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description = "";
    @Column(nullable = false)
    private Date dueDate;

    @ManyToMany(mappedBy = "tasks")
    private List<User> assignees = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Invitation> invitations = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

}
