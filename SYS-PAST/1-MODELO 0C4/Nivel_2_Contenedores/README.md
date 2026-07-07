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

![Diagrama del Sistema](https://www.plantuml.com/plantuml/png/XL8zRzH04EtzAvQhWfIS6oggXEG4I22TSe4scbjFBYFjXvdTFHB-3IL52aH7wp_6Z7ssZ3YWisTstdlptfod39oBTzKp2jQL1irzpcrwMTSCdvSxolTbMnAoZI5Zo4iRVTqw23fpbdBZQ5jVlZXRQ-d3-tUrXvIHfNHxgHCFUTagUfKfEpHN13i63qPu3lrepio6P6YeliQKgViHz7iDIL2x9qXLjKPECPn8jpGaLJmrYzNqiv2_LoLPC7kmMaYdfetITc0U3UEU4XXqHiQXYOgTYcavMannkNW-eVkMCO60NQD-oS8AfkzNGslHztQYbq4n8kyWq1UmgbauozRHJ8MGunvSznD6ELgTCJR4Q7DaWRqwV9hQN3IUGi_HH5RAtfKOm4WCUmmKPJz8j0igeaMM_I8FT9uowhCaqYt1d6nyEj15YxhRPYeEku6JTOmKA4FgdS9T8K_oECxMSTBSKkw-siZzEsV05HzwEwlDemPwaePSXnn5Yn3yDsfL8Nh7DJ971snoRA86QCcwFhzs6X1Haok6Wc3cOjKiXsacvdRra4T15nOQz6JZJ93MkczQx1LmtAC43pds9dZ8t3tPuPx40ch0ZjePFnMrQtZfOZeuCR1Ve_ljQezuylVBJMMBvlAZu0ZCU9v7CQQZZ7V86TBS8qM2bWjkeMQqzo012rT3_Ne3-7I9Hz4lXkcPHXxv9kyr1qAM4ZwqsEZ1u0W-lxn_YHylwjZbMN1qHrRWdJIJc87TzpXQ_2VgaQpV-ZPo1aFXBh8_90XZyA31lxcvMM_gwzNcHf3FCJJ5LrNr2m00)
