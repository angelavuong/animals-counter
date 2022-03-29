# animals-counter


To add a dog to the database: 
    
    curl http://<ocp-route>/animals/dogs/bond

  
To add a cat to the database: 
    
    curl http://<ocp-route>/animals/cats/koki
  

To view the list of animals:
    
    TBD 


To validate using the Postgres DB: 

        sh-4.4$ psql -U <user> -d animals
        psql (10.17)
        Type "help" for help.

        animals=> select * from animal;
         id | age | name | type 
        ----+-----+------+------
          1 |   1 | bond | dog
          2 |   1 | koki | cat
        (2 rows)

        animals=> 
