package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.commercial.dto.PaymentMomentDTO;
import com.comitfy.healtie.commercial.dto.request.PaymentMomentRequestDTO;
import com.comitfy.healtie.commercial.entity.PaymentMoment;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMomentMapper implements BaseMapper<PaymentMomentDTO, PaymentMomentRequestDTO, PaymentMoment> {
    @Override
    public PaymentMomentDTO entityToDTO(PaymentMoment entity) {
        PaymentMomentDTO paymentMomentDTO = new PaymentMomentDTO();
        paymentMomentDTO.setUserUUID(entity.getUserUUID());
        paymentMomentDTO.setOrderUUID(entity.getOrderUUID());
        paymentMomentDTO.setOrderDate(entity.getOrderDate());
        paymentMomentDTO.setDeliveryDate(entity.getDeliveryDate());
        paymentMomentDTO.setPaidAmount(entity.getPaidAmount());
      //  paymentMomentDTO.setTotalPrice(entity.getTotalPrice());
        paymentMomentDTO.setPaymentTypeEnum(entity.getPaymentTypeEnum());
      //  paymentMomentDTO.setRemainingMoney(entity.getRemainingMoney());

        paymentMomentDTO.setUuid(entity.getUuid());
        return paymentMomentDTO;
    }

    @Override
    public PaymentMoment dtoToEntity(PaymentMomentDTO dto) {
        PaymentMoment paymentMoment = new PaymentMoment();
        paymentMoment.setUserUUID(dto.getUserUUID());
        paymentMoment.setOrderUUID(dto.getOrderUUID());
        paymentMoment.setOrderDate(dto.getOrderDate());
        paymentMoment.setDeliveryDate(dto.getDeliveryDate());
        paymentMoment.setPaidAmount(dto.getPaidAmount());
      //  paymentMoment.setTotalPrice(dto.getTotalPrice());
        paymentMoment.setPaymentTypeEnum(dto.getPaymentTypeEnum());
      //  paymentMoment.setRemainingMoney(dto.getRemainingMoney());
        return paymentMoment;

    }

    @Override
    public PaymentMoment requestDTOToEntity(PaymentMomentRequestDTO dto) {
        PaymentMoment paymentMoment = new PaymentMoment();
        paymentMoment.setUserUUID(dto.getUserUUID());
        paymentMoment.setOrderUUID(dto.getOrderUUID());
        paymentMoment.setOrderDate(dto.getOrderDate());
        paymentMoment.setDeliveryDate(dto.getDeliveryDate());
        paymentMoment.setPaidAmount(dto.getPaidAmount());
      //  paymentMoment.setTotalPrice(dto.getTotalPrice());
        paymentMoment.setPaymentTypeEnum(dto.getPaymentTypeEnum());
      //  paymentMoment.setRemainingMoney(dto.getRemainingMoney());
        return paymentMoment;
    }

    @Override
    public PaymentMoment requestDTOToExistEntity(PaymentMoment paymentMoment, PaymentMomentRequestDTO dto) {

        paymentMoment.setUserUUID(dto.getUserUUID());
        paymentMoment.setOrderUUID(dto.getOrderUUID());
        paymentMoment.setOrderDate(dto.getOrderDate());
        paymentMoment.setDeliveryDate(dto.getDeliveryDate());
        paymentMoment.setPaidAmount(dto.getPaidAmount());
      //  paymentMoment.setTotalPrice(dto.getTotalPrice());
        paymentMoment.setPaymentTypeEnum(dto.getPaymentTypeEnum());
      //  paymentMoment.setRemainingMoney(dto.getRemainingMoney());
        return paymentMoment;
    }

    @Override
    public List<PaymentMoment> dtoListToEntityList(List<PaymentMomentDTO> paymentMomentDTOS) {
        List<PaymentMoment> paymentMomentList = new ArrayList<PaymentMoment>();
        for (PaymentMomentDTO paymentMomentDTO : paymentMomentDTOS) {
            PaymentMoment paymentMoment = dtoToEntity(paymentMomentDTO);
            paymentMomentList.add(paymentMoment);
        }
        return paymentMomentList;
    }

    @Override
    public List<PaymentMomentDTO> entityListToDTOList(List<PaymentMoment> paymentMoments) {
        List<PaymentMomentDTO> paymentMomentDTOList = new ArrayList<PaymentMomentDTO>();
        for (PaymentMoment paymentMoment : paymentMoments) {
            PaymentMomentDTO paymentMomentDTO = entityToDTO(paymentMoment);
            paymentMomentDTOList.add(paymentMomentDTO);
        }
        return paymentMomentDTOList;
    }

    @Override
    public PageDTO<PaymentMomentDTO> pageEntityToPageDTO(Page<PaymentMoment> pageEntity) {
        PageDTO<PaymentMomentDTO> pageDTO = new PageDTO<PaymentMomentDTO>();
        List<PaymentMoment> entityList = pageEntity.toList();
        List<PaymentMomentDTO> paymentMomentDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, paymentMomentDTOList);

        return pageDTO;
    }
}

