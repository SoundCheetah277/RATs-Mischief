package ladysnake.ratsmischief.common.item;

import ladysnake.ratsmischief.common.init.ModDataComponents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class RatMasterHoodItem extends RatMasterArmorItem {
	public RatMasterHoodItem(RatMasterArmorMaterial material, Type slot, Settings settings) {
		super(material, slot, settings);
	}

	public static boolean isHidden(ItemStack stack) {
		return Boolean.TRUE.equals(stack.get(ModDataComponents.USE_ALTERNATE_ARMOR));
	}

	@Override
	public void incrementType(ItemStack stack, boolean sneaking) {
		if (sneaking) {
			NbtCompound compound = (NbtCompound) stack.getComponents();
			compound.putBoolean("hidden", !compound.getBoolean("hidden"));
			return;
		}
		super.incrementType(stack, false);
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
		textConsumer.accept(Text.translatable("item.ratsmischief.rat_master_hood.tooltip." + isHidden(stack)).formatted(Formatting.GRAY));
	}
}
