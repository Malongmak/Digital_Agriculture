package com.makertest.app.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/makertest/app/data/repository/NGORepository;", "", "()V", "getNGOPartners", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/makertest/app/data/models/NGOPartner;", "getSampleSouthSudanNGOs", "getSampleWorkshops", "Lcom/makertest/app/data/models/NGOWorkshop;", "getWorkshops", "registerForWorkshop", "", "workshopId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NGORepository {
    
    @javax.inject.Inject
    public NGORepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.NGOPartner>> getNGOPartners() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.NGOWorkshop>> getWorkshops() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object registerForWorkshop(@org.jetbrains.annotations.NotNull
    java.lang.String workshopId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.util.List<com.makertest.app.data.models.NGOPartner> getSampleSouthSudanNGOs() {
        return null;
    }
    
    private final java.util.List<com.makertest.app.data.models.NGOWorkshop> getSampleWorkshops() {
        return null;
    }
}