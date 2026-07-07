public class Main {
    public static void main(String[] args) {
        System.out.println("=== Probando Patrón Singleton en SIGEP ===");

        // Componente 1 (Ej: Al simular FinancieroService consultando pagos)
        BaseDatosConexion conexionServicioFinanciero = BaseDatosConexion.getInstancia();
        conexionServicioFinanciero.ejecutarQuery("SELECT * FROM pagos WHERE periodo = '2026-I'");

        // Componente 2 (Ej: Al simular EstudianteService en otra parte del sistema)
        BaseDatosConexion conexionServicioEstudiantes = BaseDatosConexion.getInstancia();
        conexionServicioEstudiantes.ejecutarQuery("SELECT * FROM estudiantes WHERE estado = 'DEUDOR'");

        // Verificación de identidad por consola de que ambas referencias apuntan exactamente al mismo objeto
        System.out.println("\n¿Ambos servicios comparten físicamente la misma instancia de conexión?");
        if (conexionServicioFinanciero == conexionServicioEstudiantes) {
            System.out.println("✅ SÍ: Singleton funcionando correctamente (Mismo espacio de memoria: "
                    + conexionServicioFinanciero.hashCode() + ")");
        } else {
            System.out.println("❌ NO: El patrón ha fallado, hay instancias duplicadas.");
        }
    }
}