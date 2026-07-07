## Descripción General
El Diagrama de Contexto establece el límite del **Sistema de Gestión de Pasantías**, permitiendo visualizar a alto nivel cómo interactúan los usuarios clave del negocio y los sistemas externos con la plataforma sin entrar en detalles tecnológicos.

## Actores y Roles del Sistema
* **Estudiante:** Actor principal que interactúa buscando vacantes publicadas, postulando mediante el envío de su CV (`CU-19`) y visualizando el estado de su proceso.
* **Representante de Empresa:** Organización aliada encargada de registrar su información corporativa (`CU-08`), publicar ofertas de pasantías (`CU-16`) y evaluar o descartar a los alumnos postulantes (`CU-20`, `CU-21`).
* **Director / Administrador:** Usuario con permisos de gestión total que administra empresas, registra y renueva convenios institucionales (`CU-14`, `CU-15`), aprueba vacantes, asigna supervisores y realiza el cierre definitivo de los expedientes (`CU-28`).
* **Docente Supervisor:** Encargado del acompañamiento académico del pasante, responsable de asentar las bitácoras y visitas de seguimiento periódico (`CU-25`).

## Interacciones con Sistemas Externos
* **Sistema Académico:** Es un sistema externo esencial para el flujo del negocio. El Sistema de Pasantías consume su API para importar y validar de forma automática que los estudiantes cuenten con matrícula vigente y cumplan estrictamente con los requisitos académicos necesarios antes de permitirles postular (`CU-11`).

---
_Nota: El diagrama
### Nivel_2_contenedores

![Diagrama del Sistema](https://www.plantuml.com/plantuml/png/hPBFQiCm38VlVWeTKxRq0KOfXPBRs0fxWABQwd1nP92LClRdtMU20oauXx7c58iVd-HFtYL5qQ4FS42LoCVNKoAvaXmFCUaGqFh8ndXMaZDQWbbvYiANWVmzeDK1W_z4QTvKFBy3PRgBZr2EZXH3e9NvCSO6J0cw37CUC_qbgZzxEuB_0Tp7ACvp3ibzYFCBxoChVMY1jV3iasugGhOGorygoPjcjpNlvgR7AG7TPM15QMgs9_QgX1sbF-KjzYUFqespJ1fue6liwYxAl5nyoaHEpQYfrdFplLulB7SnlxGxKzb0sswXndc27fakQCoEsELdRNu1)

