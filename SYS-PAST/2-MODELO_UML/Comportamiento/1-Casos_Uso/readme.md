CASOS DE USO DEL SISTEMA DE PASANTIAS EN LA ESCUELA DE ADMINSTRACION

CU01: Registrar reporte contable

1. El Proceso Principal (Caso de Uso Base)
   CU01: Registrar reporte contable: Es la funcionalidad central. El actor "Estudiante Contable" interactúa directamente con ella ("Accede") para subir y registrar su informe al sistema.

2. Las Relaciones Obligatorias (<<include>>)
   El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que se registra un reporte, el sistema hace lo siguiente de forma automática:
   Validar formato y tamaño de archivo: El sistema comprueba inmediatamente si el archivo cumple con las reglas permitidas.
   Almacenar en expediente digital: Si todo está correcto, el sistema guarda el documento de forma permanente en el historial digital del estudiante.

3. El Flujo Excepcional o Alternativo (<<extend>>)
   Mostrar error de archivo inválido: Este caso de uso es opcional y condicional. No ocurre siempre; solo se activa e "inyecta" su comportamiento en el caso de uso principal si la validación previa falla (por ejemplo, si el estudiante sube un formato no permitido o un archivo que pesa demasiado).

En resumen:
El caso de uso permite al Estudiante Contable registrar su reporte, obligando al sistema a validarlo y almacenarlo, abriendo la posibilidad de mostrar un mensaje de error únicamente si el archivo adjunto no es válido.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/PP3FIWCn4CRlUOfXxorwbR9qAHuyAEAg82p8c8nhQFuiaqbf4H_6H_0P-cB6bgqjtSj2yllDV5_cIP0bUwVIqeO16JqCg9VOKoiRHy2a1KFlI2dK4XcgwoJPM0n2i8X1yCrH1PY0aYXrmA5gNrguRzhcxl6cQIluL52-d4XZAhVFwAn1XlV87YLsOGE27hS_4Gm1ilwmgxYRc_NhQW-VJcYSHqq16IXqWTO36Kj_gOpjhQ0RvJuZdycBfulBBZnGRvCmCZ0DaOkhZniLsQCDf-Pjt1l47BaB_s71XjNskmGznDuXwakfyZGmcTJZGBY2HciofDHuCit3j3wgMf3Pp0Rjig6wFiDsfSwnSUV8ZUiAH6kXO0epBx_iVm40)

CU02: Logearse

1. El Proceso Principal (Caso de Uso Base)
   CU02: Logearse: Es la funcionalidad central. Los actores "Administrador", "Director" y "Estudiante Contable" interactúan directamente con ella ("Accede") para introducir sus datos e intentar ingresar al sistema SYS PASANTIAS.

2. Las Relaciones Obligatorias (<<include>>)
   El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que alguien intenta logearse, el sistema hace lo siguiente de forma automática:

Validar credenciales: El sistema comprueba inmediatamente si el usuario y la contraseña ingresados son correctos y existen en la base de datos.

Generar Token JWT: Si la validación es exitosa, el sistema crea automáticamente un token de seguridad (JSON Web Token) para mantener la sesión activa y proteger las futuras consultas del usuario.

3. El Flujo Excepcional o Alternativo (<<extend>>)
   Mostrar Mensaje de error: Este caso de uso es opcional y condicional. No ocurre siempre; solo se activa e "inyecta" su comportamiento en el caso de uso principal si la validación previa falla (por ejemplo, si el usuario se equivoca en su contraseña o el usuario no existe).

En resumen:
El caso de uso permite al Administrador, Director y Estudiante Contable iniciar sesión, obligando al sistema a validar sus credenciales y generar un token JWT, abriendo la posibilidad de mostrar un mensaje de error únicamente si los datos introducidos no son válidos.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZP5DRXD148NtSuhIPC4g1aSHGiWQPN1Y1288QGm8OOJAtSNGyKorLTsD4H5N01Qis8Gxi67FJRW0787vSICxNYIpcrVVgrTwVUGyYWzrbTo0iUKtfWo2olpwmQ09bAsia0DotbGMj5N4dXAtCBn4mHg28uMEu3o1vhk7Qb6A3Qp7hH7sXfDyE1dsCokQP5UVMFQzkdfhFFtN2lE1O7YOVDn8G-KRxloQ-_OEJWwFRz_PlIncRUtEHUngQzt6SDdOiQJhHaUr2KZwczDSruQDyuBQIWhe05ibZe-DaFBhYJOIzHFdWpR8djhNyJYlg4F8-IHfBSXbHP0MBmfuaXVvu-c3l4ZNTyR7IVzUVFqousTO6OqoOoMaYPN1YbotBQZNx_hXPT-dYpy_Fy_uFZ59QvtQ1J4yV3wDlhELt_QCvjduwQs3qSrvDkD7jYGKHv6kqV0s_llRzoxXr3hV9PmIEpmZq0GaOYLQkv-kqBOts7-vxlZLVXOtmrt8bI9DYJPo1K7ENq4aKHc4vI3RwAX1HYF3gWgQicmNQohPGVhpOQ3jYWSROGr6xpsnRgWZOXtgVm00)

CU03: Gestionar usuarios

1. El Proceso Principal (Caso de Uso Base) CU03: Gestionar usuarios: Es la funcionalidad central dentro del sistema "SYS PASANTIAS". Los actores "Administrador" y "Director" interactúan directamente con ella ("Accede") para administrar las cuentas y la información de los usuarios en el sistema.

2. Las Relaciones Obligatorias («include»): El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que se gestionan usuarios, el sistema hace lo siguiente de forma automática:

Validar registros duplicados: El sistema comprueba inmediatamente si los datos del usuario que se intenta registrar o modificar ya existen para evitar duplicidad.

Actualizar niveles de acceso (Roles): El sistema asigna o modifica de manera obligatoria los permisos y roles correspondientes al usuario dentro de la plataforma.

3. El Flujo Excepcional o Alternativo («extend») Mostrar error de duplicado: Este caso de uso es opcional y condicional. No ocurre siempre; solo se activa e "inyecta" su comportamiento en el caso de uso principal si la validación previa de duplicados detecta que los datos ya existen en el sistema (por ejemplo, si se intenta registrar un correo o DNI que ya está en uso).

En resumen: El caso de uso permite tanto al Administrador como al Director gestionar los usuarios, obligando al sistema a validar que no haya registros duplicados y a actualizar sus niveles de acceso, abriendo la posibilidad de mostrar un mensaje de error únicamente si se detecta un dato duplicado durante el proceso.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZL11ZjD04Bpx5Itl0JXi8B1224NMcYn174080nB22FNED6QqTa_KCxD1k-87S43YYdW4J-0dl80dC7OoaCY7JIxHL5LNbUlOUHGVkZQx1dFBxqqJ19NvzPD14oZRMY47vBnfBMYhY3rbxipm4WKx28uKEeBB3EBl0QgpHcnWFUyFuM2wAAUBwPgpead6-CAoNwEh3oPw9wmo5mJJe-pJLXeg7tMNU_eTt7vuT7BtthXPojhnBaNiQiTkYrp6Ssnet-Y4ne1itJalTMVOE2-ehUI03h174drYX9JVCDf8blLlvAOboAlN5Jmhg_BfYyTbbMzAfENpFp--VQdv5RP6eu1GqwTOLxCEozQecES6rw3UdQz5e_klDPVAXyXUe02RSsgfDo10fSXPkFxSHkH6yf7-jUioEotcBs_TcTqyBMf-HCuRooYH3oZcVuCE3UyU_lx-kUOdjbz6W4Ii3C7_ogVBWHe6xNU3mpURZTyU5iaOxaEf56dAj94h55b29c4vARR6YPBPpB1gWwQY6Ck6Rn-BXdemqNR5awsuAAEFdbX7rN7y2zrV)

CU04: Gestionar solicitudes especificaciones

1. El Proceso Principal (Caso de Uso Base) CU01: Gestionar solicitudes de pasantías: Es la funcionalidad central dentro del sistema "SYS PASANTIAS". El actor "Estudiante" interactúa directamente con ella ("Accede") para iniciar el trámite, y el proceso interactúa a su vez con la "Base de Datos de Pasantías" (actor del sistema) para consultar o almacenar la información.

2. Las Relaciones Obligatorias («include»): El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que se gestiona una solicitud, el sistema hace lo siguiente de forma automática:

Validar datos obligatorios: El sistema comprueba de inmediato que todos los campos requeridos en el formulario de solicitud estén correctamente completados por el estudiante.

Registrar solicitud (Pendiente): El sistema guarda de forma obligatoria el estado inicial de la postulación como "Pendiente" para su posterior revisión.

3. El Flujo Excepcional o Alternativo («extend») Mostrar error de validación: Este caso de uso es opcional y condicional. No ocurre siempre; solo se activa e "inyecta" su comportamiento en el subproceso de validación si el estudiante olvida completar algún campo obligatorio o ingresa información con un formato incorrecto.

En resumen: El caso de uso permite al Estudiante gestionar sus solicitudes de pasantías, obligando al sistema a validar los datos obligatorios y a registrar la solicitud en estado pendiente en la Base de Datos de Pasantías, abriendo la posibilidad de mostrar un mensaje de error únicamente si la validación de los datos falla durante el proceso.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/RLB1YXD14BttLnGvQM23NaCODki64LI2euBWfRQd4WjxkaDNPNKHFyY39pyXFsRrD1adiZc4xdxlrQjNKzUYcFNO1oTVEHumOm_eDULM7m81VYD9FRb0EmLDa7d_HQ7ZJ5uvHUS6BYmteiUECIej0GLQkr7KCtg3Gj0HtA8cAOSjYd5Flr46-kqDh5OjYrAFJUDSgOvnR_wpzbCBstMxVll-rRgTmGy7zZiAUHH3NtnuzlnpV4bIci4CaW9xBkQ3pM6qcHMRmhxKVyJ0dUcweR5q5tXlfyof2YgiT2bwaqIpYIZdb8lD_K3pVFeJfp9hQLCeb-ftj6VJJvk59rkA7PDDx-bGe7AeAilVUQ1mTTKCCM09Q--feuBM5uDia9V0FtJHZ6cCibfnzC5ADisKCXe_GXdLgyL_0IkRlgk5CF9Fvs8oNbsLj3kFVJxVPlB9WdeJaYpdy_8Acm0qRWzqT4VbZXaorKbr2Hu0ZshvsTjjSPOTAEyu0DhZwLVFFatLw9Nl1sxrJgAFcB_6oMUORWm80OOUFKK4d_AmaZsL5Ya21P2whWjdgQ44TjTsElRXBm00)

