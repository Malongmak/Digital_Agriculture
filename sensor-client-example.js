// Real Farm Sensor Client Example
// This demonstrates how actual sensor hardware would connect to the API

const http = require('http');

class FarmSensorClient {
    constructor(sensorId, sensorName, sensorType, location) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.location = location;
        this.apiBaseUrl = 'http://localhost:3003';
    }

    // Register the sensor with the API
    async registerSensor() {
        const sensorData = {
            sensor_id: this.sensorId,
            name: this.sensorName,
            type: this.sensorType,
            location: this.location,
            latitude: 4.85,
            longitude: 31.60
        };

        return this.makeRequest('/api/sensors', 'POST', sensorData);
    }

    // Send single reading
    async sendReading(type, value, unit) {
        const readingData = {
            type: type,
            value: value,
            unit: unit
        };

        return this.makeRequest(`/api/sensors/${this.sensorId}/reading`, 'POST', readingData);
    }

    // Send multiple readings at once
    async sendReadings(readings) {
        const readingData = {
            readings: readings,
            timestamp: new Date().toISOString()
        };

        return this.makeRequest(`/api/sensors/${this.sensorId}/data`, 'POST', readingData);
    }

    // Make HTTP request to API
    makeRequest(endpoint, method, data) {
        return new Promise((resolve, reject) => {
            const postData = JSON.stringify(data);
            const options = {
                hostname: 'localhost',
                port: 3003,
                path: endpoint,
                method: method,
                headers: {
                    'Content-Type': 'application/json',
                    'Content-Length': Buffer.byteLength(postData)
                }
            };

            const req = http.request(options, (res) => {
                let responseData = '';
                
                res.on('data', (chunk) => {
                    responseData += chunk;
                });
                
                res.on('end', () => {
                    try {
                        const jsonResponse = JSON.parse(responseData);
                        if (res.statusCode >= 200 && res.statusCode < 300) {
                            resolve(jsonResponse);
                        } else {
                            reject(new Error(`HTTP ${res.statusCode}: ${jsonResponse.error || 'Unknown error'}`));
                        }
                    } catch (error) {
                        reject(new Error(`Invalid response: ${responseData}`));
                    }
                });
            });

            req.on('error', (error) => {
                reject(error);
            });

            req.write(postData);
            req.end();
        });
    }
}

// Example: Soil Monitor Sensor
class SoilMonitorSensor extends FarmSensorClient {
    constructor(sensorId, location) {
        super(sensorId, 'Soil Monitor Sensor', 'soil_monitor', location);
        this.readingInterval = null;
    }

    // Start monitoring soil conditions
    startMonitoring(intervalSeconds = 30) {
        console.log(`Starting soil monitoring for sensor ${this.sensorId}`);
        
        // Register sensor first
        this.registerSensor()
            .then(() => {
                console.log('Sensor registered successfully');
                
                // Start periodic readings
                this.readingInterval = setInterval(() => {
                    this.collectSoilData();
                }, intervalSeconds * 1000);
                
                // Send initial reading
                this.collectSoilData();
            })
            .catch(error => {
                console.error('Failed to register sensor:', error.message);
            });
    }

    // Collect and send soil data (replace with actual sensor readings)
    collectSoilData() {
        // In real implementation, these would come from actual hardware sensors
        const soilMoisture = this.readSoilMoisture(); // % moisture
        const soilTemperature = this.readSoilTemperature(); // °C
        const soilPh = this.readSoilPh(); // pH level
        const nitrogen = this.readNitrogen(); // mg/kg
        const phosphorus = this.readPhosphorus(); // mg/kg
        const potassium = this.readPotassium(); // mg/kg

        const readings = [
            { type: 'soil_moisture', value: soilMoisture, unit: '%' },
            { type: 'soil_temperature', value: soilTemperature, unit: '°C' },
            { type: 'soil_ph', value: soilPh, unit: 'pH' },
            { type: 'nitrogen', value: nitrogen, unit: 'mg/kg' },
            { type: 'phosphorus', value: phosphorus, unit: 'mg/kg' },
            { type: 'potassium', value: potassium, unit: 'mg/kg' }
        ];

        this.sendReadings(readings)
            .then(response => {
                console.log(`[${new Date().toISOString()}] Soil data sent:`, response.message);
            })
            .catch(error => {
                console.error('Failed to send soil data:', error.message);
            });
    }

    // Replace these methods with actual hardware sensor readings
    readSoilMoisture() {
        // Simulate soil moisture sensor (30-70% range)
        return 35 + Math.random() * 35;
    }

