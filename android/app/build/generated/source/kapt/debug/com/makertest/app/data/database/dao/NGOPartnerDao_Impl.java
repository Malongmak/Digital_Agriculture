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
import com.makertest.app.data.models.NGOPartner;
import com.makertest.app.data.models.NGOService;
import java.lang.Class;
import java.lang.Exception;
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
public final class NGOPartnerDao_Impl implements NGOPartnerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NGOPartner> __insertionAdapterOfNGOPartner;

  private final RoomConverters __roomConverters = new RoomConverters();

  private final EntityDeletionOrUpdateAdapter<NGOPartner> __deletionAdapterOfNGOPartner;

  private final EntityDeletionOrUpdateAdapter<NGOPartner> __updateAdapterOfNGOPartner;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNGOById;

  public NGOPartnerDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNGOPartner = new EntityInsertionAdapter<NGOPartner>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ngo_partners` (`id`,`name`,`description`,`contactPerson`,`phone`,`email`,`location`,`services`,`website`,`logoUrl`,`isActive`,`establishedYear`,`region`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NGOPartner entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getContactPerson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContactPerson());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEmail());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getLocation());
        }
        final String _tmp = __roomConverters.fromNGOServiceList(entity.getServices());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp);
        }
        if (entity.getWebsite() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getWebsite());
        }
        if (entity.getLogoUrl() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLogoUrl());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindLong(12, entity.getEstablishedYear());
        if (entity.getRegion() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getRegion());
        }
      }
    };
    this.__deletionAdapterOfNGOPartner = new EntityDeletionOrUpdateAdapter<NGOPartner>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `ngo_partners` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NGOPartner entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfNGOPartner = new EntityDeletionOrUpdateAdapter<NGOPartner>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `ngo_partners` SET `id` = ?,`name` = ?,`description` = ?,`contactPerson` = ?,`phone` = ?,`email` = ?,`location` = ?,`services` = ?,`website` = ?,`logoUrl` = ?,`isActive` = ?,`establishedYear` = ?,`region` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NGOPartner entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getContactPerson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContactPerson());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEmail());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getLocation());
        }
        final String _tmp = __roomConverters.fromNGOServiceList(entity.getServices());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp);
        }
        if (entity.getWebsite() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getWebsite());
        }
        if (entity.getLogoUrl() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLogoUrl());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindLong(12, entity.getEstablishedYear());
        if (entity.getRegion() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getRegion());
        }
        statement.bindLong(14, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteNGOById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ngo_partners WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertNGO(final NGOPartner ngo, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfNGOPartner.insertAndReturnId(ngo);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertNGOs(final List<NGOPartner> ngos,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNGOPartner.insert(ngos);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNGO(final NGOPartner ngo, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNGOPartner.handle(ngo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNGO(final NGOPartner ngo, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNGOPartner.handle(ngo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNGOById(final long ngoId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNGOById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, ngoId);
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
          __preparedStmtOfDeleteNGOById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<NGOPartner>> getAllActiveNGOs() {
    final String _sql = "SELECT * FROM ngo_partners WHERE isActive = 1 ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ngo_partners"}, new Callable<List<NGOPartner>>() {
      @Override
      @NonNull
      public List<NGOPartner> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfServices = CursorUtil.getColumnIndexOrThrow(_cursor, "services");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfLogoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "logoUrl");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEstablishedYear = CursorUtil.getColumnIndexOrThrow(_cursor, "establishedYear");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final List<NGOPartner> _result = new ArrayList<NGOPartner>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NGOPartner _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<NGOService> _tmpServices;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfServices)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfServices);
            }
            _tmpServices = __roomConverters.toNGOServiceList(_tmp);
            final String _tmpWebsite;
            if (_cursor.isNull(_cursorIndexOfWebsite)) {
              _tmpWebsite = null;
            } else {
              _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            }
            final String _tmpLogoUrl;
            if (_cursor.isNull(_cursorIndexOfLogoUrl)) {
              _tmpLogoUrl = null;
            } else {
              _tmpLogoUrl = _cursor.getString(_cursorIndexOfLogoUrl);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final int _tmpEstablishedYear;
            _tmpEstablishedYear = _cursor.getInt(_cursorIndexOfEstablishedYear);
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            _item = new NGOPartner(_tmpId,_tmpName,_tmpDescription,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpLocation,_tmpServices,_tmpWebsite,_tmpLogoUrl,_tmpIsActive,_tmpEstablishedYear,_tmpRegion);
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
  public Flow<List<NGOPartner>> getAllNGOs() {
    final String _sql = "SELECT * FROM ngo_partners ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ngo_partners"}, new Callable<List<NGOPartner>>() {
      @Override
      @NonNull
      public List<NGOPartner> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfServices = CursorUtil.getColumnIndexOrThrow(_cursor, "services");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfLogoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "logoUrl");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEstablishedYear = CursorUtil.getColumnIndexOrThrow(_cursor, "establishedYear");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final List<NGOPartner> _result = new ArrayList<NGOPartner>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NGOPartner _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<NGOService> _tmpServices;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfServices)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfServices);
            }
            _tmpServices = __roomConverters.toNGOServiceList(_tmp);
            final String _tmpWebsite;
            if (_cursor.isNull(_cursorIndexOfWebsite)) {
              _tmpWebsite = null;
            } else {
              _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            }
            final String _tmpLogoUrl;
            if (_cursor.isNull(_cursorIndexOfLogoUrl)) {
              _tmpLogoUrl = null;
            } else {
              _tmpLogoUrl = _cursor.getString(_cursorIndexOfLogoUrl);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final int _tmpEstablishedYear;
            _tmpEstablishedYear = _cursor.getInt(_cursorIndexOfEstablishedYear);
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            _item = new NGOPartner(_tmpId,_tmpName,_tmpDescription,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpLocation,_tmpServices,_tmpWebsite,_tmpLogoUrl,_tmpIsActive,_tmpEstablishedYear,_tmpRegion);
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
  public Object getNGOById(final long ngoId, final Continuation<? super NGOPartner> $completion) {
    final String _sql = "SELECT * FROM ngo_partners WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, ngoId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<NGOPartner>() {
      @Override
      @Nullable
      public NGOPartner call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfServices = CursorUtil.getColumnIndexOrThrow(_cursor, "services");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfLogoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "logoUrl");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEstablishedYear = CursorUtil.getColumnIndexOrThrow(_cursor, "establishedYear");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final NGOPartner _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<NGOService> _tmpServices;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfServices)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfServices);
            }
            _tmpServices = __roomConverters.toNGOServiceList(_tmp);
            final String _tmpWebsite;
            if (_cursor.isNull(_cursorIndexOfWebsite)) {
              _tmpWebsite = null;
            } else {
              _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            }
            final String _tmpLogoUrl;
            if (_cursor.isNull(_cursorIndexOfLogoUrl)) {
              _tmpLogoUrl = null;
            } else {
              _tmpLogoUrl = _cursor.getString(_cursorIndexOfLogoUrl);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final int _tmpEstablishedYear;
            _tmpEstablishedYear = _cursor.getInt(_cursorIndexOfEstablishedYear);
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            _result = new NGOPartner(_tmpId,_tmpName,_tmpDescription,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpLocation,_tmpServices,_tmpWebsite,_tmpLogoUrl,_tmpIsActive,_tmpEstablishedYear,_tmpRegion);
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
  public Flow<List<NGOPartner>> getNGOsByLocation(final String location) {
    final String _sql = "SELECT * FROM ngo_partners WHERE location LIKE '%' || ? || '%' AND isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (location == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, location);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ngo_partners"}, new Callable<List<NGOPartner>>() {
      @Override
      @NonNull
      public List<NGOPartner> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfServices = CursorUtil.getColumnIndexOrThrow(_cursor, "services");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfLogoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "logoUrl");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEstablishedYear = CursorUtil.getColumnIndexOrThrow(_cursor, "establishedYear");
          final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
          final List<NGOPartner> _result = new ArrayList<NGOPartner>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NGOPartner _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final List<NGOService> _tmpServices;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfServices)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfServices);
            }
            _tmpServices = __roomConverters.toNGOServiceList(_tmp);
            final String _tmpWebsite;
            if (_cursor.isNull(_cursorIndexOfWebsite)) {
              _tmpWebsite = null;
            } else {
              _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            }
            final String _tmpLogoUrl;
            if (_cursor.isNull(_cursorIndexOfLogoUrl)) {
              _tmpLogoUrl = null;
            } else {
              _tmpLogoUrl = _cursor.getString(_cursorIndexOfLogoUrl);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final int _tmpEstablishedYear;
            _tmpEstablishedYear = _cursor.getInt(_cursorIndexOfEstablishedYear);
            final String _tmpRegion;
            if (_cursor.isNull(_cursorIndexOfRegion)) {
              _tmpRegion = null;
            } else {
              _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
            }
            _item = new NGOPartner(_tmpId,_tmpName,_tmpDescription,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpLocation,_tmpServices,_tmpWebsite,_tmpLogoUrl,_tmpIsActive,_tmpEstablishedYear,_tmpRegion);
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
}
