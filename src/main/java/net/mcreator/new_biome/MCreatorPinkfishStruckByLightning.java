package net.mcreator.new_biome;

import net.minecraft.world.World;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

@Elementsnew_biome.ModElement.Tag
public class MCreatorPinkfishStruckByLightning extends Elementsnew_biome.ModElement {
	public MCreatorPinkfishStruckByLightning(Elementsnew_biome instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorPinkfishStruckByLightning!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorPinkfishStruckByLightning!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorPinkfishStruckByLightning!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorPinkfishStruckByLightning!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorPinkfishStruckByLightning!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) 15);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			if (!world.isRemote) {
				Entity entityToSpawn = new SilverfishEntity(EntityType.SILVERFISH, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
