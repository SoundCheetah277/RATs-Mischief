package ladysnake.ratsmischief.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RatMasterCloakItem extends RatMasterArmorItem {
	public RatMasterCloakItem(RatMasterArmorMaterial material, Type slot, Settings settings) {
		super(material, slot, settings);
	}

	public static boolean isStripped(ItemStack stack) {
		return stack.getComponents().getBoolean("stripped");
	}

	@Override
	public void incrementType(ItemStack stack, boolean sneaking) {
		if (sneaking) {
			NbtCompound compound = stack.getComponents();
			compound.putBoolean("stripped", !compound.getBoolean("stripped"));
			return;
		}
		super.incrementType(stack, false);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("item.ratsmischief.rat_master_cloak.tooltip." + stack.getComponents().getBoolean("stripped")).formatted(Formatting.GRAY));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
