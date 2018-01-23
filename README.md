# IA_TP1
Antoine Challet - CHAA30069502
François Duport - DUPF18029406


Le programme est composé d'une instance Game servant a instancier et à gérer l'environnement et le bot sous formes de thread.
C'est l'instance de game qui les créer et qui verifie à chaque instant si le bot doit mourir ou non.

L'environnement calcule de manière aléatoire si il est dangereux ou non. On utilise un rapport de 20 % pour le calcul.

Le bot lui passe a travers 4 buts differents se suivant logiquement lorsque l'environnement n'est pas dangereux, sinon
il passe par le but d'attente. Il affiche un message pour chaque but. Cette mise à jour s'effectue
toutes les deux secondes.

Pour savoir si l'environnement est sûr, le bot possede un objet senseur qui peut observer l'état de l'environnement et
donc detecter si il est dangereux ou sûr.

Le bot va donc probablement mourrir dès que l'environnement va passer en état dangereux. Cela vient de la désynchronisation
des threads et du fait que le bot n'anticipe pas le danger et/ou n'as pas de temps donné pour reagir. Si les deux threads
se mettent à jour en même temps alors il ya très peu de chace pour que le bot lise l'état de danger et se mette en attante
avant que le jeu ne le tue. 
