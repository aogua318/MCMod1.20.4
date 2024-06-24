package net.aogua318.examplemod.item;

import net.aogua318.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * 创造模式物品栏
 */
public class ModCreativeTab {
    // 对应的注册器
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);
    // 这个string是鼠标移动到tab上的显示的内容。
    public static final String EXAMPLE_MOD_TAB_STRING = "creativetab.example_tab";//创造模式物品栏的 标签名称  在lang包里添加名字
    // 添加一个tab，title标题，icon显示图标，displayItem是指tab中添加的内容，这里传入一个lammabd表达式，通过poutput添加物品，这里添加了我们的ruby
    // 构建了一个创造模式物品栏
    public static final Supplier<CreativeModeTab> EXAMPLE_TAB  = CREATIVE_MODE_TABS.register("example_tab",() -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)    //物品栏位置
            .title(Component.translatable(EXAMPLE_MOD_TAB_STRING))//物品栏名称  进行国际化操作 在lang中能自定义名称
            //.title(Component.literal(EXAMPLE_MOD_TAB_STRING)) //上一个方法的写死用法
            .icon(()->ModItems.MP5Head.get().getDefaultInstance())  //物品栏图标   获取MP5Head这个物品的图标
            .displayItems((pParameters, pOutput) -> {//向物品栏里添加物品
                pOutput.accept(ModItems.RUBY.get());
                pOutput.accept(ModItems.MP5Head.get());
                pOutput.accept(ModItems.RUBY_BLOCK.get());
                pOutput.accept(ModItems.MAOMAO_BLOCK.get());

            })
            .build());

    //记得在总线上注册
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