    readSoilTemperature() {
        // Simulate soil temperature sensor (20-35°C range)
        return 20 + Math.random() * 15;
    }

    readSoilPh() {
        // Simulate pH sensor (5.5-7.5 range)
        return 5.5 + Math.random() * 2;
    }

    readNitrogen() {
        // Simulate nitrogen sensor (20-80 mg/kg range)
        return 20 + Math.random() * 60;
    }

    readPhosphorus() {
        // Simulate phosphorus sensor (10-50 mg/kg range)
        return 10 + Math.random() * 40;
    }

    readPotassium() {
        // Simulate potassium sensor (15-60 mg/kg range)
        return 15 + Math.random() * 45;
    }

    stopMonitoring() {
        if (this.readingInterval) {
            clearInterval(this.readingInterval);
            console.log('Soil monitoring stopped');
        }
    }
}

// Example: Weather Station Sensor
class WeatherStationSensor extends FarmSensorClient {
    constructor(sensorId, location) {
        super(sensorId, 'Weather Station', 'weather_station', location);
        this.readingInterval = null;
    }

    startWeatherMonitoring(intervalSeconds = 60) {
        console.log(`Starting weather monitoring for sensor ${this.sensorId}`);
        
        this.registerSensor()
            .then(() => {
                console.log('Weather station registered successfully');
                
                this.readingInterval = setInterval(() => {
                    this.collectWeatherData();
                }, intervalSeconds * 1000);
                
                this.collectWeatherData();
            })
            .catch(error => {
                console.error('Failed to register weather station:', error.message);
            });
    }

    collectWeatherData() {
        const readings = [
            { type: 'air_temperature', value: this.readTemperature(), unit: '°C' },
            { type: 'humidity', value: this.readHumidity(), unit: '%' },
            { type: 'wind_speed', value: this.readWindSpeed(), unit: 'km/h' },
            { type: 'rainfall', value: this.readRainfall(), unit: 'mm' },
            { type: 'atmospheric_pressure', value: this.readPressure(), unit: 'hPa' }
        ];

        this.sendReadings(readings)
            .then(response => {
                console.log(`[${new Date().toISOString()}] Weather data sent:`, response.message);
            })
            .catch(error => {
                console.error('Failed to send weather data:', error.message);
            });
    }

    // Replace with actual weather sensor readings
    readTemperature() {
        return 25 + Math.random() * 10; // 25-35°C
    }

    readHumidity() {
        return 60 + Math.random() * 30; // 60-90%
    }

    readWindSpeed() {
        return 5 + Math.random() * 15; // 5-20 km/h
    }

    readRainfall() {
        return Math.random() * 5; // 0-5mm
    }

    readPressure() {
        return 1000 + Math.random() * 30; // 1000-1030 hPa
    }

    stopWeatherMonitoring() {
        if (this.readingInterval) {
            clearInterval(this.readingInterval);
            console.log('Weather monitoring stopped');
        }
    }
}

// Usage Examples
if (require.main === module) {
    console.log('=== Real Farm Sensor Client Examples ===\n');

    // Example 1: Soil Monitor Sensor
    const soilSensor = new SoilMonitorSensor('SOIL_FIELD_001', 'North Field, Juba');
    soilSensor.startMonitoring(30); // Send data every 30 seconds

    // Example 2: Weather Station
    const weatherStation = new WeatherStationSensor('WEATHER_001', 'Main Farm, Juba');
    weatherStation.startWeatherMonitoring(60); // Send data every 60 seconds

    // Example 3: Manual sensor reading
    setTimeout(() => {
        const manualSensor = new FarmSensorClient('MANUAL_001', 'Manual Test Sensor', 'temperature', 'Test Location');
        
        manualSensor.registerSensor()
            .then(() => {
                console.log('Manual sensor registered');
                
                // Send a single reading
                return manualSensor.sendReading('temperature', 28.5, '°C');
            })
            .then(response => {
                console.log('Manual reading sent:', response.message);
            })
            .catch(error => {
                console.error('Manual sensor error:', error.message);
            });
    }, 2000);

    // Handle graceful shutdown
    process.on('SIGINT', () => {
        console.log('\nShutting down sensors...');
        soilSensor.stopMonitoring();
        weatherStation.stopWeatherMonitoring();
        process.exit(0);
    });
}

module.exports = {
    FarmSensorClient,
    SoilMonitorSensor,
    WeatherStationSensor
};
