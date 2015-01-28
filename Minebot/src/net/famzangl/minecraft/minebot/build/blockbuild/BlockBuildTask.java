package net.famzangl.minecraft.minebot.build.blockbuild;

import net.famzangl.minecraft.minebot.ai.BlockItemFilter;
import net.famzangl.minecraft.minebot.ai.BlockWhitelist;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public class BlockBuildTask extends CubeBuildTask {

	public static final BlockWhitelist BLOCKS = new BlockWhitelist(Blocks.dirt,
			Blocks.stone, Blocks.cobblestone, Blocks.beacon, Blocks.bookshelf,
			Blocks.brick_block, Blocks.cake, Blocks.coal_block,
			Blocks.coal_ore, Blocks.crafting_table, Blocks.diamond_block,
			Blocks.diamond_ore, Blocks.emerald_block, Blocks.emerald_ore,
			Blocks.end_stone, Blocks.glass, Blocks.gold_block, Blocks.gold_ore,
			Blocks.grass, Blocks.gravel, Blocks.hay_block, Blocks.iron_block,
			Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore,
			Blocks.melon_block, Blocks.mossy_cobblestone, Blocks.nether_brick,
			Blocks.netherrack, Blocks.obsidian, Blocks.pumpkin,
			Blocks.quartz_block, Blocks.quartz_ore, Blocks.red_mushroom_block,
			Blocks.redstone_block, Blocks.redstone_lamp, Blocks.redstone_ore,
			Blocks.sand, Blocks.stonebrick, Blocks.tnt);

	public BlockBuildTask(BlockPos forPosition, Block blockToPlace) {
		this(forPosition, new BlockItemFilter(blockToPlace));
	}

	private BlockBuildTask(BlockPos forPosition, BlockItemFilter blockFilter) {
		super(forPosition, blockFilter);
	}

	@Override
	public String toString() {
		return "BlockBuildTask [blockFilter=" + blockFilter + ", forPosition="
				+ forPosition + "]";
	}

	@Override
	public BuildTask withPositionAndRotation(BlockPos add, int rotateSteps,
			MirrorDirection mirror) {
		return new BlockBuildTask(add, this.blockFilter);
	}
}