CU05: Recepcion convenios especificaciones

1. El Proceso Principal (Caso de Uso Base) CU05: Recepción de convenios de empresas: Es la funcionalidad central dentro del sistema "SYS PASANTIAS". El actor "Director" interactúa directamente con ella ("Accede") para registrar la llegada de un nuevo acuerdo, y el proceso interactúa a su vez con el actor del sistema "Base de Datos de Pasantías" ("Accede") para gestionar el almacenamiento de la información.

2. Las Relaciones Obligatorias («include»): El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que se procesa la recepción de un convenio, el sistema hace lo siguiente de forma automática:

Solicitar datos y vigencia: El sistema requiere obligatoriamente que se introduzcan los datos legales del acuerdo y el periodo de tiempo en el que estará activo.

Asociar convenio a empresa: El sistema vincula de manera obligatoria el documento del convenio con el registro de la organización correspondiente que ya se encuentra en la plataforma.

En resumen: El caso de uso permite al Director tramitar la recepción de convenios de empresas, obligando al sistema a solicitar los datos básicos junto a su vigencia y a asociar dicho convenio con su respectiva empresa dentro de la Base de Datos de Pasantías.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/RLB1RXCn4BtxAvvoZDI82vUeMdNRSa12AEh20OdBr9u62-yuU2P14UAJEF49_J6yJfCs5PULTzvxVkCtSwL6nRPZSlezoeOAZI1lkGosJmpwoPf7TeaV39PHulgR8SJ2tc8MvneNozjMoMK9KjIVO_sQb14OjsHPfyEAbCGU_v0UgDUul1oY6e_KTSvDjv2i4sCsV1cmweV-uwVt_J33BmS0MsLFMj6Rps_UVfKxzhpnyV6l831ybXrBF1Znk2cifBF9PcAVwuUSeez61Q6rjiSkhbbyf2QuunzRLgjjqxckrrmvvUG5EZerNQyDDxx9uuPatyJjKqF1nKNNMi4IlVSSk26jKg4QnZdmZ2wwbnrXMKEBujCsSDUTiLxxlwB-TawoyTCOyyCncFbyLTXd2T77BApB-Nogubr2U9ei0jypMAV8Q6ii5Zs5l6Yy3wSKNj8AhwDQeL1H0IVeOT2Jvc2QrVxlUegtFZhGyqqPUuIecopnFZ6cVKKYaCQrq6aHTkH9Z7NXM0Ac5xkhUgfR_Wy0)

CU06: Validacion vacantes especificacion

1. El Proceso Principal (Caso de Uso Base) CU-06: Validación de vacantes por empresa: Es la funcionalidad central dentro del módulo "SYS PASANTIAS — VALIDACIÓN". Los actores "Director" y "Estudiante" interactúan directamente con ella ("Consulta") para conocer las plazas de una organización, y el proceso a su vez interactúa con el actor del sistema "Base de Datos de Pasantías" ("Verifica en") para contrastar los datos.

2. Las Relaciones Obligatorias («include»): El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que se consulta la validación de vacantes, el sistema hace lo siguiente de forma automática:

Verificar límite de cupos: El sistema comprueba inmediatamente el tope máximo de pasantes permitidos que tiene asignada la empresa de acuerdo a sus parámetros vigentes.

Mostrar vacantes disponibles: El sistema calcula y despliega de manera obligatoria el número neto de plazas libres listas para ser ocupadas tras el descarte de cupos.

En resumen: El caso de uso permite tanto al Director como al Estudiante consultar la validación de vacantes por empresa, obligando al sistema a verificar el límite de cupos y a mostrar las plazas disponibles mediante la Base de Datos de Pasantías.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/XLJDRjj64BxpAGRE8Ut1Zlvj2O8GYPG00QbXb8s10hcCo96po7A7s5tQK8e0lVJMMteiKA3tdFe8VfCyGH-XooN5a764wY2Gymtd-sRsctrfB6fRP39u3Y6hlRWhD2RYyHy5AK72aZKPE00PAoH3hdbFHh122T-jgrZ6AMd5SAZJCUNl0_DEg1mrPh33vDsTvaAb7ePd6_zhPTIWLgIXtsi1c5ZMiJr80dmWmna5xSyeiQZk7FXB0EwtQeZ2ccYqkTnCAeor4rd7-ylnuBAARrZPEZe8X-jnhud6uZr1VnHyQ5CMXX8q9mc7e-bLj7fAE9XUzLRJBc4pXoxXe7cl-jwnJ7t8_ps7UkQb791imCbn_oavQGnEdHE3MhYGK8aiHChcMrBdSm-dj5Z0it6qZDQ3hkfkojC6kWbDBvrX-TCxDQhrv78z63mTLJGSZtgzKsVp_wFgA51iJviZt0p3pLC1c-4qR9LkJdOq7Q-_4j3lig7M_53J7NMlHxtnyEjY_SsaVnLzgvYalGNBeCNTMmkfA2qkM0LkEIFQ2oMQpLoMmoKJL4EUHJwLzGpGW7ivnfrTYbIWikIHsBsHiaTqXORAOX7QoaGtQ5pkuoSqLQ4LpEUnC9OoN2o2uCl6dSK_nt2pZ9VNFssNCNp-zG-uNRxQHijm-_Zn-goQGhCkP-7hyzxaZRf5AL9iUhZ7f5HctgYSDL2MQp9uLXA7htkJReLRqc8l4jGW7pzbmdhTIP6pyHzu-10MkO6MBxibVc1ZDUg65b9XSbPY9wag4h_bXziIJ0HrwxGMSAiiQKmImOgCZxbnm_dvmek6MNcBca9Qz5Wzy5EuZtamMZdes2IGQbF-I18hlhBfRQdAb3FyKk5YqPx0hAkzbTJji9lteNJPDLkidA0fOPNMXZl03HlR2hZ7whPtkSQwYYa7Vjigv_B-U8HpdpMhztentot-_UlZxztoi_cBtMB-mcSwlSvDVyChF1h2CUm8B2dIK7ZcUrA2o-j5tFE5os_HzDTNRbDBciz__jQ8FaqJKrbmBtI68B5nX2XzcfPpo2M-H-DFehfqIKAkEI737dOCXQmiVH6GIlsT4mGltMEHoVy0)

CU07: Seguimiento sedes especificacion

1. El Proceso Principal (Caso de Uso Base) CU-07: Seguimiento en múltiples sedes: Es la funcionalidad central dentro del módulo "SYS PASANTIAS — REPORTES". El actor "Director" interactúa directamente con ella ("Selecciona reporte") para monitorear el desarrollo de las prácticas, y el proceso a su vez interactúa con el actor del sistema "Base de Datos de Pasantías" ("Consulta datos en") para extraer la información consolidada.

2. Las Relaciones Obligatorias («include»): El caso de uso principal depende obligatoriamente de dos subprocesos para completarse con éxito. Cada vez que se realiza el seguimiento en múltiples sedes, el sistema hace lo siguiente de forma automática:

Filtrar por sede y sucursal: El sistema segmenta e identifica obligatoriamente los datos según la ubicación geográfica y la dependencia específica correspondiente.

Desplegar avance y asistencia: El sistema muestra y proyecta de manera obligatoria las métricas de progreso académico y el registro de asistencia acumulado por los pasantes.

En resumen: El caso de uso permite al Director realizar el seguimiento en múltiples sedes, obligando al sistema a filtrar por sede y sucursal y a desplegar el avance y asistencia mediante la consulta de datos en la Base de Datos de Pasantías.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLMnZXit4EttAmPtXPr2TokTP9q4GR2aNIK14kVWjOi01eBHSYGpvf82oJrR3WAaIPSkAGC4IUygNLhzYRyWdn2IuaNIdWoSr2p9HyvxZpF3fyQYjdKbaaVm1Iwuu6uCHbKBZGOsi52QaG5DJ4b6o9I1jLQobYNV3L0Zq99Agu2HmmbEjmIN7hMi9UCCMMBUSEc15PZNRjTRBbTWTKq72revSAcq90tjti42kfDrOJU20D-I8qQ9epftR1IioC5HWE3Lcgk3JGiitwpYaK9fE9zF_D_lp8tbmdCLC5FIadJAT1WMt5Yg44ebzueETS3ZwSwDbUDkbBU7qKeZyqvyTYZ6RKQv4WG_9E1-q__fp2ATphmxxxREyrv-dLy7J3XQn_NEx2hlfGVpBrxpyeqaOw0JPfr-sy36sOA_9sXtz-DWtK89blnuf1zcw3MuZvT6UT5xCM0rPxmYQRYIAE3nvswUaxH7Acj39PexZOyWYzl3uVY-5g1CMMi5k1ijD1S2fQLTqXXUrG8rt2fHkr1mbPtsgZEuJgU3rdalcsHvvxvNxMbttk-SzAfzqMkwDG-_XbkT4sw5gQYig1SjbmUbl_I6KxYgiKBD9LwIgNmsCZobOpGo6vzUts5fkPBZiIFUxby_SKdGdandWrb3sAaDQVwaqsll5Ps6HOdDsvxuEg8c_NBxf-1CDUljKtcRNVMwQUhozaa_xvouYqdgbjDx6PftqzxLGpnlS7wcB1fu72TkbB4jRhs2sA0Eir4g--bo6-JzmRnrFkzcwTNyFksiEvcbsOCAgztaAD30LziFaj24ebAItl7jt_BGKgtLsyWjddtLxGvw-SCYXl5nKZiEWfOMh0BDLwyjCAuf980dbz6IIrvw5WStd-nkTfW5gD93G0DkS3S_HKCUdg5LGSeD6fHs-m7D3Zg5qIZsoF4uIVPDxgpuje2RIJ5vzkBBIG4VV_eDdkSttpn_aHTdKVPThpYRlMob_LUoe5NDAzzI591y9QljFyBojI03XXYPCnznzZBj7vRXf2oTGWVXqfAMmN019hPjUcSrRZ-mEBqKzVSArfhBagzH7BEOS-706jPAXtYm0LENjJOeGcI_JhhmJE1UXHqVbP5nj5Ue0MzHblue39HSN3pRUUmGkFcQhERbfywB4kUUTNn8SQSsh6HSGwir3fR040eI5Cn01tGYB0LKM7KmVrT3dugc5XQ1XHib6J1xuCNuIEVGCNDcYPfHv1HH3G4DO2W7NwZDHoCq-HjDfP8i9kCcrF1-8l556pDOBU_kUnJUx65i9kFHOlpl7x_-SdpKS7Iv68yk0zAHTJdt5-G2oDYQyV36C5eGM9AaePResCHa3ihGy9L4Xa0GAiLzNhY5VV3OQttmZx__tA1zAdX1SCjDZOA_Hw309FHN9OqIdBbl7pWsZ3qR0rKjBFSvU96GPA6D9SbJzrbNuZy0)

