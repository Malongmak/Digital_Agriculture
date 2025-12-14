package com.makertest.app.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\b\u0010\t\u001a(\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0002\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0016H\u0002\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u0017\u001a\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u0016H\u0002\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"MetricIndicator", "", "label", "", "value", "status", "color", "Landroidx/compose/ui/graphics/Color;", "MetricIndicator-g2O1Hgs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "SoilTestHistoryCard", "test", "Lcom/makertest/app/data/models/SoilTestData;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "formatDate", "timestamp", "", "getMoistureColor", "moisture", "", "(F)J", "getMoistureStatus", "Lcom/makertest/app/data/models/MoistureStatus;", "getNPKColor", "nitrogen", "phosphorus", "potassium", "(FFF)J", "getPHColor", "ph", "getPHStatus", "Lcom/makertest/app/data/models/PHStatus;", "app_debug"})
public final class SoilTestHistoryCardKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void SoilTestHistoryCard(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.SoilTestData test, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final java.lang.String formatDate(long timestamp) {
        return null;
    }
    
    private static final com.makertest.app.data.models.PHStatus getPHStatus(float ph) {
        return null;
    }
    
    private static final com.makertest.app.data.models.MoistureStatus getMoistureStatus(float moisture) {
        return null;
    }
    
    private static final long getPHColor(float ph) {
        return 0L;
    }
    
    private static final long getMoistureColor(float moisture) {
        return 0L;
    }
    
    private static final long getNPKColor(float nitrogen, float phosphorus, float potassium) {
        return 0L;
    }
}