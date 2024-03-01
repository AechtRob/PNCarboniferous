package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCarboniferousTarnCraters extends GenLayer
{


    public Biome CARBONIFEROUS_TARN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns"));
    public int CARBONIFEROUS_TARN_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARN);
    public Biome CARBONIFEROUS_CRATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater"));
    public int CARBONIFEROUS_CRATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_CRATER);

    public GenLayerCarboniferousTarnCraters(long seed, GenLayer genLayer)
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


                if (k == CARBONIFEROUS_TARN_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isNotCrater(l1) && isNotCrater(k2) && isNotCrater(j3) && isNotCrater(i4)
                        && nextInt(5) <= 1)
                    {
                        aint1[j + i * areaWidth] = CARBONIFEROUS_CRATER_ID;
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

    private boolean isNotCrater(int biomeID) {
        if (biomeID == CARBONIFEROUS_TARN_ID) {
            return true;
        }
        return false;
    }

}
