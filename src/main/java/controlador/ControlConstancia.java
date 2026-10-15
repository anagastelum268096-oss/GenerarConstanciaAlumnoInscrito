package controlador;

import modelo.ConstanciaBO;
import modelo.DTOs.AlumnoDTO;
import modelo.DTOs.ConstanciaDTO;
import modelo.DTOs.InscripcionDTO;
import java.util.List;
import vista.FrmConstancia;

public class ControlConstancia {

    private FrmConstancia vista;
    private ConstanciaBO constanciaBO;
    private String idSeleccionado;

    public ControlConstancia(FrmConstancia vista) {
        this.vista = vista;
        this.constanciaBO = new ConstanciaBO();
    }

    public void buscarAlumnos(String idParcial) {
        idSeleccionado = null;
        List<AlumnoDTO> alumnos = constanciaBO.buscarAlumnos(idParcial);
        vista.mostrarCoincidencias(alumnos);
        if (idParcial.isEmpty()) {
            vista.mostrarMensaje("Capture el ID del alumno.");
        } else if (alumnos.isEmpty()) {
            vista.mostrarMensaje("Sin resultados para el ID capturado.");
        } else {
            vista.mostrarMensaje("Seleccione un alumno de la lista.");
        }
    }

    public void seleccionarAlumno(String id) {
        idSeleccionado = id;
        InscripcionDTO datos = constanciaBO.obtenerDatosConfirmacion(id);
        if (datos == null) {
            idSeleccionado = null;
            vista.mostrarMensaje("El alumno " + id + " no tiene inscripción vigente.");
        } else {
            vista.mostrarDatosConfirmacion(datos);
        }
    }

    public void generarConstancia() {
        if (idSeleccionado == null) {
            vista.mostrarMensaje("Seleccione un alumno de la lista.");
            return;
        }
        ConstanciaDTO constancia = constanciaBO.generarConstancia(idSeleccionado);
        if (constancia == null) {
            vista.mostrarMensaje("No fue posible generar la constancia.");
        } else {
            vista.mostrarConstancia(constancia);
        }
    }
}
