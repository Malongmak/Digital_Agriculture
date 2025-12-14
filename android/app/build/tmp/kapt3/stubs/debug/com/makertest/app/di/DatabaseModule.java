package com.makertest.app.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/makertest/app/di/DatabaseModule;", "", "()V", "provideFarmFieldDao", "Lcom/makertest/app/data/database/dao/FarmFieldDao;", "database", "Lcom/makertest/app/data/database/MakerTestDatabase;", "provideKnowledgeArticleDao", "Lcom/makertest/app/data/database/dao/KnowledgeArticleDao;", "provideMakerTestDatabase", "context", "Landroid/content/Context;", "provideNGOPartnerDao", "Lcom/makertest/app/data/database/dao/NGOPartnerDao;", "provideSoilTestDao", "Lcom/makertest/app/data/database/dao/SoilTestDao;", "provideUserProfileDao", "Lcom/makertest/app/data/database/dao/UserProfileDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.makertest.app.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.database.MakerTestDatabase provideMakerTestDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.database.dao.SoilTestDao provideSoilTestDao(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.database.MakerTestDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.database.dao.UserProfileDao provideUserProfileDao(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.database.MakerTestDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.database.dao.FarmFieldDao provideFarmFieldDao(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.database.MakerTestDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.database.dao.KnowledgeArticleDao provideKnowledgeArticleDao(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.database.MakerTestDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.database.dao.NGOPartnerDao provideNGOPartnerDao(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.database.MakerTestDatabase database) {
        return null;
    }
}