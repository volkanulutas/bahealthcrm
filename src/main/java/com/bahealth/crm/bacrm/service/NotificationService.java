package com.bahealth.crm.bacrm.service;

import com.bahealth.crm.bacrm.data.dto.user.RoleDto;
import com.bahealth.crm.bacrm.data.model.NotificationModel;

public interface NotificationService {
    void notify(NotificationModel notification);
}
