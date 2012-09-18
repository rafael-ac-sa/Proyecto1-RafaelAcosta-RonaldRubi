#Manual de Desarrollador Sistema de Averías

##Base de datos
Se utilizará una base de datos SQLite. Esta base de datos debe llevar por nombre averias.sqlite y debe estar ubicada en el directorio ../averias/database/. El código SQL de la base inicial se encuentra en dicho directorio, al igual que su diagrama. 
![alt text](../averias/database/diagrama.png "Diagrama")

##Pasarela a tabla de datos
Para implementar la capa de acceso de datos se utiliza una pasarela a tabla de datos. Para ello es necesario crear una clase abstracta que se encargue de almacenar la conexión jdbc. Esta clase se llamará TableGateway.java y residirá en el directorio ../src/data/.
Las otras clases necesarias que se implementan, tendran como nombre nombreclaseGateway.java y reside en el mismo directorio ../src/data/.

##La capa de lógica del dominio
Para implementar la capa de lógica del dominio se utilizará la técnica de módulo de tabla. En este caso el módulo agrupa toda la lógica del dominio, pero no se encarga del acceso a datos. Para acceder a los datos se utiliza la pasarela a tabla de datos mostrada anteriormente.
Las clases necesarias tendrán como nombre nombreclaseModule.java y residirá en el directorio 
../src/domain/.

##Capa de presentación
El servicio de averias ha sido implementado mediante controladores de página, en donde cada página se implementa como un controlador individual. La clase general para definir los controladores se llama PageController.java y debe residir en el directorio ,,/src/display/.

###El controlador
Los controladores de página son los que permiten mostrar los objetos. Estos archivos residen en el mismo directorio ../src/display/.

###La plantilla JSP
Adicionalmente se utilizará, con el controlador anterior, una plantilla JSP para realizar el formateo de página en código HTML. El nombrecontrolador.jsp se encarga de esta tarea y residirá en el directorio ../averias/.

##Configuración del contexto
El framework Spring permite crear archivos xml que definen la configuración del contexto de ejecución de la aplicación. El archivo de configuración llamado context.xml se deberá ubicar en el directorio ../averias/WEB-INF/.
Los aspectos importantes que se pueden observar en este archivo son la declaración de una instancia (singleton) al constructor de pasarelas y la declaración de la fuente de datos JDBC.
Precisamente para configurar la fuente de datos se utilizará un archivo de propiedades llamado jdbc.properties y que residirá en el directorio ../averias/WEB-INF. 

##Configuración del servidor
El servidor de servlets requiere del archivo de configuración de la aplicación para conocer en donde se ubica la clase a ejecutar. Además este archivo permite indicar la ubicación y nombre del archivo de contexto. Estos archivos de configuración del servlet siempre se llaman web.xml y deben residir en el directorio ../averias/WEB-INF/.

##Librerías requeridas
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