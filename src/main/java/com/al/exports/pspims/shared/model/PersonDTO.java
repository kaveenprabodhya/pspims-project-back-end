package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class PersonDTO extends BaseItem {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String address;
}
