
package net.pncarboniferous.world.biome.carboniferous;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockAlliopteris;
import net.lepidodendron.block.BlockNemejcopteris;
import net.lepidodendron.util.EnumBiomeTypeCarboniferous;
import net.lepidodendron.world.biome.carboniferous.BiomeCarboniferous;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeCarboniferousHillsCentre extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:carboniferous_hills_high")
	public static final BiomeGenCustom biome = null;
	public BiomeCarboniferousHillsCentre(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		//BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SWAMP);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.MOUNTAIN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HILLS);
	}

	static class BiomeGenCustom extends BiomeCarboniferous {
		public BiomeGenCustom() {
			//super(new Biome.BiomeProperties("Carboniferous Hills").setRainfall(0.5F).setBaseBiome("lepidodendron:carboniferous_swamp_hills").setBaseHeight(1.05F).setHeightVariation(0.5F).setTemperature(0.75F).setRainfall(0.9F).setWaterColor(8186044));
			super(new BiomeProperties("Carboniferous Gravelly Highlands").setBaseHeight(4.475F).setHeightVariation(0.325F).setTemperature(0.21F).setRainfall(0.2F).setWaterColor(3906905));
			setRegistryName("lepidodendron:carboniferous_hills_high");
			topBlock = Blocks.GRAVEL.getStateFromMeta(0);
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.treesPerChunk = 3;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			decorator.clayPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getFoliageColorAtPos(BlockPos pos)
		{
			return -15424749;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getGrassColorAtPos(BlockPos pos)
		{
			return -15424749;
		}

		@Override
		public int getModdedBiomeGrassColor(int original)
		{
			return -15424749;
		}

		@Override
		public int getModdedBiomeFoliageColor(int original)
		{
			return -15424749;
		}

		//protected static final WorldGenLepidodendronTree LEPIDODENDRON_TREE = new WorldGenLepidodendronTree(false);
		protected static final WorldGenWalchiaTree WALCHIA_TREE = new WorldGenWalchiaTree(false);
		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		//protected static final WorldGenCordaites CORDAITES_TREE = new WorldGenCordaites(false);
		//protected static final WorldGenPsaronius PSARONIUS = new WorldGenPsaronius(false);
		//protected static final WorldGenAlethopterisTree ALETHOPTERIS_TREE = new WorldGenAlethopterisTree(false);
		//protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenCoarseDirt TOPSOIL_GENERATOR = new WorldGenCoarseDirt();
		//protected static final WorldGenLushPrehistoricGround LUSH_GROUND_GENERATOR = new WorldGenLushPrehistoricGround();
		//protected static final WorldGenStauropteris STAUROPTERIS_GENERATOR = new WorldGenStauropteris();
//		protected static final WorldGenSphenopterisFern SPHENOPTERIS_GENERATOR = new WorldGenSphenopterisFern();
		//protected static final WorldGenMedullosales MEDULLOSALES_GENERATOR = new WorldGenMedullosales();
//		protected static final WorldGenAlliopteris ALLIOPTERIS_GENERATOR = new WorldGenAlliopteris();
//		protected static final WorldGenNemejcopteris NEMEJCOPTERIS_GENERATOR = new WorldGenNemejcopteris();
		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenRufloria RUFLORIA_GENERATOR = new WorldGenRufloria();
		protected static final WorldGenAncientMoss ANCIENT_MOSS_GENERATOR = new WorldGenAncientMoss();
		protected static final WorldGenSelaginella SELAGINELLA_GENERATOR = new WorldGenSelaginella();
		//protected static final WorldGenMarattia MARATTIA_GENERATOR = new WorldGenMarattia();
		//protected static final WorldGenZygopteridaceaeShoot ZYGOPTERIDACEAE_SHOOT_GENERATOR = new WorldGenZygopteridaceaeShoot();
		//protected static final WorldGenIsoetes ISOETES_GENERATOR = new WorldGenIsoetes();
		protected static final WorldGenWaterHorsetail WATER_HORSETAIL_GENERATOR = new WorldGenWaterHorsetail();
		protected static final WorldGenPrehistoricGroundCoverLush GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverLush();
		//protected static final WorldGenTreeLog WALCHIA_LOG_GENERATOR = new WorldGenTreeLog(BlockWalchiaLog.block);
		//protected static final WorldGenTreeRottenLog ROTTEN_LOG_GENERATOR = new WorldGenTreeRottenLog();
		//protected static final WorldGenTreeLog CORDAITES_LOG_GENERATOR = new WorldGenTreeLog(BlockCordaitesLog.block);
    	//protected static final WorldGenTreeLog LEPIDODENDRON_LOG_GENERATOR = new WorldGenTreeLog(BlockWalchiaLog.block);
		protected static final WorldGenFern FERN_GENERATOR = new WorldGenFern();
		public static final PropertyEnum<BlockDoublePlant.EnumPlantType> VARIANT = PropertyEnum.<BlockDoublePlant.EnumPlantType>create("variant", BlockDoublePlant.EnumPlantType.class);
		protected static final WorldGenLesleya LESLEYA_GENERATOR = new WorldGenLesleya();
		protected static final WorldGenFungiSimple SIMPLE_FUNGI_GENERATOR = new WorldGenFungiSimple();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	int selector = rand.nextInt(3);
	    	switch (selector) {
	    		case 0 :
	    			return NULL_TREE;
	       		case 1 :
	    			return NULL_TREE;
	       		case 2 :
	    			return WALCHIA_TREE;
	    	}
	    	return WALCHIA_TREE;
	    }


		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 12; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            FERN_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }


	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			for (int i = 0; i < 8; ++i)
			{
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				PLANT_GENERATOR.generate(BlockAlliopteris.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 16; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockNemejcopteris.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 24; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					if ((pos.getY() + l) > (worldIn.getSeaLevel() + 12)) {
						RUFLORIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LESLEYA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 60 , 255);
				}


	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 56; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 12; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            ANCIENT_MOSS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }

	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 80; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            WATER_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }


	        super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeCarboniferous getBiomeType() {
		return EnumBiomeTypeCarboniferous.Hills;
	}

	}
}
