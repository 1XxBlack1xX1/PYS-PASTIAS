// Interfaz Estrategia
interface ExportarStrategy {
    void exportar(String datosReporte);
}

// Estrategia Concreta: PDF
class ExportarPDFStrategy implements ExportarStrategy {
    @Override
    public void exportar(String datosReporte) {
        System.out.println("Generando documento PDF oficial con diseño vectorial y firmas...");
        System.out.println("Datos procesados en PDF: " + datosReporte);
    }
}

// Estrategia Concreta: Excel
class ExportarExcelStrategy implements ExportarStrategy {
    @Override
    public void exportar(String datosReporte) {
        System.out.println("Escribiendo libro de celdas en formato XLSX con fórmulas de sumatoria contable...");
    }
}

// Estrategia Concreta: CSV
class ExportarCSVStrategy implements ExportarStrategy {
    @Override
    public void exportar(String datosReporte) {
        System.out.println("Estructurando strings separados por comas (CSV) de texto plano plano...");
    }
}

// Contexto que utiliza las estrategias de manera dinámica
class ReporteExportadorContext {
    private ExportarStrategy strategy;

    public void setStrategy(ExportarStrategy strategy) {
        this.strategy = strategy;
    }

    public void ejecutarExportacion(String datos) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia de exportación.");
        }
        strategy.exportar(datos);
    }
}