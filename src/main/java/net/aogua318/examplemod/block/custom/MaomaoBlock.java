package net.aogua318.examplemod.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MaomaoBlock extends Block {
    public MaomaoBlock(){
        //继承草方块，修改硬度
        super(Properties.ofFullCopy(Blocks.GRASS_BLOCK).strength(5f));
    }
}
