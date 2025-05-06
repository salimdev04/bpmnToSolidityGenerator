
---

```markdown
# BPMN-to-Solidity Compiler

Ce projet est une preuve de concept permettant de **générer automatiquement du code Solidity** (smart contracts) à partir de **modèles BPMN simplifiés**, en utilisant **ANTLR4** pour le parsing et **Java** pour la génération du code.

---

## 🚀 Fonctionnalités

- 🔁 Analyse de modèles BPMN personnalisés via une grammaire ANTLR4
- 🧠 Génération automatique d’un smart contract `.sol` à partir du modèle
- ⚙️ Basé sur Java, ANTLR4, Gradle
- 📦 Extensible pour supporter des modèles BPMN plus complexes

---

## 🛠️ Stack technique

- **Java 17+**
- **Gradle 8.1.4**
- **ANTLR4 (v4.13.0)**
- (optionnel) Spring Boot
- IntelliJ IDEA

---

## 📁 Structure du projet

```
.
├── src/
│   ├── main/
│   │   ├── java/                 # Code source Java (Main, générateur, etc.)
│   │   └── antlr4/               # Fichier BpmnSimple.g4 (grammaire ANTLR)
├── build/
│   └── generated-src/antlr/     # Code généré automatiquement par ANTLR
├── LoanApproval.sol             # Smart contract généré automatiquement
├── build.gradle
└── README.md
```

---

## ✅ Prérequis

- Java installé (`java -version`)
- Gradle wrapper inclus (`./gradlew`)
- IntelliJ recommandé comme IDE

---

## 🔧 Installation et exécution

1. **Cloner le projet**
   ```bash
   git clone https://github.com/ton-utilisateur/bpmn-to-solidity.git
   cd bpmn-to-solidity
````

2. **Générer les classes ANTLR**

   ```bash
   ./gradlew generateGrammarSource
   ```

3. **Compiler et exécuter le projet**

   ```bash
   ./gradlew run
   ```

4. **Résultat**

    * Un fichier `LoanApproval.sol` sera généré à la racine du projet.

---

## 🧩 Exemple de modèle BPMN accepté

Voici un exemple très simple de syntaxe BPMN supportée :

```bpmn
start
task ApproveLoan
task TransferFunds
end
```

---

## 📦 Extensions futures possibles

* Génération de contrats plus complexes avec conditions, événements, etc.
* Support du BPMN standard (XML)
* Interface web pour uploader un BPMN et récupérer un smart contract
****
