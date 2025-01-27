package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BeverageType extends BaseEntity {

    private String beverageName;
    private String beverageDescription;
    private boolean isActive;
    private String nutritionInfo;

    //one to one
    @OneToOne
    private BeverageIngredients beverageIngredients;

    // one bevType hv many BevPO
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beverageType")
    private Set<BeverageProdOrder> beverageProdOrder;
}
