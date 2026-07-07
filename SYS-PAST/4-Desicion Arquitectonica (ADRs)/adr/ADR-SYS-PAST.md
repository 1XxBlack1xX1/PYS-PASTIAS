# ESPECIFICACIÓN DE CASO DE USO: CU01 - Registrar reporte contable

## 1. Descripción
El sistema permite al Estudiante Contable subir y registrar su reporte de pasantías en el expediente digital. El sistema valida de forma automática que el formato y tamaño del archivo cumplan con los requisitos establecidos antes de almacenarlo.

## Contexto
El **Sistema de Administración de Pasantías** requiere gestionar los ciclos de vida de las prácticas preprofesionales de los estudiantes. Esto involucra la interacción de múltiples actores con necesidades cambiantes: la institución académica (coordinadores y tutores), los estudiantes y las organizaciones/empresas externas. Para simplificar el despliegue, la infraestructura y el desarrollo inicial, el sistema se ha diseñado bajo una arquitectura de **Monolito** único.

Sin embargo, las reglas académicas y los procesos de validación de las pasantías (cómputo de horas, aprobación de planes de trabajo, estados de convenios) son altamente propensos a cambiar según las normativas institucionales. Existía el riesgo de que, al estar todo en una sola aplicación centralizada (Monolito), el código interno de los diferentes módulos (Estudiantes, Empresas, Evaluaciones) se mezclara y se volviera altamente dependiente de la infraestructura tecnológica elegida (como el framework Spring Boot, la base de datos relacional/NoSQL elegida o las librerías de interfaz de usuario). Si las reglas de negocio se acoplan directamente a los componentes de infraestructura o la base de datos, cualquier cambio regulatorio podría desestabilizar otras partes del monolito, haciendo que el mantenimiento del sistema fuera costoso, complejo y propenso a errores.

Se evaluó la estructura interna de la aplicación monolítica bajo dos enfoques:
1. **Diseño tradicional en capas (Arquitectura N-Tier):** Desarrollo rápido y común en sistemas monolíticos, pero con un alto riesgo de mezclar la lógica de validación académica de pasantías con anotaciones del framework, controladores web o consultas directas a la base de datos.
2. **Diseño de Arquitectura Hexagonal (Puertos y Adaptadores):** Desacoplamiento total del núcleo del negocio de las pasantías dentro del mismo monolito, permitiendo que las reglas de asignación, evaluación y control cambien de forma independiente a los mecanismos de almacenamiento, envío de correos o interfaces web.

## 2. Actores
* BERRIOS FLORES Abel yeins
* BILBAO LIZARRAGA Andre Fabrizio
* LARICO QUISPE Nelson Antony
* QUISPE TITO Juan Daniel


## 3. Precondiciones
* El estudiante debe haber iniciado sesión correctamente en el sistema (CU02).
* El estudiante debe contar con un archivo de reporte contable listo para subir.

## 4. Flujo Principal (Flujo Básico)
1. El estudiante selecciona la opción "Registrar reporte contable".
2. El sistema muestra un formulario con los campos para cargar el documento.
3. El estudiante selecciona y carga su archivo desde su equipo.
4. El estudiante hace clic en el botón "Guardar/Enviar".
5. El sistema ejecuta la validación interna del formato y tamaño del archivo (`<<include>>`).
6. El sistema almacena con éxito el documento en el expediente digital (`<<include>>`).
7. El sistema muestra un mensaje de confirmación: "Reporte registrado exitosamente".

## 5. Flujos Alternativos (Flujos de Excepción)
* **5.1. Archivo con formato o tamaño inválido (`<<extend>>`)**
    * Si en el paso 5 del flujo principal el sistema detecta que el archivo no es un PDF válido o excede el límite de tamaño:
    1. El sistema interrumpe el proceso de almacenamiento.
    2. El sistema muestra el mensaje de error correspondiente: "Error: Archivo inválido. Verifique el formato y tamaño" (`<<extend>>`).
    3. El sistema regresa al paso 2 del flujo principal para que el estudiante intente subir otro archivo.

## 6. Postcondiciones
* El reporte contable queda registrado en el sistema y asociado al expediente del estudiante en estado "Enviado/Almacenado".



