package com.makertest.app.data.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\r2\u0006\u0010\b\u001a\u00020\tH\'J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/makertest/app/data/database/dao/UserProfileDao;", "", "deleteUser", "", "user", "Lcom/makertest/app/data/models/UserProfile;", "(Lcom/makertest/app/data/models/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "observeUser", "Lkotlinx/coroutines/flow/Flow;", "updateUser", "app_debug"})
@androidx.room.Dao
public abstract interface UserProfileDao {
    
    @androidx.room.Query(value = "SELECT * FROM user_profiles WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.makertest.app.data.models.UserProfile> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_profiles WHERE userId = :userId")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.makertest.app.data.models.UserProfile> observeUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.UserProfile user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.UserProfile user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.UserProfile user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}