### ADR 04: Gestión de Estados Dinámicos en la Máquina de Reportes

* **Título:** Desacoplamiento Estricto de la Lógica Transicional del Módulo de Reportes Contables y Financieros
* **Estatus:** `ACEPTADO`
* **Contexto:** Tal como quedó evidenciado en el modelado detallado de la máquina de estados del **CU22 (Generar Reportes)**, la lógica contable institucional no es lineal. El proceso experimenta cambios de estado que incluyen `SeleccionandoPeriodo`, `CalculandoTotales`, `MostrandoReporte`, y estados de error intermedios como `ErrorExportacion`. Si el controlador recarga todo el flujo de datos desde cero cada vez que ocurre un fallo menor en la exportación, se saturaría innecesariamente el motor de base de datos con consultas pesadas redundantes.
* **Decisión:** Implementar un componente de servicio con aislamiento de estado y memoria intermedia (`ReporteService`). El estado de los cálculos parciales se almacena transitoriamente en buffers de memoria en el servidor. Si ocurre una transición de error hacia `ErrorExportacion`, la interfaz web mantendrá la visualización de los datos calculados en el estado anterior y habilitará un disparador de "Reintentar", aislando el fallo del subsistema de persistencia.

#### Consecuencias
* **Positivas:**
    * **Alta Resiliencia:** Un error al renderizar un archivo Excel o PDF no interrumpe la navegación ni obliga al usuario a reintroducir los filtros o rehacer los cálculos matemáticos complejos de totales.
    * **Eficiencia de Servidor:** Reduce drásticamente el uso de CPU e I/O en la base de datos al no repetir queries complejas de agregación ante fallos del formateador de archivos.
* **Negativas:**
    * **Uso de Memoria Volátil:** Mantener múltiples estructuras de reportes intermedios por usuario incrementará temporalmente el consumo de memoria RAM del servidor de aplicaciones durante periodos de cierre contable.

---