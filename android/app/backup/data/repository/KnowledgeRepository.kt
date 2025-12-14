package com.makertest.app.data.repository

import com.makertest.app.data.models.KnowledgeArticle
import com.makertest.app.data.models.ArticleCategory
import com.makertest.app.data.models.Difficulty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KnowledgeRepository @Inject constructor() {
    
    fun getAllArticles(): Flow<List<KnowledgeArticle>> = flow {
        // In a real app, this would fetch from a local database or remote API
        // For now, we'll provide sample content relevant to South Sudan agriculture
        val sampleArticles = getSampleSouthSudanArticles()
        emit(sampleArticles)
    }
    
    fun getArticleById(id: Long): Flow<KnowledgeArticle?> = flow {
        val articles = getSampleSouthSudanArticles()
        emit(articles.find { it.id == id })
    }
    
    private fun getSampleSouthSudanArticles(): List<KnowledgeArticle> {
        return listOf(
            KnowledgeArticle(
                id = 1,
                title = "Improving Nitrogen in Clay Soil for South Sudan Farms",
                content = "Clay soils are common in many parts of South Sudan and can present unique challenges for nitrogen management. Due to their high cation exchange capacity, clay soils tend to hold onto nitrogen tightly, which can lead to deficiencies in crops despite adequate fertilizer application. To improve nitrogen availability, consider using split applications of nitrogen fertilizer, incorporating organic matter like compost or manure, and using nitrification inhibitors during the rainy season. Additionally, planting leguminous cover crops during fallow periods can naturally increase soil nitrogen levels.",
                category = ArticleCategory.SOIL_MANAGEMENT,
                difficulty = Difficulty.INTERMEDIATE,
                readTime = 8,
                tags = listOf("nitrogen", "clay-soil", "fertilizer", "soil-health"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 30,
                updatedAt = System.currentTimeMillis() - 86400000 * 15
            ),
            KnowledgeArticle(
                id = 2,
                title = "Best Practices for Sorghum Fertilization in South Sudan",
                content = "Sorghum is a staple crop in South Sudan and requires proper fertilization for optimal yields. For the first planting after land clearing, apply 20-30 kg/ha of nitrogen, 40-60 kg/ha of phosphorus (P2O5), and 20-30 kg/ha of potassium (K2O). Split nitrogen applications are recommended: half at planting and half 3-4 weeks after emergence. During the rainy season, reduce fertilizer rates to prevent leaching. Use soil testing to determine exact nutrient needs, as soils vary greatly across South Sudan's different agro-ecological zones.",
                category = ArticleCategory.FERTILIZATION,
                difficulty = Difficulty.BEGINNER,
                readTime = 6,
                tags = listOf("sorghum", "fertilizer", "nitrogen", "phosphorus"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 20,
                updatedAt = System.currentTimeMillis() - 86400000 * 10
            ),
            KnowledgeArticle(
                id = 3,
                title = "Organic Pest Control for Smallholder Farmers",
                content = "Chemical pesticides can be expensive and environmentally damaging. Organic pest control methods are more sustainable and suitable for South Sudan's smallholder farmers. Neem oil extracts can control common pests like aphids and caterpillars. Intercropping with pest-repellent plants such as marigold or garlic can reduce pest pressure. Physical barriers like netting protect young plants from birds and insects. Encouraging natural predators like ladybugs and spiders by avoiding broad-spectrum pesticides helps maintain ecological balance. Regular field scouting and early detection are key to effective pest management.",
                category = ArticleCategory.PEST_CONTROL,
                difficulty = Difficulty.BEGINNER,
                readTime = 7,
                tags = listOf("pest-control", "organic", "neem", "integrated-pest-management"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 25,
                updatedAt = System.currentTimeMillis() - 86400000 * 5
            ),
            KnowledgeArticle(
                id = 4,
                title = "Water Conservation Techniques for Dry Season Farming",
                content = "South Sudan's climate features distinct wet and dry seasons, making water conservation crucial. Mulching with crop residues or grass reduces evaporation by up to 50%. Zai pits - small planting pits filled with compost - concentrate water and nutrients around plant roots. Contour bunds prevent soil erosion and retain rainwater on slopes. Drip irrigation, where possible, delivers water directly to plant roots with 90% efficiency compared to 60% for flood irrigation. Planting drought-resistant varieties like early-maturing maize or sorghum varieties helps maintain yields during water stress.",
                category = ArticleCategory.IRRIGATION,
                difficulty = Difficulty.INTERMEDIATE,
                readTime = 9,
                tags = listOf("water-conservation", "mulching", "drought", "irrigation"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 35,
                updatedAt = System.currentTimeMillis() - 86400000 * 12
            ),
            KnowledgeArticle(
                id = 5,
                title = "Climate-Smart Agriculture for South Sudan",
                content = "Climate change poses significant challenges to South Sudan's agriculture. Climate-smart agriculture combines adaptation and mitigation strategies. Conservation agriculture practices like minimum tillage and permanent soil cover improve soil health and water retention. Agroforestry - integrating trees with crops - provides shade, improves soil fertility, and offers additional income sources. Diversifying crop varieties with different maturity dates spreads risk. Early warning systems and climate information services help farmers make informed planting decisions. Building community seed banks ensures access to climate-resilient varieties.",
                category = ArticleCategory.CLIMATE_ADAPTATION,
                difficulty = Difficulty.ADVANCED,
                readTime = 12,
                tags = listOf("climate-change", "adaptation", "agroforestry", "conservation-agriculture"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 40,
                updatedAt = System.currentTimeMillis() - 86400000 * 20
            ),
            KnowledgeArticle(
                id = 6,
                title = "Post-Harvest Management to Reduce Losses",
                content = "Post-harvest losses can reach 30% in South Sudan due to poor storage and handling. Proper drying of grains to moisture content below 13% prevents fungal growth. Hermetic storage bags create airtight conditions that stop insect damage without chemicals. Raised platforms keep produce off the ground away from moisture and pests. Regular inspection of stored grains allows early detection of problems. Processing surplus produce through drying, milling, or fermentation extends shelf life and adds value. Community storage facilities provide better protection than individual storage.",
                category = ArticleCategory.SUSTAINABLE_FARMING,
                difficulty = Difficulty.BEGINNER,
                readTime = 8,
                tags = listOf("post-harvest", "storage", "food-security", "loss-reduction"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 15,
                updatedAt = System.currentTimeMillis() - 86400000 * 7
            ),
            KnowledgeArticle(
                id = 7,
                title = "Maize Production Guide for South Sudan",
                content = "Maize is an important food crop in South Sudan. For optimal yields, plant early in the rainy season when soil moisture is adequate. Use improved varieties adapted to local conditions with disease resistance. Spacing of 75cm between rows and 25cm between plants gives good results. Apply basal fertilizer at planting: 30 kg/ha P2O5 and 20 kg/ha K2O. Top-dress with 40 kg/ha nitrogen 3-4 weeks after emergence. Weed control is crucial in the first 6-8 weeks. Harvest when husks turn dry and grains are hard. Proper drying to 13% moisture prevents storage losses.",
                category = ArticleCategory.CROP_CARE,
                difficulty = Difficulty.BEGINNER,
                readTime = 10,
                tags = listOf("maize", "planting", "fertilizer", "harvesting"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 28,
                updatedAt = System.currentTimeMillis() - 86400000 * 14
            ),
            KnowledgeArticle(
                id = 8,
                title = "Soil Testing and Interpretation for Smallholders",
                content = "Regular soil testing helps farmers apply the right amount of fertilizers, saving money and protecting the environment. Soil pH should be between 6.0-7.0 for most crops. Below 5.5, apply lime to reduce acidity. Organic matter below 2% needs improvement through compost or manure addition. Nitrogen levels below 20 mg/kg require fertilization. Phosphorus below 15 mg/kg limits root development. Potassium below 100 mg/kg affects disease resistance. The MakerTest device provides quick, on-site soil analysis, eliminating the need to send samples to distant laboratories and wait weeks for results.",
                category = ArticleCategory.SOIL_MANAGEMENT,
                difficulty = Difficulty.INTERMEDIATE,
                readTime = 11,
                tags = listOf("soil-testing", "ph", "nutrients", "interpretation"),
                isLocal = true,
                language = "en",
                region = "South Sudan",
                createdAt = System.currentTimeMillis() - 86400000 * 22,
                updatedAt = System.currentTimeMillis() - 86400000 * 8
            )
        )
    }
}
