# Sistema de Gestion de Inventarios (Backend)
## ¿De qué trata el proyecto?
El Sistema de Gestión de Inventarios es una página web hecha para gestionar el stock de productos dentro de un comercio.
Este Sistema permite:
- Consultar productos existentes
- Registrar productos nuevos
- Modificar o Eliminar productos existentes
## Tecnologias usadas (Backend)
Para la parte Backend de este proyecto se decidio utilizar el lenguaje Java gracias a su portabilidad y escalabilidad.
Por otra parte, tambien se utilizo el Framework de Spring Boot para reducir el codigo repetitivo y para integrar una API RESTful.
Los datos persisten en la base de datos relacional MySQL.
## Cómo instalarlo y correrlo
1. Descargar/clonar el repositorio
```
git clone https://github.com/TejonCosmico/Sistema-de-Inventarios-Backend.git
```
2. Situarse en el carpeta ./Sistema-de-Inventarios-Backend
3. Ejecutar el comando
```
.\mvnw spring-boot:run
```
El proyecto para este punto va a estar corriendo en `http://localhost:8080`.
El puerto por defecto en el `8080`, pero se puede configurar en el archivo `src\main\resources\application.properties`. Para modificar el puerto agregar la linea `server.port=8080` (reemplazar 8080 por el puerto deseado).
## Ejemplo
Un ejemplo de utilizacion para este proyecto podria ser un Kiosko que quiere migrar su inventario de una planilla de papel a una base de datos. Como primer paso pasa sus existencias para ser guardadas en la base de datos. Una vez migrados los articulos le va a asegurar la persistencia de los mismos y va a tener la capacidad de eliminar o modificar cuando quiera.