CU08: Registrar Empresa especificacion
El Proceso Principal Caso de Uso Base CU08: Registrar empresa: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. El actor Administrador interactúa directamente con ella ingresa datos de nueva empresa aliada para archivar el perfil corporativo en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Validar RUC y estado activo en SUNAT: El sistema comprueba de forma obligatoria la existencia legal y la condición tributaria de la organización.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Administrador registrar una nueva empresa aliada en la plataforma, obligando al sistema a validar el RUC y el estado activo en SUNAT para asegurar que los datos corporativos queden archivados de forma verídica.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLJ1QlD64BxhAGRdK33OI8gTE3_6_B8bqq9RJ9GS2e4oNata9QjTTtULr2c5NdhhhJqM2htss6DlwPlq2Ve8NQtjn4uKg7pPdVc-sM--6VpHMDIshaJm2NoAIowukuDHrLAZWGsGiLme0_VSr2Z8m6aQc3ikrwYn0hF2GZrmMOBLDHqajAfbmPIMf24Q7YIGMQLpkn44-43k7GeEiajaT-MEAvI6atdI_0uXcfX5MJh-Tm6uR_fCcUqeyNmm7_HEic4soaPRZD85wLq-dfrcm_0WVhNYx4wICH3xw5n9-mRhepb_98W6BtVVnrA98lZ-K6DjYA5vLs5yCGgd5xsJOPgaMVnMOJGTpC_ZLeLHV_XQuzn_hpJ6BHfzg4tHU6msnbBrDJBBbPnCd8JeV7JcJ8oIwUnYTYIndH1cP_4mEj3M3jkAzMuThyHxNgMdmq4OkccUdMTnYrT9wDBX__MgTPxnE_FSwkeaHSKbDrPZeNG7q82FxDFJPj05GOfMcUQmG8FIal7GQGhZSSuR5t0o2OANxUtaN-MmIFBaowlFaXp--U4NoBvON6PvadTsPkpNg3ExxeMZ6tb9fTUXWQgr9eF-YTbrE3g6pxdmg0tSe-25ErrUpsuaVTleSDA095ZkQYZGX6BR4xCHl1dOSTsKp5fGYHfkbQvgWPehAEX65hvtfKkK_16Pew8WiwyRjzHrzdeNeTUR-0xW0-GaY7aog3NZV_yfGUyx3ZoctvzueGxyz0UNJDG5FVrrb8jRSlwHQUeoYQYGaKJWica1jwymfTTAe-Nt60HIMGBDovK5TRitzz_VVlu9kjs59gPamJtjGxSRW9lRxv09g4tjtS2wSPWpB1fdbWJkIXhMf2jkjljHah4Dl-_OJO5VVsmgAsFRId-E-rd3DpKL-Eo8EsvWjVl3TXUIG0BCTjFw0Sa2caw2Z-vKL_y1)

CU09: Actualizar Empresa especificacion
El Proceso Principal Caso de Uso Base CU09: Actualizar empresa: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. El actor Administrador interactúa directamente con ella modifica datos de contacto o razón social para sobreescribir la información en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Desplegar campos editables del perfil corporativo: El sistema habilita de forma obligatoria los formularios interactivos con la información actual de la empresa.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Administrador modificar los datos de contacto o la razón social de una organización, obligando al sistema a desplegar los campos editables del perfil corporativo para salvaguardar la información actualizada.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1Qjj048RlUeh1kHbi9CLEx61C95k6GbjCbHGAWRBPdIXBf5spksgQb48llVNM7Wk5NdliiRVqJVe4VOIkrh4Y9mfKliWp_yn--lyzr8OeKnQvfo-uM1552j3dXCbBBZ8mgiH6GybIC2gLG0N1iD4Wr4YLcgiSWLoYbaLpwfJGY-nsD9SATXPHzVEQYv4Q8Z8x_iu3-yJroEns95mC5eFUJZ9CHibehP6AeRhjXxFTPEWtwaVdd5u8r1f2Lrr8OHveNJNbrmZ1eFw__enJcJFlVPEnr4Y9VfGm78_yUDpR6SwZUH8-90pYmM8_R2KC-iFxZ0ltt6CCMnXTgOreCj5Nsc3nscR3fPXEBKAmFzgp9WPHF1lFxY6s3VZ9NZWCccmjiXgsTgk-4OzvDTyT3dpVfhctduGjNaM-RVl_wLLxdk4ZUQwvEX4hkE3QACAawW3Hu2gRTbm5pH3cn4XTlIo99iAWTj9u3fD9oYiNo7JgUNUtjvE-Ic4PfT7peoTH2dy-V87asV95aaPfPsr6VOqwi-EUFpuH4JKboVarKO35Ig4cxepPiJ_UrizHhtBChEvCggBCYU8Ig1Gd8gyO7UaRdc6DQJS7y22kxQKlKV4pJea2RkSonHbXmF14K5Aix49at5YBweLXoqBhgZCFUhsfuuO3Y4jD2Lo1nXmfjJgo-JhFAVhzgUEpqfiVND2yP7ZpQwiNjlJS4V7STchRG65M1RdEARyxnnFI82YUdHkGPnj3_txx_0cwtQL2QntZbF_-AGwwNGziMD_XQJqE34yHyArTpHMW0Cn1hoFlMt6b__gnMYIrQTrKPx951LeA81jsPjjKAdT_YYguleU2GGNk7TgtilW7)

CU10: Dar de Baja Empresa especificacion
El Proceso Principal Caso de Uso Base CU10: Dar de baja empresa: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. El actor Administrador interactúa directamente con ella deshabilita acceso por faltas o término de relación para actualizar el estado de la entidad en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Cambiar estado de empresa a Inactivo y restringir accesos: El sistema modifica de forma obligatoria la etiqueta de control y bloquea las credenciales de la organización.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Administrador deshabilitar el acceso a una empresa aliada por motivos de faltas o término de relación, obligando al sistema a cambiar el estado de la empresa a Inactivo y restringir sus accesos globales.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/XPBDQjj04CVlUeh1kHbi9CLEd61CP5k6GbjCb1GAWJ9UJUHjfDsmktP8Ig6NtdfhZuL2hptcs5lo9ds2Fa9Naft8YTB8b_LypFpcFtEW3Igpo597dt5nZWepq7ECvGKN2HYre8f3oOM8cLI257ZTYWEPaIeoboa1Nf2MMJLhXkmiMQMcKi7M9CX_JhKmCOCYiUaV7B3Vy2vbj4hn9vr9fxKLTiDUs2jZf8f9hVp-Q3likXNxqPopCq5QWrzO9rAOnx6vDU9N15xdxdyvnaociVEnohZGn50_IUZlzTpXNckhEmx6eV-Oq1js9hj-BQ7NxZvad1JV0qQ_ZX7iLqVKx-jBRIXxXynmAGO3Y-3jzdQiY5um7EsDDX3h4znmn-zw5RRwi1BMglNm8fxIQhpTxRYktURERkZNQ1Murkq-hzL_zka_iS-Ign746HTS6uMnL0r03OLbxHxcYuu9ncYapXzJr2WCwI9qE8P-F-Av2ZWOECxzzJQYjn5CWoXuVVGYYE3FfsyGlfeUXb4GDLPYhC-eCJfkUUw925Dk6wC2oiuLQImwZ8uzTpFw3Ib-ofcDGsiJZAF5EX5CYYK9RY6NNB15QiVHvJZCUF1eLvirnwJFKqfiJLl3Jd1NyfIh31c_lHRvx3DyZ-kQVarDgseX7hHQWu8SzY6Yb1YpVbpF1VQr6jKfWjhjGKcv3pU_B7owYEdczuRFh_FbNOPZwpaaJFaL5dmWWOivpdZApOeylRrEh62E8wGXK3oP6v2dQsd__lZw1PhDgI8xRyoBbFrcqm6xj9_myXuxfXa1QOCA52NboI1SWf1WI922wWeIoey4SccMKhTjjRpWzyzv9wdDCwqOPZEEW4MxE9-eB0JIMa1H9fSypebIqENrjHqICUG3EWVsjSZ-0G00)

