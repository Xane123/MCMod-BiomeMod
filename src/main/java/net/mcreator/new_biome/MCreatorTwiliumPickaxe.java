package net.mcreator.new_biome;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@Elementsnew_biome.ModElement.Tag
public class MCreatorTwiliumPickaxe extends Elementsnew_biome.ModElement {
	@ObjectHolder("new_biome:twiliumpickaxe")
	public static final Item block = null;

	public MCreatorTwiliumPickaxe(Elementsnew_biome instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
		}, 1, -3F, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("twiliumpickaxe"));
	}
}
