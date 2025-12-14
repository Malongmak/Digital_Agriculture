package com.makertest.app.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\rJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/makertest/app/data/repository/SoilTestRepository;", "", "()V", "testHistory", "", "Lcom/makertest/app/data/models/SoilTestData;", "deleteTest", "", "testId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTestById", "getTestHistory", "Lkotlinx/coroutines/flow/Flow;", "", "getTestHistoryByField", "fieldId", "", "saveSoilTest", "testData", "(Lcom/makertest/app/data/models/SoilTestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SoilTestRepository {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.makertest.app.data.models.SoilTestData> testHistory = null;
    
    @javax.inject.Inject
    public SoilTestRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSoilTest(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.SoilTestData testData, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.SoilTestData>> getTestHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.SoilTestData>> getTestHistoryByField(@org.jetbrains.annotations.NotNull
    java.lang.String fieldId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteTest(long testId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTestById(long testId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.makertest.app.data.models.SoilTestData> $completion) {
        return null;
    }
}