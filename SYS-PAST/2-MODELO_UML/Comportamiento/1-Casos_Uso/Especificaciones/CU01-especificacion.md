# ESPECIFICACIÓN DE CASO DE USO: CU01 - Registrar reporte contable

## 1. Descripción
El sistema permite al Estudiante Contable subir y registrar su reporte de pasantías en el expediente digital. El sistema valida de forma automática que el formato y tamaño del archivo cumplan con los requisitos establecidos antes de almacenarlo.

## 2. Actores
* **Estudiante Contable** (Actor Principal)

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