package modelo;

public final class DTOs {

    private DTOs() {
    }

    public static class AlumnoDTO {
        private final String id, nombre, carrera;

        public AlumnoDTO(String id, String nombre, String carrera) {
            this.id = id;
            this.nombre = nombre;
            this.carrera = carrera;
        }

        public String getId() { return id; }
        public String getNombre() { return nombre; }
        public String getCarrera() { return carrera; }
        @Override public String toString() { return id + "  -  " + nombre; }
    }

    public static class ConstanciaDTO {
        private final String folio, fechaEmision, idAlumno, nombreAlumno;
        private final String carrera, periodo;
        private final int semestre, cantidadMaterias, creditos;

        public ConstanciaDTO(String folio, String fechaEmision, String idAlumno,
                String nombreAlumno, String carrera, String periodo, int semestre,
                int cantidadMaterias, int creditos) {
            this.folio = folio;
            this.fechaEmision = fechaEmision;
            this.idAlumno = idAlumno;
            this.nombreAlumno = nombreAlumno;
            this.carrera = carrera;
            this.periodo = periodo;
            this.semestre = semestre;
            this.cantidadMaterias = cantidadMaterias;
            this.creditos = creditos;
        }

        public String getFolio() { return folio; }
        public String getFechaEmision() { return fechaEmision; }
        public String getIdAlumno() { return idAlumno; }
        public String getNombreAlumno() { return nombreAlumno; }
        public String getCarrera() { return carrera; }
        public String getPeriodo() { return periodo; }
        public int getSemestre() { return semestre; }
        public int getCantidadMaterias() { return cantidadMaterias; }
        public int getCreditos() { return creditos; }
    }

    public static class InscripcionDTO {
        private final String idAlumno, nombreAlumno, carrera, periodo, estatus;
        private final int semestre, cantidadMaterias, creditos;

        public InscripcionDTO(String idAlumno, String nombreAlumno, String carrera,
                String periodo, int semestre, int cantidadMaterias, int creditos,
                String estatus) {
            this.idAlumno = idAlumno;
            this.nombreAlumno = nombreAlumno;
            this.carrera = carrera;
            this.periodo = periodo;
            this.semestre = semestre;
            this.cantidadMaterias = cantidadMaterias;
            this.creditos = creditos;
            this.estatus = estatus;
        }

        public String getIdAlumno() { return idAlumno; }
        public String getNombreAlumno() { return nombreAlumno; }
        public String getCarrera() { return carrera; }
        public String getPeriodo() { return periodo; }
        public int getSemestre() { return semestre; }
        public int getCantidadMaterias() { return cantidadMaterias; }
        public int getCreditos() { return creditos; }
        public String getEstatus() { return estatus; }
    }
}
