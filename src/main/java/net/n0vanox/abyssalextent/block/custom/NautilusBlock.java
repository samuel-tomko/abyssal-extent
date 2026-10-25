package net.n0vanox.abyssalextent.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

//when update to 26.3 tutorial drops, make this extends BaseEntityBlock implements SimpleWaterloggedBlock
public class NautilusBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(1, 0, 0, 15, 18, 16);

    public NautilusBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    //@Override
    //public BlockState getStateForPlacement(final BlockPlaceContext context) {
    //    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    //}

}
