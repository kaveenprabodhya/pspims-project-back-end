package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PersonDTO extends BaseItem {

    @NotBlank(message = "First name is required.")
    private String firstName;
    @NotBlank(message = "Last name is required.")
    private String lastName;
    @Email(message = "Invalid email format.")
    @NotBlank(message = "Email is required.")
    private String email;
    @NotBlank(message = "Address cannot be blank.")
    private String address;
}
