package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import modelo.DTOs.AlumnoDTO;
import modelo.DTOs.ConstanciaDTO;
import modelo.DTOs.InscripcionDTO;

public class ConstanciaBO {

    private final String[][] alumnos = {
        {"00245123", "Ana López Ruiz", "Ingeniería en Software"},
        {"00241876", "Luis Pérez Soto", "Ingeniería en Software"},
        {"00249134", "María Gómez Díaz", "Ingeniería Industrial"},
        {"00243301", "Carlos Ramírez Mora", "Ingeniería Civil"},
        {"00246712", "Sofía Torres Vega", "Licenciatura en Administración"},
        {"00240245", "Jorge Medina Salas", "Ingeniería en Software"},
        {"00254890", "Daniela Cruz Ortiz", "Ingeniería Electrónica"}
    };

    private final String[][] inscripciones = {
        {"00245123", "2026-2", "5", "6", "42", "Inscrito"},
        {"00241876", "2026-2", "3", "7", "46", "Inscrito"},
        {"00249134", "2026-2", "7", "5", "38", "Inscrito"},
        {"00243301", "2026-2", "2", "7", "48", "Inscrito"},
        {"00246712", "2026-2", "4", "6", "40", "Inscrito"},
        {"00240245", "2026-2", "6", "0", "0", "Baja"}
    };

    private int consecutivo;

    public List<AlumnoDTO> buscarAlumnos(String texto) {
        List<AlumnoDTO> resultado = new ArrayList<>();
        if (texto == null || texto.isEmpty()) {
            return resultado;
        }
        for (String[] alumno : alumnos) {
            if (alumno[0].contains(texto)) {
                resultado.add(new AlumnoDTO(alumno[0], alumno[1], alumno[2]));
            }
        }
        return resultado;
    }

    public InscripcionDTO obtenerDatosConfirmacion(String id) {
        String[] alumno = buscarAlumno(id);
        String[] inscripcion = buscarInscripcion(id);
        if (alumno == null || inscripcion == null) {
            return null;
        }
        return new InscripcionDTO(id, alumno[1], alumno[2], inscripcion[1],
                Integer.parseInt(inscripcion[2]), Integer.parseInt(inscripcion[3]),
                Integer.parseInt(inscripcion[4]), inscripcion[5]);
    }

    public ConstanciaDTO generarConstancia(String id) {
        InscripcionDTO datos = obtenerDatosConfirmacion(id);
        if (datos == null) {
            return null;
        }
        LocalDate hoy = LocalDate.now();
        String folio = String.format("CE-%d-%04d", hoy.getYear(), ++consecutivo);
        String fecha = hoy.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new ConstanciaDTO(folio, fecha, id, datos.getNombreAlumno(),
                datos.getCarrera(), datos.getPeriodo(), datos.getSemestre(),
                datos.getCantidadMaterias(), datos.getCreditos());
    }

    private String[] buscarAlumno(String id) {
        for (String[] alumno : alumnos) {
            if (alumno[0].equals(id)) {
                return alumno;
            }
        }
        return null;
    }

    private String[] buscarInscripcion(String id) {
        for (String[] inscripcion : inscripciones) {
            if (inscripcion[0].equals(id) && inscripcion[5].equals("Inscrito")) {
                return inscripcion;
            }
        }
        return null;
    }
}
