### ADR 01: Elección de la Arquitectura del Sistema (Clean Architecture)

* **Título:** Patrón Arquitectónico en Capas Limpias (Clean Architecture) y Aislamiento del Dominio
* **Estatus:** `ACEPTADO`
* **Contexto:** El sistema interactúa con cuatro tipos de actores con lógicas totalmente independientes (Estudiantes, Empresas, Coordinadores Académicos y Dirección Financiera). Adicionalmente, el sistema requiere soportar una alta transaccionalidad en operaciones concurrentes. Si acoplamos la lógica de negocio directamente a los frameworks web o a las librerías de persistencia, cualquier cambio tecnológico (como cambiar la UI de la App Web) forzaría una reescritura masiva de las validaciones core del sistema.
* **Decisión:** Adoptar los principios de **Clean Architecture**, dividiendo rígidamente la lógica de la aplicación en las siguientes tres capas fundamentales:
    1. **Capa de Presentación / Controladores (`Controller`):** Encargada únicamente de capturar las peticiones HTTP/REST emitidas por la **App Web** (`UI`), validar sintaxis de entrada y delegar la carga de trabajo.
    2. **Capa de Dominio / Servicios (`Service`):** Contiene el núcleo puro del negocio (ej. verificar si un estudiante cumple el ciclo académico mínimo en el `CU19` antes de permitir la postulación). Es independiente de frameworks y bases de datos.
    3. **Capa de Infraestructura / Repositorios (`Repository`):** Implementa el acceso físico a componentes externos, como la ejecución de sentencias SQL en la base de datos o almacenamiento de archivos.

#### Consecuencias
* **Positivas:**
    * **Mantenibilidad:** Las reglas institucionales para validar convenios (`CU14`, `CU15`) se mantienen intactas aunque la interfaz de usuario cambie por completo.
    * **Testabilidad:** Permite realizar pruebas unitarias automatizadas sobre las clases de servicio sin levantar servidores web ni bases de datos reales.
* **Negativas:**
    * **Curva de Aprendizaje:** Requiere que el equipo de desarrollo entienda el flujo y mapeo de datos e interfaces entre capas limpias.

---