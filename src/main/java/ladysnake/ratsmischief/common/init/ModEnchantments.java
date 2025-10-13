package ladysnake.ratsmischief.common.init;

import ladysnake.ratsmischief.common.RatsMischief;
import ladysnake.ratsmischief.common.enchantments.RatCurseEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModEnchantments {
	RegistryKey<Enchantment> RAT_CURSE = RegistryKey.of(RegistryKeys.ENCHANTMENT, RatsMischief.id("rat_curse"));
	Map<Enchantment, Identifier> ENCHANTMENTS = new LinkedHashMap<>();
//TODO
	//Enchantment RAT_CURSE = createEnchantment("rat_curse", new RatCurseEnchantment(ENCHANTMENTS.Rarity.VERY_RARE, EquipmentSlot.values()));

	@SuppressWarnings("SameParameterValue")
	private static Enchantment createEnchantment(String name, Enchantment entity) {
		ENCHANTMENTS.put(entity, RatsMischief.id(name));
		return entity;
	}

	static void initialize() {
		ENCHANTMENTS.keySet().forEach(entityType -> Registry.register(Registries.ENCHANTMENT_PROVIDER_TYPE, ENCHANTMENTS.get(entityType), entityType));
	}
}
