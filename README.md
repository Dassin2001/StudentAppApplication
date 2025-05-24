# StudentAppApplication

**StudentAppApplication** est une application Java développée avec **Spring Boot**, utilisant **Spring Data JPA** et **Hibernate** pour la gestion de la persistance.

Ce projet est basé sur le cours de **Prof.Mohamed Youssfi** , et il a été réalisé dans un cadre pédagogique pour comprendre l’architecture MVC, la persistance des entités, et l’utilisation des repositories Spring Data.

##  Fonctionnalités

- Ajouter des produits
- Consulter tous les produits
- Rechercher des produits par nom (avec mots-clés)
- Rechercher par nom et par prix
- Affichage console des résultats via `CommandLineRunner`

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
## ajouter des prod a table de produit 
  
pour enregistre quelque produit on va vers a notre code a application 
on a besoin dexecuter le code djaouter les produis une fois que spring est demarer
pour etre simplement , on fait notre application heritede un intarfcae CommandLineRunner , on implementant les methodes definis , on a une seule commande , qui appel run()
dans cette methode que onredfifinie run(), dit que on demeare lapplication spring va demarer run
le but cest d'ajouter de produit a la base de donnees 
pour ce interet, on a besoin d'utiliser springdata pour pouvoir gerer les produit
pour cela on crrer un package  'repository, dans lequell on crie interface ProductRepository , 
important: interface herite de interface JpaRepository
donc on utilise maintenant ce interface pour pouvoir ajouter lesprod dans la bas de donnees dan mon application 
on fait declarer un  object de type ProductRepository puis on fait injectionde dep , par @ autowired
,

## 

