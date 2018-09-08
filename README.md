# Impro Photo

## Installation

### Sur PC et Raspberry
Installer Java 8 : Aller sur le site d'Oracle [...]

Télécharger sur le poste le fichier *.jar* et le fichier *launcher.bat*. (lancer le programme avec les arguments --spring.profiles.active=prod)

[...]

### Sur Raspberry uniquement
#### Point d'accès Wifi
[...]

### Sur Linux uniquement
Lancer le script [... script qui donne les droits au script download-update.sh]

#### Configuration du DNS
[...]

## Configuration de Chrome
Depuis avril 2018, pour lutter contre les pubs intrusives, Chrome a une nouvelle politique d'autoplay. 

Le logiciel contrôle des vidéos et de l'audio sans contrôle direct de l'utilisateur (c'est le code qui s'en charge). Il faut donc débloquer ce comportement sur Chrome.

Pour ça, aller sur l'URL suivante : ```chrome://flags/#autoplay-policy``` et placer la propriété ```Autoplay policy``` sur la valeur ```No user gesture is required```.

## Démarrer l'application

### Sur Windows
Lancer le script launchImpro.exe. Une fois que l'adresse IP est affichée, vous pouvez lancer Chrome 

### Sur le Raspberry
L'application se lance toute seule au démarrage, et démarre Chrome en plein écran.

## Liens utiles (si lancé sur Raspberry)
* [http://improphoto.fr](http://improphoto.fr) : URL principale de l'application
* [http://improphoto.fr/console](http://improphoto.fr/console) : Accès à la base de données (fichier ```jdbc:h2:file:./datas/dbImproPhoto```, login : ```sa```)

**Si l'application est lancée sur un PC** : 
Remplacer _improphoto.fr_ par l'adresse IP et le port fournis par le script launchImpro.exe 