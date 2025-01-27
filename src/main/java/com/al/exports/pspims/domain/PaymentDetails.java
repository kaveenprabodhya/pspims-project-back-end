package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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
