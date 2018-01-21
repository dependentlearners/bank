package com.dependentlearner.bootifil.services.notification.controller;

import com.dependentlearner.bootifil.services.notification.model.command.NotificationCommand;
import com.dependentlearner.bootifil.services.notification.model.representation.NotificationRepresentation;
import com.dependentlearner.bootifil.services.notification.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notifications")
public class NotificationController {

    private INotificationService service;

    @Autowired
    public NotificationController(INotificationService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<NotificationRepresentation> send(@RequestBody NotificationCommand notificationCommand){
        return new ResponseEntity<NotificationRepresentation>(service.send(notificationCommand), HttpStatus.ACCEPTED);
    }
}
