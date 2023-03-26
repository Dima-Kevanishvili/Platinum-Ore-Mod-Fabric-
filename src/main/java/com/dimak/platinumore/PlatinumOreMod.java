package com.dimak.platinumore;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlatinumOreMod implements ModInitializer {

    public static final String MOD_ID = "platinumore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Blocks
    public static final Block PLATINUM_ORE = new Block(
        FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F));
    public static final Block DEEPSLATE_PLATINUM_ORE = new Block(
        FabricBlockSettings.of(Material.STONE).strength(4.5F, 3.0F));

    // Items
    public static final Item RAW_PLATINUM = new Item(new FabricItemSettings());
    public static final Item PLATINUM_INGOT = new Item(new FabricItemSettings());

    // Tools
    public static ToolItem PLATINUM_SHOVEL = new ShovelItem(PlatinumOreToolMaterial.INSTANCE
        , 1.6F, -3.0F, new FabricItemSettings());
    public static ToolItem PLATINUM_AXE = new AxeItem(PlatinumOreToolMaterial.INSTANCE
        , 15F, -2.5F, new FabricItemSettings());
    public static ToolItem PLATINUM_PICKAXE = new PickaxeItem(PlatinumOreToolMaterial.INSTANCE
        , 1, -2.1F, new FabricItemSettings());
    public static ToolItem PLATINUM_SWORD = new SwordItem(PlatinumOreToolMaterial.INSTANCE
        , 10, -1.2F, new FabricItemSettings());
    // WorldGen
    public static final RegistryKey<PlacedFeature> PLATINUM_ORE_PLACED_FEATURE =
        RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "platinum_ore"));

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        // Blocks
        registerBlocks(PLATINUM_ORE, "platinum_ore");
        registerBlocks(DEEPSLATE_PLATINUM_ORE, "deepslate_platinum_ore");

        // Items
        registerItems(RAW_PLATINUM, "raw_platinum");
        registerItems(PLATINUM_INGOT, "platinum_ingot");
        registerItems(PLATINUM_SHOVEL, "platinum_shovel");
        registerItems(PLATINUM_AXE, "platinum_axe");
        registerItems(PLATINUM_PICKAXE, "platinum_pickaxe");
        registerItems(PLATINUM_SWORD, "platinum_sword");

        // Biomes
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES,
            PLATINUM_ORE_PLACED_FEATURE);
    }

    private void registerBlocks(Block block, String name) {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    private void registerItems(Item item, String name) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }
}
