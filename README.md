# 📖 QuoteKa Application   <img src="https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExMmUwZzI5b2tzbGRlZnlubGFyYTFkMWgybXM4ZzZxdnNld2lnOTc1eiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/WhoNyvVjuB88HjDK0l/giphy.gif" width="50px"/>

## 📌 Overview  
**QuoteKa** is an Android application that allows users to get a **"Quote of the Day"** and save their favorite quotes.  
The app is built using **Jetpack Compose**, follows the **MVVM architecture**, and integrates with a third-party **API** to fetch quotes.  
**Firebase Authentication** is used for user login and registration, and **SharedPreferences** is used for saving favorite quotes locally.  

---

## 📂 Project Structure  
The project is organized into the following main packages:  

### **1. data (Data Layer)**  
- **api**: Handles API requests using Retrofit.  
- **models**: Defines data models for quotes, onboarding, and authentication.  
- **repository**: Manages data operations and abstracts API interactions.  

### **2. ui (Presentation Layer)**  
- **screens**: Contains all app screens (e.g., Onboarding, Quote Display, Login, Favorites).  
- **composables**: Custom UI components such as buttons, cards, and loaders.  
- **viewmodels**: ViewModel classes that handle app logic and state management.  
- **themes**: Defines UI styling, colors, and typography.  

---

## 🚀 Features  
✅ **Onboarding Screens** – Users can swipe through introduction screens.  
✅ **Fetch "Quote of the Day"** – Retrieves quotes from an external API.  
✅ **Favorites Management** – Save and remove quotes from favorites using SharedPreferences.  
✅ **User Authentication** – Register, login, and logout using Firebase Authentication.  
✅ **MVVM Architecture** – Ensures clean code structure and separation of concerns.  
✅ **Error Handling** – Displays messages if API requests fail.  
✅ **Loading Indicator** – Shows a spinner while fetching data from the API.  

---

## 🔧 Technologies Used  
- **Kotlin**  
- **Jetpack Compose**  
- **Retrofit** (API requests)  
- **Gson** (JSON parsing)  
- **Firebase Authentication**  
- **SharedPreferences** (Local storage)  

---

## 🛠 Setup & Installation  

1️⃣ **Clone the repository:**  
```bash
git clone [YOUR_GITHUB_REPO_URL]
```

2️⃣ Open the project in Android Studio.
3️⃣ Add your API key in the BuildConfig file:
```bash
const val API_KEY = "your_api_key_here"
```
I used the free public API from here:

https://www.api-ninjas.com/api/quotes

4️⃣ Run the project on an emulator or a physical device.

⚠️ Notes
API Key: You will need an API key to fetch quotes. Update BuildConfig.API_KEY accordingly.
Settings Screen: This feature is hardcoded and not fully implemented yet.

📜 License
This project is for educational purposes only.

📢 Acknowledgments
Thank you for reviewing this project! 🚀


<img src="https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExazZmN2R6cWU4cjJkamtleTk2eHA2OTEycjdieXpkOXp3M2Q1eXhpbyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/llarwdtFqG63IlqUR1/giphy.gif"  width="50px"/>

