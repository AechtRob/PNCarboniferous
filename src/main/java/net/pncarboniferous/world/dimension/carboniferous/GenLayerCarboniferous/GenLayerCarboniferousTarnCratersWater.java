package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCarboniferousTarnCratersWater extends GenLayer
{


    public Biome CARBONIFEROUS_TARN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns"));
    public int CARBONIFEROUS_TARN_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARN);
    public Biome CARBONIFEROUS_CRATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater"));
    public int CARBONIFEROUS_CRATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_CRATER);
    public Biome CARBONIFEROUS_WATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater_water"));
    public int CARBONIFEROUS_WATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_WATER);

    public GenLayerCarboniferousTarnCratersWater(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k == CARBONIFEROUS_CRATER_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isCrater(l1) && isCrater(k2) && isCrater(j3) && isCrater(i4))
                    {
                        aint1[j + i * areaWidth] = CARBONIFEROUS_WATER_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isCrater(int biomeID) {
        if (biomeID == CARBONIFEROUS_CRATER_ID || biomeID == CARBONIFEROUS_WATER_ID) {
            return true;
        }
        return false;
    }

}
