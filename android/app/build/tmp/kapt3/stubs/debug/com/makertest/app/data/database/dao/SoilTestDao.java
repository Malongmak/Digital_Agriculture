package com.makertest.app.data.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/makertest/app/data/database/dao/SoilTestDao;", "", "deleteTest", "", "test", "Lcom/makertest/app/data/models/SoilTestData;", "(Lcom/makertest/app/data/models/SoilTestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTestById", "testId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTests", "Lkotlinx/coroutines/flow/Flow;", "", "getTestById", "getTestCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTestsByField", "fieldId", "", "insertTest", "updateTest", "app_debug"})
@androidx.room.Dao
public abstract interface SoilTestDao {
    
    @androidx.room.Query(value = "SELECT * FROM soil_tests ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.SoilTestData>> getAllTests();
    
    @androidx.room.Query(value = "SELECT * FROM soil_tests WHERE fieldId = :fieldId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.SoilTestData>> getTestsByField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId);
    
    @androidx.room.Query(value = "SELECT * FROM soil_tests WHERE id = :testId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTestById(long testId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.makertest.app.data.models.SoilTestData> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTest(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.SoilTestData test, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTest(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.SoilTestData test, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTest(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.SoilTestData test, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM soil_tests WHERE id = :testId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTestById(long testId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM soil_tests")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTestCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}