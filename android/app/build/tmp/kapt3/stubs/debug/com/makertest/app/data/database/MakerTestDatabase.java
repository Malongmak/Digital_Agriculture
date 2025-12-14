package com.makertest.app.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/makertest/app/data/database/MakerTestDatabase;", "Landroidx/room/RoomDatabase;", "()V", "farmFieldDao", "Lcom/makertest/app/data/database/dao/FarmFieldDao;", "knowledgeArticleDao", "Lcom/makertest/app/data/database/dao/KnowledgeArticleDao;", "ngoPartnerDao", "Lcom/makertest/app/data/database/dao/NGOPartnerDao;", "soilTestDao", "Lcom/makertest/app/data/database/dao/SoilTestDao;", "userProfileDao", "Lcom/makertest/app/data/database/dao/UserProfileDao;", "app_debug"})
@androidx.room.Database(entities = {com.makertest.app.data.models.SoilTestData.class, com.makertest.app.data.models.UserProfile.class, com.makertest.app.data.models.FarmField.class, com.makertest.app.data.models.KnowledgeArticle.class, com.makertest.app.data.models.NGOPartner.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.makertest.app.data.database.converters.RoomConverters.class})
public abstract class MakerTestDatabase extends androidx.room.RoomDatabase {
    
    public MakerTestDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.makertest.app.data.database.dao.SoilTestDao soilTestDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.makertest.app.data.database.dao.UserProfileDao userProfileDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.makertest.app.data.database.dao.FarmFieldDao farmFieldDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.makertest.app.data.database.dao.KnowledgeArticleDao knowledgeArticleDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.makertest.app.data.database.dao.NGOPartnerDao ngoPartnerDao();
}