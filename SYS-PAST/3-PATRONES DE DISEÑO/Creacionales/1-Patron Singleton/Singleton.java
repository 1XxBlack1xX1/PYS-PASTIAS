public class BaseDatosConexion {
    // 1. Instancia estática única de la clase
    private static BaseDatosConexion instancia;

    private String cadenaConexion;
    private boolean conectado;

    // 2. Constructor privado para evitar instanciación externa directa
    private BaseDatosConexion() {
        this.cadenaConexion = "jdbc:postgresql://localhost:5432/sigep_db";
        this.conectado = true;
        System.out.println("[BaseDatos] Inicializando pool de conexión único hacia: " + cadenaConexion);
    }

    // 3. Método público global para obtener la misma instancia (Thread-Safe)
    public static BaseDatosConexion getInstancia() {
        if (instancia == null) {
            // Sincronización para evitar problemas con hilos concurrentes
            synchronized (BaseDatosConexion.class) {
                if (instancia == null) {
                    instancia = new BaseDatosConexion();
                }
            }
        }
        return instancia;
    }

    // Método de simulación para ejecutar operaciones de persistencia
    public void ejecutarQuery(String sql) {
        if (conectado) {
            System.out.println("[BaseDatos Exec] Ejecutando de forma segura: " + sql);
        } else {
            System.out.println("[BaseDatos Error] No hay conexión activa.");
        }
    }

    public void desconectar() {
        this.conectado = false;
        System.out.println("[BaseDatos] Conexión cerrada correctamente.");
    }
}