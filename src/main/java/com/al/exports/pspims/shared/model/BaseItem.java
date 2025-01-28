package com.al.exports.pspims.shared.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Data
public class BaseItem {

    private UUID id;

    private Long version;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

    public boolean isNew() {
        return this.id == null;
    }
}
