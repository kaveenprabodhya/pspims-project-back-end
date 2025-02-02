package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeverageType extends BaseEntity {

    @Builder
    public BeverageType(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String beverageName,
                        String beverageDescription, Boolean isActive, String nutritionInfo, List<BeverageIngredients> beverageIngredients,
                        Set<BeverageProdOrder> beverageProdOrder) {
        super(id, version, createdDate, lastModifiedDate);
        this.beverageName = beverageName;
        this.beverageDescription = beverageDescription;
        this.isActive = isActive;
        this.nutritionInfo = nutritionInfo;
        this.beverageIngredients = beverageIngredients;
        this.beverageProdOrder = beverageProdOrder;
    }

    private String beverageName;
    private String beverageDescription;
    private Boolean isActive;
    private String nutritionInfo;

    //one to one
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beverageType")
    private List<BeverageIngredients> beverageIngredients;

    // one bevType hv many BevPO
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beverageType")
    private Set<BeverageProdOrder> beverageProdOrder;
}
