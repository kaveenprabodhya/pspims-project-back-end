package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.PaymentMethodEnum;
import com.al.exports.pspims.shared.enums.PaymentStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentDetailsDTO extends BaseItem {

    private PaymentStatusEnum paymentStatus;
    private Date paymentDate;
    private Float paymentAmount;
    private BigInteger invoiceNo;
    private PaymentMethodEnum paymentMethod;
}
