package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.PaymentMethodEnum;
import com.al.exports.pspims.shared.enums.PaymentStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class PaymentDetails extends BaseEntity {

    @Builder
    public PaymentDetails(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                          PaymentStatusEnum paymentStatus, Date paymentDate, Float paymentAmount, BigInteger invoiceNo,
                          PaymentMethodEnum paymentMethod) {
        super(id, version, createdDate, lastModifiedDate);
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.invoiceNo = invoiceNo;
        this.paymentMethod = paymentMethod;
    }

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    private Date paymentDate;
    private Float paymentAmount;
    private BigInteger invoiceNo;
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @PrePersist
    private void generateInvoiceNumber() {
        if (this.invoiceNo == null) {
            this.invoiceNo = BigInteger.valueOf(System.currentTimeMillis());
        }
    }
}
