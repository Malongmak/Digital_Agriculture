package com.makertest.app.data.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/makertest/app/data/database/dao/NGOPartnerDao;", "", "deleteNGO", "", "ngo", "Lcom/makertest/app/data/models/NGOPartner;", "(Lcom/makertest/app/data/models/NGOPartner;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNGOById", "ngoId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveNGOs", "Lkotlinx/coroutines/flow/Flow;", "", "getAllNGOs", "getNGOById", "getNGOsByLocation", "location", "", "insertNGO", "insertNGOs", "ngos", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNGO", "app_debug"})
@androidx.room.Dao
public abstract interface NGOPartnerDao {
    
    @androidx.room.Query(value = "SELECT * FROM ngo_partners WHERE isActive = 1 ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.NGOPartner>> getAllActiveNGOs();
    
    @androidx.room.Query(value = "SELECT * FROM ngo_partners ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.NGOPartner>> getAllNGOs();
    
    @androidx.room.Query(value = "SELECT * FROM ngo_partners WHERE id = :ngoId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getNGOById(long ngoId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.makertest.app.data.models.NGOPartner> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM ngo_partners WHERE location LIKE \'%\' || :location || \'%\' AND isActive = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.NGOPartner>> getNGOsByLocation(@org.jetbrains.annotations.NotNull
    java.lang.String location);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertNGO(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NGOPartner ngo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertNGOs(@org.jetbrains.annotations.NotNull
    java.util.List<com.makertest.app.data.models.NGOPartner> ngos, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateNGO(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NGOPartner ngo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteNGO(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NGOPartner ngo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM ngo_partners WHERE id = :ngoId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteNGOById(long ngoId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}