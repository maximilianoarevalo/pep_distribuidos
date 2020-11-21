# Pep 1: Sistemas Distribuidos

Integrantes:
- Maximiliano Arévalo Sáez
- Juan Fernández Muñoz

## Contexto

En la actualidad muchos sistemas de información, aplicaciones, sistemas web de uso general,
entre otros; se han desarrollado sobre contextos de cubicación o estimación de la demanda
computacional que tendrían dichos sistemas en contextos normales (ej: Web registro civil,
comisaría virtual carabineros, sistemas de emergencias, entre otros).

Ahora bien, si llevamos estos sistemas legados o heredados de contextos anteriores al contexto 
actual, en donde la demanda de consultas se incrementado (9 veces en consultas sobre recursos educativos,
60 % en compras en línea de insumos básicos, 30 % en compras de comercio que no son de primera necesidad), 
estos sistemas carecen de respuesta, quedando sin otorgar el servicio que deberían a los clientes, 
generando problemáticas mucho más complejas desde una perspectiva social y sistémica.

## Desarrollo y análisis de sistema legado

Para el desarrollo del primer entregable se utilizan las siguientes tecnologías:

-Frontend: Vue.js
-Backend: Springboot
-Base de Datos: PostgreSQL

Los cuales se utilizan para el desarrollo e implementación del entregable, considerando la arquitectura computacional indicada en el enunciado y mostrada a continuación:

## Funcionamiento del sistema

Para ejecutar el proyecto, es necesario utilizar dos consolas que permitan iniciar el funcionamiento del frontend y del backend, y contar con una base de datos para el funcionamiento de lo mencionado anteriormente.

Para ejecutar el backend, es necesario situarse en la carpeta "/backend" y escribir el comando:
- mvn spring-boot:run

Lo cual despliega el backend en la ruta "/localhost:8080"

Para ejecutar el frontend, es necesario situarse en la carpeta "/frontend" y escribir los comandos:
- npm install
- npm run serve

Lo cual despliega el frontend en la ruta "/localhost:8081"

Mientras que para el caso de la base de datos, basta con crearla utilizando la plataforma PgAdmin4.

## Características de los sistemas distribuidos

|Característica|Descripción|¿El sistema lo posee?|
|--------------|-----------|---------------------|
|Disponibilidad|Trata sobre la disponibilidad de los recursos, donde se tiene que facilitar a los usuarios el acceder a recursos remotos que permitan obtener un resultado.|El sistema no lo posee, porque actualmente se encuentra implementado de manera local y por ende no accede a recursos remotos. Además, si falla el dispositivo, una de las desventajas es que el sistema dejaría de responder y otra es que si se pierden los datos no sería posible ponerlos a disposición de una manera rápida.|
|Transparencia de la distribución|Se basa en hacer creer al usuario que los procesos y recursos que utiliza el sistema se encuentran dentro de la misma máquina, por lo que se le oculta que los componentes del sistema distribuido se ejecutan separados en diferentes máquinas.|El sistema no puede ser considerado transparente, ya que actualmente funciona de manera local y no se encuentra distribuido.|
|Apertura|Un sistema distribuido abierto es el que permite ofrecer servicios bajo reglas estándar de sintaxis y semántica que faciliten la comunicación entre componentes. Junto con realizar cambios e implementar nuevos servicios de manera sencilla sin generar complicaciones en el sistema.|El sistema lo posee, ya que cuenta con la comunicación estándar de los componentes de Frontend y Backend utilizando API REST, cumpliendo con lo requerido para la característica.|
|Escalabilidad|Un sistema es escalable si es capaz de aumentar o disminuir la cantidad de recursos según lo que se le demande en determinadas condiciones, es decir, aumentar o disminuir su capacidad de respuesta de manera dinámica. La escalibilidad puede ser horizontal, lo que implica que un sistema aumenta la cantidad de recursos, o vertical, que implica aumenta la capacidad de recursos.|El sistema no es escalable, ya que no tiene la posibilidad de asignar los recursos de manera dinámica en base a la demanda. Además, no es posible responder varias consultas a la vez debido a que se pueden producir cuellos de botella y tampoco se implementa caché, por lo que los tiempos de respuesta no se ven disminuidos.|

## Pruebas y resultados

Pruebas y resultados

