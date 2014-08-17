package net.famzangl.minecraft.minebot.build.blockbuild;

import net.famzangl.minecraft.minebot.Pos;
import net.famzangl.minecraft.minebot.ai.task.AITask;
import net.famzangl.minecraft.minebot.ai.task.BlockSide;
import net.famzangl.minecraft.minebot.ai.task.place.JumpingPlaceAtHalfTask;
import net.famzangl.minecraft.minebot.ai.task.place.SneakAndPlaceAtHalfTask;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BuildHalfslabTask extends CubeBuildTask {

	public static final Block[] BLOCKS = new Block[] { Blocks.stone_slab,
			Blocks.wooden_slab };
	private final BlockSide side;
	private final SlabType slabType;

	public BuildHalfslabTask(Pos forPosition, SlabType slabType, BlockSide up) {
		super(forPosition, new SlabFilter(slabType));
		this.slabType = slabType;
		this.side = up;
	}

	@Override
	public AITask getPlaceBlockTask(Pos relativeFromPos) {
		if (!isStandablePlace(relativeFromPos)) {
			throw new IllegalArgumentException("Cannot build standing there: "
					+ relativeFromPos);
		} else if (relativeFromPos.equals(FROM_GROUND)) {
			return new JumpingPlaceAtHalfTask(forPosition.x, forPosition.y + 1,
					forPosition.z, blockFilter, side);
		} else {
			return new SneakAndPlaceAtHalfTask(forPosition.x,
					forPosition.y + 1, forPosition.z, blockFilter,
					relativeFromPos, getMinHeightToBuild(), side);
		}
	}

	@Override
	protected double getBlockHeight() {
		return side == BlockSide.LOWER_HALF ? .5 : 1;
	}

	@Override
	public String toString() {
		return "BuildHalfslabTask [side=" + side + ", blockFilter="
				+ blockFilter + ", forPosition=" + forPosition + "]";
	}

	@Override
	public BuildTask withPositionAndRotation(Pos add, int rotateSteps,
			MirrorDirection mirror) {
		return new BuildHalfslabTask(add, slabType, side);
	}
}
