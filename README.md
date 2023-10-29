# compte-management

# Projet Spring Boot avec Java 17, React JS et base de donn�es H2

Ce projet Spring Boot utilise Java 17 comme version Java et une base de donn�es H2 pour le stockage des donn�es.

## Pr�requis

Avant de commencer, assurez-vous d'avoir install� les outils suivants sur votre syst�me :

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase-downloads.html) : Vous devez avoir Java 17 install� sur votre machine. Vous pouvez v�rifier votre installation en ex�cutant `java -version` dans votre terminal.

- [Apache Maven](https://maven.apache.org/) : Maven est utilis� pour g�rer les d�pendances du projet et construire l'application.

- [Node.js](https://nodejs.org/) : Node.js est requis pour ex�cuter l'application React.


## Installation

1. Clonez ce r�f�rentiel sur votre machine locale :

```shell
git clone https://github.com/toueileb/compte-management.git

2. Acc�dez au r�pertoire du projet :

cd compte-management

3. Construisez le projet Spring Boot � l'aide de Maven :
mvn clean install

4. Lancement de la partie Spring Boot
mvn spring-boot:start

5. Acc�dez au r�pertoire de la partie front-end :

cd frontend/compte-management

6. Installez les d�pendances de l'application React :
npm install

7.Lancement de la partie React
npm start

8. Acc�der � l'application
http://localhost:3000 (De pr�ference sur Mozilla)

9. Configuration de la base de donn�es avec Liquibase:

Ce projet utilise Liquibase pour la gestion de la base de donn�es. Liquibase vous permet de d�finir et de g�rer la structure de la base de donn�es, y compris la cr�ation de tables et les insertions de jeu de donn�es. Les changelogs de Liquibase sont situ�s dans le r�pertoire `src/main/resources/db/changelog`.

Vous pouvez personnaliser les changelogs selon les besoins de votre projet. Pour plus d'informations sur la configuration de Liquibase, veuillez consulter la documentation de Liquibase.

Assurez-vous que les configurations de base de donn�es dans le fichier `src/main/resources/application.properties` sont compatibles avec les changelogs de Liquibase pour garantir la coh�rence de la base de donn�es avec l'application Spring Boot.

N'h�sitez pas � personnaliser ces �tapes en fonction des sp�cificit�s de votre projet.


10. Url Swagger:
http://localhost:9090/swagger-ui/index.html#/

11. Pour Connecter à l'appplication vous pouvez utiliser le compte ci_aprés
Mail: james.williams@example.com
Mot de passe: 12345678