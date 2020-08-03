package org.top.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.top.model.Payment;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
