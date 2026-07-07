# Nivel 3: Diagrama de Componentes (C4 Model)

## Descripción General
Este diagrama desglosa el interior del contenedor de la **Aplicación Web (Monolito)**. Permite evidenciar cómo está estructurado modularmente el backend de la aplicación, dividiendo el sistema en componentes lógicos fuertemente cohesivos que aíslan las responsabilidades de cada conjunto de Casos de Uso.

## Componentes / Módulos Internos

* **Módulo de Empresas:** Centraliza la lógica para dar de alta, modificar y aplicar la baja lógica o inhabilitación de las organizaciones en el sistema (`CU-08`, `CU-09`, `CU-10`).
* **Módulo de Estudiantes:** Controla la gestión de expedientes de los alumnos, la edición de perfiles (como la carga de CV) y la consulta de estados académicos (`CU-11`, `CU-12`, `CU-13`).
* **Módulo de Convenios:** Controla el ciclo documental y de vigencia de las alianzas estratégicas institucionales con las empresas, incluyendo adendas y renovaciones (`CU-14`, `CU-15`).
* **Módulo de Vacantes y Postulaciones:** Gestiona el Core transaccional del negocio: creación de ofertas por las empresas, aprobación y publicación por parte del Director, postulación del alumno y los flujos de aceptación o rechazo (`CU-16` al `CU-21`).
* **Módulo de Seguimiento y Evaluación:** Administra el monitoreo del alumno en la empresa mediante la asignación de docentes, registro de bitácoras periódicas, cálculo automatizado de promedios de desempeño, emisión de constancias con código de verificación QR y cierre de procesos (`CU-24` al `CU-28`).

## Integración de Datos
Todos los componentes lógicos se comunican directamente con el contenedor de la Base de Datos Relacional de manera interna utilizando JDBC/JPA, aprovechando la transaccionalidad nativa para asegurar que las reglas de negocio (como no eliminar empresas con convenios activos) se cumplan de forma estricta.

---
_Nota: El
### Nivel_3_contenedores

![Diagrama del Sistema](https://www.plantuml.com/plantuml/png/TPJDRjiu4CVlUWgkJmuGnt4skyZkAMlPsBQeWS29Smt6rDYPb29LadBh57sO7dleARTU_M8TYb8Z6p8WWE9mFdxpvyUrys1zcQla3z9IbHcAH-yBz-zmQE7JsPhyOxai7Lffj4VjpwJ9XuK27M86pcUAbiFqSd0JJ8lP-s4EpgDbqqDgyiBe45E4_8adhr1C2DOMSX1SwRS7EZ4GCwED8c_2oWquphVx0Iv9KguCfD7sLxQ2o4v5xot_s1Ky1-U5Ay6IwR7vpHqZt3rkSrG8g-4SGVfWloVkqx6p4ev_aUj_B55GoC8kkv-W1NSeU7q9yWFNEEkT9CdjDlW-Z4sfCx3RVhtsa9kiLEWuyMptmh_6YGf8crXZ7Frw9-9B8eHuRRJFaTEyiEYW5HsQQAo1zhQmfDUlKS7sFpfFHaD0jBZc9gmv5SnUWg9daBHxqI9qn2RQr7FEYtLUmMwGyTXF5uFpgrCHXd-gONH-mjrsW3fVPWJSs05hQ-4OxdzPJZf0WWZguES2CuexpP3iQ7tD21AotVUS95Heer5akeZ3dzregT4Rr6GEm1hpKInsODqK2Fusj4Oj2SHMMDIcfPbiqeWSh3GkWbr6eh-wYUv1TYZLMBd6ZM7L51VXaADyCz3uLEtnIfLFLGgpGkl1rNkfa7UzQAVYr51OiupJclLl0IhGNeowQMznNL9EF3FxmAq5JZpTW2gZBaStsj5QWt1bWNP3pjWWmPByxfiqDcApcJnKeBBkH19QYnNhnMN3UbMnVctT-Ccodosvo1WSXh09UED4ogKjg51zZb66E9iwljGv2Cc0O3rbfhh5xDHwElPlu5Hl-9KH1NgA-hNl30SVnhOlnR5mrYpNfZEwVMvRLqH6StTCSuRQZq1pABRxPw4hV7-hv_7fW8CjqeQpDLhjALJfdyuNao3mkyauhMliIz7j5ntRNHzFr-xpk5Excsw_Q-wxp9DV)