CU11: Consultar Empresa especificacion
El Proceso Principal Caso de Uso Base CU11: Consultar empresa: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. Los actores Estudiante busca plazas o convenios, Director revisa aliados estratégicos y Administrador gestiona el catálogo interactúan directamente con ella para leer los registros en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Generar vista resumida con convenios asociados: El sistema construye de forma obligatoria una ficha con los enlaces legales vigentes de la organización.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Estudiante, al Director y al Administrador buscar y revisar el catálogo de empresas aliadas, obligando al sistema a generar una vista resumida con los convenios asociados de forma inmediata.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLF1QXix5DtFLroSdS76Cx4J9nYJiJs6R1xXJVBWGU0XItgsY4Po94rJfnIwwQwxTbaeT1TALrrs5_z9lw2VK4dsE3F9X7QyaUuzzzvppv5Fj47Av1aFz1KJIwHG1dg1YBnXOWv6vRIKK38N14ibg8AmLqeWRAHApOfJG3TKownSDKFuQhujvLB1tZHslw3Sc6A3nDoMlmh0VgDToNXR4asxqsvhB-ab_QI_mKX5gDhce_5-qkkKukSBXgy4rHeY7vrAOPvYNJHbjnJ2xiFThp6Jd0IlonnpJJ7IppACZlgTqL5hhpU99qdqb64uwauFerg6ORltcEFKVuyuHdKSNQYEqM2WLzhGx3_h3PDYEBGKmiF-WHKnZ4VZet6LOcr19pc8Uk43jtfOGTQfLNqHpsarsUzrEnthvi5X4jLe5NTiklE7MjNx6JtZvuPN8oOP4qmRXOXK3K0QVAH8ZvpHXC846QdTuGnf90pL7ZgQm62GCgS26WwBccq0Oep8-YvZM7fmkj8kKga8Tk_TblsRmbcSnd-TdyOf_7Zp0PBq_69oQWD9sjWgMBoznlYY5OQNucywz-GLK6romXmtFsry4ORLYjDiAPLno9TBIXYrI5XT2gpMTuIvxT1IoPcLGMzam2Q49nvNM_w3E2Ek8xSqPinT211wAJ9arFehpZc25spkHXKzevgUrWqlEhHQGqySZY6Ld65c4AZDXjBsBUqOU5YxFVGyBVx-2nEOvuJUVw_aehgScrFOOKVPh9A2tI8WMviv89vdGZx0HnEBZ7c6C1LLKajfMN64sVgR208X3GN5vWi3yl_2XP-Vth-3PlFCkYq5OHvwt6m6O6t-30alBMOxploYI85JaJaHYOGLu3nRSgR0jW1kMIfwdJEzSMxtqdJRDdLzFxvr0osrtq-ypYdPhRIPjK3EJUCkxbzSxAZQ0HK4t8x1YJtbsIy0)

CU12: Registrar Convenio especificacion
El Proceso Principal Caso de Uso Base CU12: Registrar convenio: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. El actor Director interactúa directamente con ella formaliza vínculo interinstitucional para archivar el pacto legal en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de dos subprocesos del sistema para completarse con éxito:

Verificar antecedentes de la empresa seleccionada: El sistema revisa de forma obligatoria que la empresa no cuente con restricciones previas.

Cargar documento digitalizado del convenio firmado: El sistema solicita e indexa de forma mandatoria el archivo legal en formato PDF.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director formalizar un vínculo interinstitucional con una empresa, obligando al sistema a verificar los antecedentes de la organización seleccionada y a cargar el documento digitalizado del convenio firmado para su almacenamiento seguro.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1QXin48Rl-nI3SpFOU3TsuWHZilQksq1R0fiK2e4obcH7P5SAafQGb48llVNM7Wk5NdlCiRVaJVe4VOHAyZhPE1keVLdD_3FwvjSSQ8FAb4KUw7CkBb1X0VeCgRpaOWb6bQoMKB8Kb4Wbc89mK4iWCL9bvYfdW9TCow9UDKTolgnASwbWQnQxVr1lp8X1iRJb7mAmlybzoRGgYMRzMR-pbGxIOJfSQQIYJ5NvQBgT3dgr-F4P9-U2QGsHZywaC4-rBfhnQmPX_-7invZBd0OVwuobPWJriuJHth0tsUji3P8uIQEdXE6aFzkD6Wd3xc2JSUP_6unH4wCBDH6DHlfA6rQyHsAu5EEnHGXtXplMn32UJFUccuWD1Rrq9ng4DRP6MGLhtThSYEUyIhO7_LxFlkRERXerU1NtRBhtlrurlcVqp7kkk5enBRZWsYYaKhK0DVZ8EfrgKrAEmZ2ViyTrPk9MW398q4ZjFevGEvtsmaa2er76dJyu7WV1mrwtidSP7CLP_ERuCCxWpwTla6R79ycX3QHPgt9glMEjwKadZ4v5J4o9ERz61UmnqlGaZ1wNlCGvpxcnqkBkXfQvnpiLZ7B2xsw4Ovs-XIiWrXCtp6fgOa9uygJEAEy7T3fZVnNimsj9-O8J1Ef7HysN0gdKWNMdhhjd1YuMKXMuklw2AIq5ve6NTRjZVxVLt_xYWkGbPRU_VSxtcYGsyw94HH485dCkDJ01B7Tz5ZmF0Y4D0yMNPmRaOct7tnzVlq2xVMHzbw8QVB_T3i0Q_XFIlEOYK3PdxemA55jMkz2rKgV-_jcraTeqzNcrCHfbZnep3RZsW68tO8A2emqEx5TP_0C0)

CU13: Consultar Convenio especificacion
El Proceso Principal Caso de Uso Base CU13: Consultar convenio: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. Los actores Estudiante verifica vigencia para postular, Director supervisa metas de cooperación y Administrador audita documentos de soporte interactúan con ella para leer los datos en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Desplegar vigencia, cláusulas clave y descarga de PDF: El sistema muestra de manera obligatoria las fechas límite, las pautas legales y el botón de descarga del documento original.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Estudiante, al Director y al Administrador verificar el estado de los lazos institucionales, obligando al sistema a desplegar la vigencia, las cláusulas clave y la opción de descarga del archivo PDF correspondiente.


![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZL9DQ_D64BxhLmpEpM1ZoNRYl1ZpIfOCkPHG9OT2e4nsD_QIrQxPNJKVfT1BRxsrnqAXjr9woh6t-9_q5_GdT2H_82SAl3AOtNbcPfzvdldiF5fV5YfmzrAlqM81ReNSF4Yz16zBqG2iAJLdncfX8Hmt06JUsDm_AG7u89mfcbMtoEwNkr9bB9miukeND1iBvb4lgVpx0EXB3YNpNKcq62r6lPDid4sooJR7M2xi3e_cmsmyQCIlLfBTQ-4SH7LqORH_drj5S_ai81mTxjinRetYmGzDZgKJ3Ds73AFpoI0vxvsCqpZDelSCmsIqE8jQ6ORzyLkEY_fxmp5gumZqjJ6QJjsJywBu5fcNHizcH24ycvoIY66SpC_dHnJR2mRPQJGE6zpQqlPaIQst6_6HLkbmF1eCoCtJiongqIeU43puKgrQ_Om-y7FBgvDAAwfJ1z01NVRnc1TII-SjyXrOH_PmNgw5_Kww7KRNFP9Kgy45fEYDgmwNw51xuUh498NfD9ULRZYR1S5XtwdbDpbSnddyrTL5dCE_F_uAMNvrdLvG8CixEmNtkzUPN_V2uOsU6-rAvT62SBxaidgfVcX-7GwFAnPIUKk9p4ZD91VqHtbhOsyqsxnmkJHW0DT2AScDsuxCV0ZlV3vkcmgtLc9PCNXS2ou5CO2d6qryIBfAW7KjmEPlF3IDMfgI9IG_z7gpcZjyWlrii2AzZ9Me01dopP-5P2QexMYc9wLZs2J1J47Cl0d8dMRYruACGq1L5jeuG61eboQeqNv_LazDQQz_aKwgvEBrdoCiQiEgzabAIFP88WlWjVkaWIsPBosIea6W3R6oShdoOExs3ltt-oy_GxTxQGKpcaicDo_wKxSR0At07v2fXh4avgsW2KaEKafe40hSTfVwb5-L_FPJrSiutzOi5q2JbwZaCu92aFhEs0BhBEhjKIdaIAVce_r0Q0uLzU0pdShYVm00)

CU14: Dar de Baja Convenio especificacion
El Proceso Principal Caso de Uso Base CU14: Dar de baja convenio: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. El actor Director interactúa directamente con ella rescinde acuerdo por mutuo disenso o caducidad para modificar el estado del documento en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Inactivar vacantes amparadas bajo este convenio: El sistema da de baja de forma obligatoria todas las ofertas laborales ligadas a dicho marco legal.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director rescindir un acuerdo legal por mutuo disenso o caducidad, obligando al sistema a inactivar de manera automática todas las vacantes amparadas bajo este convenio para evitar postulaciones erróneas.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLBDQjj04BxhAGRd433OM8gTEC6OoBOCWPA4AWaK0cMyEtMsaNRJtPL3MWAzzDPRUomKUksnnzxID-aJz16walpZEWfqVV1gPhvlllbc3ur5RRCqySora3UeCGLpXLpT2Za5gpDQIsYLISwKbgJ1xwmba5cbOtkN4E0j6PMkeoR8hgTpQA8qR8t3_EUj4nEpAASE_iu3TmPBo70E2SRjSRkn5NMYRjGjQvJcfEVvOBWJTLfhyRChmQub6GD14HqhQH_Nvj5Ol2NmsyllSeo9IhXtlwunCyJGFAamsE-s1lkDhSue74N1OuN-e3tU2oeL-itEfiPnSJOq1bKQmPqgHRsUkJEMqfV8h52ottSI_BtkhZFH3mV3_U66n2f0AzeDElvAMtNPGkozj_aYdl9gjDDfjrfkcxjxKL3XLTXowTP_UbMzp-29VPQwQYEXAR_L00suZqKyvAcGmbYDV9ui8elq00q19nYXLIQ_dA91QSaKfOCHz7gnoDt1Vj_pLg-w5h-8uJICm-Epep26t-y_m_3a-28wFZg9QwLBo_TL6vut_FQbV4xJGeW6fkICf515a-6vt_wt_a98bYMkZYkMfIIj0kIlC_T_AU-0ZCL9GemqpCIK91DOpiMi3u-McLlax816erzqWWCuaeQqHP0PpTHI2wIecV8ATzQh5we1MKQQAn3IM64pvkWnyOggPhDVjZ-0X-zEV99nUlXPvdAgmSXbmYH5HX9N7KaMmpZExOjy4alRdYUL9T1YUcL1lLgOy-VhfuzGhvzgSc0kcFZrGnxKwnuuvx_1CmHARpGPX5bf7KVWDA62NeEUZy2nQ9c0ALVQTFYSuik7d5iPMqKU9Il1RpBYkA9JG22a0o2ORB4CnqgIGpw6T-XkMVeN)

