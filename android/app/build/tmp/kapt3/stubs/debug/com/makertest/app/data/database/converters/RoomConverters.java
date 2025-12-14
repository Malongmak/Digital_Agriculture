package com.makertest.app.data.database.converters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/makertest/app/data/database/converters/RoomConverters;", "", "()V", "fromNGOServiceList", "", "value", "", "Lcom/makertest/app/data/models/NGOService;", "fromStringList", "toNGOServiceList", "toStringList", "app_debug"})
public final class RoomConverters {
    
    public RoomConverters() {
        super();
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromStringList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> toStringList(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromNGOServiceList(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.makertest.app.data.models.NGOService> value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.makertest.app.data.models.NGOService> toNGOServiceList(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
}