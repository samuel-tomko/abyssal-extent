package net.n0vanox.abyssalextent.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplates {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final Component UPGRADE_TITLE = Component
            .translatable(Util.makeDescriptionId("upgrade", Identifier.fromNamespaceAndPath("abyssal-extent", "prismalloy_upgrade_smithing_template")))
            .withStyle(TITLE_FORMAT);

    private static final Component APPLIES_TO = Component
            .translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath("abyssal-extent", "smithing_template.prismalloy_upgrade.applies_to")))
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component INGREDIENTS = Component
            .translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath("abyssal-extent", "smithing_template.prismalloy_upgrade.ingredients")))
            .withStyle(DESCRIPTION_FORMAT);

    private static final Component BASE_SLOT_DESC = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath("abyssal-extent", "smithing_template.prismalloy_upgrade.base_slot_description")));

    private static final Component ADDITIONS_SLOT_DESC = Component.translatable(
            Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath("abyssal-extent", "smithing_template.prismalloy_upgrade.additions_slot_description")));

    public static SmithingTemplateItem createPrismalloyUpgrade(Item.Properties properties) {
        return new SmithingTemplateItem(
                APPLIES_TO, INGREDIENTS,
                BASE_SLOT_DESC, ADDITIONS_SLOT_DESC,
                baseSlotIcons(), additionsSlotIcons(), properties.rarity(Rarity.UNCOMMON));
    }

    private static List<Identifier> baseSlotIcons() {
        return List.of(
                vanilla("container/slot/helmet"),
                vanilla("container/slot/sword"),
                vanilla("container/slot/chestplate"),
                vanilla("container/slot/pickaxe"),
                vanilla("container/slot/leggings"),
                vanilla("container/slot/axe"),
                vanilla("container/slot/boots"),
                vanilla("container/slot/hoe"),
                vanilla("container/slot/shovel"),
                vanilla("container/slot/spear"));
    }

    private static List<Identifier> additionsSlotIcons() {
        return List.of(vanilla("container/slot/ingot"));
    }

    private static Identifier vanilla(String path) {
        return Identifier.withDefaultNamespace(path);
    }
}