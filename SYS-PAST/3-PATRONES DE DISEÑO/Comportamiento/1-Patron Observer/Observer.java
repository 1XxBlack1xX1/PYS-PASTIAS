import java.util.ArrayList;
import java.util.List;

// Interfaz del Observador
interface PostulacionObserver {
    void actualizar(String estado, String detalle);
}

// Observador Concreto 1: Notificaciones al Estudiante
class EstudianteNotificacion implements PostulacionObserver {
    @Override
    public void actualizar(String estado, String detalle) {
        System.out.println("[Email Estudiante] Tu postulación ha cambiado al estado: " + estado + ". Detalle: " + detalle);
    }
}

// Observador Concreto 2: Notificaciones al Coordinador
class CoordinadorNotificacion implements PostulacionObserver {
    @Override
    public void actualizar(String estado, String detalle) {
        System.out.println("[Panel Coordinador] Alerta de auditoría: Postulación actualizada a " + estado);
    }
}

// Sujeto (Subject) - El objeto que es observado
class PostulacionContext {
    private final List<PostulacionObserver> observers = new ArrayList<>();
    private String estado;
    private final String idPostulacion;

    public PostulacionContext(String idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public void adjuntar(PostulacionObserver observer) {
        observers.add(observer);
    }

    public void desadjuntar(PostulacionObserver observer) {
        observers.remove(observer);
    }

    public void cambiarEstado(String nuevoEstado, String detalle) {
        this.estado = nuevoEstado;
        System.out.println("\n--- Cambio de Estado en Postulación " + idPostulacion + " a: " + nuevoEstado + " ---");
        notificarObservers();
    }

    private void notificarObservers() {
        for (PostulacionObserver observer : observers) {
            observer.actualizar(this.estado, "ID Ref: " + idPostulacion);
        }
    }
}