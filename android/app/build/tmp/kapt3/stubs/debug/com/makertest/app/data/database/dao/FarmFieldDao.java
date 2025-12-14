package com.makertest.app.data.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/makertest/app/data/database/dao/FarmFieldDao;", "", "deleteField", "", "field", "Lcom/makertest/app/data/models/FarmField;", "(Lcom/makertest/app/data/models/FarmField;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFieldById", "fieldId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFields", "Lkotlinx/coroutines/flow/Flow;", "", "getFieldById", "getFieldCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertField", "updateField", "app_debug"})
@androidx.room.Dao
public abstract interface FarmFieldDao {
    
    @androidx.room.Query(value = "SELECT * FROM farm_fields ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.FarmField>> getAllFields();
    
    @androidx.room.Query(value = "SELECT * FROM farm_fields WHERE id = :fieldId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFieldById(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.makertest.app.data.models.FarmField> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertField(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.FarmField field, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateField(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.FarmField field, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteField(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.FarmField field, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM farm_fields WHERE id = :fieldId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFieldById(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM farm_fields")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFieldCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}