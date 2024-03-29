package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncarboniferous.world.biome.carboniferous.BiomeCarboniferousIce;
import net.pncarboniferous.world.biome.carboniferous.BiomeCarboniferousSwamp;
import net.pncarboniferous.world.biome.carboniferous.BiomeCarboniferousVolcanicTarns;

public class GenLayerDiversifyCarboniferousAsh extends GenLayer {

    public Biome CARBONIFEROUS_TARNS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns"));
    public int CARBONIFEROUS_TARNS_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARNS);
    public Biome CARBONIFEROUS_ASH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_ash"));
    public int CARBONIFEROUS_ASH_ID =  Biome.getIdForBiome(CARBONIFEROUS_ASH);

    private final int TarnsBiomes[] = new int[] {
            CARBONIFEROUS_TARNS_ID,
            CARBONIFEROUS_TARNS_ID,
            CARBONIFEROUS_TARNS_ID,
            CARBONIFEROUS_TARNS_ID,
            CARBONIFEROUS_ASH_ID
    };

    public GenLayerDiversifyCarboniferousAsh(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeCarboniferousVolcanicTarns.biome)
                        output[i] = TarnsBiomes[nextInt(TarnsBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}