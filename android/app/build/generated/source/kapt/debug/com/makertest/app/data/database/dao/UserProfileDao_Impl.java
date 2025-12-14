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
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.makertest.app.data.models.UserProfile;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserProfileDao_Impl implements UserProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserProfile> __insertionAdapterOfUserProfile;

  private final EntityDeletionOrUpdateAdapter<UserProfile> __deletionAdapterOfUserProfile;

  private final EntityDeletionOrUpdateAdapter<UserProfile> __updateAdapterOfUserProfile;

  public UserProfileDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserProfile = new EntityInsertionAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_profiles` (`userId`,`name`,`email`,`phone`,`location`,`memberSince`,`totalTests`,`fieldCount`,`yieldImprovement`,`preferredLanguage`,`isNGOMember`,`ngoName`,`profileImage`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocation());
        }
        statement.bindLong(6, entity.getMemberSince());
        statement.bindLong(7, entity.getTotalTests());
        statement.bindLong(8, entity.getFieldCount());
        statement.bindLong(9, entity.getYieldImprovement());
        if (entity.getPreferredLanguage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPreferredLanguage());
        }
        final int _tmp = entity.isNGOMember() ? 1 : 0;
        statement.bindLong(11, _tmp);
        if (entity.getNgoName() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNgoName());
        }
        if (entity.getProfileImage() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getProfileImage());
        }
        statement.bindLong(14, entity.getCreatedAt());
        statement.bindLong(15, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfUserProfile = new EntityDeletionOrUpdateAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `user_profiles` WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
      }
    };
    this.__updateAdapterOfUserProfile = new EntityDeletionOrUpdateAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_profiles` SET `userId` = ?,`name` = ?,`email` = ?,`phone` = ?,`location` = ?,`memberSince` = ?,`totalTests` = ?,`fieldCount` = ?,`yieldImprovement` = ?,`preferredLanguage` = ?,`isNGOMember` = ?,`ngoName` = ?,`profileImage` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocation());
        }
        statement.bindLong(6, entity.getMemberSince());
        statement.bindLong(7, entity.getTotalTests());
        statement.bindLong(8, entity.getFieldCount());
        statement.bindLong(9, entity.getYieldImprovement());
        if (entity.getPreferredLanguage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPreferredLanguage());
        }
        final int _tmp = entity.isNGOMember() ? 1 : 0;
        statement.bindLong(11, _tmp);
        if (entity.getNgoName() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNgoName());
        }
        if (entity.getProfileImage() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getProfileImage());
        }
        statement.bindLong(14, entity.getCreatedAt());
        statement.bindLong(15, entity.getUpdatedAt());
        if (entity.getUserId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getUserId());
        }
      }
    };
  }

  @Override
  public Object insertUser(final UserProfile user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserProfile.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final UserProfile user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserProfile.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final UserProfile user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserProfile.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserById(final String userId,
      final Continuation<? super UserProfile> $completion) {
    final String _sql = "SELECT * FROM user_profiles WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserProfile>() {
      @Override
      @Nullable
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfMemberSince = CursorUtil.getColumnIndexOrThrow(_cursor, "memberSince");
          final int _cursorIndexOfTotalTests = CursorUtil.getColumnIndexOrThrow(_cursor, "totalTests");
          final int _cursorIndexOfFieldCount = CursorUtil.getColumnIndexOrThrow(_cursor, "fieldCount");
          final int _cursorIndexOfYieldImprovement = CursorUtil.getColumnIndexOrThrow(_cursor, "yieldImprovement");
          final int _cursorIndexOfPreferredLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredLanguage");
          final int _cursorIndexOfIsNGOMember = CursorUtil.getColumnIndexOrThrow(_cursor, "isNGOMember");
          final int _cursorIndexOfNgoName = CursorUtil.getColumnIndexOrThrow(_cursor, "ngoName");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final UserProfile _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final int _tmpMemberSince;
            _tmpMemberSince = _cursor.getInt(_cursorIndexOfMemberSince);
            final int _tmpTotalTests;
            _tmpTotalTests = _cursor.getInt(_cursorIndexOfTotalTests);
            final int _tmpFieldCount;
            _tmpFieldCount = _cursor.getInt(_cursorIndexOfFieldCount);
            final int _tmpYieldImprovement;
            _tmpYieldImprovement = _cursor.getInt(_cursorIndexOfYieldImprovement);
            final String _tmpPreferredLanguage;
            if (_cursor.isNull(_cursorIndexOfPreferredLanguage)) {
              _tmpPreferredLanguage = null;
            } else {
              _tmpPreferredLanguage = _cursor.getString(_cursorIndexOfPreferredLanguage);
            }
            final boolean _tmpIsNGOMember;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNGOMember);
            _tmpIsNGOMember = _tmp != 0;
            final String _tmpNgoName;
            if (_cursor.isNull(_cursorIndexOfNgoName)) {
              _tmpNgoName = null;
            } else {
              _tmpNgoName = _cursor.getString(_cursorIndexOfNgoName);
            }
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new UserProfile(_tmpUserId,_tmpName,_tmpEmail,_tmpPhone,_tmpLocation,_tmpMemberSince,_tmpTotalTests,_tmpFieldCount,_tmpYieldImprovement,_tmpPreferredLanguage,_tmpIsNGOMember,_tmpNgoName,_tmpProfileImage,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<UserProfile> observeUser(final String userId) {
    final String _sql = "SELECT * FROM user_profiles WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"user_profiles"}, new Callable<UserProfile>() {
      @Override
      @Nullable
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfMemberSince = CursorUtil.getColumnIndexOrThrow(_cursor, "memberSince");
          final int _cursorIndexOfTotalTests = CursorUtil.getColumnIndexOrThrow(_cursor, "totalTests");
          final int _cursorIndexOfFieldCount = CursorUtil.getColumnIndexOrThrow(_cursor, "fieldCount");
          final int _cursorIndexOfYieldImprovement = CursorUtil.getColumnIndexOrThrow(_cursor, "yieldImprovement");
          final int _cursorIndexOfPreferredLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredLanguage");
          final int _cursorIndexOfIsNGOMember = CursorUtil.getColumnIndexOrThrow(_cursor, "isNGOMember");
          final int _cursorIndexOfNgoName = CursorUtil.getColumnIndexOrThrow(_cursor, "ngoName");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final UserProfile _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final int _tmpMemberSince;
            _tmpMemberSince = _cursor.getInt(_cursorIndexOfMemberSince);
            final int _tmpTotalTests;
            _tmpTotalTests = _cursor.getInt(_cursorIndexOfTotalTests);
            final int _tmpFieldCount;
            _tmpFieldCount = _cursor.getInt(_cursorIndexOfFieldCount);
            final int _tmpYieldImprovement;
            _tmpYieldImprovement = _cursor.getInt(_cursorIndexOfYieldImprovement);
            final String _tmpPreferredLanguage;
            if (_cursor.isNull(_cursorIndexOfPreferredLanguage)) {
              _tmpPreferredLanguage = null;
            } else {
              _tmpPreferredLanguage = _cursor.getString(_cursorIndexOfPreferredLanguage);
            }
            final boolean _tmpIsNGOMember;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNGOMember);
            _tmpIsNGOMember = _tmp != 0;
            final String _tmpNgoName;
            if (_cursor.isNull(_cursorIndexOfNgoName)) {
              _tmpNgoName = null;
            } else {
              _tmpNgoName = _cursor.getString(_cursorIndexOfNgoName);
            }
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new UserProfile(_tmpUserId,_tmpName,_tmpEmail,_tmpPhone,_tmpLocation,_tmpMemberSince,_tmpTotalTests,_tmpFieldCount,_tmpYieldImprovement,_tmpPreferredLanguage,_tmpIsNGOMember,_tmpNgoName,_tmpProfileImage,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
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
