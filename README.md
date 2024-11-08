# pruebaTecnica

## Descripción

Implementación de servicio que permite lanzar consultas para obtener el precio de un producto en una fecha y horario específico. El servicio recibe por parámetro el id del producto el id de la marca y el horario a consultar. La aplicación selecciona el precio que corresponda para el producto según el horario proporcionado y devuelve la tarifa con mayor prioridad.

## Tecnologías y Librerías

La aplicación utiliza las siguientes tecnologías y dependencias:

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Data JPA**
- **H2 Database** 
- **JUnit y MockMvc**

## Arquitectura y Patrones de Diseño

### 1. Arquitectura en Capas

- **Capa de Controlador (Controller)**: Maneja las peticiones HTTP y delega la lógica de negocio a la capa de servicio. Está representada por la clase `PriceController`.
- **Capa de Servicio (Service)**: Contiene la lógica de negocio. Está representada por la interfaz `PriceService`.
- **Capa de Repositorio (Repository)**: Interactúa con la base de datos mediante JPA. Define métodos de consulta a través de `PriceRepository`.

### 2. Patrones de Diseño

- **Data Transfer Object (DTO)**: Usado para manejar los datos de entrada y salida, asegurando que la estructura de los datos esté controlada y documentada.
- **Clean Code & SOLID Principles**: Se han aplicado principios de código limpio, asegurando que el código sea fácil de entender, extender y mantener. Cada clase y método tiene una sola responsabilidad, y las dependencias se gestionan mediante inyección.

### 3. Modelo de Base de Datos en Memoria

La base de datos H2 está configurada en memoria y se inicializa automáticamente con el conjunto de datos de ejemplo en la tabla `PRICES`.

## Uso

La aplicación contiene un endpoint REST para consultar los precios de productos en un horario concreto.

### Endpoint

#### Request

- **Método**: `GET`
- **URL**: `/api/prices`
- **Parámetros de Consulta**:
  - `productId`: Identificador único del producto (ejemplo: `35455`).
  - `brandId`: Identificador de la cadena o marca (ejemplo: `1`).
  - `applicationDate`: Fecha de consulta en formato ISO 8601 (ejemplo: `2020-06-14T10:00:00`).

#### Respuesta

Si se encuentra un precio aplicable la aplicación devuelve un JSON con los datos del producto junto con la tarifa.

- **Ejemplo de respuesta encontrada**: 
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 1,
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 35.50,
  "currency": "EUR"
}

En caso de no encontrar una tarifa válida para la fecha solicitada la API devolverá un error 404 NOT FOUND.

## Pruebas

El proyecto incluye tests para validar el correcto funcionamiento del servicio en diferentes escenarios:

-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
-          Test 6: petición a las 21:00 del día 31/12/2021 del producto 35455   para la brand 1 (ZARA)

Los tests se han implementado utilizando JUnit y MockMvc.