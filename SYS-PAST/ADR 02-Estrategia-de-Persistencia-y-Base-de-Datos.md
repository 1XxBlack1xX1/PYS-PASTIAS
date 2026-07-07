### ADR 02: Estrategia de Persistencia y Consistencia de Datos

* **Título:** Persistencia Basada en Sistema Relacional (RDBMS - PostgreSQL) con Control ACID
* **Estatus:** `ACEPTADO`
* **Contexto:** El ciclo de vida de un proceso de pasantía involucra un fuerte entrelazado de restricciones lógicas y relacionales. Un estudiante no puede postular (`CU19`) si la vacante no está publicada (`CU18`); a su vez, una vacante no puede publicarse si la empresa matriz no está activa (`CU08`). Además, la gestión financiera y contable del sistema (`CU01`, `CU22`) demanda una exactitud matemática absoluta para evitar inconsistencias en saldos o estados de morosidad.
* **Decisión:** Utilizar un **Sistema de Gestión de Bases de Datos Relacionales (RDBMS)** impulsado por PostgreSQL, gestionado a través de un mapeador objeto-relacional (ORM). Queda estrictamente prohibida la eliminación física de registros maestros; en su lugar, se implementará un patrón de **Eliminación Lógica** empleando banderas booleanas (ej. cambiar atributo `activo = false` en el `CU10`).

#### Consecuencias
* **Positivas:**
    * **Integridad Referencial Garantizada:** La base de datos rechaza de forma nativa cualquier intento de alteración que viole las llaves foráneas.
    * **Transacciones Fuertes (ACID):** Operaciones complejas como el cierre de un proceso (`CU28`) y la emisión simultánea de constancias (`CU27`) se ejecutan bajo bloques transaccionales atómicos.
* **Negativas:**
    * **Rigidez de Esquema:** Cualquier modificación estructural de los datos requiere la planeación y despliegue de scripts secuenciales de migración de base de datos.

---