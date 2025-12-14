package com.makertest.app.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\bH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u000bH\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u000200H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017\u00a8\u00061"}, d2 = {"Lcom/makertest/app/data/models/SoilTestResult;", "", "ph", "", "phStatus", "Lcom/makertest/app/data/models/PHStatus;", "moisture", "moistureStatus", "Lcom/makertest/app/data/models/MoistureStatus;", "nitrogen", "nitrogenStatus", "Lcom/makertest/app/data/models/NutrientStatus;", "phosphorus", "phosphorusStatus", "potassium", "potassiumStatus", "(FLcom/makertest/app/data/models/PHStatus;FLcom/makertest/app/data/models/MoistureStatus;FLcom/makertest/app/data/models/NutrientStatus;FLcom/makertest/app/data/models/NutrientStatus;FLcom/makertest/app/data/models/NutrientStatus;)V", "getMoisture", "()F", "getMoistureStatus", "()Lcom/makertest/app/data/models/MoistureStatus;", "getNitrogen", "getNitrogenStatus", "()Lcom/makertest/app/data/models/NutrientStatus;", "getPh", "getPhStatus", "()Lcom/makertest/app/data/models/PHStatus;", "getPhosphorus", "getPhosphorusStatus", "getPotassium", "getPotassiumStatus", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class SoilTestResult {
    private final float ph = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.models.PHStatus phStatus = null;
    private final float moisture = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.models.MoistureStatus moistureStatus = null;
    private final float nitrogen = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.models.NutrientStatus nitrogenStatus = null;
    private final float phosphorus = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.models.NutrientStatus phosphorusStatus = null;
    private final float potassium = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final com.makertest.app.data.models.NutrientStatus potassiumStatus = null;
    
    public SoilTestResult(float ph, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.PHStatus phStatus, float moisture, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.MoistureStatus moistureStatus, float nitrogen, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NutrientStatus nitrogenStatus, float phosphorus, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NutrientStatus phosphorusStatus, float potassium, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NutrientStatus potassiumStatus) {
        super();
    }
    
    public final float getPh() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.PHStatus getPhStatus() {
        return null;
    }
    
    public final float getMoisture() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.MoistureStatus getMoistureStatus() {
        return null;
    }
    
    public final float getNitrogen() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.NutrientStatus getNitrogenStatus() {
        return null;
    }
    
    public final float getPhosphorus() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.NutrientStatus getPhosphorusStatus() {
        return null;
    }
    
    public final float getPotassium() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.NutrientStatus getPotassiumStatus() {
        return null;
    }
    
    public final float component1() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.NutrientStatus component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.PHStatus component2() {
        return null;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.MoistureStatus component4() {
        return null;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.NutrientStatus component6() {
        return null;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.NutrientStatus component8() {
        return null;
    }
    
    public final float component9() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.makertest.app.data.models.SoilTestResult copy(float ph, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.PHStatus phStatus, float moisture, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.MoistureStatus moistureStatus, float nitrogen, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NutrientStatus nitrogenStatus, float phosphorus, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NutrientStatus phosphorusStatus, float potassium, @org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.NutrientStatus potassiumStatus) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}