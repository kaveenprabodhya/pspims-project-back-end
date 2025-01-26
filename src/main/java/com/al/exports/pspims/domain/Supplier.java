package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Supplier extends BaseEntity {

    @Builder
    public Supplier(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Person person,
                    SupplierStatusEnum supplierStatus, SupplierPaymentTermsEnum supplierPaymentTerms) {
        super(id, version, createdDate, lastModifiedDate);
        this.person = person;
        this.supplierStatus = supplierStatus;
        this.supplierPaymentTerms = supplierPaymentTerms;
    }

    private Person person;
    private SupplierStatusEnum supplierStatus;
    private SupplierPaymentTermsEnum supplierPaymentTerms;
}
