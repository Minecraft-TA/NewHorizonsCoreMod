package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.WirelessRedstoneCBEAddons;
import static gregtech.api.enums.Mods.WirelessRedstoneCBECore;
import static gregtech.api.enums.Mods.WirelessRedstoneCBELogic;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptWirelessRedstone implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Wireless Redstone";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                WirelessRedstoneCBECore.ID,
                WirelessRedstoneCBELogic.ID,
                WirelessRedstoneCBEAddons.ID,
                ProjectRedCore.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(WirelessRedstoneCBECore.ID, "stoneBowl", 1, 0, missing),
                "plateStone",
                null,
                "plateStone",
                "plateStone",
                "craftingToolHardHammer",
                "plateStone",
                "plateStone",
                "plateStone",
                "plateStone");
        addShapedRecipe(
                getModItem(WirelessRedstoneCBEAddons.ID, "remote", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing),
                "craftingToolFile",
                "circuitAdvanced",
                CustomItemList.Display.get(1L),
                "circuitAdvanced",
                "itemCasingTungstenSteel",
                "screwTungstenSteel",
                "itemCasingTungstenSteel");
        addShapedRecipe(
                getModItem(WirelessRedstoneCBEAddons.ID, "sniffer", 1, 0, missing),
                getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0, missing),
                getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing),
                getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0, missing),
                "itemCasingTungstenSteel",
                "stickTungstenSteel",
                "itemCasingTungstenSteel",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0, missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0, missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0, missing));
        addShapedRecipe(
                getModItem(WirelessRedstoneCBEAddons.ID, "psniffer", 1, 0, missing),
                getModItem(WirelessRedstoneCBECore.ID, "blazeRecieverDish", 1, 0, missing),
                getModItem(WirelessRedstoneCBECore.ID, "blazeTransceiver", 1, 0, missing),
                getModItem(WirelessRedstoneCBECore.ID, "blazeRecieverDish", 1, 0, missing),
                "itemCasingTungstenSteel",
                "stickTungstenSteel",
                "itemCasingTungstenSteel",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0, missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0, missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 1L),
                        getModItem(WirelessRedstoneCBECore.ID, "retherPearl", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "retherPearl", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBECore.ID, "blazeTransceiver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(WirelessRedstoneCBECore.ID, "stoneBowl", 1, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).duration(30 * SECONDS).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(WirelessRedstoneCBECore.ID, "stoneBowl", 1, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "blazeTransceiver", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBECore.ID, "blazeRecieverDish", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).duration(30 * SECONDS).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).duration(30 * SECONDS).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).duration(30 * SECONDS).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "blazeTransceiver", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).duration(30 * SECONDS).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "compass", 1, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBEAddons.ID, "triangulator", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(WirelessRedstoneCBEAddons.ID, "triangulator", 1, 0, missing),
                        getModItem(Minecraft.ID, "paper", 8, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBEAddons.ID, "map", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(15 * SECONDS).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 3L),
                        getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBEAddons.ID, "tracker", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(WirelessRedstoneCBECore.ID, "blazeTransceiver", 2, 0, missing),
                        getModItem(WirelessRedstoneCBECore.ID, "retherPearl", 2, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBEAddons.ID, "rep", 1, 0, missing))
                .fluidInputs(Materials.Obsidian.getMolten(1440)).duration(30 * SECONDS).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing))
                .itemOutputs(getModItem(WirelessRedstoneCBECore.ID, "retherPearl", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(1 * MINUTES).eut(30)
                .addTo(UniversalChemical);

    }
}
