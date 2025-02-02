package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.SupplierPaymentTermsEnum;
import com.al.exports.pspims.shared.enums.SupplierProductTypeEnum;
import com.al.exports.pspims.shared.enums.SupplierStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Supplier extends Person {

    @Builder
    public Supplier(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String firstName,
                    String lastName, String email, String address, SupplierStatusEnum supplierStatus,
                    SupplierPaymentTermsEnum supplierPaymentTerms, Agent agent,
                    Set<SupplierPaymentDetails> supplierPaymentDetails, Set<CoconutPurchase> coconutPurchase) {
        super(id, version, createdDate, lastModifiedDate, firstName, lastName, email, address);
        this.supplierStatus = supplierStatus;
        this.supplierPaymentTerms = supplierPaymentTerms;
        this.agent = agent;
        this.supplierPaymentDetails = supplierPaymentDetails;
        this.coconutPurchase = coconutPurchase;
    }

    @Enumerated(EnumType.STRING)
    private SupplierStatusEnum supplierStatus;
    @Enumerated(EnumType.STRING)
    private SupplierPaymentTermsEnum supplierPaymentTerms;
    @ManyToOne
    private Agent agent;
    // one sup to many pay
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<SupplierPaymentDetails> supplierPaymentDetails;
    // one sup to many cocoP
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<CoconutPurchase> coconutPurchase;
}
