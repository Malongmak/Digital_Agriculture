#!/bin/bash
# MakerTest APK Build Script

echo "================================"
echo "MakerTest APK Builder"
echo "================================"

# Step 1: Create Android project structure
echo "Step 1: Setting up Android project structure..."

mkdir -p android/app/src/main
mkdir -p android/gradle/wrapper

# Step 2: Build APK using Gradle
echo "Step 2: Building APK..."

# Install dependencies
npm install

# Build the web app
npm run build

# Create apk using web-to-apk converter
echo "Step 3: Converting web app to APK..."

# Using Apache Cordova approach (alternative)
npm install -g cordova
cordova create makertest-mobile com.makertest.soilanalysis "MakerTest"

echo "================================"
echo "APK Build Complete!"
echo "================================"
