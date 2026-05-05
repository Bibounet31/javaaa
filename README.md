# README - Space Launch Simulator

## Compilation et exécution

### Prérequis
- Java 21+

### Compilation
```bash
javac */*.java *.java
```

### Exécution
```bash
java Start
```

### Structure des fichiers
```
javaaa/
├── Start.java
├── Simulator.java
├── Launch.java
├── HistoryManager.java
├── InsufficientFuelException.java
├── Rocket/
│   └── Rocket.java
├── Launchers/
│   ├── Launchers.java
│   ├── Falcon9.java
│   ├── SaturnV.java
│   ├── Ariane5.java
│   └── SLS.java
├── Capsule/
│   ├── CapsulesMaker.java
│   ├── Orion.java
│   ├── CrewDragon.java
│   ├── Apollo.java
│   └── CargoDragon.java
├── Booster/
│   └── BoosterMaker.java
└── Mission/
    ├── MissionMaker.java
    ├── EarthOrbit.java
    ├── ISS.java
    ├── Moon.java
    ├── Mars.java
    └── Custom.java
```

---

## Mission personnelle — Jupiter

La mission personnelle est **Jupiter**, accessible via le choix 5 dans le menu.

**Caractéristiques :**
- Distance : 628 730 000 km
- Mission habitée : oui
- Coefficient carburant : 0.000008

**Justification :** Jupiter est la planète la plus massive du système solaire. Une mission vers Jupiter représente un défi technologique extrême — distance 3x supérieure à Mars, durée estimée de plusieurs années. Le coefficient carburant est plus faible que Mars car à cette distance, la physique orbitale permet des trajectoires de transfert plus efficaces (assistance gravitationnelle).

---

## Concepts POO utilisés

| Concept | Où dans le code |
|---|---|
| Héritage | `Falcon9 extends Launchers`, `Orion extends CapsulesMaker` |
| Classe abstraite | `Launchers`, `CapsulesMaker`, `MissionMaker` |
| Polymorphisme | `List<Launchers>`, `List<MissionMaker>` |
| Composition | `Rocket` contient un `Launchers`, une `CapsulesMaker`, une liste de `BoosterMaker` |
| Surcharge | `addBooster(BoosterMaker)` et `addBooster(BoosterMaker, int)` dans `Rocket` |
| Redéfinition | `@Override getDescription()` dans chaque sous-classe |
| Exception métier | `InsufficientFuelException` |
| Singleton | `Simulator.getInstance()` |
| Fichier | `HistoryManager` lit/écrit `history.txt` |

## UML

<img width="804" height="666" alt="image" src="https://github.com/user-attachments/assets/cb3a7942-cee2-482b-bd8b-70cd2817dd4b" />
