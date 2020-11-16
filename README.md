# java-textbook
## Definitions
**ORM** (Object-Relational Mapping)  
**POM** (Project Object Model) - Maveni projekti ja dependency fail

## Using Gradle to run whole project
In project root folder (where are _build.gradle_ and _settings.gradle_ files)  
``` gradle run --args "myFirstArgument mySecondArgument"```
* "myFirstArgument mySecondArgument" - arguments you want to pass into _main(String args[])_, will be accessible as 
args[0], args[1].

## Connecting to Postgres database
1. You need to download postgresql-42.2.10 or later libary
2. Place it under project root
3. Using ``` File -> Project Structure -> Modules``` in InteliJ, add it to current project.
4. If you want to add it to gradle build also add this line to build.gradle  
``` compile(group: 'org.postgresql', name: 'postgresql', version: '42.2.10')```
5. For connection, I have created separate class

# Spring Framework
### spring-API-postgres
Eesmärk oli genereerida lihtne "Hello World" endpoint, lisada juurde võimalus läbi Swaggeri API requeste teha, ühendada see ära siis PostgreSQl baasiga ja genereerida GET all ja POST enpointid

STEP 1. [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) - setting up hello-world endpoint. Can be run using ```> mvn spring-boot:run```  
STEP 2. [Spring Boot + Swagger2](https://www.javainuse.com/spring/boot_swagger) - adding Swagger documentation manager to your Api

STEP 3 PostgreSql baasiga ühendamine ja fetchAll endpointi tegemine. Peamise tegin 3.1 järgi, aga seal oli puudu Repository package, Service package, äkki isegi mapper, et need pidin 3.2 pealt võtma   
  3.1  [Set up a Spring Boot Application With PostgreSQL](https://dzone.com/articles/bounty-spring-boot-and-postgresql-database) - Enam vähem, aga service ja entity ja repository osa oli puudu.  
  3.2 [Spring Boot PostgreSQL tutorial](http://zetcode.com/springboot/postgresql/) - Siit sai puudujääva osa Hindu tekstist  
  3.3 [Configuring Spring Boot for PostgreSQL](https://dzone.com/articles/configuring-spring-boot-for-postgresql) - siit sai puudujääva Postgresi confi osa, mis kahest eelmisest vajaka jäi  
Kasulik käsk ```mvn clean spring-boot:run``` või ```mvn clean spring-boot:run -X```  

STEP 4. POST endpoint. Otseselt häid viiteid ei oskagi anda. Lõpuks kasutasin kuidagi .save() meetodit. Hindu projektis oli ka DAO packages veel tehtud asju, aga mul lõpuks ei läinudki vaja. Kokku läks selle ühe endpointi uurimine 5 tundi ja siis sain ka alles esialgse variandi toimima. Sisuliselt oli vaja lisada Controllerisse paar rida koodi juurde. Enamus näited implementeerisid kohe save meetodi läbi repository, aga kuna mul oli see Service package ka hindu projektist vahel, pidin läbi selle tegema.

Tükk tegu oli ka sellega, et ei peaks etteantavasse JSON-isse id-d lisama. Selle muudatuse tuli läbi annotatsioonide lõpuks model failis sisse viia.  

*KOKKU: 8h 46 min* 

### spring-consuming-rest
Alustuseks paned üles teenuse, mis võtab Springi tsitaatide endpointiga ühendust. Selle jaoks, et ta konsooli logiks, pidi mingeid trikke tegema Loggeriga main klassi alt. Arusaamatuks jäi, et kui tahaks seda teadet kuhugi salvestada ja edasi saata, kuidas see siis toimuks.

Tükk aega rähklesin, et kuidagi tsitaati kätte saada Value klassist. Lõpuks kasutasin ikkagi @Overide toString funktsiooni.
Proovisin ka saata sõnumit  Fleepi nimelisse rakendusse läbi webhooki. Kuna Gsonit veel kasutanud pole, siis võtsin oma enda näitest ja kasutasin http libary HTTP Requesti.  

[Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/) - õpetus, kuidas Spring frameworkiga consumida API endpointe  
[Jackson 2 – Convert Java Object to / from JSON](https://mkyong.com/java/jackson-2-convert-java-object-to-from-json/) - kuidas java objektist json String teha

*KOKKU: 2h 40 min*

### spring-google-charts
Põhja ehitasin valmis järgneva õpetuse pealt. **NB** Kui genereerida projekt spring initializeriga ja see laadida Intelij vahendusel, siis ta mõnikord ei saa aru, et tegu on Maven projektiga. Sel juhul pane projket kinni, kustuta .idea kaust ja lae pom.xml uuesti. Aitas. Edasi võtsin google chart lehelt demo koodi. Lisasin charti jaoks eraldi htmli, lisasin chart controlleri. Staatiliselt hakkas kõik tööle, aga kuidas seda dünaamiliseks teha? Õnneks leidus maailmas sama mõttemaailmaga inimesi.  
[Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)  
[google-chart-example-with-spring-boot](https://asbnotebook.com/2020/04/18/google-chart-example-with-spring-boot/)

*KOKKU 2h 18min*

#Fantasy premierleague projekt
api - https://fantasy.premierleague.com/api/bootstrap-static/  
ideas https://towardsdatascience.com/fantasy-premier-league-value-analysis-python-tutorial-using-the-fpl-api-8031edfe9910  

# Ideid läbivaatamiseks
https://www.concretepage.com/spring-boot/spring-boot-rest-example  
https://howtodoinjava.com/spring-boot2/rest/rest-api-example/
