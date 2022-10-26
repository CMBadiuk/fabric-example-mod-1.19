package net.cmbadiuk.tutorialmod;

import net.cmbadiuk.tutorialmod.block.ModBlocks;
import net.cmbadiuk.tutorialmod.item.ModItems;
import net.cmbadiuk.tutorialmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// I'm learnding!
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.RegisterModItems();
		ModBlocks.RegisterModBlocks();
		ModLootTableModifiers.modifyLootTables();
	}
}
