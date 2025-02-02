package com.al.exports.pspims.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@ToString(callSuper = true)
public class Person extends BaseEntity {

    public Person(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String firstName,
                  String lastName, String email, String address) {
        super(id, version, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String address;
}
