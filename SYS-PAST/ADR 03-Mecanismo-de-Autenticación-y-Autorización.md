### ADR 03: Mecanismo de Autenticación, Sesiones y Control de Accesos

* **Título:** Autenticación Descentralizada con Stateless JWT y Control de Acceso Basado en Roles (RBAC)
* **Estatus:** `ACEPTADO`
* **Contexto:** El sistema expone endpoints e interfaces críticas para múltiples actores concurrentes externos. Dado que los privilegios varían drásticamente de un rol a otro (por ejemplo, un jefe de empresa externo bajo ningún concepto puede alterar los registros contables del `CU01` ni asignar supervisores en el `CU24`), se necesita un control estricto. El uso tradicional de sesiones en memoria del servidor (Stateful Sessions) degrada severamente el rendimiento y limita la capacidad del sistema de escalar de manera elástica.
* **Decisión:** Implementar un modelo de seguridad **Stateless** (sin estado en servidor) basado en fichas de seguridad **JSON Web Tokens (JWT)**. El flujo operativo se define de la siguiente forma: El usuario se autentica en el controlador (`CU02`), el servicio genera un token firmado criptográficamente que incluye el ID del usuario y su rol explícito (`ADMIN`, `ESTUDIANTE`, `EMPRESA`, `COORDINADOR`), y la App Web almacena e inyecta este token en las cabeceras HTTP de las peticiones subsecuentes, donde es validado por un filtro RBAC.

#### Consecuencias
* **Positivas:**
    * **Escalabilidad Total:** El servidor backend no retiene estados ni consume RAM guardando sesiones de usuarios conectados.
    * **Seguridad Granular:** Se implementa autorización decorada directamente a nivel de los métodos de los controladores mediante anotaciones de rol.
* **Negativas:**
    * **Complejidad en Revocación:** Una vez emitido un token JWT, es válido hasta su expiración. Para invalidarlo de forma inmediata por emergencias, se debe integrar una caché de lista negra (Blacklist).

---