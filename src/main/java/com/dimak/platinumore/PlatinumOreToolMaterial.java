package com.dimak.platinumore;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PlatinumOreToolMaterial implements ToolMaterial {

    public static final PlatinumOreToolMaterial INSTANCE = new PlatinumOreToolMaterial();
    @Override
    public int getDurability() {
        return 1561;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10F;
    }

    @Override
    public float getAttackDamage() {
        return 4F;
    }

    @Override
    public int getMiningLevel() {
        return 10;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PlatinumOreMod.PLATINUM_INGOT);
    }
}
