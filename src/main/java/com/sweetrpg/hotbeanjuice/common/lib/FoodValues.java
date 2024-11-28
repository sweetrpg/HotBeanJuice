package com.sweetrpg.hotbeanjuice.common.lib;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodValues {

    public static final FoodProperties COFFEE = (new FoodProperties.Builder())
            .nutrition(3)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED), 0.5f)
            .alwaysEat()
            .build();
    public static final FoodProperties ESPRESSO = (new FoodProperties.Builder())
            .nutrition(3)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED), 1)
            .alwaysEat()
            .fast()
            .build();
    public static final FoodProperties CAPPUCCINO = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.5f)
            .alwaysEat()
            .fast()
            .build();
    public static final FoodProperties LATTE = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.5f)
            .alwaysEat()
            .fast()
            .build();
    public static final FoodProperties MOCHA = (new FoodProperties.Builder())
            .nutrition(3)
            .saturationMod(0.5f)
            .alwaysEat()
            .fast()
            .build();
    public static final FoodProperties MACCHIATO = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.5f)
            .alwaysEat()
            .fast()
            .build();
    public static final FoodProperties HOT_CHOCOLATE = (new FoodProperties.Builder())
            .nutrition(1)
            .saturationMod(0.5f)
            .alwaysEat()
            .build();

}
