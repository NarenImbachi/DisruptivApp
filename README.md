# Proyecto de Gestión de Tíquets

Este proyecto es una aplicación para la gestión de tíquets, desarrollada como parte de una prueba técnica. La aplicación está actualmente en construcción y se ha enfocado en establecer una arquitectura sólida y escalable.

## Estructura del Proyecto y Arquitectura Hexagonal

El proyecto sigue los principios de la **Arquitectura Hexagonal** (también conocida como Arquitectura de Puertos y Adaptadores). Esta arquitectura nos permite aislar la lógica de negocio de los detalles de infraestructura, lo que facilita la mantenibilidad, la escalabilidad y las pruebas del sistema.

La estructura del proyecto se organiza de la siguiente manera:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── disruptiv/
│   │           └── tikets/
│   │               ├── TiketsApplication.java      # Punto de entrada de la aplicación Spring Boot
│   │               ├── app/                        # Capa de Aplicación
│   │               │   ├── input/                  # Puertos de entrada (interfaces)
│   │               │   ├── out/                    # Puertos de salida (interfaces)
│   │               │   └── service/                # Lógica de orquestación de casos de uso
│   │               ├── domain/                     # Capa de Dominio
│   │               │   ├── enums/                  # Enumeraciones del dominio
│   │               │   └── model/                  # Entidades y objetos de valor del dominio
│   │               └── infra/                      # Capa de Infraestructura
│   │                   ├── input/                  # Adaptadores de entrada (controladores REST)
│   │                   │   ├── controller/
│   │                   │   ├── dto/
│   │                   │   └── mapper/
│   │                   └── out/                    # Adaptadores de salida (persistencia)
│   │                       ├── adapter/
│   │                       ├── entidades/
│   │                       ├── mapper/
│   │                       └── repos/
│   └── resources/
│       └── application.yaml                      # Configuración de la aplicación
└── test/                                           # Pruebas
```

### Explicación de la Arquitectura

-   **Capa de Dominio (`domain`):** Contiene la lógica de negocio pura y las entidades principales. No tiene dependencias de ninguna otra capa. Aquí se encuentran los modelos `Tiket` y `Usuario`.
-   **Capa de Aplicación (`app`):** Orquesta los casos de uso del sistema. Define los **puertos de entrada** (interfaces como `ITiketInputPort`) que exponen la funcionalidad, y los **puertos de salida** (interfaces como `ITiketOutputPort`) que definen las necesidades de persistencia o comunicación externa. Los servicios de aplicación (`TiketService`) implementan los puertos de entrada y utilizan los puertos de salida.
-   **Capa de Infraestructura (`infra`):** Contiene los adaptadores que interactúan con el mundo exterior.
    -   **Adaptadores de Entrada (`infra/input`):** En este caso, se ha implementado un adaptador para la API REST, que incluye controladores, DTOs y mappers.
    -   **Adaptadores de Salida (`infra/out`):** Implementan los puertos de salida. En este proyecto, el adaptador de salida se encarga de la persistencia en la base de datos. Incluye los repositorios (JPA), las entidades de base de datos y los mappers para convertir entre entidades de dominio y entidades de persistencia.

## Entidades del Dominio

Las entidades principales del sistema son:

### Tiket

Representa un tíquet de soporte o tarea.

-   `id`: Identificador único.
-   `titulo`: Título del tíquet.
-   `descripcion`: Descripción detallada.
-   `estado`: Estado actual del tíquet (`ABIERTO`, `EN_PROGRESO`, `CERRADO`).
-   `prioridad`: Prioridad del tíquet (`BAJA`, `MEDIA`, `ALTA`).
-   `fechaCreacion`: Fecha de creación.
-   `usuarioAsig`: Usuario asignado al tíquet.

### Usuario

Representa a un usuario del sistema.

-   `id`: Identificador único.
-   `nombre`: Nombre del usuario.
-   `email`: Correo electrónico del usuario.

---

*Este proyecto fue desarrollado en el tiempo establecido para una prueba técnica, demostrando la capacidad de aplicar patrones de arquitectura de software limpios y escalables.*
