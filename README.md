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

Para ejecutar el backend, es necesario situarse en la carpeta /backend y escribir el comando:
- mvn spring-boot:run

Lo cual despliega el backend en la ruta /localhost:8080

Para ejecutar el frontend, es necesario situarse en la carpeta /frontend y escribir los comandos:
- npm install
- npm run serve

Lo cual despliega el frontend en la ruta /localhost:8081

Mientras que para el caso de la base de datos, basta con crearla utilizando la plataforma PgAdmin4.

## Características de los sistemas distribuidos

|Característica|Descripción|¿El sistema lo posee?|
|--------------|-----------|---------------------|
|Escalabilidad|-|-|
|Transparencia|-|-|
|Disponibilidad|-|-|
|Apertura|-|-|

## Pruebas y resultados

Pruebas y resultados

