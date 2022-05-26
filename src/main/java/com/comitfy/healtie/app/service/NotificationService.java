package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.NotificationDTO;
import com.comitfy.healtie.app.dto.requestDTO.NotificationRequestDTO;
import com.comitfy.healtie.app.entity.Notification;
import com.comitfy.healtie.app.mapper.NotificationMapper;
import com.comitfy.healtie.app.repository.NotificationRepository;
import com.comitfy.healtie.app.specification.NotificationSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService extends BaseService<NotificationDTO, NotificationRequestDTO, Notification, NotificationRepository, NotificationMapper, NotificationSpecification> {

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    NotificationSpecification notificationSpecification;

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public NotificationRepository getRepository() {
        return notificationRepository;
    }

    @Override
    public NotificationMapper getMapper() {
        return notificationMapper;
    }

    @Override
    public NotificationSpecification getSpecification() {
        return notificationSpecification;
    }
}
