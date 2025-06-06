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

## configuration de projet 

Pour la configuration, on utilise dans le fichier `application.properties` les lignes suivantes :

```properties
spring.application.name=student-app            # nom de l'application
server.port=8085                               # port du serveur
spring.datasource.url=jdbc:h2:mem:products-db  # URL de la base de données H2
spring.h2.console.enabled=true                 # activer la console H2
```
Quand on exécute notre application, on obtient dans le navigateur la page suivante :

![illustrations](images/bd_in_navigator1.png)
Après avoir cliqué sur Connect,
on peut voir les entités existantes : 

![illustrations](images/bd_in_navigator2.png)

## ajouter des prod a table de produit 
  
Ajouter des produits à la table Product
Pour enregistrer quelques produits, on modifie le code dans le fichier principal de l'application.
On a besoin d’exécuter le code d’ajout des produits dès que Spring démarre.

Pour simplifier cela, on fait en sorte que notre classe principale hérite de l’interface CommandLineRunner.
On implémente la méthode run(). Cette méthode est automatiquement appelée après le démarrage de l'application.

Le but est d’ajouter des produits à la base de données.

Pour cela, on utilise Spring Data JPA.
On crée un package repository, dans lequel on crée une interface ProductRepository.
##### Important : cette interface hérite de JpaRepository.

On peut maintenant utiliser cette interface pour ajouter les produits à la base de données.
Dans notre application, on déclare un objet de type ProductRepository et on utilise l’injection de dépendances avec @Autowired.
Ensuite, on ajoute les produits :

![illustrations](images/ajout_prod.png)

Résultat dans la base de données :

![illustrations](images/bd_in_navigator4_productContent.png)

Pour la gestion du projet, on utilise toujours ProductRepository pour afficher les produits et effectuer des recherches dans la table à l’aide de méthodes déjà définies comme findAll(), findByName(), findByNameContains(), etc.

![illustrations](images/methods.png)

les methodes :

![illustrations](images/methods1.png)

la methode search donne les meme resultat qye find by name 

```
@Query("select p from Product p where p.name like :x and p.price>:y")
List<Product> search(@Param(x) String kw,@Param(y) Double price);
```


Application:


```
        System.out.println("---- Résultats de search() : ------");

        // Appel de la méthode personnalisée "search" avec le mot-clé "%C%"
        List<Product> products3 = productRepository.search("%C%");

        // Affichage des résultats
        products3.forEach(prod -> {
            System.out.println(prod.toString());
        });```
```


Resultats :



![illustrations](images/search.png)



## Application Web – Exposition de services REST


Pour créer un service web REST avec Spring Boot, il suffit d’annoter une classe avec `@RestController`.  
Dans notre cas, la classe `ProductRestController` permet d’exposer des endpoints HTTP permettant d'accéder aux données des produits.

L'accès à la base de données se fait via une interface `ProductRepository`, injectée automatiquement grâce à l'annotation `@Autowired`.

Nous avons défini une méthode `products()` qui retourne la liste des produits stockés en base de données au format JSON, en s'appuyant sur la méthode `findAll()` de Spring Data JPA.  
Cette méthode est exposée via l'URL `/products` à l’aide de l’annotation `@GetMapping`.

##### Exemple de code pour exposer les produits au format JSON :

Code source affichant les produits au format JSON :

![illustrations](images/jsoncode.png)

Affichage JSON avec products() :

![illustrations](images/findalljson.png)


Affichage JSON avec productById() :

![illustrations](images/jsonwithid.png)
Lorsque l’ID demandé n’existe pas, deux approches sont possibles :

Générer une exception automatiquement :

```        return productRepository.findById(id).orElseThrow();
```
Retourner null si aucun produit n’est trouvé :

```        return productRepository.findById(id).orElse(null);
```
 
###Conclusion:
Avec Spring Boot, on peut créer des web services REST de manière très simple et efficace.
Il n’est pas nécessaire d’écrire beaucoup de code.
La plupart des fonctionnalités sont gérées automatiquement grâce à un ensemble puissant d’annotations.
Il est donc essentiel de bien comprendre et maîtriser ces annotations pour tirer pleinement parti du framework.

