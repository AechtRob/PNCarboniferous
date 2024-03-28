package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCarboniferousRiverBorder extends GenLayer
{

    public Biome CARBONIFEROUS_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_swamp_river_border"));
    public int CARBONIFEROUS_RIVER_ID = Biome.getIdForBiome(CARBONIFEROUS_RIVER);
    public Biome CARBONIFEROUS_RIDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_hills_high"));
    public int CARBONIFEROUS_RIDGE_ID = Biome.getIdForBiome(CARBONIFEROUS_RIDGE);

    public Biome CARBONIFEROUS_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_swamp"));
    public int CARBONIFEROUS_SWAMP_ID = Biome.getIdForBiome(CARBONIFEROUS_SWAMP);
    public Biome CARBONIFEROUS_SWAMP_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_swamp_hills"));
    public int CARBONIFEROUS_SWAMP_HILLS_ID = Biome.getIdForBiome(CARBONIFEROUS_SWAMP_HILLS);
    public Biome CARBONIFEROUS_SWAMP_BURNT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_swamp_burnt"));
    public int CARBONIFEROUS_SWAMP_BURNT_ID = Biome.getIdForBiome(CARBONIFEROUS_SWAMP_BURNT);
    public Biome CARBONIFEROUS_MARSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_marsh"));
    public int CARBONIFEROUS_MARSH_ID = Biome.getIdForBiome(CARBONIFEROUS_MARSH);

    public Biome CARBONIFEROUS_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean_shore"));
    public int CARBONIFEROUS_OCEAN_SHORE_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN_SHORE);
    public Biome CARBONIFEROUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean"));
    public int CARBONIFEROUS_OCEAN_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN);
    public Biome CARBONIFEROUS_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_beach"));
    public int CARBONIFEROUS_BEACH_ID =  Biome.getIdForBiome(CARBONIFEROUS_BEACH);
    public Biome CARBONIFEROUS_OCEAN_CLIFF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean_cliff"));
    public int CARBONIFEROUS_OCEAN_CLIFF_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN_CLIFF);
    public Biome CARBONIFEROUS_BAY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_bay"));
    public int CARBONIFEROUS_BAY_ID =  Biome.getIdForBiome(CARBONIFEROUS_BAY);

    public Biome CARBONIFEROUS_SAVANNA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_cold_savanna"));
    public int CARBONIFEROUS_SAVANNA_ID =  Biome.getIdForBiome(CARBONIFEROUS_SAVANNA);
    public Biome CARBONIFEROUS_ICE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_polar_desert"));
    public int CARBONIFEROUS_ICE_ID =  Biome.getIdForBiome(CARBONIFEROUS_ICE);
    public Biome CARBONIFEROUS_ICE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_polar_desert_edge"));
    public int CARBONIFEROUS_ICE_EDGE_ID =  Biome.getIdForBiome(CARBONIFEROUS_ICE_EDGE);
    public Biome CARBONIFEROUS_ICE_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_polar_lakes"));
    public int CARBONIFEROUS_ICE_LAKES_ID =  Biome.getIdForBiome(CARBONIFEROUS_ICE_LAKES);
    public Biome CARBONIFEROUS_ICE_SPIKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_polar_desert_spikes"));
    public int CARBONIFEROUS_ICE_SPIKES_ID =  Biome.getIdForBiome(CARBONIFEROUS_ICE_SPIKES);

    public Biome CARBONIFEROUS_TARN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns"));
    public int CARBONIFEROUS_TARNS_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARN);
    public Biome CARBONIFEROUS_CRATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater"));
    public int CARBONIFEROUS_TARNS_CRATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_CRATER);
    public Biome CARBONIFEROUS_CRATER_WATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater_water"));
    public int CARBONIFEROUS_TARNS_CRATER_WATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_CRATER_WATER);
    public Biome CARBONIFEROUS_ASH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_ash"));
    public int CARBONIFEROUS_ASH_ID =  Biome.getIdForBiome(CARBONIFEROUS_ASH);


    public GenLayerCarboniferousRiverBorder(long seed, GenLayer genLayer)
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

                if (isSwamp(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isSwamp(l1) && !isOceanOrBeach(l1) && isRequiredforSwamp(l1))
                        || (!isSwamp(k2) && !isOceanOrBeach(k2) && isRequiredforSwamp(k2))
                        || (!isSwamp(j3) && !isOceanOrBeach(j3) && isRequiredforSwamp(j3))
                        || (!isSwamp(i4) && !isOceanOrBeach(i4) && isRequiredforSwamp(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = CARBONIFEROUS_RIVER_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isTarns(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isTarns(l1) && !isOceanOrBeach(l1) && isRequiredforTarns(l1))
                            || (!isTarns(k2) && !isOceanOrBeach(k2) && isRequiredforTarns(k2))
                            || (!isTarns(j3) && !isOceanOrBeach(j3) && isRequiredforTarns(j3))
                            || (!isTarns(i4) && !isOceanOrBeach(i4) && isRequiredforTarns(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = CARBONIFEROUS_RIDGE_ID;
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

    private boolean isOceanOrBeach(int biomeID) {
        if (biomeID == CARBONIFEROUS_OCEAN_ID || biomeID == CARBONIFEROUS_OCEAN_SHORE_ID || biomeID == CARBONIFEROUS_OCEAN_CLIFF_ID
            || biomeID == CARBONIFEROUS_BEACH_ID || biomeID == CARBONIFEROUS_BAY_ID) {
            return true;
        }
        return false;
    }

    private boolean isSwamp(int biomeID) {
        if (biomeID == CARBONIFEROUS_SWAMP_ID
            || biomeID == CARBONIFEROUS_SWAMP_HILLS_ID
            || biomeID == CARBONIFEROUS_SWAMP_BURNT_ID
            || biomeID == CARBONIFEROUS_MARSH_ID) {
            return true;
        }
        return false;
    }

    private boolean isRequiredforSwamp(int biomeID) {
        if (biomeID == CARBONIFEROUS_SAVANNA_ID
                || biomeID == CARBONIFEROUS_ICE_ID
                || biomeID == CARBONIFEROUS_ICE_EDGE_ID
                || biomeID == CARBONIFEROUS_ICE_LAKES_ID
                || biomeID == CARBONIFEROUS_ICE_SPIKES_ID) {
            return true;
        }
        return false;
    }

    private boolean isTarns(int biomeID) {
        if (biomeID == CARBONIFEROUS_TARNS_ID
                || biomeID == CARBONIFEROUS_TARNS_CRATER_ID
                || biomeID == CARBONIFEROUS_TARNS_CRATER_WATER_ID
                || biomeID == CARBONIFEROUS_ASH_ID) {
            return true;
        }
        return false;
    }

    private boolean isRequiredforTarns(int biomeID) {
        if (biomeID != CARBONIFEROUS_TARNS_ID
                && biomeID != CARBONIFEROUS_ASH_ID
                && biomeID != CARBONIFEROUS_TARNS_CRATER_ID
                && biomeID != CARBONIFEROUS_TARNS_CRATER_WATER_ID
                && biomeID != CARBONIFEROUS_SAVANNA_ID) {
            return true;
        }
        return false;
    }

}
