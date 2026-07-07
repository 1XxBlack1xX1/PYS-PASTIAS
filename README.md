
## SISTEMA DE GESTIÓN DE PASANTÍAS - SIS-PASAN

Documentación de la arquitectura de actores y organización modular para la Escuela Profesional de Administración.

## Tecnologías

-Java

-Experto

-PlantaUML

Arquitectura Monolítica en Capas

## Modelado
UML

-Casos de uso

-Diagramas de secuencia

-Diagramas de estado

-Diagrama de clases genera

## INTEGRANTES

-Quispe Tito Juan Daniel

-Larico Quispe Nelson Antony

## 1. Arquitectura de Actores y Permisos
El sistema implementa un patrón de herencia para la gestión de accesos:

Usuario General: Es una abstracción de seguridad. Cualquier persona autenticada en el sistema (sea alumno, empresa o coordinador) comparte una frontera común: el acceso obligatorio a través del CU02: Logearse en el Sistema.

Director / Secretaria (Administrador): Posee el nivel más alto de privilegios a nivel gerencial y contable. No interviene en la aprobación diaria de alumnos, sino en la salud financiera del sistema (CU01, CU22) y el control posterior de auditorías de datos (CU03, CU23).

Coordinador Académico: Es el motor operativo y de seguimiento del sistema. Se encarga de validar que se cumplan las reglas de juego académicas: matricula estudiantes, valida y publica vacantes de empresas, asigna supervisores y da el cierre legal a los expedientes de prácticas.

Empresa: Actor externo autorizado que provee el mercado de vacantes (CU16, CU17). Su interacción está restringida a gestionar su propia información legal, proponer plazas de trabajo y evaluar el desempeño final del estudiante en su sede (CU26).

Estudiante: Beneficiario final del sistema. Su interacción se centra en mantener actualizado su perfil académico, consultar su expediente (CU13) y postular a las vacantes activas del mercado (CU19).

## 2. Organización Modular de los Casos de Uso
A. Módulo de Seguridad y Usuarios
Centraliza las fronteras de autenticación y la bitácora inalterable del sistema. A través de la Programación Orientada a Aspectos (AOP), cada vez que un coordinador o administrador altera un registro, el CU23: Consultar Historial guarda una traza exacta de auditoría sin intervenir directamente con la lógica de negocio.

## 3. Módulo Financiero y Contable
Controla la solvencia económica de los procesos. Antes de emitir actas o permitir postulaciones masivas, el sistema requiere la consolidación de estados de cuenta mediante el CU01 y el CU22 (Generar Reportes). Como se define en la máquina de estados, este módulo procesa en memoria intermedia los totales contables y permite la exportación dinámica a formatos físicos (PDF, Excel, CSV) de forma aislada a errores de red.

## 4. Módulo de Empresas y Convenios
Gobierna la capa de relaciones interinstitucionales. Una empresa no puede registrar vacantes si previamente el Coordinador Académico no ha completado la CU05: Recepción de Convenios y la consecuente aprobación legal mediante el CU14 y CU15 (Registrar y Renovar Convenios).

## 5. Módulo de Alumnos
Encargado de la persistencia y ciclo de vida de los datos maestros del cuerpo estudiantil. Controla el registro inicial, las actualizaciones de ciclos académicos y la consulta de deudas financieras previas a la habilitación de prácticas.

## 6. Módulo de Convocatorias y Vacantes
Es el puente entre la oferta y la demanda. Las empresas registran intenciones de vacantes, pero estas entran en un estado de espera hasta que el Coordinador ejecuta el CU06: Validación de Vacantes y activa el flujo para el CU18: Publicar Vacante, momento en el cual se vuelve visible para los estudiantes.

## 7. Módulo de Postulaciones y Seguimiento Académico
Representa el flujo transaccional principal (Core Business). Describe el ciclo desde que un estudiante ejecuta el CU19: Postular a Vacante, pasando por los filtros automáticos y manuales de aceptación (CU20 / CU21), el monitoreo en campo de los docentes delegados (CU24, CU25), la calificación final de la empresa (CU26) y la culminación administrativa con la CU27: Emitir Constancia y el CU28: Cerrar Proceso.

## diagrama general de casos de uso:
![diagrama de Contexto](http://www.plantuml.com/plantuml/png/VPRFRjiu4CRlUWh2bxQ7O2tvZsCVYXgAjmsm6mVHPgy58x4kKOeqICf0kzi7siCU5dq4lzWEAL6XbL5p2VaDV-JCHzBYEsEfjaqjo0sd1qrh-l4zaqnJyR6uVR-xJmJxP8bLHFF3PqighbbfkPA9-SBbaG90ZhJyGW-ii5y58ovCvK6m9B7SWX2c9Tsqf68afqOPrtWqYboHTg7a5RcwkYBR_8_zmwvmxOIMLcaokV6BGkiNKh1ICyYOqmcXXcohciimR6TiKt4gBVEnvsu_e3vgPbgoQuTGhfIkkAGLTBObhSx_rBnKVcGK2gCVJGCfg52I7zPfeOmFkuVTNNwx9JUxYv9ynj3w-srFF2SwqDiKByKecyj0qZjF9WKtbe7b5OCKZUNd7zArxwc1LSx_GhQllUTl9kIl927mzuhyVlvHDKAHT0Cc7nhDArgHhr2z_CIXIqitYniRzfjC0bAn60aP6JSvwVuQmqfgWCaVfzc6_AOEZ6heCqcO85s-hTqm0CLccxOO9QdkrmZ834CoG21_qmWBo0TOH6bE1Ncz1R-X3KwywIR8sWc-3zs0N7i7VmNRPScPfhWDVLorlbdw9DYO2M3p0pj0IffgQ1sLjgo7GbKfMfNFIR88DA6A3AzYjWddtRIfdPW4yqPt4niyLiZ25LAoOnbEMK-4AXOeTnqR4DzC5qE9zGQkfcseuDzU8ciCIQTGkE1muuO0X51W7cSLAWd874My0LAT4621RmSi4b_BhMXgEROR8Jww0Ud5IHhy1hem2cMHbnYLeLHqdp1ev0ujF7LI9NNtpv-gFsdfmD6Qnu3HKpYFVnmA9NZ98RjmCI2EKiiDJ2nuHSFX3Ulqt1BrOHbP7f1W0awiOh-7o0f5u8BSDqzGoKlW6ZTw2OI2NH5GZv8CVFE_ot3-cRGg-gwDsVupVCnvg2nUn7yB8kFnsjPzffhGONNeLSwcuE1HgoUg0-ethOKWZ4B-RfIVwRSHAaMfEInb-C4VfUR8z8aRfGCoHv55V28YFmArG2dOiDs9YWQO6sPOVMJd_tfaYI8hG6fkkVOtqReF3Wt42YNW7ELCQ-U0LYKp_GBX57tldrx57bui-Ut-RbV4xvPyVqTo27hniTYxmOuPF8EIhW_Xj-rd7CQWRpVe-7UGyyk_gtmlSEbbTtRHpRBBxWmMYPzwpyrkH3f3j3LG_HEm-n_MMmo5ww6m7WZfT2WiXy9g86HBbm7-wamYEImvnyGb9guGCKqnCSF4EIOkCF4Q4RCf9gQOECV41IPY5S7XJTunMJMr-1y0)
