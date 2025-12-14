package com.makertest.app.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.makertest.app.data.database.dao.FarmFieldDao;
import com.makertest.app.data.database.dao.FarmFieldDao_Impl;
import com.makertest.app.data.database.dao.KnowledgeArticleDao;
import com.makertest.app.data.database.dao.KnowledgeArticleDao_Impl;
import com.makertest.app.data.database.dao.NGOPartnerDao;
import com.makertest.app.data.database.dao.NGOPartnerDao_Impl;
import com.makertest.app.data.database.dao.SoilTestDao;
import com.makertest.app.data.database.dao.SoilTestDao_Impl;
import com.makertest.app.data.database.dao.UserProfileDao;
import com.makertest.app.data.database.dao.UserProfileDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MakerTestDatabase_Impl extends MakerTestDatabase {
  private volatile SoilTestDao _soilTestDao;

  private volatile UserProfileDao _userProfileDao;

  private volatile FarmFieldDao _farmFieldDao;

  private volatile KnowledgeArticleDao _knowledgeArticleDao;

  private volatile NGOPartnerDao _nGOPartnerDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `soil_tests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fieldId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `ph` REAL NOT NULL, `moisture` REAL NOT NULL, `nitrogen` REAL NOT NULL, `phosphorus` REAL NOT NULL, `potassium` REAL NOT NULL, `deviceId` TEXT NOT NULL, `location` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_profiles` (`userId` TEXT NOT NULL, `name` TEXT NOT NULL, `email` TEXT, `phone` TEXT, `location` TEXT NOT NULL, `memberSince` INTEGER NOT NULL, `totalTests` INTEGER NOT NULL, `fieldCount` INTEGER NOT NULL, `yieldImprovement` INTEGER NOT NULL, `preferredLanguage` TEXT NOT NULL, `isNGOMember` INTEGER NOT NULL, `ngoName` TEXT, `profileImage` TEXT, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `FarmField` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `cropType` TEXT NOT NULL, `size` REAL NOT NULL, `location` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_articles` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `category` TEXT NOT NULL, `difficulty` TEXT NOT NULL, `readTime` INTEGER NOT NULL, `imageUrl` TEXT, `tags` TEXT NOT NULL, `isLocal` INTEGER NOT NULL, `language` TEXT NOT NULL, `region` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ngo_partners` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `contactPerson` TEXT NOT NULL, `phone` TEXT NOT NULL, `email` TEXT NOT NULL, `location` TEXT NOT NULL, `services` TEXT NOT NULL, `website` TEXT, `logoUrl` TEXT, `isActive` INTEGER NOT NULL, `establishedYear` INTEGER NOT NULL, `region` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '271bc885215335db7a8211bd3717123b')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `soil_tests`");
        db.execSQL("DROP TABLE IF EXISTS `user_profiles`");
        db.execSQL("DROP TABLE IF EXISTS `FarmField`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_articles`");
        db.execSQL("DROP TABLE IF EXISTS `ngo_partners`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsSoilTests = new HashMap<String, TableInfo.Column>(10);
        _columnsSoilTests.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("fieldId", new TableInfo.Column("fieldId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("ph", new TableInfo.Column("ph", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("moisture", new TableInfo.Column("moisture", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("nitrogen", new TableInfo.Column("nitrogen", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("phosphorus", new TableInfo.Column("phosphorus", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("potassium", new TableInfo.Column("potassium", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSoilTests.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSoilTests = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSoilTests = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSoilTests = new TableInfo("soil_tests", _columnsSoilTests, _foreignKeysSoilTests, _indicesSoilTests);
        final TableInfo _existingSoilTests = TableInfo.read(db, "soil_tests");
        if (!_infoSoilTests.equals(_existingSoilTests)) {
          return new RoomOpenHelper.ValidationResult(false, "soil_tests(com.makertest.app.data.models.SoilTestData).\n"
                  + " Expected:\n" + _infoSoilTests + "\n"
                  + " Found:\n" + _existingSoilTests);
        }
        final HashMap<String, TableInfo.Column> _columnsUserProfiles = new HashMap<String, TableInfo.Column>(15);
        _columnsUserProfiles.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("memberSince", new TableInfo.Column("memberSince", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("totalTests", new TableInfo.Column("totalTests", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("fieldCount", new TableInfo.Column("fieldCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("yieldImprovement", new TableInfo.Column("yieldImprovement", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("preferredLanguage", new TableInfo.Column("preferredLanguage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("isNGOMember", new TableInfo.Column("isNGOMember", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("ngoName", new TableInfo.Column("ngoName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("profileImage", new TableInfo.Column("profileImage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserProfiles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserProfiles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserProfiles = new TableInfo("user_profiles", _columnsUserProfiles, _foreignKeysUserProfiles, _indicesUserProfiles);
        final TableInfo _existingUserProfiles = TableInfo.read(db, "user_profiles");
        if (!_infoUserProfiles.equals(_existingUserProfiles)) {
          return new RoomOpenHelper.ValidationResult(false, "user_profiles(com.makertest.app.data.models.UserProfile).\n"
                  + " Expected:\n" + _infoUserProfiles + "\n"
                  + " Found:\n" + _existingUserProfiles);
        }
        final HashMap<String, TableInfo.Column> _columnsFarmField = new HashMap<String, TableInfo.Column>(5);
        _columnsFarmField.put("id", new TableInfo.Column("id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmField.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmField.put("cropType", new TableInfo.Column("cropType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmField.put("size", new TableInfo.Column("size", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmField.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFarmField = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFarmField = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFarmField = new TableInfo("FarmField", _columnsFarmField, _foreignKeysFarmField, _indicesFarmField);
        final TableInfo _existingFarmField = TableInfo.read(db, "FarmField");
        if (!_infoFarmField.equals(_existingFarmField)) {
          return new RoomOpenHelper.ValidationResult(false, "FarmField(com.makertest.app.data.models.FarmField).\n"
                  + " Expected:\n" + _infoFarmField + "\n"
                  + " Found:\n" + _existingFarmField);
        }
        final HashMap<String, TableInfo.Column> _columnsKnowledgeArticles = new HashMap<String, TableInfo.Column>(13);
        _columnsKnowledgeArticles.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("difficulty", new TableInfo.Column("difficulty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("readTime", new TableInfo.Column("readTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("isLocal", new TableInfo.Column("isLocal", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("region", new TableInfo.Column("region", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeArticles.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKnowledgeArticles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKnowledgeArticles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKnowledgeArticles = new TableInfo("knowledge_articles", _columnsKnowledgeArticles, _foreignKeysKnowledgeArticles, _indicesKnowledgeArticles);
        final TableInfo _existingKnowledgeArticles = TableInfo.read(db, "knowledge_articles");
        if (!_infoKnowledgeArticles.equals(_existingKnowledgeArticles)) {
          return new RoomOpenHelper.ValidationResult(false, "knowledge_articles(com.makertest.app.data.models.KnowledgeArticle).\n"
                  + " Expected:\n" + _infoKnowledgeArticles + "\n"
                  + " Found:\n" + _existingKnowledgeArticles);
        }
        final HashMap<String, TableInfo.Column> _columnsNgoPartners = new HashMap<String, TableInfo.Column>(13);
        _columnsNgoPartners.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("contactPerson", new TableInfo.Column("contactPerson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("services", new TableInfo.Column("services", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("website", new TableInfo.Column("website", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("logoUrl", new TableInfo.Column("logoUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("establishedYear", new TableInfo.Column("establishedYear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNgoPartners.put("region", new TableInfo.Column("region", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNgoPartners = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNgoPartners = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNgoPartners = new TableInfo("ngo_partners", _columnsNgoPartners, _foreignKeysNgoPartners, _indicesNgoPartners);
        final TableInfo _existingNgoPartners = TableInfo.read(db, "ngo_partners");
        if (!_infoNgoPartners.equals(_existingNgoPartners)) {
          return new RoomOpenHelper.ValidationResult(false, "ngo_partners(com.makertest.app.data.models.NGOPartner).\n"
                  + " Expected:\n" + _infoNgoPartners + "\n"
                  + " Found:\n" + _existingNgoPartners);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "271bc885215335db7a8211bd3717123b", "a471e3e808e3f5c57e08e17e56aab594");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "soil_tests","user_profiles","FarmField","knowledge_articles","ngo_partners");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `soil_tests`");
      _db.execSQL("DELETE FROM `user_profiles`");
      _db.execSQL("DELETE FROM `FarmField`");
      _db.execSQL("DELETE FROM `knowledge_articles`");
      _db.execSQL("DELETE FROM `ngo_partners`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SoilTestDao.class, SoilTestDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserProfileDao.class, UserProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FarmFieldDao.class, FarmFieldDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(KnowledgeArticleDao.class, KnowledgeArticleDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NGOPartnerDao.class, NGOPartnerDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public SoilTestDao soilTestDao() {
    if (_soilTestDao != null) {
      return _soilTestDao;
    } else {
      synchronized(this) {
        if(_soilTestDao == null) {
          _soilTestDao = new SoilTestDao_Impl(this);
        }
        return _soilTestDao;
      }
    }
  }

  @Override
  public UserProfileDao userProfileDao() {
    if (_userProfileDao != null) {
      return _userProfileDao;
    } else {
      synchronized(this) {
        if(_userProfileDao == null) {
          _userProfileDao = new UserProfileDao_Impl(this);
        }
        return _userProfileDao;
      }
    }
  }

  @Override
  public FarmFieldDao farmFieldDao() {
    if (_farmFieldDao != null) {
      return _farmFieldDao;
    } else {
      synchronized(this) {
        if(_farmFieldDao == null) {
          _farmFieldDao = new FarmFieldDao_Impl(this);
        }
        return _farmFieldDao;
      }
    }
  }

  @Override
  public KnowledgeArticleDao knowledgeArticleDao() {
    if (_knowledgeArticleDao != null) {
      return _knowledgeArticleDao;
    } else {
      synchronized(this) {
        if(_knowledgeArticleDao == null) {
          _knowledgeArticleDao = new KnowledgeArticleDao_Impl(this);
        }
        return _knowledgeArticleDao;
      }
    }
  }

  @Override
  public NGOPartnerDao ngoPartnerDao() {
    if (_nGOPartnerDao != null) {
      return _nGOPartnerDao;
    } else {
      synchronized(this) {
        if(_nGOPartnerDao == null) {
          _nGOPartnerDao = new NGOPartnerDao_Impl(this);
        }
        return _nGOPartnerDao;
      }
    }
  }
}
