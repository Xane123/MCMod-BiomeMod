package net.mcreator.new_biome;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsnew_biome.ModElement.Tag
public class MCreatorCookedLoveFruitFoodEaten extends Elementsnew_biome.ModElement {
	public MCreatorCookedLoveFruitFoodEaten(Elementsnew_biome instance) {
		super(instance, 31);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorCookedLoveFruitFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 3200, (int) 3, (false), (false)));
	}
}
