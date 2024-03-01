
package net.pncarboniferous.world.biome.carboniferous;

import net.lepidodendron.block.BlockLavaCobble;
import net.lepidodendron.block.BlockLavaRock;
import net.lepidodendron.util.EnumBiomeTypeCarboniferous;
import net.lepidodendron.world.biome.carboniferous.BiomeCarboniferous;
import net.lepidodendron.world.gen.WorldGenGravelNearWater;
import net.lepidodendron.world.gen.WorldGenNullTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pncarboniferous.ElementsPNCarboniferousMod;

import java.util.Random;

@ElementsPNCarboniferousMod.ModElement.Tag
public class BiomeCarboniferousVolcanicTarnsCraterWater extends ElementsPNCarboniferousMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:carboniferous_volcanic_tarns_crater_water")
	public static final BiomeGenCustom biome = null;
	public BiomeCarboniferousVolcanicTarnsCraterWater(ElementsPNCarboniferousMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.PLAINS);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD);
	}

	static class BiomeGenCustom extends BiomeCarboniferous {
		public BiomeGenCustom() {
			super(new BiomeProperties("Carboniferous Volcanic Tarns").setRainfall(0.1F).setBaseHeight(-0.95F).setHeightVariation(0.00F).setTemperature(0.25F));
			setRegistryName("lepidodendron:carboniferous_volcanic_tarns_crater_water");
			topBlock = BlockLavaCobble.block.getDefaultState();
			fillerBlock = BlockLavaRock.block.getDefaultState();
			decorator.treesPerChunk = -999;
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
		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);

		protected static final WorldGenGravelNearWater GRAVEL_GENERATOR = new WorldGenGravelNearWater();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
			return NULL_TREE;

	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 32; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					GRAVEL_GENERATOR.generate(worldIn, rand, worldIn.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + j, 0, pos.getZ() + k)).up());
				}

			super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeCarboniferous getBiomeType() {
			return EnumBiomeTypeCarboniferous.Volcanic;
		}

	}
}
