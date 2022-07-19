package com.comitfy.healtie.commercial.repository;

import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends BaseRepository<Order> {

    boolean existsByUserUUID(UUID uuid);
}
