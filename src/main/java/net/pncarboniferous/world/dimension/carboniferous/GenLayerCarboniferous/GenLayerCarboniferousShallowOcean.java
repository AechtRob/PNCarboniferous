package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCarboniferousShallowOcean extends GenLayer
{

    public Biome CARBONIFEROUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean"));
    public  int CARBONIFEROUS_OCEAN_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN);
    public  Biome CARBONIFEROUS_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean_shore"));
    public  int CARBONIFEROUS_OCEAN_SHORE_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN_SHORE);
    public  Biome CARBONIFEROUS_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_swamp"));
    public  int CARBONIFEROUS_SWAMP_ID =  Biome.getIdForBiome(CARBONIFEROUS_SWAMP);
    public  Biome CARBONIFEROUS_SWAMP_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_swamp_hills"));
    public  int CARBONIFEROUS_SWAMP_HILLS_ID =  Biome.getIdForBiome(CARBONIFEROUS_SWAMP_HILLS);
    public  Biome CARBONIFEROUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_beach"));
    public  int CARBONIFEROUS_BEACH_ID =  Biome.getIdForBiome(CARBONIFEROUS_BEACH);
    public Biome CARBONIFEROUS_MARSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_marsh"));
    public int CARBONIFEROUS_MARSH_ID =  Biome.getIdForBiome(CARBONIFEROUS_MARSH);
    public Biome CARBONIFEROUS_SAVANNA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_cold_savanna"));
    public int CARBONIFEROUS_SAVANNA_ID =  Biome.getIdForBiome(CARBONIFEROUS_SAVANNA);


    public GenLayerCarboniferousShallowOcean(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        return this.getIntsOcean(areaX, areaY, areaWidth, areaHeight);
    }

    private int[] getIntsOcean(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_)
    {
        int i = p_151626_1_ - 1;
        int j = p_151626_2_ - 1;
        int k = 1 + p_151626_3_ + 1;
        int l = 1 + p_151626_4_ + 1;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(p_151626_3_ * p_151626_4_);

        for (int i1 = 0; i1 < p_151626_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_151626_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_151626_1_), (long)(i1 + p_151626_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * k];

                if (k1 == CARBONIFEROUS_OCEAN_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == CARBONIFEROUS_MARSH_ID || l1 == CARBONIFEROUS_SWAMP_ID || l1 == CARBONIFEROUS_SWAMP_HILLS_ID || l1 == CARBONIFEROUS_BEACH_ID || l1 == CARBONIFEROUS_SAVANNA_ID)
                        || (i2 == CARBONIFEROUS_MARSH_ID || i2 == CARBONIFEROUS_SWAMP_ID || i2 == CARBONIFEROUS_SWAMP_HILLS_ID || i2 == CARBONIFEROUS_BEACH_ID || i2 == CARBONIFEROUS_SAVANNA_ID)
                        || (j2 == CARBONIFEROUS_MARSH_ID || j2 == CARBONIFEROUS_SWAMP_ID || j2 == CARBONIFEROUS_SWAMP_HILLS_ID || j2 == CARBONIFEROUS_BEACH_ID || j2 == CARBONIFEROUS_SAVANNA_ID)
                        || (k2 == CARBONIFEROUS_MARSH_ID || k2 == CARBONIFEROUS_SWAMP_ID || k2 == CARBONIFEROUS_SWAMP_HILLS_ID || k2 == CARBONIFEROUS_BEACH_ID || k2 == CARBONIFEROUS_SAVANNA_ID)
                    );
                    if (flag)
                    {
                        k1 = CARBONIFEROUS_OCEAN_SHORE_ID;
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }
    
}
