# Graphql_Banque_Service
 
## GraphQL Spring Boot & Android Java Demo

Ce projet démontre l'intégration de GraphQL avec un backend Spring Boot et un frontend mobile Android en Java.

## Qu'est-ce que GraphQL ?

[GraphQL](https://graphql.org/) est un langage de requête pour les API et un environnement d'exécution pour exécuter ces requêtes avec vos données existantes. Contrairement aux API REST classiques, qui exposent des endpoints pour chaque type de donnée, GraphQL permet de récupérer exactement ce dont vous avez besoin dans une seule requête.

Avec GraphQL, les clients peuvent demander précisément les données nécessaires et rien de plus. Cela réduit la surcharge de données et rend les appels API plus efficaces.

### Avantages de GraphQL :
- **Récupération de données flexible** : Demander exactement ce dont vous avez besoin, pas plus, pas moins.
- **Regroupement de plusieurs requêtes en une seule** : Pas besoin d'appels multiples pour récupérer des informations liées.
- **Évolution facile de l'API** : Les modifications de l'API ne cassent pas les clients existants.

## Prérequis

- JDK 11 ou version supérieure
- Android Studio
- Maven
- Spring Boot

## Backend (Spring Boot avec GraphQL)

### Démarrer

1. Clone le repository 

2. Installe les dépendances :
    mvn install
3. Lance l'application Spring Boot :
    mvn spring-boot:run
    Le serveur sera accessible sur `http://localhost:8080`.

### Endpoints

L'endpoint GraphQL est accessible à :

- `POST http://localhost:8080/graphql`

## Frontend (Android Java)

### Démarrer

1. Ouvre Android Studio et importe le projet Android

2. Configure l'URL de ton backend dans le fichier de configuration de l'application (`strings.xml` ou un fichier de config similaire).

3. Lance l'application sur ton appareil Android ou un émulateur.

### Fonctionnalités

- Récupérer et afficher les données depuis le backend via des requêtes GraphQL.
- Interface utilisateur simple pour interagir avec le backend.

## Vidéo Démo



Regarde la vidéo démo pour voir comment l'application fonctionne. 


https://github.com/user-attachments/assets/fd0b86c1-4a74-4fb9-8704-92f0327e988d



