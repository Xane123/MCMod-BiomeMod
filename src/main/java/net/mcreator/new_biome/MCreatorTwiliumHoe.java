package net.mcreator.new_biome;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@Elementsnew_biome.ModElement.Tag
public class MCreatorTwiliumHoe extends Elementsnew_biome.ModElement {
	@ObjectHolder("new_biome:twiliumhoe")
	public static final Item block = null;

	public MCreatorTwiliumHoe(Elementsnew_biome instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, 9f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("twiliumhoe"));
	}
}
