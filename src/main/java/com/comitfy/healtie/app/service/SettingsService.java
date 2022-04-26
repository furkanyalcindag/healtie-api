package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.SettingsDTO;
import com.comitfy.healtie.app.dto.requestDTO.SettingsRequestDTO;
import com.comitfy.healtie.app.entity.Settings;
import com.comitfy.healtie.app.mapper.SettingsMapper;
import com.comitfy.healtie.app.repository.SettingsRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService extends BaseService<SettingsDTO, SettingsRequestDTO, Settings, SettingsRepository, SettingsMapper> {

    @Autowired
    SettingsRepository settingsRepository;

    @Autowired
    SettingsMapper settingsMapper;

    @Override
    public SettingsRepository getRepository() {
        return settingsRepository;
    }

    @Override
    public SettingsMapper getMapper() {
        return settingsMapper;
    }
}
