# 📱 Hotel Booking App

Une application mobile Android pour la réservation d’hôtels, construite avec **Java**, **Firebase**, et utilisant un **Navigation Drawer**.

## 🚀 Fonctionnalités

- 🔐 Authentification utilisateur (Firebase Auth)
- 🏨 Consultation des chambres disponibles
- 🛏 Réservation d’une chambre
- 👤 Gestion de profil utilisateur
- 🧾 Historique des réservations
- 📍 Affichage de la localisation de l'hôtel
- 📞 Page Contact
- ⚙ Paramètres utilisateur
- 📜 Navigation par Drawer (menu latéral)

---

## 🛠️ Technologies utilisées

- **Android Studio**
- **Java**
- **Firebase Authentication**
- **Firebase Realtime Database**
- **Navigation Component**
- **Material Design**
- **Google Maps API**

---

## 📂 Structure du projet

```

app/
├── java/com/example/hotel/
│   ├── MainActivity.java
│   ├── login1.java
│   ├── signup1.java
│   ├── myreservation.java
│   ├── setting.java
│   ├── reservation.java
│   ├── rooM1.java
│   ├── rooM2.java
│   └── ui/contactus/contactus.java
│
├── res/
│   ├── layout/
│   ├── mipmap/         ← Icones de l'application
│   └── values/
│
├── AndroidManifest.xml

````

---

## ✅ Prérequis

- Android Studio Bumblebee ou + récent
- Connexion internet (Firebase)
- Clé API Google Maps (déjà incluse dans le `AndroidManifest.xml`)

---

## ▶️ Démarrer l’application

1. Clone ce dépôt :
   ```bash
   git clone https://github.com/Jvsxm-x/hotel_manegment.git
````

2. Ouvre le projet dans Android Studio.
3. Connecte ton appareil ou démarre un émulateur.
4. Clique sur **Run ▶**.

---

## 🔐 Accès Firebase

* Pour utiliser Firebase :

  * Crée un projet Firebase
  * Ajoute ton fichier `google-services.json` dans le dossier `app/`
  * Active Firebase Authentication et Realtime Database

---

## ✏️ Personnalisation

* Modifier l’icône de l'application : `res/mipmap/`
* Modifier le thème : `res/values/themes.xml`
* Modifier les routes/navigation : `nav_graph.xml`



## 📄 Licence

Ce projet est sous licence **MIT** – voir le fichier `LICENSE.md` pour plus d’informations.

---

## 🙌 Contributeurs

* jassem chouat (https://github.com/jvsxm-x) – Développeur principal

```

