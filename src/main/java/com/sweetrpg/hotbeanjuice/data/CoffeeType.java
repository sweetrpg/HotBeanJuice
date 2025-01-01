package com.sweetrpg.hotbeanjuice.data;

import net.minecraft.util.StringRepresentable;

public enum CoffeeType implements StringRepresentable {
    ARABICA,
    CANEPHORA,
    RACEMOSA,
    ;

    @Override
    public String getSerializedName() {
        return this.name();
    }
}
