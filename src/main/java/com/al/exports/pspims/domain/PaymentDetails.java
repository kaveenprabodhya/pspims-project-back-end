package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.PaymentMethodEnum;
import com.al.exports.pspims.shared.enums.PaymentStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
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
