package net.mcreator.new_biome;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@Elementsnew_biome.ModElement.Tag
public class MCreatorTwiliumSword extends Elementsnew_biome.ModElement {
	@ObjectHolder("new_biome:twiliumsword")
	public static final Item block = null;

	public MCreatorTwiliumSword(Elementsnew_biome instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return null;
			}
		}, 3, -3F, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("twiliumsword"));
	}
}
