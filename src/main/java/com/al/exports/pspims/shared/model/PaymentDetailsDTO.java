package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.PaymentMethodEnum;
import com.al.exports.pspims.shared.enums.PaymentStatusEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentDetailsDTO extends BaseItem {

    @NotNull
    private PaymentStatusEnum paymentStatus;
    @PastOrPresent
    private Date paymentDate;
    @Positive
    private Float paymentAmount;
    @NotNull
    private BigInteger invoiceNo;
    @NotNull
    private PaymentMethodEnum paymentMethod;
}
