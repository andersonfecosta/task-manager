package com.taskmanager.taskmanager.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_task", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "inviter", cascade = CascadeType.ALL)
    private List<Invitation> sentInvitations = new ArrayList<>();

    @OneToMany(mappedBy = "invitee", cascade = CascadeType.ALL)
    private List<Invitation> receivedInvitations = new ArrayList<>();

}
