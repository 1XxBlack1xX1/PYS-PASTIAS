### ADR 05: Traza de Auditoría Regulatoria e Historial del Sistema

* **Título:** Inyección de Traza de Auditoría No Invasiva mediante Programación Orientada a Aspectos (AOP)
* **Estatus:** `ACEPTADO`
* **Contexto:** Por normativas gubernamentales y procesos de acreditación institucional, el sistema debe contar con un registro inalterable de auditoría (`CU23: Consultar Historial`). Es mandatorio rastrear exactamente quién y cuándo aprobó una postulación (`CU20`), asignó un supervisor (`CU24`), o emitió una constancia oficial (`CU27`). Mezclar el código de negocio puro con lógica manual de inserción de bitácoras degrada severamente la legibilidad y eleva el riesgo de omisión humana.
* **Decisión:** Centralizar el registro de auditoría mediante el uso del patrón arquitectónico de **Programación Orientada a Aspectos (AOP)**. Se creará un interceptor genérico (Aspecto de Auditoría) que escuchará de forma automática cualquier método mutador (`@Auditable` o patrones INSERT/UPDATE/DELETE) dentro de la capa de servicios. Cada vez que ocurra una mutación exitosa, el aspecto capturará el contexto (usuario, IP, método, parámetros) y disparará un hilo secundario asíncrono para registrar la bitácora en la base de datos.

#### Consecuencias
* **Positivas:**
    * **Código de Negocio Limpio (SRP):** Las clases de servicio se dedican enteramente a resolver las reglas de negocio de las prácticas, sin mezclar líneas destinadas a auditoría.
    * **Garantía de Cobertura Total:** Al estar automatizado por interceptores en tiempo de ejecución, se erradica la posibilidad de olvidar auditar un caso de uso clave por error humano.
* **Negativas:**
    * **Complejidad de Depuración:** Rastrear el flujo de la aplicación se vuelve más complejo para desarrolladores debido a la naturaleza oculta e interceptora de los aspectos.