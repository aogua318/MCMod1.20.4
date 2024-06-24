package net.aogua318.examplemod.item;

import net.aogua318.examplemod.ExampleMod;
import net.aogua318.examplemod.block.ModBlocks;
import net.aogua318.examplemod.item.custom.MP5HeadItem;
import net.aogua318.examplemod.item.custom.RubyItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    /**
     * 第一个参数  注册的类型
     * 第二个参数  模组的ID
     * 返回值      注册器
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ExampleMod.MODID);

    /**
     * 注册器
     * 第一个参数，name物品名字
     * Item对象  也可以是自己写的ITEM对象
     */
    public static final Supplier<Item> RUBY = ITEMS.register("ruby",() -> new RubyItem(new Item.Properties()));
   //添加第二个物品
    public static final Supplier<Item> MP5Head = ITEMS.register("mp5head",() -> new MP5HeadItem(new Item.Properties()));

    //注册物品
    public static final Supplier<Item> RUBY_BLOCK = ITEMS.register("ruby_block",()->new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> MAOMAO_BLOCK = ITEMS.register("maomao_block",()->new BlockItem(ModBlocks.MAOMAO_BLOCK.get(), new Item.Properties()));


    /**
     * 将注册机添加到总线
     * @param eventBus
     */

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
