# Projet Java
**Projet Empreinte Carbone**

Yang YANG & Ningxin YE

MIAGE groupe 3

Université Paris Dauphine

## Introduction
Le projet est pour la mise en oeuvre d' un calculateur d'empreinte carbone.

L'utilisateur peut saisir des paramètres sur **le appartement**, **le transport**, **la valeur des biens consommés**, **les habitudes alimentaires**， **les services publics** (par défaut 1,5 TCO2eq) 

pour obtenir son empreinte carbone.

## Quelques extensions sont en cours de conception

* Donner aux utilisateurs des conseils pratiques en comparant leurs émissions de carbone à celles de la moyenne des Français. 
* Concevoir une interface graphique si le temps le permet.

## Usage

Il y a principalement deux fonction `Program`, un pour obtenir un utilisateur en utilisant un fichier text, l'autre pour obtenir un utilisateur vide, et ajouter les information pas en pas.

### En utilisant le fichier text
Le fichier `.txt` est sous la forme comme indiquer dans le fichier `Data/standard.txt`. Il y a aussi un exemple `Data/exemple1.txt`.Le chemin du fichier texte est passé par l'argument de la programme.

Pour compiler:
```bash
cd src/
javac Program.java
```
ça va produire un fichier `Program.class`. 

Pour utiliser, on doit passer un chemin d'un fichier text.
```bash
java Program ../Data/exemple.txt
```
Vous verrez le résultat.

### En complétant les information pas en pas

Pour compiler:
```bash
javac view_console/MainUI.java 
```
Et pour utiliser:
```bash
java view_console/MainUI 
```

Ici, vous pouvez selectionner les actions que vous voulez faire en tapant la chiffre et entrer. 

### GUI
En fait, on a fait une interface graphique, dans le pachage `view`, mais c'est pas encore fini. il y a qu'une fonctionnement : télécharger un fichier et afficher la résumé.

Si vous voulez tester, vous pouvez compiler comme:
```bash
javac view/MainWindow.java
```
et lancer :
```bash
java view/MainWindow
```
Vous allez voir une fenetre avec plusieurs boutons. Le premier bouton est pour télécharger un fichier text, vous pouvez choisir celui dan `Data/exemple.txt`, et le dernier bouton est pour afficher la résumeé.

Les reste boutons n'ont pas encore les actions.

## Contact 
Si vous avez des remarques, veuillez contacter ：

yang.yang2@dauphine.eu

ningxin.ye@dauphine.eu

