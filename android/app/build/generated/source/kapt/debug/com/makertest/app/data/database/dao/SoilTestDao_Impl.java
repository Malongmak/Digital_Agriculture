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
import com.makertest.app.data.models.SoilTestData;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class SoilTestDao_Impl implements SoilTestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SoilTestData> __insertionAdapterOfSoilTestData;

  private final EntityDeletionOrUpdateAdapter<SoilTestData> __deletionAdapterOfSoilTestData;

  private final EntityDeletionOrUpdateAdapter<SoilTestData> __updateAdapterOfSoilTestData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTestById;

  public SoilTestDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSoilTestData = new EntityInsertionAdapter<SoilTestData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `soil_tests` (`id`,`fieldId`,`timestamp`,`ph`,`moisture`,`nitrogen`,`phosphorus`,`potassium`,`deviceId`,`location`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SoilTestData entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getFieldId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFieldId());
        }
        statement.bindLong(3, entity.getTimestamp());
        statement.bindDouble(4, entity.getPh());
        statement.bindDouble(5, entity.getMoisture());
        statement.bindDouble(6, entity.getNitrogen());
        statement.bindDouble(7, entity.getPhosphorus());
        statement.bindDouble(8, entity.getPotassium());
        if (entity.getDeviceId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDeviceId());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLocation());
        }
      }
    };
    this.__deletionAdapterOfSoilTestData = new EntityDeletionOrUpdateAdapter<SoilTestData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `soil_tests` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SoilTestData entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfSoilTestData = new EntityDeletionOrUpdateAdapter<SoilTestData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `soil_tests` SET `id` = ?,`fieldId` = ?,`timestamp` = ?,`ph` = ?,`moisture` = ?,`nitrogen` = ?,`phosphorus` = ?,`potassium` = ?,`deviceId` = ?,`location` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SoilTestData entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getFieldId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFieldId());
        }
        statement.bindLong(3, entity.getTimestamp());
        statement.bindDouble(4, entity.getPh());
        statement.bindDouble(5, entity.getMoisture());
        statement.bindDouble(6, entity.getNitrogen());
        statement.bindDouble(7, entity.getPhosphorus());
        statement.bindDouble(8, entity.getPotassium());
        if (entity.getDeviceId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDeviceId());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLocation());
        }
        statement.bindLong(11, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteTestById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM soil_tests WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertTest(final SoilTestData test, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfSoilTestData.insertAndReturnId(test);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTest(final SoilTestData test, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSoilTestData.handle(test);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTest(final SoilTestData test, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSoilTestData.handle(test);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTestById(final long testId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTestById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, testId);
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
          __preparedStmtOfDeleteTestById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SoilTestData>> getAllTests() {
    final String _sql = "SELECT * FROM soil_tests ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"soil_tests"}, new Callable<List<SoilTestData>>() {
      @Override
      @NonNull
      public List<SoilTestData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFieldId = CursorUtil.getColumnIndexOrThrow(_cursor, "fieldId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfPh = CursorUtil.getColumnIndexOrThrow(_cursor, "ph");
          final int _cursorIndexOfMoisture = CursorUtil.getColumnIndexOrThrow(_cursor, "moisture");
          final int _cursorIndexOfNitrogen = CursorUtil.getColumnIndexOrThrow(_cursor, "nitrogen");
          final int _cursorIndexOfPhosphorus = CursorUtil.getColumnIndexOrThrow(_cursor, "phosphorus");
          final int _cursorIndexOfPotassium = CursorUtil.getColumnIndexOrThrow(_cursor, "potassium");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final List<SoilTestData> _result = new ArrayList<SoilTestData>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SoilTestData _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFieldId;
            if (_cursor.isNull(_cursorIndexOfFieldId)) {
              _tmpFieldId = null;
            } else {
              _tmpFieldId = _cursor.getString(_cursorIndexOfFieldId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpPh;
            _tmpPh = _cursor.getFloat(_cursorIndexOfPh);
            final float _tmpMoisture;
            _tmpMoisture = _cursor.getFloat(_cursorIndexOfMoisture);
            final float _tmpNitrogen;
            _tmpNitrogen = _cursor.getFloat(_cursorIndexOfNitrogen);
            final float _tmpPhosphorus;
            _tmpPhosphorus = _cursor.getFloat(_cursorIndexOfPhosphorus);
            final float _tmpPotassium;
            _tmpPotassium = _cursor.getFloat(_cursorIndexOfPotassium);
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item = new SoilTestData(_tmpId,_tmpFieldId,_tmpTimestamp,_tmpPh,_tmpMoisture,_tmpNitrogen,_tmpPhosphorus,_tmpPotassium,_tmpDeviceId,_tmpLocation);
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
  public Flow<List<SoilTestData>> getTestsByField(final String fieldId) {
    final String _sql = "SELECT * FROM soil_tests WHERE fieldId = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fieldId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fieldId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"soil_tests"}, new Callable<List<SoilTestData>>() {
      @Override
      @NonNull
      public List<SoilTestData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFieldId = CursorUtil.getColumnIndexOrThrow(_cursor, "fieldId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfPh = CursorUtil.getColumnIndexOrThrow(_cursor, "ph");
          final int _cursorIndexOfMoisture = CursorUtil.getColumnIndexOrThrow(_cursor, "moisture");
          final int _cursorIndexOfNitrogen = CursorUtil.getColumnIndexOrThrow(_cursor, "nitrogen");
          final int _cursorIndexOfPhosphorus = CursorUtil.getColumnIndexOrThrow(_cursor, "phosphorus");
          final int _cursorIndexOfPotassium = CursorUtil.getColumnIndexOrThrow(_cursor, "potassium");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final List<SoilTestData> _result = new ArrayList<SoilTestData>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SoilTestData _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFieldId;
            if (_cursor.isNull(_cursorIndexOfFieldId)) {
              _tmpFieldId = null;
            } else {
              _tmpFieldId = _cursor.getString(_cursorIndexOfFieldId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpPh;
            _tmpPh = _cursor.getFloat(_cursorIndexOfPh);
            final float _tmpMoisture;
            _tmpMoisture = _cursor.getFloat(_cursorIndexOfMoisture);
            final float _tmpNitrogen;
            _tmpNitrogen = _cursor.getFloat(_cursorIndexOfNitrogen);
            final float _tmpPhosphorus;
            _tmpPhosphorus = _cursor.getFloat(_cursorIndexOfPhosphorus);
            final float _tmpPotassium;
            _tmpPotassium = _cursor.getFloat(_cursorIndexOfPotassium);
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item = new SoilTestData(_tmpId,_tmpFieldId,_tmpTimestamp,_tmpPh,_tmpMoisture,_tmpNitrogen,_tmpPhosphorus,_tmpPotassium,_tmpDeviceId,_tmpLocation);
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
  public Object getTestById(final long testId,
      final Continuation<? super SoilTestData> $completion) {
    final String _sql = "SELECT * FROM soil_tests WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, testId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SoilTestData>() {
      @Override
      @Nullable
      public SoilTestData call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFieldId = CursorUtil.getColumnIndexOrThrow(_cursor, "fieldId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfPh = CursorUtil.getColumnIndexOrThrow(_cursor, "ph");
          final int _cursorIndexOfMoisture = CursorUtil.getColumnIndexOrThrow(_cursor, "moisture");
          final int _cursorIndexOfNitrogen = CursorUtil.getColumnIndexOrThrow(_cursor, "nitrogen");
          final int _cursorIndexOfPhosphorus = CursorUtil.getColumnIndexOrThrow(_cursor, "phosphorus");
          final int _cursorIndexOfPotassium = CursorUtil.getColumnIndexOrThrow(_cursor, "potassium");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final SoilTestData _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFieldId;
            if (_cursor.isNull(_cursorIndexOfFieldId)) {
              _tmpFieldId = null;
            } else {
              _tmpFieldId = _cursor.getString(_cursorIndexOfFieldId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpPh;
            _tmpPh = _cursor.getFloat(_cursorIndexOfPh);
            final float _tmpMoisture;
            _tmpMoisture = _cursor.getFloat(_cursorIndexOfMoisture);
            final float _tmpNitrogen;
            _tmpNitrogen = _cursor.getFloat(_cursorIndexOfNitrogen);
            final float _tmpPhosphorus;
            _tmpPhosphorus = _cursor.getFloat(_cursorIndexOfPhosphorus);
            final float _tmpPotassium;
            _tmpPotassium = _cursor.getFloat(_cursorIndexOfPotassium);
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _result = new SoilTestData(_tmpId,_tmpFieldId,_tmpTimestamp,_tmpPh,_tmpMoisture,_tmpNitrogen,_tmpPhosphorus,_tmpPotassium,_tmpDeviceId,_tmpLocation);
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
  public Object getTestCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM soil_tests";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
