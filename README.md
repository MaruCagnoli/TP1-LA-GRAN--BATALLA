# TP1-LA-GRAN--BATALLA
Trabajo práctico de Laboratorio V


1- Que es Maven?
Maven es una herramienta de software para la gestión y 
construcción de proyectos creada en el año 2002. 
Su modelo de configuración de construcción es simple y está basado en formato XML.
Maven utiliza un Proyect Object Model(POM) para describir el proyecto de software
a construir, sus dependencias de otro módulos y componentes externos, y el orden de 
construcción de sus elementos.
Maven es una de las herramientas más útiles a la hora de utilizar librerías de terceros.
Posee la capacidad de realizar ciertas tareas claramente definidas, como la compilación del
código y su empaquetado.
Todas las dependencias del proyecto se definen  en un fichero propio, el POM. 
POM es un archivo en formato XML que contiene todo lo que el programador o equipo de
trabajo necesita para que a la hora de generar el fichero ejecutable de una aplicación
este contenga todo lo necesario para su ejecución en su interior.
Maven tiene una gran capacidad para trabajar en red. Cuando definimos las dependencias,
Maven se encargará de ubicar las librerías que deseamos utilizar en Maven Central, el
cual es un repositorio que contiene cientos de librerías constantemente actualizadas
por sus creadores. Gracias a Maven todo se hace de manera automática sin tener que hacer
nada más que definir las dependencias a utilizar en un determinado proyecto.

2 - POM qué significa y para que nos sirve?
La sigla POM significa Proyect Object Model. Con POM hacemos una descripción del proyecto.
Es decir, decimos de qué se compone nuestro proyecto(nombre, versión, librerías de las 
que depende, etc) y Maven se encarga de hacer todas las tareas por nosotros. POM es un 
archivo en formato XML. 
Requisitos mínimos para un POM:
- raíz del proyecto
- modelVersion 
- groupId - el id del grupo del proyecto.
- artifact - el id del proyecto.
- versión: la versión del artefacto en el grupo especificado.

3 - Diferencia entre Archetype y ArtifacId.
Artifact se utiliza para denominar la unidad mínima que maneja el repositorio del usuario.
Puede ser un jar, un ear, un zip, etc. Cuando Maven compila y empaqueta un código, 
produce también artifacts que instala en el repositorio. El funcionamiento de Maven
se basa en el uso de un repositorio donde ir a buscar las dependencias. La identificación
de los artefactos que necesita se hace a través de GroupId, ArtifactId, Version.
Por su parte Archetype (Arquetipo), es una estructura que permite describir y administrar un proyecto con Maven.
Asegura además que el proyecto tenga los pom.xml que le corresponden.
Estas plantillas son llamadas arquetipos y el plugin que permite la generación a partir
de los arquetipos se llama también archetype.
Se componen por un directorio resources que contiene todos los archivos y directorios
que contendrá el proyecto generado y un descriptor en xml.


