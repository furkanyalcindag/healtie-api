package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.NotificationDTO;
import com.comitfy.healtie.app.dto.requestDTO.NotificationRequestDTO;
import com.comitfy.healtie.app.entity.Notification;
import com.comitfy.healtie.app.mapper.NotificationMapper;
import com.comitfy.healtie.app.repository.NotificationRepository;
import com.comitfy.healtie.app.service.NotificationService;
import com.comitfy.healtie.app.specification.NotificationSpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController extends BaseCrudController<NotificationDTO, NotificationRequestDTO, Notification, NotificationRepository, NotificationMapper, NotificationSpecification, NotificationService> {

    @Autowired
    NotificationService notificationService;

    @Autowired
    NotificationMapper notificationMapper;

    @Override
    protected NotificationService getService() {
        return notificationService;
    }

    @Override
    protected NotificationMapper getMapper() {
        return notificationMapper;
    }
}
