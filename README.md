# compte-management

# Projet Spring Boot avec Java 17, React JS et base de données H2

Ce projet Spring Boot utilise Java 17 comme version Java et une base de données H2 pour le stockage des données.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants sur votre système :

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase-downloads.html) : Vous devez avoir Java 17 installé sur votre machine. Vous pouvez vérifier votre installation en exécutant `java -version` dans votre terminal.

- [Apache Maven](https://maven.apache.org/) : Maven est utilisé pour gérer les dépendances du projet et construire l'application.

- [Node.js](https://nodejs.org/) : Node.js est requis pour exécuter l'application React.


## Installation

1. Clonez ce référentiel sur votre machine locale :

```shell
git clone https://github.com/toueileb/compte-management.git

2. Accédez au répertoire du projet :

cd compte-management

3. Construisez le projet Spring Boot à l'aide de Maven :
mvn clean install

4. Lancement de la partie Spring Boot
mvn spring-boot:start

5. Accédez au répertoire de la partie front-end :

cd frontend/compte-management

6. Installez les dépendances de l'application React :
npm install

7.Lancement de la partie React
npm start

8. Accéder à l'application
http://localhost:3000 (De préference sur Mozilla)

9. Configuration de la base de données avec Liquibase:

Ce projet utilise Liquibase pour la gestion de la base de données. Liquibase vous permet de définir et de gérer la structure de la base de données, y compris la création de tables et les insertions de jeu de données. Les changelogs de Liquibase sont situés dans le répertoire `src/main/resources/db/changelog`.

Vous pouvez personnaliser les changelogs selon les besoins de votre projet. Pour plus d'informations sur la configuration de Liquibase, veuillez consulter la documentation de Liquibase.

Assurez-vous que les configurations de base de données dans le fichier `src/main/resources/application.properties` sont compatibles avec les changelogs de Liquibase pour garantir la cohérence de la base de données avec l'application Spring Boot.

N'hésitez pas à personnaliser ces étapes en fonction des spécificités de votre projet.


