package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.PaymentMethodEnum;
import com.al.exports.pspims.shared.enums.PaymentStatusEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PaymentDetailsDTO extends BaseItem {

    @NotNull(message = "Payment status is required.")
    private PaymentStatusEnum paymentStatus;
    @PastOrPresent(message = "Payment date cannot be in the future.")
    private Date paymentDate;
    @Positive(message = "Payment amount must be a positive number.")
    private Float paymentAmount;
    @NotNull(message = "Invoice number is required.")
    private BigInteger invoiceNo;
    @NotNull(message = "Payment method cannot be null.")
    private PaymentMethodEnum paymentMethod;
}