CU15: Renovar Convenio especificacion
El Proceso Principal Caso de Uso Base CU15: Renovar convenio: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CONVENIOS. El actor Director interactúa directamente con ella gestiona adenda del convenio para actualizar el periodo de validez legal en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Calcular extensión de fechas y adjuntar adenda digital: El sistema realiza forzosamente el cómputo de la nueva vigencia y asocia el documento digital respectivo.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director gestionar la renovación de un convenio previamente registrado, obligando al sistema a calcular la extensión de las fechas y a adjuntar la adenda digital para lograr que la vigencia del convenio sea extendida legalmente.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPBFJjj04CRlVefHk4LA59iO0eeYdCIfa2f0DLIgX5GDkuEpnTb5k-jGg91wwQstzbYfKgyzzjWRVPC-GH-XkoP06enKvv3r_FdycszsnrZKjfmLWJaJyXmrpi1CaQiB8NEmkgIbX5Qbv4nfIHh2U2c1p2gTsSk202_8gDbormcoitpHMYWDQvF4_u9bOM8MPUxQtmNWdk5zosZH4aswasvhBOtJNjgxhL6Qarxaez5w6dUMueTJmSua6GDH5PqeQH_N-cWchWZ2xiDxDSQ9AdXmlSnO6c9edYICjdgTuLPhBHudupHwJ1WEkvFDg9OmRCUhZ9FgMM6CwXXzg8wetpUNnjBiDJ8hb1mC74AusTjm9eR9SBGrMa6iQ-Ya6r4SBh7LborWhuFL6_6KL-FrkDlfk6rkRAPHZLT9nwKx_-bL_JwZ9_PvozKO2qt-r00qu5xkuaE_OKumHgkCFnoWGMd9L8N3CVJxcV3Zus0G10_Njf6zok0WoPAzmzqaWz_lFyDeV-zbkhUxdpKMDjnTeCReg1N6n_85IJL73Kp9EKcXga-CZi9ufHeBLXQkZjvQaaRy-Y4zs2cnAPfZUGd8tvJIedO7aXo1YrnOB2gvXDaG7gtC6-66XbPhK7qGjk4P6P_3Un4gxi62ggRT7bHohlZckv2iA3dT_AnoNiYRi-qBIYp45S8vQQ6uygXp5-5q1GNbM0I1L9P0YtngGPtU3VpdwwUFq6mUQ79VvOBvCRURpG2SbzyWVO1nWYS4PFp0cd9Xh4Qku5pJNE2CfAMsQ_9zNpvuGMLidU9pXBd8IJBnxwnE-TPeBZYs0_SFdZVOSQTozXS0)

CU16: Registrar Vacante especificacion
El Proceso Principal Caso de Uso Base CU16: Registrar vacante: Es la funcionalidad central dentro del sistema SYS PASANTIAS — VACANTES. El actor Empresa interactúa directamente con ella publica requerimientos de pasantía para archivar la oferta laboral transitoria en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de dos subprocesos del sistema para completarse con éxito:

Verificar estatus activo del convenio de la empresa: El sistema comprueba de forma obligatoria que la empresa posea un lazo legal vigente.

Asignar estado inicial como Pendiente de aprobación: El sistema otorga de manera forzosa dicha etiqueta de control a la nueva oferta.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite a una Empresa que cuenta con un convenio vigente activo registrar los requerimientos de una pasantía, obligando al sistema a verificar dicho convenio y a asignar el estado inicial Pendiente de aprobación, quedando la vacante guardada a la espera de ser publicada.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZL9DQjj05Dxh50zd4J3OM8hjEC6OoBOCXL9CbGGAWJAMNkGXqemxCt98Iw6RxhfhbuL2jwMhBhjBRj8Jz0XzeyY9d2XGUpDwFzzyFtEa3LCcpr97Nt2nOefbe9SibfTS961KZfM6ahc88wa4Ad1xbGQBZ5IXkKeHs2LgcLMt5YowIChLL2hOcVdsxrI1CJ9C9BJ-pW7wZUzM9kMAD-lEkgsTe1SCWi7jZ5GnghBlJVQ2NgTIFrxow4AWrk0LrPaKvl6ihORyBOBRlVykP2na6ZllgnnpZH7JJpBq3WQTyK5hfpVrfu7tcA4xxixslLg6RhltaEEi-3tWwDLnjAKwHiEXlj86izUK3PTYD28AxlwWJoQw_dXoCDcYMB_G2VfUpwrmgnqhoP9R3r_4KrvDzthTJeVIxEy7NerNVeVQdV_qgZvFxuayRtarWcobKBC6C0rqtfJ7Dk0OOSgCrFOmPve9WxeO74zXE0ovLSz68yUvVxMDy5K8Sp_qNnm_yqFuy-4BdFeJ-Wh2Hcd2vlaq9YSjjtycNc92I8efMBF8tb5SCJbn-zlZfwZuEOze3hLX9jTWZL_BCn5Z2f4KQnHSMguf0wp8yYFZmgEqji5zpHDHGiSIkE0HPnOr8_pTEOgOep259Mobv895_EQNsDtWUpNuv34P2gtMg103Xp3F5oa908LlSXAJ4MJfxgfmz-OdSuhHTdjKiAQTwnzSH6aUu_NlhPvNrwExA1lg-2fQyZK3UOxAC39a8HN98PU5vXGmPuuZ9EbHF5aQ6jlu_VVRvq_GRCufKKcQ2vM7pQO35ELtU7vdB95U81WKg20Nz-wlUM9zAgDfqvvT_VhHOafjwa4tmGFP4fCzvOEW8okor2jKzaRGg61Lc4ZDjaEfW5NX7D4fp_u1)

CU17: Actualizar Vacante especificacion
El Proceso Principal Caso de Uso Base CU17: Actualizar vacante: Es la funcionalidad central dentro del sistema SYS PASANTIAS — VACANTES. El actor Empresa interactúa directamente con ella modifica perfil de vacante abierta para reescribir los datos de la vacante en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Desplegar especificaciones editables de la postulación: El sistema habilita obligatoriamente la interfaz con los campos modificables de la oferta.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite a la Empresa modificar el perfil de una vacante que le pertenece y que se encuentra abierta, obligando al sistema a desplegar sus especificaciones editables para que los requisitos u oferta de la vacante se actualicen correctamente.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPBFQjj04CRlUeh1kHbiBCMEdM1CP5k6Gbj2bHGAWR9UJPmbqgwxksf8Ig6NtdfhZuL2hptss5lw9ds2Fa9dDtAY90hKlgpcpxU_-MRtZMNQbaKUc3CXrqop0imfozIva2kmkiHQGgjIPbnfYHh2GIt1k5KwjHSv0Zj7eufwrvBnirNLcYiDMulO_OEwC7BBv8hQtmL0l-bDowngYHRzHR-pbGoIKJAwhb4wGrtbezbsCkZLueUdWfz9D0OY7rqeQH_MkcWgBX72_kst7sEfyYnuNsSi3N9c7YMCTaUzwMvdQp2Fvqdqa32SzXV3g94mx0xkCoxyxnvZrCJeGar4ux6vC1QBrxGReUHaGWZXSBH39eRnTBOxkulOsD1BTg91M6ThBAjWoQrxB-8nh-RRWtwlHzlS6IPHWrTnZzAz__MgSP_H8_kyvcebnLgZOIrW1kYy2K_TWZE4ERFAkCC1CqnQDBvmEeVnE1LkUZQP1C7jgssbhr8uYDFu-U6JE8K_7xx0otX6NqdQgapOF9_MxAWJ3ezbp6t9Sd79DBnbt5tYxvWTXSExzNCqwnnNL4S7vE94SCR9UJJ74ZDXsJ97pvepM2jZovpIltzABqUtXF1WPSu8cXewdOc_4FRWcSgyCgnHduZSwLLOm9O2jMM1h-ns9rwKMgv-2CdpCiEhNpxdvQPpohn0D5oB9NcvCJ9d6xqWa8fKjLYTMb0dcud_Vlly2Thj0p9LoKpu4VRQxG38pU_mzAQTn9ReA2rAvAY1EMsytYTS01hBz8QvI-rEuUj79qtcD6eJeSOtfJ32mPO4vNhlKeD1A2gFP3T0cO4R8zYdKrdy0m00)

CU18: Publicar Vacante especificacion
El Proceso Principal Caso de Uso Base CU18: Publicar vacante: Es la funcionalidad central dentro del sistema SYS PASANTIAS — VACANTES. Los actores Administrador aprueba vacante solicitada y Director autoriza publicación masiva interactúan con ella para actualizar la visibilidad global de la oferta en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Cambiar estatus a Publicada y visibilizar en feed de alumnos: El sistema modifica de forma obligatoria el estado de la vacante y la despliega para el alumnado.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Administrador y al Director autorizar y aprobar una vacante registrada previamente, obligando al sistema a cambiar su estatus a Publicada y a visibilizarla en el feed de los alumnos, haciéndola pública en el portal.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1Qjj048RlUeh1EGGCDfPY9qum9h8jGw4KWv928L16seczHDerkok7f1HwwQstzbWezDfZZxsbRz8dw2DqLvOJrr5exOjsvf-TR_wTKsrGcIBFF7t5nH8Lvg0NoEGr5tCmgg2jX9A5OAbKWXJulQq4faQgsDna17XDMkRRLGccL_EgD9CAzgQX-tlR5rDgKCnj-HiFx6zqNpAkIe9fTzfjxKMzg1_rrngf6Aag7umFebvdAtwsuEcL8AqXAADJASnZhOl6_9R0xpwSop4IcJ7lxJPZeIb5_IHXSDplZ8vRUxr9E8c2nuJ-g3iz2ce9_NPlbt5Q_dOOWpf65weZ6WpqZJQKlyRKS2c6GulW7_KFhOb-E1eVZtSGwmewqM7GyxVOwcKLh7LhPoEUycfoqEjsElOr3u-YeCQhi6FJdV_qgluzWoVUSytL25dE1TT68PEg0QYXZ6pI4-usiihOmoO-SWl022Pef7OVCzGe3EbIE9h0O11pvmuEXvxtiDMD-5KCip0ENvmz2sFuzUuJl0p7zXJ5ZSgapNernkSjltyXPaMIyHGLh31rBSeEutE_lwF6FE5MHTgWAJGWx5UL3FSln0sikEO9p_Yj4mcu968E7BCY5tBD7QR6XqVlwjmgJO5MQrXsXXC8bwgW13TGeALjnOrjvbcR_b8MrZ7R5PPhd9J__2uWHyrNw9MQTdjOjhRYkszSf5d1wEv7cNCNEJjFdA10Hty_24C6yqmccBavCWHvISgWvmbfWHIVBumDRQpw_UNZ1sWsPufIAHWlAKwQJG_i8to5vm-JC4e85fYG0isP14NpzNxO2HIjEEPaPMrRw6e_ltUNIct-SIlfDNT6pdpAO2cLgSYbjcbJCEwKkksHOE1cy4xjLv7_0G00)

