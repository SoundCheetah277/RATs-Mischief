package ladysnake.ratsmischief.common.init;

import ladysnake.ratsmischief.common.RatsMischief;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModBlocks {
	Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();

	Block MOD_BLOCK = createBlock("mod_block", new ModBlocks(Map.of(BLOCKS, MapColor.DEEPSLATE_GRAY).strength(-1.0F, 3600000.0F).sounds(BlockSoundGroup.COPPER)), true);

	static void initialize() {
		BLOCKS.keySet().forEach(block -> Registry.register(Registries.BLOCK, BLOCKS.get(block), block));
	}

	private static <T extends Block> T createBlock(String name, T block, boolean createItem) {
		BLOCKS.put(block, RatsMischief.id(name));
		if (createItem) {
			ModItems.ITEMS.put(new BlockItem(block, new Item.Settings()), BLOCKS.get(block));
		}
		return block;
	}
}
