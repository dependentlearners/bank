package com.dependentlearner.bootifil.services.notification.service;

import com.dependentlearner.bootifil.services.notification.model.command.NotificationCommand;
import com.dependentlearner.bootifil.services.notification.model.representation.NotificationRepresentation;

public interface INotificationService {

    public NotificationRepresentation send(NotificationCommand command);
}
