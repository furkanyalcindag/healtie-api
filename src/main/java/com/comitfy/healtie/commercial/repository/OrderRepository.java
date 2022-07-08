package com.comitfy.healtie.commercial.repository;

import com.comitfy.healtie.commercial.entity.Orders;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends BaseRepository<Orders> {

    boolean existsByUserUUID(UUID uuid);
}
