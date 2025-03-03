package com.uraneptus.sullysmod.core.integration.jei.category;

import com.google.common.collect.ImmutableList;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.common.recipes.GrindstonePolishingRecipe;
import com.uraneptus.sullysmod.core.integration.jei.JEIRecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("SameParameterValue")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SMPolishingCategory implements IRecipeCategory<GrindstonePolishingRecipe> {

    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public SMPolishingCategory(IGuiHelper helper) {
        title = Component.translatable(SullysMod.MOD_ID + ".jei." + getUid().getPath());
        background = helper.createDrawable(SullysMod.modPrefix("textures/gui/jei/grindstone_polishing.png"), 0, 0, 96, 31);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.GRINDSTONE));
    }

    @Override
    public Component getTitle() {
        return this.title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    public ResourceLocation getUid() {
        return this.getRecipeType().getUid();
    }


    @Override
    public @NotNull RecipeType<GrindstonePolishingRecipe> getRecipeType() {
        return JEIRecipeTypes.GRINDSTONE_POLISHING;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder layout, GrindstonePolishingRecipe polishingRecipes, IFocusGroup ingredients) {
        layout.addSlot(RecipeIngredientRole.INPUT, 4, 9).addIngredients(polishingRecipes.getIngredients().iterator().next());
        layout.addSlot(RecipeIngredientRole.OUTPUT, 76, 9).addItemStack(new ItemStack(polishingRecipes.result.getItem(), polishingRecipes.getResultCount()));
    }

    @Override
    public List<Component> getTooltipStrings(GrindstonePolishingRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (iconPosition(31, 3, mouseX, mouseY)) {
            return ImmutableList.of(Component.translatable(SullysMod.MOD_ID + ".jei." + getUid().getPath() + ".info"));
        }
        return Collections.emptyList();
    }

    private static boolean iconPosition(int x, int y, double mouseX, double mouseY) {
        final int iconHeight = 25;
        final int iconWidth = 26;
        return x <= mouseX && mouseX < x + iconWidth && y <= mouseY && mouseY < y + iconHeight;
    }
}
