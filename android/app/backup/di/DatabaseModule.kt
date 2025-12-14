package com.makertest.app.di

import android.content.Context
import androidx.room.Room
import com.makertest.app.data.database.MakerTestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideMakerTestDatabase(
        @ApplicationContext context: Context
    ): MakerTestDatabase {
        return Room.databaseBuilder(
            context,
            MakerTestDatabase::class.java,
            "makertest_database"
        ).build()
    }
    
    @Provides
    fun provideSoilTestDao(database: MakerTestDatabase) = database.soilTestDao()
    
    @Provides
    fun provideUserProfileDao(database: MakerTestDatabase) = database.userProfileDao()
    
    @Provides
    fun provideFarmFieldDao(database: MakerTestDatabase) = database.farmFieldDao()
    
    @Provides
    fun provideKnowledgeArticleDao(database: MakerTestDatabase) = database.knowledgeArticleDao()
    
    @Provides
    fun provideNGOPartnerDao(database: MakerTestDatabase) = database.ngoPartnerDao()
}
