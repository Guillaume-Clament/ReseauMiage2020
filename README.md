# Projet de réseau Master 1 MIAGE 2020

## 1) Prerequis :

* Java 11 minimun
* IntelliJ

## 2) installation :
#### Clonner le projet sur le dépot git hub (mode public)
* https://github.com/Guillaume-Clament/ReseauMiage2020.git

## 3) lancement du projet :

Lancer en premier le "main" du serveur qui se trouve dans le sous projet RéseauMiage2020_Serveur.
* MainServer

Par la suite lancer le client depuis le "main" qui se trouve dans RéseauMiage2020_Client.
* MainClient

## 4) consultation des logs:

Dans la racine du projet il y a un fichier de log "logs.json" ou nous pouvons consulter les échanges entre le serveur et client.
Si le fichier n'existe pas il sera créé lors du premier échange entre le client et le serveur.

## 5) Conception:

A la racine du projet se trouve les fichiers suivants:
* client.uml
* metier.uml
* serveur.uml
* travail.uml

ils sont consultables depuis intelliJ et approtent une connaissance sur la structure des classes JAVA au sein du projet

### 5.1) USE CASE
![DESCRIPTION DE L'IMAGE](https://zupimages.net/up/21/01/hlhh.jpg)


### 5.1) Diagramme de séquence
Ajout d'un couple login password
![DESCRIPTION DE L'IMAGE](https://zupimages.net/up/21/01/aidr.jpg)

Vérification de login et d'un password
![DESCRIPTION DE L'IMAGE](https://zupimages.net/up/21/01/e7a5.jpg)

Supression d'un couple login password
![DESCRIPTION DE L'IMAGE](https://zupimages.net/up/21/01/eqx7.jpg)

Modification d'un password par un manager
![DESCRIPTION DE L'IMAGE](https://zupimages.net/up/21/01/r3jn.jpg)

## Bugs:
Au lancement du projet il y a un nullPointeur sur une exception (en UDP), en mode débug elle n'apparait pas forcément.

