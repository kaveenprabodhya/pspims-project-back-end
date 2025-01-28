package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.PaymentMethodEnum;
import com.al.exports.pspims.shared.enums.PaymentStatusEnum;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PaymentDetails extends BaseEntity {

    private PaymentStatusEnum paymentStatus;
    private Date paymentDate;
    private Float paymentAmount;
    private BigInteger invoiceNo;
    private PaymentMethodEnum paymentMethod;
}
