package com.makertest.app.data.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0019\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0017\u001a\u00020\u0011H\'J\u0019\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/makertest/app/data/database/dao/KnowledgeArticleDao;", "", "deleteArticle", "", "article", "Lcom/makertest/app/data/models/KnowledgeArticle;", "(Lcom/makertest/app/data/models/KnowledgeArticle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticleById", "articleId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllArticles", "Lkotlinx/coroutines/flow/Flow;", "", "getArticleById", "getArticlesByCategory", "category", "", "insertArticle", "insertArticles", "articles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchArticles", "query", "updateArticle", "app_debug"})
@androidx.room.Dao
public abstract interface KnowledgeArticleDao {
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_articles ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.KnowledgeArticle>> getAllArticles();
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_articles WHERE id = :articleId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getArticleById(long articleId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.makertest.app.data.models.KnowledgeArticle> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_articles WHERE category = :category ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.KnowledgeArticle>> getArticlesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_articles WHERE title LIKE \'%\' || :query || \'%\' OR content LIKE \'%\' || :query || \'%\' ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.makertest.app.data.models.KnowledgeArticle>> searchArticles(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertArticle(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.KnowledgeArticle article, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertArticles(@org.jetbrains.annotations.NotNull
    java.util.List<com.makertest.app.data.models.KnowledgeArticle> articles, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateArticle(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.KnowledgeArticle article, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteArticle(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.KnowledgeArticle article, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM knowledge_articles WHERE id = :articleId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteArticleById(long articleId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}