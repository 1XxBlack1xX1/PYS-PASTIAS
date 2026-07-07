# ADR 002: Uso de Arquitectura Hexagonal en Microservicios para el Sistema de Administración de Pasantías

## Estado
Aceptado

## Fecha
2026-07-07

## Contexto
El **Sistema de Administración de Pasantías** requiere gestionar de manera altamente escalable y segura los ciclos de vida de las prácticas preprofesionales de los estudiantes. Esto involucra la interacción de múltiples actores con necesidades cambiantes: la institución académica (coordinadores y tutores), los estudiantes y las organizaciones/empresas externas. Debido a la naturaleza del sistema, se ha dividido en un ecosistema de **Microservicios** independientes (por ejemplo: Microservicio de Estudiantes, Microservicio de Empresas y Convenios, Microservicio de Evaluaciones y Reportes).

Sin embargo, las reglas académicas y los procesos de validación de las pasantías (cómputo de horas, aprobación de planes de trabajo, estados de convenios) son altamente propensos a cambiar según las normativas institucionales. Existía el riesgo de que estas reglas de negocio centrales se acoplaran directamente a la infraestructura tecnológica (como el framework Spring Boot, bases de datos relacionales para expedientes o NoSQL para bitácoras, y protocolos de comunicación como REST o sistemas de mensajería para notificaciones). Si la tecnología de persistencia cambiaba o se requería probar las reglas de aprobación sin depender de una base de datos activa, el acoplamiento haría que la evolución del sistema fuera costosa y compleja.

Se evaluó la estructura interna de los microservicios bajo dos enfoques:
1. **Diseño tradicional en capas:** Desarrollo rápido, pero con un alto riesgo de mezclar la lógica de validación académica de pasantías con anotaciones del framework o consultas directas a la base de datos.
2. **Diseño de Arquitectura Hexagonal (Puertos y Adaptadores):** Desacoplamiento total del núcleo del negocio de las pasantías, permitiendo que las reglas de asignación, evaluación y control cambien de forma independiente a los mecanismos de almacenamiento o interfaces de usuario.

## Decisión
Hemos decidido adoptar la **Arquitectura Hexagonal** de manera estricta para el diseño interno de **cada microservicio del Sistema de Administración de Pasantías**.

La estructura interna de cada componente se dividirá de la siguiente manera:
* **Dominio / Core (Gestión de Pasantías):** Contiene la lógica pura del negocio académico. Incluye las entidades principales (`Estudiante`, `Pasantia`, `Empresa`, `Tutor`, `Evaluacion`) y las reglas comerciales (validación de horas mínimas, verificación de vigencia de convenios, estados de aprobación de informes), totalmente aisladas de frameworks, librerías web o de persistencia.
* **Puertos (Ports):** Interfaces que definen los contratos del sistema. Los puertos de entrada (*Inbound/Driving*) exponen los casos de uso específicos del negocio (ej. `PostularAPasantia`, `EvaluarDesempeño`, `GenerarReporteFinal`). Los puertos de salida (*Outbound/Driven*) definen los contratos necesarios para la persistencia o integraciones (ej. `PasantiaRepositoryPort`, `NotificacionServicePort`).
* **Adaptadores (Adapters):** Implementaciones técnicas externas. 
  * Los adaptadores de entrada (*Driving*) exponen las API REST para los portales web del estudiante y la empresa, o controladores de eventos para la recepción de solicitudes.
  * Los adaptadores de salida (*Driven*) gestionan el acceso a las bases de datos (ej. mediante Spring Data JPA para PostgreSQL o MongoDB), el almacenamiento de archivos (ej. cartas de aceptación en PDFs) y las llamadas HTTP o colas de mensajería para notificar a los usuarios.

## Consecuencias

### Positivas (Beneficios)
* **Aislamiento de la Lógica Académica:** Los cambios en los reglamentos internos de pasantías de la institución se pueden implementar modificando únicamente el Dominio, sin alterar los controladores web ni la base de datos.
* **Flexibilidad Tecnológica y Multi-inquilino:** Permite migrar o diversificar el almacenamiento (por ejemplo, guardar los documentos firmados en una nube o localmente) cambiando solo un adaptador de salida, manteniendo intacto el flujo de aprobación del sistema.
* **Facilidad de Pruebas Automatizadas (Mocks):** Facilita la realización de pruebas unitarias robustas sobre los flujos críticos (como el cálculo correcto de horas acumuladas por el alumno) simulando el comportamiento de las bases de datos o servicios de autenticación mediante los puertos.
* **Autonomía de los Microservicios:** Cada módulo del flujo de la pasantía (Postulación, Seguimiento, Certificación) evoluciona a su propio ritmo técnico.

### Negativas (Compensaciones / Trade-offs)
* **Duplicidad de Modelos e Incremento de Mapeadores:** Al separar estrictamente las capas, es obligatorio transformar los datos constantemente: de los DTOs de la API REST a Objetos de Dominio (`Pasantia`), y de estos a Entidades de base de datos (`PasantiaEntity`). Esto añade código repetitivo (*boilerplate*) y requiere el uso de librerías de mapeo (como MapStruct).
* **Curva de Aprendizaje y Mayor Número de Archivos:** El equipo de desarrollo debe adaptarse a trabajar con una estructura de paquetes rigurosa por cada microservicio. Una funcionalidad simple requiere la creación de interfaces (puertos), implementaciones (adaptadores) y modelos separados, aumentando el tiempo inicial de desarrollo.

esto cambialo todo a monolito, todo lo que diga microservicios cambialo a monolito porque estamos trabajando con monolito y no microservicios