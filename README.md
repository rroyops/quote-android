<div align="center">

# Quote of the Day (Android)

An Android client for `quote-api` — my own backend, not a third-party quote service. This is the first project in the portfolio where the client and server are both mine.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue?style=flat-square)
![Status](https://img.shields.io/badge/status-v1.0-brightgreen?style=flat-square)

</div>

## 📖 Overview

Shows a random quote fetched from [`quote-api`](https://github.com/rroyops/quote-api). You can favorite quotes (stored locally with Room) and pull a new random one. The point of this project was learning the full client→server round trip: Retrofit for the network call, a Repository layer deciding what to do with the result, and a ViewModel exposing a clean state to the UI.

## ✨ Features

- Fetches a random quote from a real backend I wrote myself
- Favorite/unfavorite quotes, persisted locally with Room
- Explicit loading / success / error states (no silent failures)
- Retry on network failure
- Retrofit logging interceptor for debugging requests during development

## 📱 Screenshots

<!-- Replace with real screenshots once running against quote-api -->
| Loading | Quote shown | Error state |
|---|---|---|
| _placeholder_ | _placeholder_ | _placeholder_ |

## 🏗️ Architecture

```
model/       → Quote (shared Retrofit DTO + Room entity)
network/     → QuoteApiService (Retrofit interface), RetrofitInstance (client setup)
data/        → FavoriteQuoteDao + AppDatabase (Room), QuoteRepository (single source of truth)
viewmodel/   → QuoteViewModel (exposes QuoteUiState: Loading/Success/Error)
ui/          → QuoteScreen (Composables, reacts to state)
```

The **Repository** is the new layer vs. project #1 (`unit-converter-android`). The ViewModel never imports Retrofit or Room directly — only the Repository — so swapping backends or adding an offline cache later means changing `QuoteRepository`, not the ViewModel or UI.

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose, Material 3
- **Networking:** Retrofit + OkHttp
- **Local storage:** Room (favorites)
- **Concurrency:** Kotlin Coroutines

## 🚀 Getting Started

### Prerequisites
- Android Studio (Koala/Ladybug or later)
- JDK 17+
- [`quote-api`](https://github.com/rroyops/quote-api) running locally (see that repo's README)

### Installation
```bash
git clone https://github.com/rroyops/quote-android.git
cd quote-android
```
1. Start `quote-api` first (`npm start` in that repo — must be running before you launch this app)
2. Open this project in Android Studio, let Gradle sync
3. Run on an **emulator** (the app is pre-configured to reach your computer's localhost via `10.0.2.2`, which only works from the emulator — see note below for physical devices)

> **Physical device note:** `10.0.2.2` only resolves on the Android emulator. To test on a real phone, replace `BASE_URL` in `app/build.gradle.kts` with your computer's LAN IP (e.g. `http://192.168.1.50:3000/`) and make sure your phone is on the same Wi-Fi network.

## 🗺️ Roadmap

- [x] Random quote fetch + favorites (v1)
- [ ] Browse all quotes / filter by category
- [ ] Submit a new quote from the app (`POST` to the API)
- [ ] Point `BASE_URL` at a deployed version of `quote-api` instead of localhost
- [ ] Pull-to-refresh gesture instead of a button

## 🧠 What I Learned

The `10.0.2.2` emulator alias tripped me up at first — I expected `localhost` to just work, since that's what the backend logs when it starts. Learning that the emulator is its own separate "device" with its own network namespace, and that it maps `10.0.2.2` specifically back to the host machine, was a useful bit of Android-specific plumbing I hadn't needed to know until now.

## 🤝 Contributing

Personal learning project — issues and suggestions welcome.

## 📄 License

Distributed under the MIT License. See [`LICENSE`](LICENSE) for details.
