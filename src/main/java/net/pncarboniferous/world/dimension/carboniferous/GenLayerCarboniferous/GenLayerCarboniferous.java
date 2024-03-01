package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerCarboniferous {

    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerCarboniferousBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        if (!LepidodendronConfig.doShrinkBiomes) {
            biomes = new GenLayerZoom(2001L, biomes);
        }
        biomes = new GenLayerDiversifyCarboniferous(1000L, biomes);
        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerDiversifyCarboniferous(1001L, biomes);
        biomes = new GenLayerCarboniferousIceEdgeSea(3L, biomes);

        biomes = new GenLayerCarboniferousEstuary1(1000L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerCarboniferousDeepOcean(1100L, biomes);
        biomes = new GenLayerCarboniferousShallowOcean(1300L, biomes);
        biomes = new GenLayerDiversifyCarboniferousBurnt(666L, biomes);
        biomes = new GenLayerDiversifyCarboniferousBurntMarsh(666L, biomes);

        biomes = new GenLayerCarboniferousEstuary2(1000L, biomes);

        biomes = new GenLayerZoom(1003L, biomes);

        biomes = new GenLayerCarboniferousEstuary2(1000L, biomes);

        biomes = new GenLayerCarboniferousIceEdge(2L, biomes);
        biomes = new GenLayerCarboniferousHillsEdge(27L, biomes);
        biomes = new GenLayerCarboniferousHillsCentre(37L, biomes);
        biomes = new GenLayerCarboniferousIceLakes(1000L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerCarboniferousTarnCraters(1451L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);

        biomes = new GenLayerCarboniferousTarnCratersWater(191L, biomes);
        biomes = new GenLayerCarboniferousTarnCraters(1452L, biomes);

        biomes = new GenLayerCarboniferousEstuary2(1000L, biomes);

        biomes = new GenLayerCarboniferousHillsCentreExpand(77L, biomes);
        biomes = new GenLayerCarboniferousIceSpikes(1000L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);

        biomes = new GenLayerCarboniferousTarnCratersWater(191L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerCarboniferousTarnCratersWater(191L, biomes);
        biomes = new GenLayerCarboniferousBeach(1050L, biomes);
        biomes = new GenLayerDiversifyCarboniferousBurnt(667L, biomes);
        biomes = new GenLayerDiversifyCarboniferousBurntMarsh(667L, biomes);
        biomes = new GenLayerCarboniferousCliff(1080L, biomes);
        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);

        biomes = new GenLayerCarboniferousTarnCratersWaterSmall(199L, biomes);
        biomes = new GenLayerCarboniferousRiverBorder(325L, biomes);
        biomes = new GenLayerSmooth(706L, biomes);
        biomes = new GenLayerFuzzyZoom(1002L, biomes);
        biomes = new GenLayerCarboniferousRiverBorder(326L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);

        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 1);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = new GenLayerRiver(1L, genlayercreek4);
        GenLayer genlayercreek6 = new GenLayerSmooth(1000L, genlayercreek5);
        GenLayer genlayercreekfinal = new GenLayerCarboniferousRiverMix(100L, biomes, genlayercreek6);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayercreekfinal);

        genlayercreekfinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayercreekfinal, genlayervoronoizoom, genlayercreekfinal });
    }

}