package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public abstract class Person  extends BaseEntity {

    @Builder
    public Person(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String firstName,
                  String lastName, String email, String address, String registrationDate) {
        super(id, version, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String registrationDate;
}
