package com.al.exports.pspims.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
