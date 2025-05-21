# BookGestion

Ce projet est une simple application de gestion de bibliothèque en Java, utilisant Maven pour la gestion des dépendances et JUnit 5 pour les tests.

## Prérequis

- Java 17 ou supérieur
- Maven 3.6 ou supérieur

## Compilation du projet

### Cloner le dépôt
```bash
git clone https://github.com/Zastial/BookGestion.git
```

### Accéder au répertoire du projet
```bash
cd BookGestion
```

### Installer maven

Mac OS :
```bash
brew install maven
```

Linux :
```bash
sudo apt update
sudo apt install maven
```

Windows : 

- Télécharger Maven depuis : https://maven.apache.org/download.cgi
- Décompresser l’archive dans un dossier (ex : C:\Program Files\Apache\maven)
- Ajouter le chemin bin de Maven à la variable d’environnement PATH
- Redémarrer le terminal ou l’invite de commandes

### Utiliser maven

Pour vérifier l’installation, exécuter :
```bash
mvn -v
```

Pour compiler le projet, exécuter la commande suivante à la racine du projet :

```bash
mvn compile
```

## Lancer les tests
Pour exécuter tous les tests unitaires et fonctionnels :
```bash
mvn test
```

Pour exécuter un test spécifique, vous pouvez utiliser la commande suivante :
```bash
mvn -Dtest=NomDuTest test
```

Ou lancer les tests depuis les fichiers *Test.java* en cliquant sur le logo "Run" dans l'IDE.

## Structure du projet
- src/main/java : code source de l'application
- src/test/java : tests unitaires et fonctionnels

