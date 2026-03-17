# 📚 Sistema de Gestión de Biblioteca

## 📌 Descripción

Este proyecto consiste en una biblioteca desarrollada en IntelliJ IDEA que permite gestionar una colección de libros mediante una API REST en localhost. El sistema implementa funcionalidades para crear, eliminar, actualizar y consultar libros almacenados en una lista o estructura de datos.

Está orientado a practicar desarrollo backend, uso de APIs y conceptos de programación orientada a objetos (POO).

---

## ⚙️ Tecnologías utilizadas

* Java
* IntelliJ IDEA
* Spring Boot (API REST)
* JSON
* HTTP (GET, POST, PUT, DELETE)

---

## 🚀 Funcionalidades

* ➕ Crear libros
* ❌ Eliminar libros
* ✏️ Actualizar libros
* 📖 Obtener lista de libros

---

## 🌐 Endpoints de la API

| Método | Endpoint     | Descripción              |
| ------ | ------------ | ------------------------ |
| GET    | api/v1/libros      | Obtener todos los libros |
| GET    | api/v1/libros/{id} | Obtener libro por ID     |
| POST   | api/v1/libros      | Crear un libro           |
| PUT    | api/v1/libros/{id} | Actualizar un libro      |
| DELETE | api/v1/libros/{id} | Eliminar un libro        |

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

```
git clone https://github.com/Gabrielex3/bibliotecav1.git
```

2. Abrir el proyecto en IntelliJ IDEA

3. Ejecutar la aplicación (clase principal de Spring Boot)

4. El servidor se iniciará en:

```
http://localhost:8080
```

---

## 🧪 Ejemplo de uso (API en localhost)

### 🔹 Obtener todos los libros

```
GET http://localhost:8080/libros
```

### 🔹 Crear un libro

```
POST http://localhost:8080/libros
Content-Type: application/json
```

```json
{
  "id" : 1
  "titulo": "El Principito",
  "autor": "Antoine de Saint-Exupéry"
}
```

### 🔹 Actualizar un libro

```
PUT http://localhost:8080/libros/1
```

```json
{
  "id" : 1
  "titulo": "El Principito (Actualizado)",
  "autor": "Antoine de Saint-Exupéry"
}
```

### 🔹 Eliminar un libro

```
DELETE http://localhost:8080/libros/1
```

---

## 🧩 Estructura del proyecto

```
src/
 ├── controller/   // Controladores REST
 ├── model/        // Clases (Libro)
 ├── service/      // Lógica de negocio
 └── main/         // Clase principal
```

---

## 👤 Autor

* 

---

## 📌 Notas

Este proyecto puede mejorarse agregando:

* Base de datos (MySQL, PostgreSQL)
* Validaciones
* Seguridad (Spring Security)
* Documentación con Swagger
