package com.dependentlearner.bootifil.services.notification.controller;

import com.dependentlearner.bootifil.services.notification.NotificationApplication;
import com.dependentlearner.bootifil.services.notification.model.command.NotificationCommand;
import com.dependentlearner.bootifil.services.notification.model.representation.NotificationRepresentation;
import com.dependentlearner.bootifil.services.notification.service.NotificationServiceImpl;
import com.netflix.discovery.converters.Auto;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationApplication.class)
public class NotificationControllerTest {

    @Autowired
    private NotificationController subjectUnderTest;

    @Before
    public void init(){
        //subjectUnderTest = new NotificationController(new NotificationServiceImpl());
    }

    @BeforeClass
    public static void setup(){
        System.out.println("before running");
    }

    @Test
    public void testNotification(){
        Assert.assertEquals(new NotificationRepresentation(), subjectUnderTest.send(new NotificationCommand()).getBody());
    }

    @After
    public void tearDown(){
        System.out.println("tearing down");
    }
}