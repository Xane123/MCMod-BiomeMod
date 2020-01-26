package net.mcreator.new_biome;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@Elementsnew_biome.ModElement.Tag
public class MCreatorCuteDirtRandomTickUpdateEvent extends Elementsnew_biome.ModElement {
	public MCreatorCuteDirtRandomTickUpdateEvent(Elementsnew_biome instance) {
		super(instance, 3);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorCuteDirtRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorCuteDirtRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorCuteDirtRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorCuteDirtRandomTickUpdateEvent!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getLight(new BlockPos((int) x, (int) y, (int) z))) >= 10)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MCreatorCuteGrass.block.getDefaultState(), 3);
		}
	}
}
