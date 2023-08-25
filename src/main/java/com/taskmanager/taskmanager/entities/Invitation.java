package com.taskmanager.taskmanager.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_invitation")
@Data
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "inviter_id")
    private User inviter;

    @ManyToOne
    @JoinColumn(name = "invitee_id")
    private User invitee;

    @Enumerated(EnumType.STRING)
    private InvitationStatus status;
}
