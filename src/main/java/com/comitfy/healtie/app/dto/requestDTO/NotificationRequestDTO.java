package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class NotificationRequestDTO extends BaseDTO {

    private String title;
    private String message;
    private String link;
    private boolean isSend;
    private String base64;
}
