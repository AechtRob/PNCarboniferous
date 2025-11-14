package net.pncarboniferous.world.dimension.carboniferous.GenLayerCarboniferous;

import net.lepidodendron.util.EnumBiomeTypeCarboniferous;
import net.lepidodendron.world.biome.carboniferous.BiomeCarboniferous;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pncarboniferous.world.biome.carboniferous.BiomeCarboniferousColdCordaitesWoodland;

public class GenLayerCarboniferousRiverMix  extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome CARBONIFEROUS_CREEK_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_hills"));
    public int CARBONIFEROUS_CREEK_HILLS_ID = Biome.getIdForBiome(CARBONIFEROUS_CREEK_HILLS);
    public Biome CARBONIFEROUS_CREEK_MARSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_marsh"));
    public int CARBONIFEROUS_CREEK_MARSH_ID = Biome.getIdForBiome(CARBONIFEROUS_CREEK_MARSH);
    public Biome CARBONIFEROUS_CREEK_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_swamp"));
    public int CARBONIFEROUS_CREEK_SWAMP_ID = Biome.getIdForBiome(CARBONIFEROUS_CREEK_SWAMP);
    public Biome CARBONIFEROUS_CREEK_COAST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_coastal"));
    public int CARBONIFEROUS_CREEK_COAST_ID = Biome.getIdForBiome(CARBONIFEROUS_CREEK_COAST);
    public Biome CARBONIFEROUS_CREEK_ICE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_polar"));
    public int CARBONIFEROUS_CREEK_POLAR_ID = Biome.getIdForBiome(CARBONIFEROUS_CREEK_ICE);
    public Biome CARBONIFEROUS_CREEK_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_estuary"));
    public int CARBONIFEROUS_CREEK_ESTUARY_ID =  Biome.getIdForBiome(CARBONIFEROUS_CREEK_ESTUARY);
    public Biome CARBONIFEROUS_CREEK_SAVANNA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_cold_savanna"));
    public int CARBONIFEROUS_CREEK_SAVANNA_ID =  Biome.getIdForBiome(CARBONIFEROUS_CREEK_SAVANNA);
    public Biome CARBONIFEROUS_CREEK_FEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_fen"));
    public int CARBONIFEROUS_CREEK_FEN_ID =  Biome.getIdForBiome(CARBONIFEROUS_CREEK_FEN);
    public Biome CARBONIFEROUS_CREEK_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_creek_cold_woodland"));
    public int CARBONIFEROUS_CREEK_FOREST_ID =  Biome.getIdForBiome(CARBONIFEROUS_CREEK_FOREST);

    //Biomes to exclude for rivers:
    public Biome CARBONIFEROUS_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean_shore"));
    public int CARBONIFEROUS_OCEAN_SHORE_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN_SHORE);
    public Biome CARBONIFEROUS_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean"));
    public  int CARBONIFEROUS_OCEAN_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN);
    public Biome CARBONIFEROUS_OCEAN_CLIFF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_ocean_cliff"));
    public  int CARBONIFEROUS_OCEAN_CLIFF_ID =  Biome.getIdForBiome(CARBONIFEROUS_OCEAN_CLIFF);
    public  Biome CARBONIFEROUS_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_hills_high"));
    public  int CARBONIFEROUS_MOUNTAINS_ID =  Biome.getIdForBiome(CARBONIFEROUS_MOUNTAINS);
    public  Biome CARBONIFEROUS_TARNS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns"));
    public  int CARBONIFEROUS_TARNS_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARNS);
    public  Biome CARBONIFEROUS_TARNS_CRATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater"));
    public  int CARBONIFEROUS_TARNS_CRATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARNS_CRATER);
    public  Biome CARBONIFEROUS_TARNS_CRATER_WATER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_volcanic_tarns_crater_water"));
    public  int CARBONIFEROUS_TARNS_CRATER_WATER_ID =  Biome.getIdForBiome(CARBONIFEROUS_TARNS_CRATER_WATER);
    public Biome CARBONIFEROUS_BAY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:carboniferous_bay"));
    public int CARBONIFEROUS_BAY_ID =  Biome.getIdForBiome(CARBONIFEROUS_BAY);

    public GenLayerCarboniferousRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == CARBONIFEROUS_OCEAN_SHORE_ID
                        || aint[i] == CARBONIFEROUS_OCEAN_ID
                        || aint[i] == CARBONIFEROUS_OCEAN_CLIFF_ID
                        || aint[i] == CARBONIFEROUS_MOUNTAINS_ID
                        || aint[i] == CARBONIFEROUS_TARNS_ID
                        || aint[i] == CARBONIFEROUS_TARNS_CRATER_ID
                        || aint[i] == CARBONIFEROUS_TARNS_CRATER_WATER_ID
                        || aint[i] == CARBONIFEROUS_BAY_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeCarboniferous) {
                        BiomeCarboniferous biomeCarboniferous = (BiomeCarboniferous) biome;
                        if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Ice) {
                            aint2[i] = CARBONIFEROUS_CREEK_POLAR_ID;
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Hills) {
                            aint2[i] = CARBONIFEROUS_CREEK_HILLS_ID;
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Marsh) {
                            aint2[i] = CARBONIFEROUS_CREEK_MARSH_ID;
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Swamp) {
                            aint2[i] = CARBONIFEROUS_CREEK_SWAMP_ID;
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Ocean) {
                            aint2[i] = CARBONIFEROUS_CREEK_COAST_ID;
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Estuary) {
                            aint2[i] = CARBONIFEROUS_CREEK_ESTUARY_ID;
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Savanna) {
                            if (biome == BiomeCarboniferousColdCordaitesWoodland.biome) {
                                aint2[i] = CARBONIFEROUS_CREEK_FOREST_ID;
                            }
                            else {
                                aint2[i] = CARBONIFEROUS_CREEK_SAVANNA_ID;
                            }
                        }
                        else if (biomeCarboniferous.getBiomeType() == EnumBiomeTypeCarboniferous.Fen) {
                            aint2[i] = CARBONIFEROUS_CREEK_FEN_ID;
                        }
                        else {
                            aint2[i] = aint[i];
                        }
                    }
                    else {
                        aint2[i] = aint[i];
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
