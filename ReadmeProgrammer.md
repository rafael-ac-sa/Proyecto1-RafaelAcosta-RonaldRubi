#Manual de Desarrollador Sistema de Aver�as

##Base de datos
Se utilizar� una base de datos SQLite. Esta base de datos debe llevar por nombre averias.sqlite y debe estar ubicada en el directorio ../averias/database/. El c�digo SQL de la base inicial se encuentra en dicho directorio, al igual que su diagrama. 
![alt text](../averias/database/diagrama.png "Diagrama")

##Pasarela a tabla de datos
Para implementar la capa de acceso de datos se utiliza una pasarela a tabla de datos. Para ello es necesario crear una clase abstracta que se encargue de almacenar la conexi�n jdbc. Esta clase se llamar� TableGateway.java y residir� en el directorio ../src/data/.
Las otras clases necesarias que se implementan, tendran como nombre nombreclaseGateway.java y reside en el mismo directorio ../src/data/.

##La capa de l�gica del dominio
Para implementar la capa de l�gica del dominio se utilizar� la t�cnica de m�dulo de tabla. En este caso el m�dulo agrupa toda la l�gica del dominio, pero no se encarga del acceso a datos. Para acceder a los datos se utiliza la pasarela a tabla de datos mostrada anteriormente.
Las clases necesarias tendr�n como nombre nombreclaseModule.java y residir� en el directorio 
../src/domain/.

##Capa de presentaci�n
El servicio de averias ha sido implementado mediante controladores de p�gina, en donde cada p�gina se implementa como un controlador individual. La clase general para definir los controladores se llama PageController.java y debe residir en el directorio ,,/src/display/.

###El controlador
Los controladores de p�gina son los que permiten mostrar los objetos. Estos archivos residen en el mismo directorio ../src/display/.

###La plantilla JSP
Adicionalmente se utilizar�, con el controlador anterior, una plantilla JSP para realizar el formateo de p�gina en c�digo HTML. El nombrecontrolador.jsp se encarga de esta tarea y residir� en el directorio ../averias/.

##Configuraci�n del contexto
El framework Spring permite crear archivos xml que definen la configuraci�n del contexto de ejecuci�n de la aplicaci�n. El archivo de configuraci�n llamado context.xml se deber� ubicar en el directorio ../averias/WEB-INF/.
Los aspectos importantes que se pueden observar en este archivo son la declaraci�n de una instancia (singleton) al constructor de pasarelas y la declaraci�n de la fuente de datos JDBC.
Precisamente para configurar la fuente de datos se utilizar� un archivo de propiedades llamado jdbc.properties y que residir� en el directorio ../averias/WEB-INF. 

##Configuraci�n del servidor
El servidor de servlets requiere del archivo de configuraci�n de la aplicaci�n para conocer en donde se ubica la clase a ejecutar. Adem�s este archivo permite indicar la ubicaci�n y nombre del archivo de contexto. Estos archivos de configuraci�n del servlet siempre se llaman web.xml y deben residir en el directorio ../averias/WEB-INF/.

##Librer�as requeridas
Deben residir en el directorio ../averias/WEB-INF/lib
+ commons-dbcp-1.4.jar
+ commons-logging-1.1.1.jar
+ commons-pool-1.6.jar
+ servlet-api.jar
+ spring-asm-3.2.0.M1.jar
+ spring-beans-3.2.0.M1.jar
+ spring-context-3.2.0.M1.jar
+ spring-core-3.2.0.M1.jar
+ spring-expression-3.2.0.M1.jar
+ spring-jdbc-3.2.0.M1.jar
+ spring-tx.3.2.0.M1.jar
+ spring-web-3.2.0.M1.jar
+ sqlite-jdbc-3.5.9.jar
+ el-api-6.0.18.jar
+ jasper-6.0.18.jar
+ jasper-el-6.0.18.jar
+ jasper-jdt-6.0.18.jar
+ jsp-api-6.0.18.jar
+ jstl-api-1.2.jar
+ jstl-impl-1.2.jar
+ jtds-1.2.4.jar
+ juli-6.0.18.jar
+ servlet-api-2.5.jar
+ urlrewrite-3.2.0.jar