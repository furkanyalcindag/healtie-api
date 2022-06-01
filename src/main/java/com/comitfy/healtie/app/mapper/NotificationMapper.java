package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.NotificationDTO;
import com.comitfy.healtie.app.dto.requestDTO.NotificationRequestDTO;
import com.comitfy.healtie.app.entity.Notification;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationMapper implements BaseMapper<NotificationDTO, NotificationRequestDTO, Notification> {

    @Override
    public NotificationDTO entityToDTO(Notification entity) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle(entity.getTitle());
        notificationDTO.setMessage(entity.getMessage());
        notificationDTO.setLink(entity.getLink());
        notificationDTO.setSend(entity.isSend());
        notificationDTO.setUuid(entity.getUuid());
        notificationDTO.setBase64(entity.getBase64());
        return notificationDTO;
    }

    @Override
    public Notification dtoToEntity(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setLink(dto.getLink());
        notification.setSend(dto.isSend());
        notification.setBase64(dto.getBase64());
        return notification;
    }

    @Override
    public Notification requestDTOToEntity(NotificationRequestDTO dto) {
        Notification notification = new Notification();
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setLink(dto.getLink());
        notification.setSend(dto.isSend());
        notification.setUuid(dto.getUuid());
        notification.setBase64(dto.getBase64());
        return notification;
    }

    @Override
    public Notification requestDTOToExistEntity(Notification notification, NotificationRequestDTO dto) {
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setLink(dto.getLink());
        notification.setSend(dto.isSend());
        notification.setBase64(dto.getBase64());
        return notification;
    }

    @Override
    public List<Notification> dtoListToEntityList(List<NotificationDTO> notificationDTOS) {
        List<Notification> notificationList = new ArrayList<>();
        for (NotificationDTO notificationDTO : notificationDTOS) {
            Notification notification = dtoToEntity(notificationDTO);
            notificationList.add(notification);
        }
        return notificationList;
    }

    @Override
    public List<NotificationDTO> entityListToDTOList(List<Notification> notifications) {
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = entityToDTO(notification);
            notificationDTOList.add(notificationDTO);
        }
        return notificationDTOList;
    }

    @Override
    public PageDTO<NotificationDTO> pageEntityToPageDTO(Page<Notification> pageEntity) {
        PageDTO<NotificationDTO> pageDTO = new PageDTO<NotificationDTO>();
        List<Notification> entityList = pageEntity.toList();
        List<NotificationDTO> notificationDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, notificationDTOList);
        return pageDTO;
    }
}
