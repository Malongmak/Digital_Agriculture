package com.makertest.app.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a5\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u001e\u001a\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010#\u001a\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0002\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\'\u001a\u0010\u0010(\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0002\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"ForecastCard", "", "forecast", "Lcom/makertest/app/data/models/DailyForecast;", "modifier", "Landroidx/compose/ui/Modifier;", "WeatherAlertCard", "alert", "Lcom/makertest/app/data/models/WeatherAlert;", "WeatherCard", "current", "Lcom/makertest/app/data/models/CurrentWeather;", "location", "", "WeatherDetailItem", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "value", "color", "Landroidx/compose/ui/graphics/Color;", "WeatherDetailItem-g2O1Hgs", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Ljava/lang/String;J)V", "formatAlertTime", "startTime", "", "endTime", "getAlertColor", "severity", "Lcom/makertest/app/data/models/AlertSeverity;", "(Lcom/makertest/app/data/models/AlertSeverity;)J", "getAlertIcon", "getUVColor", "uvIndex", "", "(F)J", "getWeatherColor", "condition", "Lcom/makertest/app/data/models/WeatherCondition;", "(Lcom/makertest/app/data/models/WeatherCondition;)J", "getWeatherIcon", "app_debug"})
public final class WeatherCardKt {
    
    @androidx.compose.runtime.Composable
    public static final void WeatherCard(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.CurrentWeather current, @org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ForecastCard(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.DailyForecast forecast, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void WeatherAlertCard(@org.jetbrains.annotations.NotNull
    com.makertest.app.data.models.WeatherAlert alert, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final androidx.compose.ui.graphics.vector.ImageVector getWeatherIcon(com.makertest.app.data.models.WeatherCondition condition) {
        return null;
    }
    
    private static final long getWeatherColor(com.makertest.app.data.models.WeatherCondition condition) {
        return 0L;
    }
    
    private static final long getUVColor(float uvIndex) {
        return 0L;
    }
    
    private static final androidx.compose.ui.graphics.vector.ImageVector getAlertIcon(com.makertest.app.data.models.AlertSeverity severity) {
        return null;
    }
    
    private static final long getAlertColor(com.makertest.app.data.models.AlertSeverity severity) {
        return 0L;
    }
    
    private static final java.lang.String formatAlertTime(long startTime, long endTime) {
        return null;
    }
}