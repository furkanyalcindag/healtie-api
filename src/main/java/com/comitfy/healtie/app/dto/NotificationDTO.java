package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class NotificationDTO extends BaseDTO {

    private String title;
    private String message;
    private String link;
    private boolean isSend;
    private String base64;

}
