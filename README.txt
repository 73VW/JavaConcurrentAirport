**********************************
Programmation concurrente : Labo 3
**********************************

Auteurs : Maël Pedretti, Laurent Gander


Le but de ce laboratoire est de simuler la gestion d'un aéroport. Les avions le visitent dans cet ordre :

1. Approche
2. Atterrit
3. Se gare
4. Décolle
5. S'envole

Au démarrage de la simulation, l'utilisateur choisi ces paramètres

- Nombre d'avions
- Nombre de piste d'atterrissage
- Nombre de place au terminal
- Nombre de piste de décollage
- Type d'implémentation des tampons
- Mode test
- Durée aléatoire


Pour chaque piste ou place, un tampon est utilisée. Les choix sont :

- ``BlockingQueue``
- ``LinkedList``

Les ``BlockingQueue`` sont facile à gérer. La partie concurrente est déjà implémentée.

Pour les ``LinkedList``, la partie concurrente est gérée manuellement à l'aide de méthodes ``synchronized`` et d'un ``Object`` servant de moniteur

Tests de performance
********************

Le tableau suivant représente le temps en millisecondes de l'exécution du simulateur. Les paramètres du simulateur sont : 50 avions, ``sleep`` de 100ms pour représenter la durée de l'action. Ici, les case signifie à la fois le nombre de pistes d'atterrissage, le nombre de places au terminal et le nombre de pistes de décollage. Les valeurs inscrites dans ce tableau sont des moyennes calculées à partir de 4 chronométrages.

Tableau récapitulatif
*********************

+--------+---------------+------------+---------+
|        | BlockingQueue | LinkedList | Tableau |
+========+===============+============+=========+
| 1 case | 5830          | 5845       | 5972    |
+--------+---------------+------------+---------+
| 4 case | 2324          | 2306       | 2135    |
+--------+---------------+------------+---------+
| 8 case | 1464          | 1492       | 1503    |
+--------+---------------+------------+---------+

Nous observons que pour 1 et 8 cases, les ``BlockingQueue`` sont plus performantes.
