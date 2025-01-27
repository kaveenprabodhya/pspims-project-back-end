package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Supplier extends Person {

    private SupplierStatusEnum supplierStatus;
    private SupplierPaymentTermsEnum supplierPaymentTerms;
    // one sup to many pay
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<SupplierPaymentDetails> supplierPaymentDetails;
    // one sup to many cocoP
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<CoconutPurchase> coconutPurchase;
}
