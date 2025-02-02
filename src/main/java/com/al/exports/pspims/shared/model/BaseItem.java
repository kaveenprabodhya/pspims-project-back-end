package com.al.exports.pspims.shared.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BaseItem {

    private UUID id;

    private Long version;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

}