CU19: Postular Vacante especificacion
El Proceso Principal Caso de Uso Base CU19: Postular a vacante: Es la funcionalidad central dentro del sistema SYS PASANTIAS — POSTULACIONES. El actor Estudiante interactúa directamente con ella envía aplicación a oferta activa para registrar el emparejamiento estudiante-vacante en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Vincular CV almacenado y generar ticket de postulación: El sistema asocia de forma obligatoria el currículum del alumno y emite el comprobante digital del proceso.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite a un Estudiante debidamente habilitado enviar su aplicación a una vacante que se encuentre en estado Publicada, obligando al sistema a vincular su CV y generar un ticket de postulación para que esta sea transmitida con éxito a la empresa.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZL91Q-j64BxhLmpE8M2miHGxiOCnaMKP0Y4nLH8e1CfOcjhRIBjcT-KqBO5UUkkjFHOAlPQUUkmj-IVl5xoVy7ObHq_FKU19bzsP-RxvvfizKngbphFKKVUCRr1Y1cgDYNXWV0LQvbHBI97p91QIamHtK4jWh8MCz6DAW0-aH5P7BJ6-N-sWgP1mCFVjxzI9ATR8LmR-imFccrQGO0VnvlrvltCG3i9XE2nhX4n8xl9US1GEUhNuzPh5zvoK0g-8pWNN-xLbD68_4RZzwbwEiHHfuZpLDUQAObJlAlH6mzvqr3aOpFnPwBrLw4xxynElKQ7R7Unhd1VVdaQlIQCDDIaQZzMZqfHzXx5cWaycHe9xCZms9hh-D1W5UnAR0Btms1kuLTVciahiaxF_8jxpQdOqwFTwPfl79w7Nu9NVC-dULthLl4_ldNsMkbgXqdd2a6jg0IemrzVCrEuu8PYX5ieU5gXidIeAfpCOZoDc3S39n74-FznMz6q42p_oBw_F_GW-_F87BAwYwviBFpY_kWoZLcb6zOnQmKt77TtnXJ1IKfI0iCMuKXJSkAClwsyPZul2u1OmpJ0cZec0npk-8axI9BGnYRJLl2b9O_Ro7o_e_5Yxy6PrrX0pEdGwaw8Xd4B8jo__8k0cPN691mJnFKcDO65RT8hARdTIafx2ypz6MPedzFn_cRDqqvd9V4ChfhH4e6o3adx0Z17N0gXolxERsN6uq0IIhTRQj7iT_-DVl_y6xVP2KYnumWezf-ss0yRVlo5CQqoGq9Bi7IMiSSbIfWjx8AsC1UAsm8OF5_dIJfZWOTUmMS8_VxMTXD9DhIwmxgcb0U9RPl10Fp8j56PaEo2anRII57OTuWdOkPmpSygpJm00)

CU20: Aprobar Postulacion especificacion
El Proceso Principal Caso de Uso Base CU20: Aprobar postulación: Es la funcionalidad central dentro del sistema SYS PASANTIAS — POSTULACIONES. Los actores Empresa acepta propuesta de pasante y Director valida y otorga firma final institucional interactúan con ella para convertir la postulación en una pasantía formal dentro de la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de dos subprocesos del sistema para completarse con éxito:

Notificar preselección interna y generar flujo de visado: El sistema comunica de manera obligatoria las fases previas y prepara los documentos para firma.

Asignar estado final Aprobada: El sistema actualiza obligatoriamente la etiqueta de la postulación al nivel resolutivo.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite formalizar la selección de un estudiante a partir de una postulación activa, requiriendo que la Empresa acepte la propuesta y el Director otorgue el visado institucional, obligando al sistema a gestionar las notificaciones de preselección y a asignar el estado de Aprobada.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLB1QlD64BxhAGRd433OI8gTEC6Oo98CWP8Ob1GAWRAMniusqgxPNJbrIw6NtdfhZuL2hwMd7djBtgHFq4Veh2p_aHC5VldWsPdvvllscxtKXYbJ5hcZ7xbOCyKAq0yiaqzShC2e4Xi59KkHfL89LE0D6mMM6gaIiyqHs1DgMJHH2vO-hcfeBXKSpGBxSvg3CJLCh0Z-lGFqJJz1mXhYpmQpGUye7iQZUBJhaIf3LTVzy2GUketyxGDF7mLg3NwLdKbXtlVQRCA_G_06h-Vg6WkPPyuFJOsbnfJf3nNwvoDtUjux6aP15Fll5NhJmUpCRrNezOTlDSwgxur6lqsZJRKf6e_rLXiilgRTS2ac4vBWdOrEoKGlc8RduO74Te0Rd_f3hwcjjQqMQzqwV14VUHMT30UkIziyFOlz5gy2byhkvthLka__WttkT7NYOgrGimum3HJlqn5NQACgJuTzVceNdo54p4XjWpdJJ1ZKLUCqWl4uuTOLDfaupkjhxYHV9J0Fak3wzYf8uDyVVuNvJN9xzqKGNjrSnqcdTcZ_jZhXNSztxqMmLdB15AobDcNEKlxojwYemZlVFKHSIyENFBNDT2FCCQswWPCy9TYzsC8A1IfgMERbDzAgtt3DCbaD35BZmRkT7b84cgy4uL4RWi6I2vR3yKvZnextS_oMEUGusGkztgII3XVKY6l3WC3hqWwqUjOxDnrolDdw9Sjvnc0BafQmOaIi2bRJSw4DDsNA9PsS2j3lJwhh4FBvJoxIlCpm-P-3cjzMiupJY2gX51kEok21xu2Y5lZo5x5Bqf0xZf3KflZgmO1SxjVot--__0pTxbnXAaN6A_X5j-i0RVuFY721WDzo4gwW5EoGnLgsiJb5R5P3XZaWDMJSUjEd8NRERpzP0WAsCSHD18LGlmSfQ6-rz0AfPYaOoBIaVyWPR5Yw8q6HWRsQSqbHMVmF)

CU21: Rechazar Postulacion especificacion
El Proceso Principal Caso de Uso Base CU21: Rechazar postulación: Es la funcionalidad central dentro del sistema SYS PASANTIAS — POSTULACIONES. El actor Empresa interactúa directamente con ella declina expediente de postulante para actualizar el estatus de la solicitud a Rechazada en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Despachar alerta automática con el motivo de descarte: El sistema envía obligatoriamente un mensaje informando las razones de la declinación.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite a la Empresa declinar el expediente de una postulación activa, obligando al sistema a actualizar su estado a Rechazada y a despachar una alerta automática con el motivo del descarte, cerrando la solicitud como no seleccionada.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1Qjj048RlUeh1EGGCDfPY9qum9h8jGo0afaeEXK2Px4xj9TAkkxjgcfH2BxtrrXuBfRtss6DloPlq2Ve8NIboepWAT7tmQcV-sM_-sNrZKTiiJJnp8UGIDQPW5iZLfP1pi3gZIa2hJ7Acj2GDVgyIG6QLZkrLGe2NP5HQLPqZkvYNqaHfs9Y6-S-h5YPcKSwT_Aq7Ret-ISQb99XsfztMHjIB-b7_BaTfJhgC1-EjgDUfd9yi1BkGP0m4nUbKIRkMMvx6ufh0xzv_5ssSguHxxwgCcI66vad2OBVV6UssDdgJS185ZmdzKNUw4zGI-ktUEkEqM6kCGHqZk5L7D1YOAsCfVO7C2YM7GuVWx_ItdOb-E1hlZjSGwmITQ3le-HMs-hGIrhcrzYAUycgorUjsEcwQspjHKEDLs77XpdzwLJ_Fu8bvtd4redIfoM03q83Rhuv7-O0vmGIjClbcXWQb9LCaZYOm6CGYxnw7Gy-xVxMD-7aCip0EZquEmXX-l_yCi-FuvFGm71yS7qLnetHYzOOQuzDMu9_9PyGMU8qQbihOB44cRd_AugxnQU0_b4p8BD6bQy24j4N0pAhqzfiL384fUIOfWLHPyLhbv9mCGssfg1OowyEZoUL-kEQXrHeMzy4UJ8WbGYBGcoLnGTBcXLPqxiihyjhjOL7I2Mv-2CcIZDFDho9M57D6xUK96IRY6e6CHPiLVXgL22PinW5Xi-oUuwRdIMK9j9WlBAYNg-x_VFtq4PhDcIQc91U5EtlDfWVEuU-EzPmSg31MQCWaFZ0Ha3adiEroy_Gl7_8wBbvNw71D-YeZZi18Qyp_LQf0AZ2K46FEEEIkB4aEEREtxtPP-XS0)

