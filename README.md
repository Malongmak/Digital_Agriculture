# Digital Agriculture for South Sudan

A comprehensive web-based agricultural management system designed specifically for South Sudan farmers, featuring AI-powered analysis, real-time monitoring, and localized agricultural recommendations.

## 🌱 Features

### Core Functionality
- **🤖 AI Farm Analyzer**: Intelligent agricultural analysis using OpenAI GPT-3.5
- **🌤️ Weather Monitoring**: Real-time weather data and 7-day forecasts
- **🧪 Soil Analysis**: pH, NPK, moisture analysis with recommendations
- **💡 Smart Recommendations**: Crop advice, irrigation planning, fertilizer guidance
- **📊 Dashboard**: Comprehensive farm management interface
- **👤 User Profiles**: Personalized farm field management
- **📚 Knowledge Bank**: Agricultural best practices for South Sudan
![Image](https://github.com/user-attachments/assets/15883847-61ee-45ee-86ce-653c3d7436fc)
### South Sudan Localization
- **Crop Focus**: Sorghum, maize, millet, groundnuts
- **Climate Adaptation**: Drought-resistant farming techniques
- **NGO Partnerships**: FAO, IFAD, AfDB, CARE, World Vision, Oxfam
- **Regional Coverage**: All major South Sudan agricultural zones

### Technical Features
- **📱 Responsive Design**: Mobile-first approach for all devices
- **🔐 Secure Authentication**: User registration and login system
- **🌐 Real-time Data**: WebSocket integration for live updates
- **🗄️ Data Persistence**: SQLite database for local storage
- **🔄 API Integration**: RESTful backend with sensor support

## 🚀 Quick Start

### Prerequisites
- Node.js 14+ 
- Modern web browser
- Internet connection for AI features

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/Malongmak/Digital_Agriculture.git
   cd Digital_Agriculture
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Set up environment variables**
   ```bash
   # Create .env file
   OPENAI_API_KEY=your_openai_api_key_here
   SENSOR_API_PORT=3003
   ```

4. **Start the application**
   ```bash
   # Start backend server
   node sensor-server.js
   
   # Open frontend in browser
   # Open modern-app.html in your web browser
   ```

### Access Points
- **Frontend**: Open `modern-app.html` in web browser
- **Backend API**: `http://localhost:3003`
- **Health Check**: `http://localhost:3003/health`

## 📖 Usage Guide

### Getting Started
1. **Register/Login**: Create account or sign in
2. **Complete Profile**: Add farm details and location
3. **Navigate Tabs**: Use tab navigation for different features

### AI Analyzer
1. **Select Analysis Type**: Choose from soil health, crop recommendation, irrigation planning, etc.
2. **Provide Data**: Enter farm observations and sensor data
3. **Describe Issues**: Detail any problems or questions
4. **Get Insights**: Receive AI-powered agricultural recommendations

### Weather Monitoring
- **Automatic Location**: Uses GPS or manual location selection
- **7-Day Forecast**: Detailed weather predictions
- **Agricultural Alerts**: Weather-based farming recommendations

### Soil Analysis
- **Manual Input**: Enter pH, NPK, moisture values
- **Instant Analysis**: Get soil health assessment
- **Recommendations**: Fertilizer and crop suggestions

## 🛠️ API Documentation

### Authentication Endpoints
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

### AI Analysis
- `POST /api/ai/analyze` - AI farm analysis
  ```json
  {
    "analysisType": "soil_health",
    "farmData": "pH 6.5, moisture 25%",
    "farmIssues": "Yellowing leaves",
    "prompt": "Full AI prompt"
  }
  ```

### Weather Data
- `GET /api/weather/:location` - Weather by location
- `POST /api/weather` - Weather data submission

### Sensor Integration
- `POST /api/sensors` - Register new sensor
- `POST /api/sensors/:id/reading` - Submit sensor data
- `GET /api/dashboard/sensors` - Get all sensors

## 🌍 South Sudan Features

### Supported Locations
- **Juba** (Capital)
- **Wau**, **Aweil**, **Malakal**
- **Yei**, **Yambio**, **Torit**
- **Mayiandit**, **Payinjiar**
- All major agricultural regions

### Crop Recommendations
- **Sorghum**: Primary staple crop
- **Maize**: Secondary staple
- **Millet**: Drought-resistant option
- **Groundnuts**: Cash crop alternative

### Climate Considerations
- **Rainy Season**: April-November planting
- **Dry Season**: Irrigation planning
- **Temperature**: 25-32°C optimal range
- **Soil Types**: Sandy loam to clay adaptations

## 🔧 Configuration

### Environment Variables
```bash
OPENAI_API_KEY=sk-proj-xxxxxxxxxxxxxxxxxxxx  # Required for AI features
SENSOR_API_PORT=3003                       # Server port
NODE_ENV=production                       # Environment mode
```

### Database Setup
- **SQLite**: Automatic database creation
- **Tables**: Users, sensors, readings, weather data
- **Backup**: Regular data export options

## 📱 Mobile Responsiveness

### Breakpoints
- **Mobile**: ≤480px (14px base font)
- **Tablet**: 481-768px (15px base font)
- **Desktop**: ≥769px (16px base font)

### Mobile Optimizations
- **Touch Targets**: 44px minimum for accessibility
- **Font Sizes**: 16px inputs prevent iOS zoom
- **Navigation**: Vertical layout on small screens
- **Forms**: Optimized input spacing and sizing

## 🔒 Security

### Data Protection
- **No Hardcoded Keys**: API keys use environment variables
- **Input Validation**: All user inputs sanitized
- **Secure Endpoints**: Authentication required for sensitive data
- **HTTPS Ready**: SSL certificate support

### Privacy
- **Local Storage**: Data stored locally when possible
- **Minimal Tracking**: No unnecessary analytics
- **User Control**: Data deletion and export options

## 🤝 Contributing

### Development Setup
1. Fork the repository
2. Create feature branch
3. Make changes with proper testing
4. Submit pull request

### Code Standards
- **ES6+**: Modern JavaScript features
- **Responsive**: Mobile-first design
- **Accessible**: WCAG 2.1 compliance
- **Secure**: No secrets in code

## 📞 Support

### Technical Support
- **Documentation**: This README file
- **Issues**: GitHub Issues page
- **Community**: Local agricultural extension offices

### Agricultural Support
- **NGOs**: FAO, IFAD, CARE partnerships
- **Government**: Ministry of Agriculture resources
- **Local**: Extension officers in major towns

## 📄 License

This project is licensed under the MIT License - see LICENSE file for details.

## 🙏 Acknowledgments

- **OpenAI**: For AI analysis capabilities
- **Font Awesome**: For icon library
- **South Sudan Farmers**: For requirements and feedback
- **Agricultural NGOs**: For expertise and resources

---

**Made with ❤️ for South Sudan Farmers**

*Digital Agriculture for South Sudan - Empowering farmers with technology and AI*
