package com.makertest.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.makertest.app.data.database.dao.SoilTestDao
import com.makertest.app.data.database.dao.UserProfileDao
import com.makertest.app.data.database.dao.FarmFieldDao
import com.makertest.app.data.database.dao.KnowledgeArticleDao
import com.makertest.app.data.database.dao.NGOPartnerDao
import com.makertest.app.data.database.converters.RoomConverters
import com.makertest.app.data.models.SoilTestData
import com.makertest.app.data.models.UserProfile
import com.makertest.app.data.models.FarmField
import com.makertest.app.data.models.KnowledgeArticle
import com.makertest.app.data.models.NGOPartner

@Database(
    entities = [
        SoilTestData::class,
        UserProfile::class,
        FarmField::class,
        KnowledgeArticle::class,
        NGOPartner::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class MakerTestDatabase : RoomDatabase() {
    abstract fun soilTestDao(): SoilTestDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun farmFieldDao(): FarmFieldDao
    abstract fun knowledgeArticleDao(): KnowledgeArticleDao
    abstract fun ngoPartnerDao(): NGOPartnerDao
}