CU22: Generar Reportes especificacion
El Proceso Principal Caso de Uso Base CU22: Generar reportes: Es la funcionalidad central dentro del sistema SYS PASANTIAS — REPORTES. Los actores Director quien Configura filtros estratégicos y Administrador quien Solicita métricas del ciclo interactúan directamente con ella para extraer analíticas agregadas desde la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Compilar métricas y estructurar documento analítico PDF/Excel: El sistema procesa de forma obligatoria los datos agregados y les da un formato descargable estructurado.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director y al Administrador, siempre que cuenten con acceso al módulo de analítica, generar informes del ciclo de pasantías, obligando al sistema a compilar las métricas y estructurar un archivo en formato PDF o Excel para obtener el documento definitivo solicitado.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLB1RjD04BtxAqRf1I8bn6xIfbKKrKaSn0MYkZqWLKARzTHTTRrRxQxL5eJ4XHitE28XSQiGfnwvDN_25_09Z9s4M6aYiRwivysRUVDcZwnZnkMPzEobK5VCi0pi1KlqjL0fE9DZ1J0wLmdNHg41lrC167VQnEvM8h1hj3ghigQCNwOBgjG6TiPXyNdLmiWTKodHttb0P_2FCbnGWd5xt6xiH9se6tNdETeaQ1PuCDoDEgrA_EH2y4k5ra9GHiTQkSUvHJGMRn7yzkg_76EgPUAzhshCBN9cjoeC3hgjmK5ZfpCAHr7mMA4_Q8_tWuqA_MPdNUEuF6iQWqqQWSucHRsUlRKEipUCEw5LlqyI_Ftk7fdeXuFXmR0YPHkX5Uq57R-gRKFQKYovjVuYjdarsksqMotQvjv-56pmAcmHtFfVhpRkCzYopxcksaWOB6urO1RePnaFaqmeOPrXoG8i8qjum2n2WZ1YJjlYCc6MAOUsJ1sCeDUBHU4Ew_SzR_MgQ_7h62PX7BuyUH76yFl35pYE9g-EJwAujZ1f-RngmzD649ofvwZGC0C6hxHPTXYU1i5QjiwkXAIyR7RdZA0Wt0BI03btEV7FLA9vdg5o6fXYSlRJ2QxXoMGqVXRTS9HFvrDovyEZrHQ6aJdGQFJBrd08GwtEHKgLuLn8PxGjcp4tkqkfhlLAkwg4M4l1XMCLWGbAu89BxPKvpMQ_x4_93p-4uZ9FyE7N7AD2P2iXqGrrmTK8L8Qb1bEMCEjvIZi48z8B1_fywTAVRvy_GRq-CSYrIaZ4x5uTrkiUaF_V8P9aOiwCqAHdYk0Alu5nZbO3aoJtFiabWTMcJI8N_AyVYyBQkasLOmGzTOBg0KfOsKzZBxS9Tk5AefiUgWIA0RmZkkNPNm00)

CU23: Consultar Historial especificacion
El Proceso Principal Caso de Uso Base CU23: Consultar historial: Es la funcionalidad central dentro del sistema SYS PASANTIAS — REPORTES. Los actores Director Consulta auditorías pasadas y Administrador Audita flujos históricos concluidos interactúan con ella para consultar las tablas de histórico archivado en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Estructurar línea de tiempo de procesos académicos previos: El sistema organiza y muestra cronológicamente las acciones y flujos pasados del expediente.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director y al Administrador auditar registros pasados bajo la condición de tener el acceso concedido al sistema, obligando a la plataforma a estructurar una línea de tiempo con los procesos académicos previos para visualizar la información histórica requerida.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1QjjC4CVlUeh1kHbiBDbEd61CP5k6x_BLHCcX42YJtOszZRJhxguIqbBefRVUscEXq5ifEUNOM_mcVO8-GdVNTgqcCbIwh6R-i_FJV-PO6rIcoBD0Nt6nG8Kvw3bIUSF538mgM2cXP24eaKem1M6tb41Yf4hDRSO0RvYMURdg0idLR5sQIGLxazYzGVbYHWoAcIr_4u1zXdzAHkkIQDAPT1fxIJVf9RsLHYhAr3eVZTf9jrMAdyuvkH9CQuXyT2A5UQfrqPI_PX1sjj_-DovaHeEtPSP2Cu9w9s5qs6iD3njxtN4yJgAdXE6mCpc8AWd3PlSnuyG_ZnYZAaONgYBgz_MjDYn_OMV3fHWCB49uqDkt9eRnS7GuAg7iAcWb-r4tBB5LorQmrgt76x7Bgt6xsscrx3Jt3vAemgkuPTEjV_IgUfxHZdckk6fZhfWxrG0rs8zDFAOv5rmRXNITz95DUkWMW38Oev7Q7QQeKHYclNGuXdu_vSuT70o2OBlLjVHv2jCuZVy__IzEuUUxJt2IJ9-Td2PfRMtIPhrgexD6r3uN8obqaHbKCEVQDkUO-IQZiwZzTq5YSGjY2cMrsV9EC7HaXhDy8UtfN2oK94nRO2H8bzzoJknveTWrbolmc9WGdWpMsMMjWKPZuBl24MoW00lABTJo3krDg96Y3hnJPNNiH0YNMV5IQlyRotlbcnCfI5OixwZKWHStcmDFOQiUldENfEpXXy_v6uVZSdU35nbw_xUN0YeovzT8PH08QHWeFfiRa9SRntvz-VW1wlMfOhOxvOGlxyLHlHw07STNsznP19Y1NWtGCpBAgMnQYLDzVk_AfJPLzIc3l61kSI13uE9IgXozncAMx0AvPKPGx5N15AVO39YWuBY3Otigyjy0)

CU24: Asignar Supervisor especificacion
El Proceso Principal Caso de Uso Base CU24: Asignar supervisor: Es la funcionalidad central dentro del sistema SYS PASANTIAS — SEGUIMIENTO. El actor Director interactúa directamente con ella Vincula docente con alumno activo para asociar los registros de supervisión académica en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Desplegar docentes habilitados y enviar alertas de tutoría: El sistema filtra forzosamente la lista del personal apto y despacha los avisos correspondientes al docente seleccionado.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director enlazar a un docente con un alumno activo que cuente con una pasantía debidamente aprobada e iniciada, obligando al sistema a desplegar el listado de docentes habilitados y enviar las alertas de tutoría para establecer formalmente el monitoreo del estudiante.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPBFRjD04CRlVefHUekKA7QJDgsYg4xie1uebTmY8LL2azqXMTNUZNRNhGf2uiAD6noHaBWXn8aZj_PDU08UWLqteQPD1FPbFNy-_-QRFJ0MjIsBF33dGYvGOm5cZbnT2Za3gqkg9RGg9MTAIz8Gzce9P5Rfp5xb17X9HXNrhYcoyzcoDLSQjYQnVuEwC36BSkRQNmNWdj6Vbl6o9Pfq9ztMLjfB-sd_jaPfJdgPZyRRQQzJYv_C1JkNP0n4LNIYf7rOwwEPU4aGTk--gp6cAkV1wpfZQOYXsKWOxVKxextMLY-9apHwI1YEkfFTQ2rXsExTPvnKppt6Q1sZ3wqZ6WpCbR5KF4TcXPB3eKC8T_ixpiGm7ettndN43GsTT2VgXJMsjMLBMEVM_HknoQjakzVjTDmsTtRJQ8rNSSUbE__frVfzHXlsUSlLI8GcVse06d0Vg_Z8RvWJ96YLyOTZD2WjcQfmbC1Wa0a_FWw7GN1tRHlPimoEuom-EZcCC_ZvvWDawQFJmyU7wT79ayRIYDKLQenFMr7tJCP6p2HgCEM2z8KmIvxnQTJzkpuXiyXfvagvOkHvO8vJaGkBN9apUGKaBuHBOqxQOaLkIpVHpJUi96DcGtYmEc-86nvQhM7rKzY7fqAoCiVLVu0fwKJBGYhmNHSgg0hRxM6bwJgklxgMlEHq_QFALMgZn6LYevX0q3HpbkbRFrUZYfllqYaYl_bI28P189Kbq68sjw1Uh2puzUdzEsWsZpKv3YwOxzflDWDm3d-6D0SojkG2FIcdAO4bIHfAYR2e5kVc1rneDKMEG22aqt37jbFm8X_VUdLbxB_bMKdIOkL7AMiR0woMo1NuY-yIK2WfdFMasW593dwmuC2Tok8t)

CU25: Registrar Seguimiento especificacion
El Proceso Principal Caso de Uso Base CU25: Registrar seguimiento: Es la funcionalidad central dentro del sistema SYS PASANTIAS — SEGUIMIENTO. El actor Supervisor interactúa directamente con ella Registra incidencias o visitas de campo con la finalidad de almacenar la bitácora en la ficha del alumno dentro de la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Habilitar formulario de bitácoras y control de horas acumuladas: El sistema proporciona de forma obligatoria los campos de texto e interactivos para asentar las visitas de campo y actualizar las horas de práctica desarrolladas.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Supervisor registrar los pormenores del avance de un estudiante que tenga asignado, obligando al sistema a habilitar el formulario de bitácoras y el control de horas acumuladas, logrando así añadir una nueva bitácora de seguimiento al expediente de la pasantía.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1QjjA58RtUeg3ipFOM8gLEC6OoBPyRnOtDrJ9eX0enwCJUuWqOsP6ITDIwAQxxjfbeRJRqaNfihluJVe4VOJEA7QYEWfK1gEPS_vVt_nd3hH1POeyy_G55mjKc8EUOoglk9Y1KGLL2aeM8cLI2LBWXvK2CYDLOgup0hmYBVEgQehiOhQIPbB1rYHoFwzgJCoWc5dvIm_iCxoJZ5QIODATT5jRSHZtujvjZrGfgLKz66t7OQUoVpBdx4AGrX2KknCfpCDUjvlm5mH-ztvT7cCgizHxLMKiD37KZn86UxtESA-r5OwZSHmy9FI7tSbkK4lejyDDnadvR306TOnkguwetzVNsb3-39dXKWm65i7VxUtO4FreEDeRRIBM23hnJX3wLRQwjZMiJMlZHZoMrNWxx7OwTfexkt5GarNKiUNEtsPLEy_WaNdUSZMIOa7gackf6e0Qx79T6RePfmHZD5AxbsFKA0pfid4uXdu_uIu070myx_xYDfAd2Hn7INHqSXWbyFFrUqZYVquF_pkCZqx-RwoYM5-YnkYq5OHduWdDh9b21Pfc1Syv2IFBBurEW_1FoRyuvHatjlTSghp8K77f0AVSB3yngL2VYMjWKXWbCrUOkpr0LhZc56zF437ZmuCXkcXi2D1g3SelmpwiqO0BnbEoVrOjmOPc6Sfa6EOBwPNjxVQWTBQwcozMa1KftVmeQwNdS6mhKPOZ8u7tn402CeHppkPe7JF0hCY5z3mX3O7Yixa1URxEujV7Ts-XsJoseKkHSiQNtyL-i-c1JVipn1dekwbQioc18K4AKFEPm5G2hltRLk9K7zuuEwbDdLz2WCjlc18K5baKT5a5JwawCMTDpnUKkXMvOeQmA2_EyYksFH8fk2Dv1_Qjo7y3)

