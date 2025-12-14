package com.makertest.app.data.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.makertest.app.data.database.converters.RoomConverters;
import com.makertest.app.data.models.ArticleCategory;
import com.makertest.app.data.models.Difficulty;
import com.makertest.app.data.models.KnowledgeArticle;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class KnowledgeArticleDao_Impl implements KnowledgeArticleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KnowledgeArticle> __insertionAdapterOfKnowledgeArticle;

  private final RoomConverters __roomConverters = new RoomConverters();

  private final EntityDeletionOrUpdateAdapter<KnowledgeArticle> __deletionAdapterOfKnowledgeArticle;

  private final EntityDeletionOrUpdateAdapter<KnowledgeArticle> __updateAdapterOfKnowledgeArticle;

  private final SharedSQLiteStatement __preparedStmtOfDeleteArticleById;

  public KnowledgeArticleDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKnowledgeArticle = new EntityInsertionAdapter<KnowledgeArticle>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `knowledge_articles` (`id`,`title`,`content`,`category`,`difficulty`,`readTime`,`imageUrl`,`tags`,`isLocal`,`language`,`region`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeArticle entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        statement.bindString(4, __ArticleCategory_enumToString(entity.getCategory()));
        statement.bindString(5, __Difficulty_enumToString(entity.getDifficulty()));
        statement.bindLong(6, entity.getReadTime());
        if (entity.getImageUrl() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getImageUrl());
        }
        final String _tmp = __roomConverters.fromStringList(entity.getTags());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp);
        }
        final int _tmp_1 = entity.isLocal() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        if (entity.getLanguage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLanguage());
        }
        if (entity.getRegion() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getRegion());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfKnowledgeArticle = new EntityDeletionOrUpdateAdapter<KnowledgeArticle>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `knowledge_articles` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeArticle entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfKnowledgeArticle = new EntityDeletionOrUpdateAdapter<KnowledgeArticle>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `knowledge_articles` SET `id` = ?,`title` = ?,`content` = ?,`category` = ?,`difficulty` = ?,`readTime` = ?,`imageUrl` = ?,`tags` = ?,`isLocal` = ?,`language` = ?,`region` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeArticle entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        statement.bindString(4, __ArticleCategory_enumToString(entity.getCategory()));
        statement.bindString(5, __Difficulty_enumToString(entity.getDifficulty()));
        statement.bindLong(6, entity.getReadTime());
        if (entity.getImageUrl() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getImageUrl());
        }
        final String _tmp = __roomConverters.fromStringList(entity.getTags());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp);
        }
        final int _tmp_1 = entity.isLocal() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        if (entity.getLanguage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLanguage());
        }
        if (entity.getRegion() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getRegion());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
        statement.bindLong(14, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteArticleById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM knowledge_articles WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertArticle(final KnowledgeArticle article,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfKnowledgeArticle.insertAndReturnId(article);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertArticles(final List<KnowledgeArticle> articles,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfKnowledgeArticle.insert(articles);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteArticle(final KnowledgeArticle article,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfKnowledgeArticle.handle(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateArticle(final KnowledgeArticle article,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfKnowledgeArticle.handle(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteArticleById(final long articleId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteArticleById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, articleId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteArticleById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<KnowledgeArticle>> getAllArticles() {
    final String _sql = "SELECT * FROM knowledge_articles ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_articles"}, new Callable<List<KnowledgeArticle>>() {
      @Override
      @NonNull
      public List<KnowledgeArticle> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfReadTime = CursorUtil.getColumnIndexOrThrow(_cursor, "readTime");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocal");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<KnowledgeArticle> _result = new ArrayList<KnowledgeArticle>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeArticle _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final ArticleCategory _tmpCategory;
            _tmpCategory = __ArticleCategory_stringToEnum(_cursor.getString(_cursorIndexOfCategory));
            final Difficulty _tmpDifficulty;
            _tmpDifficulty = __Difficulty_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpReadTime;
            _tmpReadTime = _cursor.getInt(_cursorIndexOfReadTime);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __roomConverters.toStringList(_tmp);
            final boolean _tmpIsLocal;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_1 != 0;
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new KnowledgeArticle(_tmpId,_tmpTitle,_tmpContent,_tmpCategory,_tmpDifficulty,_tmpReadTime,_tmpImageUrl,_tmpTags,_tmpIsLocal,_tmpLanguage,_tmpRegion,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getArticleById(final long articleId,
      final Continuation<? super KnowledgeArticle> $completion) {
    final String _sql = "SELECT * FROM knowledge_articles WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, articleId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<KnowledgeArticle>() {
      @Override
      @Nullable
      public KnowledgeArticle call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfReadTime = CursorUtil.getColumnIndexOrThrow(_cursor, "readTime");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocal");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final KnowledgeArticle _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final ArticleCategory _tmpCategory;
            _tmpCategory = __ArticleCategory_stringToEnum(_cursor.getString(_cursorIndexOfCategory));
            final Difficulty _tmpDifficulty;
            _tmpDifficulty = __Difficulty_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpReadTime;
            _tmpReadTime = _cursor.getInt(_cursorIndexOfReadTime);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __roomConverters.toStringList(_tmp);
            final boolean _tmpIsLocal;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_1 != 0;
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new KnowledgeArticle(_tmpId,_tmpTitle,_tmpContent,_tmpCategory,_tmpDifficulty,_tmpReadTime,_tmpImageUrl,_tmpTags,_tmpIsLocal,_tmpLanguage,_tmpRegion,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<KnowledgeArticle>> getArticlesByCategory(final String category) {
    final String _sql = "SELECT * FROM knowledge_articles WHERE category = ? ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_articles"}, new Callable<List<KnowledgeArticle>>() {
      @Override
      @NonNull
      public List<KnowledgeArticle> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfReadTime = CursorUtil.getColumnIndexOrThrow(_cursor, "readTime");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocal");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<KnowledgeArticle> _result = new ArrayList<KnowledgeArticle>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeArticle _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final ArticleCategory _tmpCategory;
            _tmpCategory = __ArticleCategory_stringToEnum(_cursor.getString(_cursorIndexOfCategory));
            final Difficulty _tmpDifficulty;
            _tmpDifficulty = __Difficulty_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpReadTime;
            _tmpReadTime = _cursor.getInt(_cursorIndexOfReadTime);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __roomConverters.toStringList(_tmp);
            final boolean _tmpIsLocal;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_1 != 0;
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new KnowledgeArticle(_tmpId,_tmpTitle,_tmpContent,_tmpCategory,_tmpDifficulty,_tmpReadTime,_tmpImageUrl,_tmpTags,_tmpIsLocal,_tmpLanguage,_tmpRegion,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<KnowledgeArticle>> searchArticles(final String query) {
    final String _sql = "SELECT * FROM knowledge_articles WHERE title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%' ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_articles"}, new Callable<List<KnowledgeArticle>>() {
      @Override
      @NonNull
      public List<KnowledgeArticle> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfReadTime = CursorUtil.getColumnIndexOrThrow(_cursor, "readTime");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfIsLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocal");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<KnowledgeArticle> _result = new ArrayList<KnowledgeArticle>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeArticle _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final ArticleCategory _tmpCategory;
            _tmpCategory = __ArticleCategory_stringToEnum(_cursor.getString(_cursorIndexOfCategory));
            final Difficulty _tmpDifficulty;
            _tmpDifficulty = __Difficulty_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpReadTime;
            _tmpReadTime = _cursor.getInt(_cursorIndexOfReadTime);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __roomConverters.toStringList(_tmp);
            final boolean _tmpIsLocal;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocal);
            _tmpIsLocal = _tmp_1 != 0;
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new KnowledgeArticle(_tmpId,_tmpTitle,_tmpContent,_tmpCategory,_tmpDifficulty,_tmpReadTime,_tmpImageUrl,_tmpTags,_tmpIsLocal,_tmpLanguage,_tmpRegion,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __ArticleCategory_enumToString(@NonNull final ArticleCategory _value) {
    switch (_value) {
      case SOIL_MANAGEMENT: return "SOIL_MANAGEMENT";
      case CROP_CARE: return "CROP_CARE";
      case PEST_CONTROL: return "PEST_CONTROL";
      case IRRIGATION: return "IRRIGATION";
      case FERTILIZATION: return "FERTILIZATION";
      case CLIMATE_ADAPTATION: return "CLIMATE_ADAPTATION";
      case SUSTAINABLE_FARMING: return "SUSTAINABLE_FARMING";
      case MARKET_INFO: return "MARKET_INFO";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Difficulty_enumToString(@NonNull final Difficulty _value) {
    switch (_value) {
      case BEGINNER: return "BEGINNER";
      case INTERMEDIATE: return "INTERMEDIATE";
      case ADVANCED: return "ADVANCED";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private ArticleCategory __ArticleCategory_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "SOIL_MANAGEMENT": return ArticleCategory.SOIL_MANAGEMENT;
      case "CROP_CARE": return ArticleCategory.CROP_CARE;
      case "PEST_CONTROL": return ArticleCategory.PEST_CONTROL;
      case "IRRIGATION": return ArticleCategory.IRRIGATION;
      case "FERTILIZATION": return ArticleCategory.FERTILIZATION;
      case "CLIMATE_ADAPTATION": return ArticleCategory.CLIMATE_ADAPTATION;
      case "SUSTAINABLE_FARMING": return ArticleCategory.SUSTAINABLE_FARMING;
      case "MARKET_INFO": return ArticleCategory.MARKET_INFO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Difficulty __Difficulty_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "BEGINNER": return Difficulty.BEGINNER;
      case "INTERMEDIATE": return Difficulty.INTERMEDIATE;
      case "ADVANCED": return Difficulty.ADVANCED;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
