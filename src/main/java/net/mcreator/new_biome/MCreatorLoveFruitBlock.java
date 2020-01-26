package net.mcreator.new_biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@Elementsnew_biome.ModElement.Tag
public class MCreatorLoveFruitBlock extends Elementsnew_biome.ModElement {
	@ObjectHolder("new_biome:lovefruitblock")
	public static final Block block = null;

	public MCreatorLoveFruitBlock(Elementsnew_biome instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0f, 2f).lightValue(0).doesNotBlockMovement());
			setRegistryName("lovefruitblock");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer() {
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			return VoxelShapes.create(0.125D, 0.125D, 0.125D, 0.875D, 0.875D, 0.875D);
		}

		@Override
		public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return true;
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(MCreatorLoveFruitItem.block, (int) (1));
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.PINK;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(MCreatorLoveFruitItem.block, (int) (1)));
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("new_biome:cutebiome")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(new OreFeature(OreFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == DimensionType.OVERWORLD)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(world, generator, rand, pos, config);
				}
			}, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("lovefruitblock", "lovefruitblock", blockAt -> {
				boolean blockCriteria = false;
				if (blockAt.getBlock() == Blocks.OAK_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.OAK_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.SPRUCE_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.BIRCH_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.JUNGLE_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == Blocks.DARK_OAK_LEAVES.getDefaultState().getBlock())
					blockCriteria = true;
				return blockCriteria;
			}), block.getDefaultState(), 24), Placement.COUNT_RANGE, new CountRangeConfig(24, 0, 0, 256)));
		}
	}
}
