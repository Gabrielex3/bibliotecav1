Perfecto, aquí tienes el **README completo y listo para la rama `V2`**, con todos los endpoints, búsquedas avanzadas y ejemplos, listo para pegar en tu repositorio:

---

# 📚 Sistema de Gestión de Biblioteca (V2)

## 📌 Descripción

Este proyecto consiste en una biblioteca desarrollada en IntelliJ IDEA que permite gestionar una colección de libros mediante una API REST en localhost. El sistema implementa funcionalidades para crear, eliminar, actualizar y consultar libros almacenados en una lista o estructura de datos.

Además, incorpora búsquedas avanzadas como filtrado por autor, ISBN, año de publicación y análisis cronológico de los libros.

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

### 📖 Gestión básica

* ➕ Crear libros
* ❌ Eliminar libros
* ✏️ Actualizar libros
* 📚 Obtener lista de libros

### 🔍 Búsquedas y consultas avanzadas

* 🔎 Buscar un libro por ISBN
* 👤 Buscar libros por autor
* 📅 Obtener cantidad de libros publicados en un año específico
* ⏳ Obtener el libro más antiguo (según fecha de publicación)
* 🚀 Obtener el libro más nuevo
* 📊 Listar todos los libros ordenados por año de publicación

---

## 🌐 Endpoints de la API

**URL base:** `http://localhost:8080/api/v1/libros`

| Método | Endpoint                                       | Descripción                             |
| ------ | ---------------------------------------------- | --------------------------------------- |
| GET    | /api/v1/libros                                 | Listar todos los libros                 |
| GET    | /api/v1/libros/buscador/id/{id}                | Buscar libro por ID                     |
| POST   | /api/v1/libros                                 | Agregar un libro                        |
| PUT    | /api/v1/libros/id/{id}                         | Actualizar un libro                     |
| DELETE | /api/v1/libros/buscador/id/{id}                | Eliminar un libro                       |
| GET    | /api/v1/libros/total                           | Total de libros                         |
| GET    | /api/v1/libros/buscador/isbn/{strb}            | Buscar libro por ISBN                   |
| GET    | /api/v1/libros/buscador/getAnioLista/{year}    | Listar libros publicados en un año      |
| GET    | /api/v1/libros/buscador/getAnioContador/{year} | Contador de libros publicados en un año |
| GET    | /api/v1/libros/buscador/getForAutor/{autor}    | Buscar libro por autor                  |
| GET    | /api/v1/libros/buscador/masAntiguo             | Obtener el libro más antiguo            |
| GET    | /api/v1/libros/buscador/masNuevo               | Obtener el libro más nuevo              |

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar la rama `V2` del repositorio:

```bash
git clone -b V2 https://github.com/Gabrielex3/bibliotecav1.git
```

2. Abrir el proyecto en IntelliJ IDEA

3. Ejecutar la aplicación (clase principal de Spring Boot)

4. El servidor se iniciará en:

```text
http://localhost:8080
```

---

## 🧪 Ejemplo de uso (API en localhost)

### 🔹 Listar todos los libros

```http
GET http://localhost:8080/api/v1/libros
```

### 🔹 Crear un libro

```http
POST http://localhost:8080/api/v1/libros
Content-Type: application/json
```

```json
{
  "id": 1,
  "titulo": "El Principito",
  "autor": "Antoine de Saint-Exupéry",
  "isbn": "1234567890",
  "anioPublicacion": 1943
}
```

### 🔹 Actualizar un libro

```http
PUT http://localhost:8080/api/v1/libros/id/1
```

```json
{
  "id": 1,
  "titulo": "El Principito (Actualizado)",
  "autor": "Antoine de Saint-Exupéry",
  "isbn": "1234567890",
  "anioPublicacion": 1943
}
```

### 🔹 Eliminar un libro

```http
DELETE http://localhost:8080/api/v1/libros/buscador/id/1
```

### 🔹 Buscar libro por ISBN

```http
GET http://localhost:8080/api/v1/libros/buscador/isbn/1234567890
```

### 🔹 Buscar libro por autor

```http
GET http://localhost:8080/api/v1/libros/buscador/getForAutor/Antoine%20de%20Saint-Exupéry
```

### 🔹 Listar libros por año

```http
GET http://localhost:8080/api/v1/libros/buscador/getAnioLista/1943
```

### 🔹 Contar libros por año

```http
GET http://localhost:8080/api/v1/libros/buscador/getAnioContador/1943
```

### 🔹 Libro más antiguo

```http
GET http://localhost:8080/api/v1/libros/buscador/masAntiguo
```

### 🔹 Libro más nuevo

```http
GET http://localhost:8080/api/v1/libros/buscador/masNuevo
```

---

## 🧩 Estructura del proyecto

```text
src/
 ├── controller/   // Controladores REST
 ├── model/        // Clases (Libro)
 ├── service/      // Lógica de negocio
 └── main/         // Clase principal
```

---

## 👤 Autor

* Gabriel Exe

---

## 📌 Notas y mejoras futuras

Este proyecto puede mejorarse agregando:

* Base de datos (MySQL, PostgreSQL)
* Validaciones de datos
* Manejo de excepciones global
* Seguridad (Spring Security)
* Documentación con Swagger/OpenAPI
* Paginación y filtrado avanzado

---


