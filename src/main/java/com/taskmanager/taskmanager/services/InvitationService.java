package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.entities.Invitation;
import com.taskmanager.taskmanager.repositories.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvitationService {

    @Autowired
    private InvitationRepository invitationRepository;

    public Invitation getInvitationById(Long id) {
        return invitationRepository.findById(id).orElse(null);
    }
    public List<Invitation> getAllInvitations() {
        return invitationRepository.findAll();
    }
    public Invitation createInvitation(Invitation invitation) {
        return invitationRepository.save(invitation);
    }
    public Invitation updateInvitation(Long id, Invitation invitationUpdated) {
        Invitation invitation = invitationRepository.findById(id). orElse(null);
        if (invitation!=null) {
            invitation.setTask(invitationUpdated.getTask());
            invitation.setInviter(invitationUpdated.getInviter());
            invitation.setInvitee(invitationUpdated.getInvitee());
            invitation.setStatus(invitationUpdated.getStatus());
            return invitationRepository.save(invitation);
        }
        return null;
    }
    public void deleteInvitation(Long id) {
        invitationRepository.deleteById(id);
    }
}
