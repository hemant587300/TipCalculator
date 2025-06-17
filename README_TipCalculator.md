# 💰 Tip Calculator (Jetpack Compose)

A simple and elegant Android application built using **Jetpack Compose** in **Kotlin** that helps users calculate service tips based on the total bill amount and quality of service.

---

## 📱 Features

- 📊 Calculate tip based on predefined percentages (10%, 7%, 5%)
- 🔘 Select service quality: Amazing, Good, Okay
- 🔁 Option to **round up** the tip to nearest whole value
- 💻 Built using **Jetpack Compose** and **Material 3**
- 🧪 Includes basic unit and instrumentation test setup

---

## 🚀 Tech Stack

- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose
- **Themeing:** Material 3
- **Test Libraries:** JUnit, Espresso

---

## 🎬 Demo

![Screenshot](screenshot.png)

---

## 🧠 How It Works

```kotlin
tip = costOfService × tipPercentage
if (roundUp) tip = ceil(tip)
```

Example:  
For ₹250, Good (7%) → Tip = ₹17.5  
With rounding → ₹18.0

---

## 📁 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com.smartblind.tipcalculator/
│   │   │   └── ui/
│   │   │       └── components/TipCalculatorScreen.kt
│   │   └── res/
│   ├── test/ → Unit Tests
│   └── androidTest/ → Instrumented Tests
```

---

## ✅ How to Run

1. Clone the repo
2. Open in **Android Studio (Meerkat or later)**
3. Connect Android 13+ device or emulator
4. Run app ➡️ Tip away!

---

## 🧑‍💻 Author

**Hem Pathak**  
B.Tech CSE @ Amity University Mumbai  
Passionate about crafting clean UIs and useful real-world Android apps.

---

## 📜 License

This project is open-source under [MIT License](LICENSE)
