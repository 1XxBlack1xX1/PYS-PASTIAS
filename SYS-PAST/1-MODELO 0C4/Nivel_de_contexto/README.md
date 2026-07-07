# Nivel 1: Diagrama de Contexto del Sistema (C4 Model)

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
_Nota: El diagrama visual de este nivel se encuentra definido en el archivo `contexto.puml` adjunto en esta misma carpeta._
### Nivel_Contexto

![Diagrama del Sistema](https://www.plantuml.com/plantuml/png/RLBBRjH04BpxAuQS78dTHIHmu9HzH42q2GPdnJ5gZnjdf9bfQnvE5iJ7SEIGKsvS_MFqU1_P8An86VTELNLL-Sm7S24QdRrGLkfOexWDeVNl9XC7T-D6XTjOHOzEaWremrYIcRGQRCACVAYrgYRpqr6HHglBvSI03-XuT3Dd12YBRjmc_Yoee54i53GE30XMcW-SM9D3BqQYL0pT_F8UVL3zeqtd0Znpzm_Wiwn0vydcqKTmYlnBSRJQ7lcctZ4SyVpSXrWh1YBVEZSjIm2V5igX3EJIj8mjkaxvz7Pqd6NbEg5lPXHj3MwT6xAaLI1cM_OFHWKy57cs6kF5ZqpmitUTts4rRLi6Jrkj9CZ1prUiH7wv9JvEYrv01s8YojOfsuWPKKZJKhaEXGOlEfO3dzIshiLQj8ua-n61QX2Q__h7XYNI9OiDIRvag8wQht-76iRixjbkYoglArQPWSS4Ma3W1ETeWmETv0loeN5OVbxoQfTh_f-cKsr0eXqabVr6ZbztBU4-Oj3HsDHD1tARloJReKqjhKMbGlzBajjuyjX4PHGhqtX8Op6RYxpaA3G6iiUy-SzzC-Vt8VURzASIQZHAfd9sXQHP_piD1mkEEcHtWxMquDC7aVB8lg0--8xsPQqy2DIY9HT02uCRI2ByS7rTb1p75NJOG4qkbSbCYMW77r9T8h9FzDAfQhT0z61h4j522WFlXzZwFpQrTcYNuPlGYuWka3WvUVLszERqvFK_Gl-9WTlrqJmvtXLnkFj5-UbAJ8kFp7Q6jeucu-Sl)

