# Arquitectura Empresarial
Proyecto software para PROSA de manejo CMDB Oracle

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Este proyecto consta de dos rutas

  - Code: Aquí se aloja el proyecto back-end basada en Java + Spring Boot. Con conexión a la base de datos.
  - Front: Aquí se aloja la plicacion front-end, basada en React, que se conecta a la API.

# Despliegue Back- end
El proyecto ocupa Openshift para poder desplegarse, los pasos a seguir para desplegarlo son:
  1. Tener instalado openshift o minishift en algún servidor.
  2. Entrar a la plataforma openshift con el comando
  ```sh
$ oc login
```
  3. Entrar a el proyecto creado o crear un proyecto desde oc con:
 ```sh
$ oc project <nombre-proyecto>
```
  4. Desplegamos el primer microservicio llamado persistence ejemplo:
```sh
$ oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~https://repo-git.com/proyecto.git --context-dir=code/poc/poc-persistence  --name="persistence"
```
  5. Desplegamos el segundo microservicio llamado web ejemplo:
```sh
$ oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~https://repo-git.com/proyecto.git --context-dir=code/poc/poc-web --name="web" --env-file=\ruta\var-web.env
```
  6. Esperamos a que terminen de desplegarse
  7. Creamos una ruta para los microservicios

# Despliegue Front- end
El proyecto ocupa Openshift para poder desplegarse, los pasos a seguir para desplegarlo son:
  1. Tener instalado openshift o minishift en algun servidor.
  2. Entrar a la plataforma openshift con el comando
  ```sh
$ oc login
```
  3. Entrar a el proyecto creado o crear un proyecto desde oc con:
 ```sh
$ oc project <nombre-proyecto>
```
  4. Desplegamos el proyecto front ejemplo:
```sh
$ oc new-app https://repo-git.com/proyecto.git  --context-dir=front --name=front --env-file=\ruta\env-front.env
```
  6. Esperamos a que terminen de desplegarse
  7. Creamos una ruta para los microservicios

# Variables de entorno
Las variables de entorno están en dentro del proyecto en la carpeta environment-variables, en ella están tres archivos como sigue:
* env-front.env: Contiene las variables de entorno del proyecto Front-end. Donde se especifican los puntos de acceso a los microservicios persistence y web.
* var-persistence.env: Contiene las variables de entorno del microservicio persistence. Donde se declara los puntos de acceso y credenciales para entrar a la base de datos.
* var-web.env: Contiene las variables de entorno del microservicio web. Donde se especifican los valores y credenciales para acceso al LDAP.