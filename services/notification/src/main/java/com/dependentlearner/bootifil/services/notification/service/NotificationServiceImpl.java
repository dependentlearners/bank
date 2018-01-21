package com.dependentlearner.bootifil.services.notification.service;

import com.dependentlearner.bootifil.services.notification.model.command.NotificationCommand;
import com.dependentlearner.bootifil.services.notification.model.representation.NotificationRepresentation;
import org.springframework.stereotype.Service;

public class NotificationServiceImpl implements INotificationService {

    @Override
    public NotificationRepresentation send(NotificationCommand command) {
        return new NotificationRepresentation();
    }

}
