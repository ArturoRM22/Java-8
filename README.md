## Learning Lambdas, Method References and Default Methods in java 8. 

In this repository, we used lambda expressions to implement basic library functionalities with fewer lines of code, resulting in cleaner and more readable logic once you get the hang of how lambdas work.
We also explored how interfaces can include default methods with actual implementations, which can be overridden if needed.

Finally, we realized that method references can be used instead of some lambda expressions. 

Overall, these Java 8 updates are powerful tools that significantly improve developer productivity.

## Team 46

- Carlos Iván Armenta Naranjo - A01643070
- Jorge Javier Blásquez Gonzalez - A01637706 
- Adolfo Hernández Signoret - A01637184
- Arturo Ramos Martínez - A01643269
- Moisés Adrián Cortés Ramos - A01642492
- Bryan Ithan Landín Lara - A01636271

## How to execute
1. Clone this repo:
```
git clone https://github.com/ArturoRM22/Java-8.git
```
2. Install dependencies and packages from the pom.xml using mvn:
```
mvn clean install
```
In case of a failed installation, check which maven-surefire-plugin version works for you.

3. Then you can execute the program with this command comming from the exec-maven-plugin: 

```
mvn exec:java
```

4. For the tests run: 

```
mvn test
```
