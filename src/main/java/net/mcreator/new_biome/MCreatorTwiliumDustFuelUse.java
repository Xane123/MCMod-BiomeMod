package net.mcreator.new_biome;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

@Elementsnew_biome.ModElement.Tag
public class MCreatorTwiliumDustFuelUse extends Elementsnew_biome.ModElement {
	public MCreatorTwiliumDustFuelUse(Elementsnew_biome instance) {
		super(instance, 35);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MCreatorTwiliumDust.block, (int) (1)).getItem())
			event.setBurnTime(600);
	}
}
