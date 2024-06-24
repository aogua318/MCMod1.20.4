package net.aogua318.examplemod.block.custom;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

/**
 * 创建新方块  需要注册
 */
public class RubyBlock extends Block {

    public RubyBlock(){
        //继承铁块的属性，并且更硬
        super(Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(5f));
    }
}
