package ladysnake.ratsmischief.common.item;

import ladysnake.ratsmischief.common.init.ModDataComponents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class RatMasterCloakItem extends RatMasterArmorItem {
	public RatMasterCloakItem(RatMasterArmorMaterial material, Type slot, Settings settings) {
		super(material, slot, settings);
	}

	public static boolean isStripped(ItemStack stack) {
		return Boolean.TRUE.equals(stack.get(ModDataComponents.USE_ALTERNATE_ARMOR));
	}

	@Override
	public void incrementType(ItemStack stack, boolean sneaking) {
		if (sneaking) {
			stack.set(ModDataComponents.USE_ALTERNATE_ARMOR, !stack.get(ModDataComponents.USE_ALTERNATE_ARMOR));
			return;
		}
		super.incrementType(stack, false);
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
		textConsumer.accept(Text.translatable("item.ratsmischief.rat_master_cloak.tooltip." + isStripped(stack)).formatted(Formatting.GRAY));
	}
}
