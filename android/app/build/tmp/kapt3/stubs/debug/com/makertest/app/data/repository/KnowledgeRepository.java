package com.makertest.app.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/makertest/app/data/repository/KnowledgeRepository;", "", "()V", "getAllArticles", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/makertest/app/data/models/KnowledgeArticle;", "getArticleById", "id", "", "getSampleSouthSudanArticles", "app_debug"})
public final class KnowledgeRepository {
    
    @javax.inject.Inject
    public KnowledgeRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.KnowledgeArticle>> getAllArticles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.makertest.app.data.models.KnowledgeArticle> getArticleById(long id) {
        return null;
    }
    
    private final java.util.List<com.makertest.app.data.models.KnowledgeArticle> getSampleSouthSudanArticles() {
        return null;
    }
}