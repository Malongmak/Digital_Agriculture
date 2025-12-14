package com.makertest.app.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00112\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0011J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/makertest/app/data/repository/ProfileRepository;", "", "()V", "farmFields", "", "Lcom/makertest/app/data/models/FarmField;", "userProfile", "Lcom/makertest/app/data/models/UserProfile;", "addFarmField", "", "field", "(Lcom/makertest/app/data/models/FarmField;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFarmField", "fieldId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFarmFieldById", "Lkotlinx/coroutines/flow/Flow;", "getFarmFields", "", "getUserProfile", "saveUserProfile", "profile", "(Lcom/makertest/app/data/models/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFarmField", "updateUserProfile", "app_debug"})
public final class ProfileRepository {
    @org.jetbrains.annotations.Nullable
    private com.makertest.app.data.models.UserProfile userProfile;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.makertest.app.data.models.FarmField> farmFields = null;
    
    @javax.inject.Inject
    public ProfileRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveUserProfile(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.UserProfile profile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateUserProfile(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.UserProfile profile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.makertest.app.data.models.UserProfile> getUserProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFarmField(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.FarmField field, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateFarmField(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.FarmField field, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteFarmField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.FarmField>> getFarmFields() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.makertest.app.data.models.FarmField> getFarmFieldById(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId) {
        return null;
    }
}