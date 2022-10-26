package net.cmbadiuk.tutorialmod.block;

import net.cmbadiuk.tutorialmod.TutorialMod;
import net.cmbadiuk.tutorialmod.block.custom.JumpBlock;
import net.cmbadiuk.tutorialmod.block.custom.TanzaniteLampBlock;
import net.cmbadiuk.tutorialmod.item.ModItemGroup;
import net.cmbadiuk.tutorialmod.item.custom.EggplantCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block TANZANITE_BLOCK = RegisterBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_ORE = RegisterBlock("tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block DEEPSLATE_TANZANITE_ORE = RegisterBlock("deepslate_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block JUMP_BLOCK = RegisterBlock("jump_block",
            new JumpBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_LAMP = RegisterBlock("tanzanite_lamp",
            new TanzaniteLampBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().luminance(state -> state.get(TanzaniteLampBlock.LIT) ? 15 : 0)), ModItemGroup.TANZANITE);

    public static final Block EGGPLANT_CROP = RegisterBlockWithoutItem("eggplant_crop",
            new EggplantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    private static Block RegisterBlock(String name, Block block, ItemGroup tab){
        RegisterBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }
    private static Block RegisterBlockWithoutItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item RegisterBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }


    public static void RegisterModBlocks() {
        TutorialMod.LOGGER.debug("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
