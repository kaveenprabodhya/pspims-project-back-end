package com.al.exports.pspims.shared.enums;

public enum InventoryQuantityTypeEnum {
    UNIT,         // Single countable item (e.g., one coconut, one bottle)
    KILOGRAM,     // Weight-based measurement
    GRAM,         // Smaller weight unit
    TONNE,        // Large weight measurement

    LITER,        // Volume-based measurement
    MILLILITER,   // Smaller volume unit

    PACK,         // Packaged units (e.g., a pack of 6 bottles)
    DOZEN,        // 12 units grouped together
    BOX,          // Box containing multiple units
    PACKET,       // Smaller packaging unit (e.g., spice packets)
    BARREL        // Large liquid container (e.g., coconut oil barrels)
}
