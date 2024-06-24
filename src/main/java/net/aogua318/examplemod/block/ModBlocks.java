package net.aogua318.examplemod.block;

import net.aogua318.examplemod.ExampleMod;
import net.aogua318.examplemod.block.custom.MaomaoBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.aogua318.examplemod.block.custom.RubyBlock;

import java.util.function.Supplier;

import static net.aogua318.examplemod.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ExampleMod.MODID);
    public static final Supplier<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final Supplier<Block> MAOMAO_BLOCK = BLOCKS.register("maomao_block", MaomaoBlock::new);
    public static Supplier<Block> registerBlock(String name,Supplier<Block> block){
        Supplier<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    public static void registerBlockItem(String name, Supplier<Block> block){
        registerBlockItem(name, block, new Item.Properties());
    }
    public static void registerBlockItem(String name, Supplier<Block> block, Item.Properties properties){
        ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
