package com.bahealth.crm.bacrm.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationModel<X, Y> {
    private X from; // Treatment, User etc.

    private Y to; // User, Role etc.

    private String message;

    private long date;
}
