# Series Backend API Spring Boot
Este proyecto es una API REST para gestionar series, incluyendo sus temporadas, capítulos, actores y personajes.

## Requisitos previos

Java 17 o superior
Maven
MySQL/PostgreSQL (configura la base de datos en application.properties)

# Configuración del proyecto

Clona el repositorio:
```bash
clone [URL_DEL_REPOSITORIO]
```

Navega al directorio del proyecto:
```bash

cd series
```

Compila el proyecto:
```bash
mvn clean install
```

Ejecuta la aplicación:
```bash
mvn spring-boot:run
```

La aplicación estará disponible en http://localhost:8080.



## Guía de uso de la API
Orden recomendado para crear recursos
Para utilizar correctamente la API, se recomienda seguir este orden al crear los recursos:

1. Crear una serie
2. Crear temporadas para la serie
3. Crear capítulos para cada temporada
4. Añadir imágenes a los capítulos
5. Crear actores
6. Crear personajes y asociarlos a la serie y a los actores


## Endpoints disponibles

### Series (The Mandalorian ya fue creada, puedes usarla para crear temporadas, capítulos, actores y personajes)

Crear una serie:

```http POST /series
Content-Type: application/json

{
    "nombre": "The Mandalorian",
    "descripcion": "Un cazarrecompensas mandaloriano viaja por los confines de la galaxia, lejos de la autoridad de la Nueva República",
    "creador": "Jon Favreau",
    "clasificacion": "TV-14",
    "numeroTemporadas": 3,
    "anioEmision": 2019,
    "imagenPoster": "https://ejemplo.com/mandalorian-poster.jpg",
    "temporadas": [],
    "personajes": [],
    "actores": []
}


```

Obtener una serie:

```
http GET /series/{id}
```

### Temporadas
Crear una temporada:

```http POST /temporadas
Content-Type: application/json

{
    "numeroTemporada": 1,
    "anioLanzamiento": 2019,
    "serieId": 1,
    "capitulos": []
}
```

Obtener una temporada:

```
http GET /temporadas/{id}
```

### Capítulos

Crear un capítulo:

```http POST /capitulos
Content-Type: application/json


{
    "numeroCapitulo": 1,
    "nombre": "El Mandaloriano",
    "descripcion": "Un mandaloriano solitario viaja a los confines de la galaxia en busca de su próximo objetivo",
    "calificacionPromedio": 4.9,
    "temporadaId": 1
}
```

Obtener un capítulo:

```
http GET /capitulos/{id}
```

### Imágenes de Capítulos

Crear una imagen para un capítulo:

```
http POST /imagenes-capitulos
Content-Type: application/json

{
    "url": "https://ejemplo.com/mandalorian-cap1.jpg",
    "capituloId": 1
}
```

Obtener una imagen:

```
http GET /imagenes-capitulos/{id}
```

Listar todas las imágenes:

```http GET /imagenes-capitulos```

Listar imágenes de un capítulo específico:

```http GET /imagenes-capitulos/capitulo/{capituloId}```


### Actores

Crear un actor:

```
http POST /actores
Content-Type: application/json

{
    "nombre": "Pedro Pascal",
    "biografia": "Actor chileno-estadounidense conocido por sus roles en Game of Thrones, Narcos y The Mandalorian",
    "foto": "https://ejemplo.com/pedro-pascal.jpg",
    "personajes": [],
    "series": []
}
```

### Obtener un actor:
```
http GET /actores/{id}
```


### Personajes

Crear un personaje:

```http POST /personajes
Content-Type: application/json

{
    "nombre": "Din Djarin",
    "descripcion": "Un cazarrecompensas mandaloriano que se convierte en el protector de Grogu",
    "foto": "https://ejemplo.com/din-djarin.jpg",
    "serieId": 1,
    "actorId": 1
}
```

### Obtener un personaje:

```
http GET /personajes/{id}
```


## Notas adicionales

- Todos los endpoints devuelven respuestas en formato JSON
- Los IDs son generados automáticamente por la base de datos
- Asegúrate de usar IDs válidos al crear relaciones entre entidades
- Las solicitudes POST deben incluir el header Content-Type: application/json

## Manejo de errores
La API devuelve los siguientes códigos de estado HTTP:

200: Operación exitosa
201: Recurso creado exitosamente
404: Recurso no encontrado
400: Solicitud incorrecta
500: Error interno del servidor