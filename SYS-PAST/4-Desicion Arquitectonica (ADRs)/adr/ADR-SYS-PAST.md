# ADR 001: Uso de Arquitectura Monolítica Modular para el Sistema de Pasantías

## 📌 Estado
**Aceptado**

---

## 📅 Fecha
2026-07-07

---

## 📖 Contexto
La Escuela de Administración requiere un sistema centralizado para gestionar el ciclo de vida de las pasantías de los estudiantes (postulaciones, convenios con empresas, asignación de tutores académicos y evaluaciones).

Al analizar los requerimientos, se identificó que el sistema debe ser desarrollado e implementado de forma rápida, con costos de infraestructura controlados y por un equipo de desarrollo unificado. Además, los módulos del sistema (estudiantes, empresas y evaluaciones) requieren compartir datos constantemente de forma síncrona y con una fuerte consistencia transaccional (por ejemplo, no se puede evaluar a un estudiante si su convenio de pasantía no está aprobado en la base de datos).

Se evaluaron dos enfoques macro estructurales para el sistema:

1. **Arquitectura de Microservicios:** Ofrece alta autonomía de despliegue, pero introduce una gran complejidad en la red, gestión de bases de datos duplicadas y costos elevados de infraestructura que la Escuela no requiere en este momento.
2. **Arquitectura Monolítica Modular:** Concentra toda la aplicación en una única base de código y un solo despliegue, pero organizando el código internamente por "módulos" claros según el negocio de la Escuela de Administración, evitando que se transforme en un sistema desordenado.

---

## 🎯 Decisión
Hemos decidido adoptar una **Arquitectura Monolítica Modular** para el diseño e implementación del Sistema de Pasantías.

Toda la aplicación se empaquetará, compilará y desplegará como una única unidad funcional (un solo archivo ejecutable o contenedor), compartiendo una única base de datos relacional centralizada.

Para mantener el orden y evitar el "código espagueti", la estructura interna del monolito se organizará estrictamente bajo un esquema de **Capas Tradicionales por Módulo**:

* **Capa de Presentación / Interfaz de Usuario:** Controladores web, vistas (Thymeleaf/vistas del framework) y APIs para los estudiantes, empresas y personal administrativo de la escuela.
* **Capa de Lógica de Negocio (Servicios):** Contiene las reglas académicas de la Escuela de Administración (validación de créditos del pasante, flujos de aprobación de convenios y cálculo de notas de evaluación).
* **Capa de Acceso a Datos (Persistencia/DAO):** Mapeo de las entidades y consultas directas a la base de datos unificada del sistema.

La comunicación entre los diferentes módulos del negocio (como el módulo de Alumnos y el módulo de Pasantías) se realizará directamente en memoria a través de llamadas de código locales (invocación de métodos entre servicios), garantizando transacciones seguras y rápidas.

---

## ⚡ Consecuencias

### 👍 Positivas (Beneficios)
* **Despliegue y Operación Simplificados:** Al ser un único monolito, el proceso de despliegue (CI/CD) es sumamente sencillo. Solo se configura un servidor web y una única base de datos, reduciendo drásticamente los costos operativos para la institución.
* **Consistencia de Datos Inmediata:** Facilita la gestión de transacciones lógicas (ACID). Si la inscripción de una pasantía falla, se puede hacer un rollback automático de todo el proceso en la base de datos de forma nativa.
* **Desarrollo Inicial Veloz:** El equipo de desarrollo puede trabajar sobre un único proyecto, compartiendo librerías y componentes comunes sin la necesidad de gestionar APIs complejas de red o protocolos de mensajería asíncrona.
* **Refactorización Sencilla:** Modificar flujos que involucren a estudiantes y empresas es fácil y rápido a nivel de código, ya que todo el sistema reside en el mismo espacio de trabajo.

### 👎 Negativas (Desventajas / Riesgos)
* **Acoplamiento Potencial:** Al compartir la misma base de datos y proyecto, existe el riesgo de que los desarrolladores rompan las barreras de los módulos y creen dependencias circulares si no se supervisa el diseño del código.
* **Escalabilidad Unificada:** Si solo el módulo de "Postulaciones" recibe un tráfico masivo en una semana específica del año, se debe escalar e incrementar los recursos de todo el monolito completo, no solo de esa funcionalidad.
* **Punto Único de Fallo:** Si un error crítico (como una fuga de memoria en el módulo de reportes de administración) tira abajo la aplicación, todo el sistema de pasantías (incluyendo el acceso de alumnos y empresas) dejará de funcionar simultáneamente.