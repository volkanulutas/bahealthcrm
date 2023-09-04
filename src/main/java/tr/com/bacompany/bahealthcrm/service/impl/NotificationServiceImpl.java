package tr.com.bacompany.bahealthcrm.service.impl;

import tr.com.bacompany.bahealthcrm.data.dto.TreatmentDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.RoleDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.UserDto;
import tr.com.bacompany.bahealthcrm.data.model.NotificationModel;
import tr.com.bacompany.bahealthcrm.service.NotificationService;
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
