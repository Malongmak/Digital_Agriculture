package com.makertest.app.data.repository

import com.makertest.app.data.models.NGOPartner
import com.makertest.app.data.models.NGOWorkshop
import com.makertest.app.data.models.NGOService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NGORepository @Inject constructor() {
    
    fun getNGOPartners(): Flow<List<NGOPartner>> = flow {
        // In a real app, this would fetch from a remote API or local database
        // For now, we'll provide sample NGO partners relevant to South Sudan agriculture
        val samplePartners = getSampleSouthSudanNGOs()
        emit(samplePartners)
    }
    
    fun getWorkshops(): Flow<List<NGOWorkshop>> = flow {
        // Sample workshops for South Sudan farmers
        val sampleWorkshops = getSampleWorkshops()
        emit(sampleWorkshops)
    }
    
    suspend fun registerForWorkshop(workshopId: String) {
        // In a real app, this would make an API call to register the user
        // For now, we'll just simulate the registration
    }
    
    private fun getSampleSouthSudanNGOs(): List<NGOPartner> {
        return listOf(
            NGOPartner(
                id = 1,
                name = "Food and Agriculture Organization (FAO) South Sudan",
                description = "FAO works to improve food security and nutrition in South Sudan through sustainable agriculture development, emergency response, and resilience building programs.",
                contactPerson = "Dr. John Akech",
                phone = "+211 912 345 678",
                email = "fao-ss@fao.org",
                location = "Juba, Central Equatoria",
                services = listOf(
                    NGOService.TRAINING,
                    NGOService.EQUIPMENT_DISTRIBUTION,
                    NGOService.TECHNICAL_SUPPORT,
                    NGOService.EMERGENCY_RELIEF
                ),
                website = "www.fao.org/south-sudan",
                establishedYear = 1945,
                region = "South Sudan"
            ),
            NGOPartner(
                id = 2,
                name = "International Fund for Agricultural Development (IFAD)",
                description = "IFAD invests in rural people to empower them to increase their food security, improve nutrition, and increase their incomes.",
                contactPerson = "Ms. Sarah Nyachan",
                phone = "+211 923 456 789",
                email = "ifad-ss@ifad.org",
                location = "Juba, Central Equatoria",
                services = listOf(
                    NGOService.FINANCIAL_SUPPORT,
                    NGOService.TRAINING,
                    NGOService.TECHNICAL_SUPPORT,
                    NGOService.MARKET_ACCESS
                ),
                website = "www.ifad.org",
                establishedYear = 1977,
                region = "South Sudan"
            ),
            NGOPartner(
                id = 3,
                name = "African Development Bank (AfDB) South Sudan",
                description = "AfDB supports agricultural development projects that improve food security and reduce poverty in South Sudan.",
                contactPerson = "Mr. James Lual",
                phone = "+211 934 567 890",
                email = "afdb-ss@afdb.org",
                location = "Juba, Central Equatoria",
                services = listOf(
                    NGOService.FINANCIAL_SUPPORT,
                    NGOService.EQUIPMENT_DISTRIBUTION,
                    NGOService.INFRASTRUCTURE_DEVELOPMENT
                ),
                website = "www.afdb.org",
                establishedYear = 1964,
                region = "South Sudan"
            ),
            NGOPartner(
                id = 4,
                name = "CARE International South Sudan",
                description = "CARE works to save lives, defeat poverty, and achieve social justice, with a focus on empowering women and girls.",
                contactPerson = "Ms. Grace Nyak",
                phone = "+211 945 678 901",
                email = "care-ss@care.org",
                location = "Juba, Central Equatoria",
                services = listOf(
                    NGOService.EMERGENCY_RELIEF,
                    NGOService.TRAINING,
                    NGOService.SEED_DISTRIBUTION,
                    NGOService.EDUCATION
                ),
                website = "www.care.org",
                establishedYear = 1945,
                region = "South Sudan"
            ),
            NGOPartner(
                id = 5,
                name = "World Vision South Sudan",
                description = "World Vision provides emergency assistance and promotes long-term development to help communities become self-sufficient.",
                contactPerson = "Mr. Peter Deng",
                phone = "+211 956 789 012",
                email = "wv-ss@wvi.org",
                location = "Juba, Central Equatoria",
                services = listOf(
                    NGOService.EMERGENCY_RELIEF,
                    NGOService.SEED_DISTRIBUTION,
                    NGOService.TRAINING,
                    NGOService.EDUCATION
                ),
                website = "www.wvi.org",
                establishedYear = 1950,
                region = "South Sudan"
            ),
            NGOPartner(
                id = 6,
                name = "Oxfam South Sudan",
                description = "Oxfam works to create lasting solutions to poverty and injustice through humanitarian response and development programs.",
                contactPerson = "Ms. Rachel Kiden",
                phone = "+211 967 890 123",
                email = "oxfam-ss@oxfam.org",
                location = "Juba, Central Equatoria",
                services = listOf(
                    NGOService.EMERGENCY_RELIEF,
                    NGOService.MARKET_ACCESS,
                    NGOService.TRAINING,
                    NGOService.TECHNICAL_SUPPORT
                ),
                website = "www.oxfam.org",
                establishedYear = 1942,
                region = "South Sudan"
            )
        )
    }
    
    private fun getSampleWorkshops(): List<NGOWorkshop> {
        return listOf(
            NGOWorkshop(
                id = "workshop_1",
                ngoId = 1,
                title = "Soil Health Management Training",
                description = "Learn advanced techniques for improving soil health, including composting, crop rotation, and organic matter management.",
                date = System.currentTimeMillis() + 86400000 * 7, // 7 days from now
                location = "Juba Agricultural Training Center",
                duration = 8,
                maxParticipants = 50,
                currentParticipants = 23,
                topics = listOf("Soil Testing", "Composting", "Crop Rotation", "Organic Farming"),
                instructor = "Dr. Michael Luka",
                cost = 0.0
            ),
            NGOWorkshop(
                id = "workshop_2",
                ngoId = 2,
                title = "Climate-Smart Agriculture",
                description = "Understand climate change impacts and learn adaptation strategies for sustainable farming in South Sudan.",
                date = System.currentTimeMillis() + 86400000 * 14, // 14 days from now
                location = "Yei Agricultural Center",
                duration = 6,
                maxParticipants = 30,
                currentParticipants = 18,
                topics = listOf("Climate Adaptation", "Water Conservation", "Drought-Resistant Crops"),
                instructor = "Ms. Anna Joseph",
                cost = 50.0
            ),
            NGOWorkshop(
                id = "workshop_3",
                ngoId = 4,
                title = "Post-Harvest Management",
                description = "Learn proper techniques for crop storage, processing, and reducing post-harvest losses.",
                date = System.currentTimeMillis() + 86400000 * 21, // 21 days from now
                location = "Wau Training Facility",
                duration = 4,
                maxParticipants = 40,
                currentParticipants = 35,
                topics = listOf("Storage Methods", "Processing", "Loss Reduction", "Market Preparation"),
                instructor = "Mr. Samuel John",
                cost = 0.0
            ),
            NGOWorkshop(
                id = "workshop_4",
                ngoId = 1,
                title = "Integrated Pest Management",
                description = "Learn sustainable pest control methods that reduce reliance on chemical pesticides.",
                date = System.currentTimeMillis() + 86400000 * 28, // 28 days from now
                location = "Malakal Agricultural Station",
                duration = 6,
                maxParticipants = 25,
                currentParticipants = 12,
                topics = listOf("Organic Pesticides", "Biological Control", "Pest Identification", "Prevention"),
                instructor = "Dr. Sarah Achan",
                cost = 25.0
            ),
            NGOWorkshop(
                id = "workshop_5",
                ngoId = 5,
                title = "Smallholder Business Skills",
                description = "Develop business management skills for small-scale farming operations and market access.",
                date = System.currentTimeMillis() + 86400000 * 35, // 35 days from now
                location = "Bor Training Center",
                duration = 5,
                maxParticipants = 35,
                currentParticipants = 28,
                topics = listOf("Business Planning", "Market Analysis", "Financial Management", "Record Keeping"),
                instructor = "Mr. David Malok",
                cost = 30.0
            )
        )
    }
}
