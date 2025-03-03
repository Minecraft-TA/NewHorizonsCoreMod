package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CatWalks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptCatWalk implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Cat Walk";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(CatWalks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(CatWalks.ID, "catwalk_unlit", 6, 0, missing),
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(CatWalks.ID, "cagedLadder_north_unlit", 6, 0, missing),
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                getModItem(Minecraft.ID, "ladder", 1, 0, missing),
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(CatWalks.ID, "scaffold", 1, 0, missing),
                "screwSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "frameGtSteel",
                "craftingToolWrench");
        addShapelessRecipe(
                getModItem(CatWalks.ID, "scaffold", 1, 0, missing),
                getModItem(CatWalks.ID, "scaffold", 1, 1, missing));
        addShapedRecipe(
                getModItem(CatWalks.ID, "support_column", 3, 0, missing),
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel",
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel",
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel");
        addShapedRecipe(
                getModItem(CatWalks.ID, "steelgrate", 5, 0, missing),
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "craftingToolScrewdriver",
                "stickSteel");
        addShapedRecipe(
                getModItem(CatWalks.ID, "blowtorch", 1, 0, missing),
                null,
                "screwSteel",
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                "craftingToolScrewdriver",
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "craftingToolWrench",
                null);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 3L))
                .itemOutputs(getModItem(CatWalks.ID, "steelgrate", 10, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 6L),
                        getModItem(CatWalks.ID, "steelgrate", 4, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "support_column", 4, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CatWalks.ID, "steelgrate", 3, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 2L))
                .itemOutputs(getModItem(CatWalks.ID, "catwalk_unlit", 6, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "scaffold", 1, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CatWalks.ID, "steelgrate", 4, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "cagedLadder_north_unlit", 6, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail", 1, 0, missing)).duration(7 * SECONDS + 10 * TICKS)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "activator_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_activator", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_detector", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "golden_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_powered", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 2L),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "ropeLight", 8, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "support_column", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 6L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "scaffold", 1, 0, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 2L))
                .outputChances(10000, 10000).duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "scaffold", 1, 1, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 2L))
                .outputChances(10000, 10000).duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "catwalk_unlit", 1, 0, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 2L))
                .outputChances(10000, 10000).duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "cagedLadder_north_unlit", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 2L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

    }
}
