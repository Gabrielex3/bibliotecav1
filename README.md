# 📚 Sistema de Gestión de Biblioteca (API REST)

## 📌 Descripción

Este proyecto es el backend de un sistema de biblioteca desarrollado en Java utilizando el framework Spring Boot. Permite gestionar una colección de libros y sus respectivos préstamos mediante una API REST local. El sistema almacena la información en memoria y expone rutas (endpoints) para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) completas.

Proyecto orientado a la aplicación de conceptos de Programación Orientada a Objetos (POO), arquitectura de software por capas (Controller, Service, Repository, Model) y diseño de APIs RESTful.

---

## ⚙️ Tecnologías Utilizadas

* **Lenguaje:** Java 21+
* **Framework:** Spring Boot
* **Herramientas:** Lombok (para reducción de código repetitivo)
* **Formato de datos:** JSON
* **Protocolo:** HTTP (GET, POST, PUT, DELETE)
* **Entorno de Desarrollo:** IntelliJ IDEA

---

## 🚀 Funcionalidades Principales

* 📖 **Gestión de Libros:** Registro, actualización, eliminación y listado general.
* 🤝 **Gestión de Préstamos:** Registro de préstamos vinculados automáticamente a la información completa del libro correspondiente.
* 🔍 **Búsquedas Personalizadas:** * Búsqueda por ID e ISBN.
  * Búsqueda por Autor.
  * Filtrado por año de publicación y conteo total.
  * Identificación del libro más antiguo y más nuevo.

---

## 🌐 Endpoints de la API

### 📚 Endpoints de Libros (`/api/v1/libros`)
| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| **GET** | `/api/v1/libros` | Lista todos los libros registrados |
| **GET** | `/api/v1/libros/buscador/id/{id}` | Busca un libro por su ID único |
| **POST** | `/api/v1/libros` | Crea un nuevo registro de libro |
| **PUT** | `/api/v1/libros/id/{id}` | Actualiza la información de un libro |
| **DELETE** | `/api/v1/libros/buscador/id/{id}` | Elimina un libro del sistema |
| **GET** | `/api/v1/libros/buscador/isbn/{isbn}` | Busca un libro por su código ISBN |
| **GET** | `/api/v1/libros/buscador/getForAutor/{autor}`| Lista libros de un autor específico |
| **GET** | `/api/v1/libros/buscador/getAnioLista/{year}`| Lista libros publicados en un año dado |

### 🤝 Endpoints de Préstamos (`/api/v1/prestamos`)
| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| **GET** | `/api/v1/prestamos` | Lista todos los préstamos activos |
| **GET** | `/api/v1/prestamos/{id}` | Muestra el detalle de un préstamo por ID |
| **POST** | `/api/v1/prestamos` | Registra un nuevo préstamo |
| **PUT** | `/api/v1/prestamos/{id}` | Modifica los datos de un préstamo |
| **DELETE** | `/api/v1/prestamos/{id}` | Cancela o elimina un préstamo |

---

## ▶️ Cómo ejecutar el proyecto en Localhost

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone [https://github.com/Gabrielex3/bibliotecav1/tree/V3.git](https://github.com/Gabrielex3/bibliotecav1/tree/V3.git)
