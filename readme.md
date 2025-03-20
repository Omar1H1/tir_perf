# Projet TirPerf

## Introduction

Le projet TirPerf est une application de gestion et d'analyse des performances des appels. Il utilise Spring Boot pour le backend et JPA pour la gestion des données. Ce projet permet de stocker et d'analyser les résultats des appels effectués dans différents environnements, en fournissant des rapports détaillés sur les performances.

## Entités

Le projet comprend plusieurs entités principales :

- **Applicatif** : Représente une application ou un service.
- **Scenario** : Définit un scénario d'exécution avec des références et des descriptions.
- **ContextExecution** : Contient des informations sur l'environnement d'exécution.
- **RapportExecution** : Stocke les résultats des exécutions, y compris les durées et les erreurs.
- **TirPerf** : L'entité principale qui relie les rapports, les contextes et les scénarios.

