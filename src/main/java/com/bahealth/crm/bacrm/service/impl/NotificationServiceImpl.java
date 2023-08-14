package com.bahealth.crm.bacrm.service.impl;

import com.bahealth.crm.bacrm.data.dto.TreatmentDto;
import com.bahealth.crm.bacrm.data.dto.user.RoleDto;
import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.model.NotificationModel;
import com.bahealth.crm.bacrm.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {
    public void notify(NotificationModel notification) {
        if (notification.getFrom() instanceof TreatmentDto) {
        } else if (notification.getFrom() instanceof UserDto) {
        }
        if (notification.getTo() instanceof RoleDto) {
            RoleDto to = (RoleDto) notification.getTo();
            notification.setTo(to.getName());
        }
        log.info("Notification is sent from to." + notification.toString());
        // TODO: rest call or mobile app. notification provider or email.
    }
}