CU26: Evaluar Desempeño especificacion
El Proceso Principal Caso de Uso Base CU26: Evaluar desempeño: Es la funcionalidad central dentro del sistema SYS PASANTIAS — SEGUIMIENTO. Los actores Empresa Evalúa competencias corporativas y Supervisor Asigna notas de informe final intervienen en ella de manera directa para consolidar las calificaciones de la pasantía en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Desplegar matriz de rúbricas y promediar calificación ponderada: El sistema muestra forzosamente la matriz evaluativa e instrumentaliza el cálculo aritmético con base en los pesos asignados.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite a la Empresa y al Supervisor asentar las notas de la fase de culminación de un alumno cuya pasantía esté en etapa final o concluida, obligando al sistema a desplegar la matriz de rúbricas y promediar de forma ponderada su calificación formal por las actividades efectuadas.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPBFQlj64CVlUeh1kHbiBCLsd61CP5ikWJODA3aK0cKiZPqbqgwwkt98Ig6NtdfhZuL2hwM7qbjwYz-aJz17wAoSFwgZm4-wxCwVsSz-ltjgB6fRvfbdReKiK6CEvWPJTIVa6gmkgPRGgfHfehGa3VwWbi34AXtR-um0xyYelDwrnEHs_ToQAGq7Yz3zNdqm9HRbcjk_zO2_wMlBxBabMFGN_Sv1D8X6qMXNetHA-ZaVp0wZGQyMlxmHoQqaOo2eeWibxVjQ5ut50u7VVzjNrrYgBFM-gpEMXX8q7n86nwFUzBXpC9Y7yoXuJ-XF-ukZe97Gxmxs6HVLjySOD36wK1FHU6pkZQNyQ_P6A3cPC89_D1goY7uudHtFzX2R6dhHC1ZuTRR6iXqigxN_8ZxIQduuwFTwxERmA0eQj0fxdEvzgbQDVWOV-BdZQaLveSbW2z00hr_2SLcGtWYZT9NXxKjcwgnF2UPebN6B2pGeBPcgS3g7yJWMJXUSJ3plxJstugzYk0ZZyFpoB8pXd-z_XZZwxEhiYxFe_FBBrawXrxVLcbrrWk6rZ3QObQZv74DvGTi_LNNCx2eO_hz-JgR8QCsbELej7XoPtZukjU3yjRo7GgkSKi452MPYnU54RF-IK2Z9kcAwao1Ch0_ld7LwiJZGwKoge-447DZs4I5HZ6L99W8DRtIXD5gnGUEnPlM6q8YrH93AOYMRa2kbSuALa9XvLL6tEwa0kFhfTo6Jh4pfwUygvoQnk9oPAMbK9bAitKD9gcPc24NbnlOFz3m-Ya2BzOq5jNgHxDzVV_eHskqBDeOlBYeDJjfj3zYHt-3psW0Uk2GWOr43IJ0baCK2Ty2W856Ea46wtEpwV_d13LR6DasECZUgP0CaKtrJKef0bRcf0gS4PZcv50l8PnbmsczuEZlVzKYcJZdoJdbLvly1)

CU27: Emitir Constancia especificacion
El Proceso Principal Caso de Uso Base CU27: Emitir constancia: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CIERRE. Los actores Director Autoriza egreso de pasantía y Administrador Modula expedientes aptos interactúan de forma directa para liberar la constancia oficial descargable desde la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Validar requerimientos mínimos e incrustar firma QR digital: El sistema efectúa de manera forzosa la revisión de condiciones de cierre y estampa el código QR con valor de firma institucional.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director y al Administrador emitir el documento acreditativo para estudiantes que hayan cumplido las horas requeridas y aprobado sus evaluaciones, obligando al sistema a validar los requerimientos mínimos e incrustar la firma QR para poner a disposición la constancia de pasantía oficial.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZPB1Qlj64CRlUeh1kHbiBCMEdM1CP5k6G5hIE2aK0cMidTXBf5rrTzKqAOLUUkkjFHOAlPQSUkmjUPC-GH-XixBTA8aDV_dWrSmtEx_vHgVMeN5bdWNsJge23UPWLoZqlLHBSAQaMiBeKebK6qK6mbujWQdJPkuUCWAy9wlpUjK2qxlbfZJJ1WvciVy5zOifTQYMNFvz0FoC_o-PR4gYMNVMRHqalMIG3DOQRGIPJJwQ72QzJYr-jPBfdI9h8QgYCwtSHwsFpkKZGTXzVQ_6MEXC13_K6KjBATgzXD7ne3C-RXtqfl4qYJuIXkFkh1_j90pRlVUCi-fvnnZjOlIXNKJ3eNsmZlAlCNLIgz684SB-u8XD3EFnv7XIHznJq4cEebvOPzifMyEoM--_Y7rUJGzxtKw7jtdKJw8TNiKTJdS-rQkT-upsx7FDrPXAG_xK0BJ0BzjuB7Aff7K6nIPPHRRfCLe2GJ15fwq_NA15vSXMql4KXiEvzExWQ1G4hrzrO_xL72xYUVpvrLayXtz-_1KcPydbPTBOMBJzk1gJwrRKlr59Bfqqa6fb-OfKOjLWSXtrtyg_n4mAD63ecvACp2KfJvQ_F2cPQtkZ2AHAJMaTYswboH6-k0GXbz9XjfulTI5yMAgtYcs1LcjKTOKJY4ksG3uYqDAGrNxwefh-vGc3ogMw-ZCjoeortnKaF1HPm8BHWYhVRe-gnYny_fC1irBGyz_h75_2JdBcN2x8OCq3qBUI_p9kRLCqIrna50HAEm8Zbol7-Qr5__x-oy_GR5uOudB1LIz_gPDcCm3s_Wz8CY3hIY6PtkzpGR12RWPfcHTigFPD8KCBAstGRjqLV7m0HugLM1YzG8vKCleMin9JjevicvluFh_zv06qTRi8pj_CLRUIoO3yzWLoiw8a5W5Bf2sqNL_J3aW9y7C7ftmgy_y0)

CU28: Cerrar Proceso especificacion
El Proceso Principal Caso de Uso Base CU28: Cerrar proceso: Es la funcionalidad central dentro del sistema SYS PASANTIAS — CIERRE. El actor Director interactúa directamente con ella Concluye oficialmente el ciclo para cambiar el estatus final del expediente a Archivado / Concluido en la Base de Datos de Pasantes.

Las Relaciones Obligatorias include: El caso de uso principal depende obligatoriamente de un subproceso del sistema para completarse con éxito:

Verificar checklist completo y archivar expediente físico/digital: El sistema revisa de forma mandatoria que no falte ningún elemento formal en el legajo y ejecuta el resguardo en el repositorio correspondiente.

El Flujo Excepcional o Alternativo extend: No se especifican flujos opcionales o condicionales de extensión en el diagrama provisto.

En resumen: El caso de uso permite al Director dar por finalizado oficialmente el ciclo de prácticas de un alumno, requiriendo como condición previa que la constancia fuera emitida y todos los documentos archivados; esto obliga al sistema a verificar el checklist de control completo para trasladar el expediente al archivo histórico y liberar al alumno del proceso activo.

![diagrama de Contexto](http://www.plantuml.com/plantuml/png/ZLB1QiD64BthAmRd432rOobsuWHZ8iio14e9SL8e1CfuTsClNksQtLLJjnHwwQstzbWez5fwoh6tv4_w1Vs4ZYGxLHq5khgiPjwyUVDchvn7w_DC1MujzGOjPk1MoCsJr4lmDXUrX3MvvinOBIo4Wre2cJTsxhTA03u9Px9wrGBPUhahLSR2qImklg1EB9X7lQJoRmEWCtahINObqQm_wtUEqa4wJ8SLnbWkx2uV9QVfe5UBtwqaMslX74HbT6QqVuyjedFvZO2m__PVZR4mYWVVrJNcJZ1q7ogCBeQzoKNdQ32DfsdqNc4uwS_EeqQ5ONTmg75MdWEDKPD6eDEaQ3HoM-T5zYKoBuqUZqb2U3uy8nF3U99S90SIcmfwwLaq26lQcc6LM7Bhy4LyvDNqTD3lzMYRP-TfrE1LtADqxtzwrRpFw8DzLhfQKsb5SMi1Eg2VVNnIR9WBcA8thhZSe4FjXIk1aocCHdDPZ8_ZSH3y-snRyo_cS1FFuy_khkCv_FNzpv1SfxUtQMldmVxrj9BxJZHyq8cm5Yrih672cP8zkO-6_yL-Bgnyb8nmR2NOMb5dO2RRAE7DWzu2MhQINr5QVBqHN0eI2e-lVpZ9p0cNI-bHbSmnyo6yMrnX1uqEdSwux0sNa1ZDLBuLOAYjH9MLb481aqoPe4Hrk-EIaE0llyi2pyNBdrMEgCYaWWYpXKGGpgFF7JnAZGeGZkDACJTmicickJaE0cseZvNBbQVMUoV-_lMd7w7TlY6RZUOawFLPNxRR0P2_ly6d21Ic1fgK0XSBIeCJ5aGclUG8M_266mUgsAHXUJ4CNN4lmNM9gI3xvOUYYt6-gKsgwkvkq26Wsf4OM4ddNvyj6KuA5BZgRNm2IYw4HSrD2LPvfYl0Rj-0p5DvDn2QGp5xS4MtFFi7)

Quiero tomarme un momento, con total calma y sinceridad, para expresar el profundo agradecimiento que siento hacia ti. A veces el día a día nos lleva tan de prisa que dejamos por sentado el valor de las personas que nos rodean, pero hoy no quiero que sea uno de esos días. No quiero que el tiempo pase sin que sepas lo mucho que significas para mí y lo mucho que valoro tu presencia, tu apoyo y tu entrega.
