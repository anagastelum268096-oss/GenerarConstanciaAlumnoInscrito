package vista;

import controlador.ControlConstancia;
import modelo.DTOs.AlumnoDTO;
import modelo.DTOs.ConstanciaDTO;
import modelo.DTOs.InscripcionDTO;
import java.awt.CardLayout;
import java.util.List;

/**
 * Vista del caso de uso "Generar Constancia de alumno inscrito".
 * La interfaz se edita en la pestaña Design (archivo FrmConstancia.form).
 */
public class FrmConstancia extends javax.swing.JFrame {

    private static final String TARJETA_DATOS = "datos";
    private static final String TARJETA_CONSTANCIA = "constancia";

    private ControlConstancia controlador;

    public FrmConstancia() {
        initComponents();
        setLocationRelativeTo(null);
        controlador = new ControlConstancia(this);
        mostrarMensaje("Capture el ID del alumno.");
    }

    /** Muestra en la zona derecha los alumnos que coinciden con el ID tecleado. */
    public void mostrarCoincidencias(List<AlumnoDTO> alumnos) {
        lstCoincidencias.setListData(alumnos.toArray(new AlumnoDTO[0]));
    }

    /** Muestra debajo de la lista los datos de confirmación del alumno. */
    public void mostrarDatosConfirmacion(InscripcionDTO datos) {
        txtDatos.setText(
                "ID: " + datos.getIdAlumno() + "\n"
                + "Nombre: " + datos.getNombreAlumno() + "\n"
                + "Carrera: " + datos.getCarrera() + "\n"
                + "Periodo: " + datos.getPeriodo() + "\n"
                + "Semestre inscrito: " + datos.getSemestre() + "\n"
                + "Cantidad de materias: " + datos.getCantidadMaterias() + "\n"
                + "Créditos: " + datos.getCreditos() + "\n"
                + "Estatus: " + datos.getEstatus());
        txtDatos.setCaretPosition(0);
        lblZona.setText("Datos de confirmación:");
        ((CardLayout) pnlTarjetas.getLayout()).show(pnlTarjetas, TARJETA_DATOS);
        btnGenerarConstancia.setEnabled(true);
    }

    /** Muestra la constancia en la misma zona donde estaban los datos de confirmación. */
    public void mostrarConstancia(ConstanciaDTO constancia) {
        txtConstancia.setText(
                "CONSTANCIA DE ALUMNO INSCRITO\n"
                + "Folio: " + constancia.getFolio()
                + "        Fecha de emisión: " + constancia.getFechaEmision() + "\n\n"
                + "Se hace constar que el alumno " + constancia.getNombreAlumno()
                + ", con ID " + constancia.getIdAlumno()
                + ", de la carrera de " + constancia.getCarrera()
                + ", se encuentra inscrito en el periodo " + constancia.getPeriodo()
                + ", cursando el semestre " + constancia.getSemestre()
                + " con " + constancia.getCantidadMaterias()
                + " materias y " + constancia.getCreditos() + " créditos.\n\n"
                + "Se extiende la presente para los fines que al interesado convengan.");
        txtConstancia.setCaretPosition(0);
        lblZona.setText("Constancia:");
        ((CardLayout) pnlTarjetas.getLayout()).show(pnlTarjetas, TARJETA_CONSTANCIA);
    }

    /** Muestra un mensaje en la zona de datos y deshabilita la generación. */
    public void mostrarMensaje(String mensaje) {
        txtDatos.setText(mensaje);
        lblZona.setText("Datos de confirmación:");
        ((CardLayout) pnlTarjetas.getLayout()).show(pnlTarjetas, TARJETA_DATOS);
        btnGenerarConstancia.setEnabled(false);
    }

    /** Este método lo regenera NetBeans a partir de FrmConstancia.form. */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIzquierdo = new javax.swing.JPanel();
        pnlCaptura = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnGenerarConstancia = new javax.swing.JButton();
        pnlDerecho = new javax.swing.JPanel();
        pnlLista = new javax.swing.JPanel();
        lblCoincidencias = new javax.swing.JLabel();
        scrollCoincidencias = new javax.swing.JScrollPane();
        lstCoincidencias = new javax.swing.JList<>();
        pnlZona = new javax.swing.JPanel();
        lblZona = new javax.swing.JLabel();
        pnlTarjetas = new javax.swing.JPanel();
        pnlDatosConfirmacion = new javax.swing.JPanel();
        txtDatos = new javax.swing.JTextArea();
        pnlConstancia = new javax.swing.JPanel();
        txtConstancia = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Constancia de alumno inscrito");
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        pnlIzquierdo.setLayout(new java.awt.BorderLayout());

        pnlCaptura.setLayout(new java.awt.GridLayout(3, 1, 0, 6));

        lblId.setText("ID del alumno:");
        pnlCaptura.add(lblId);

        txtId.setColumns(14);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });
        pnlCaptura.add(txtId);

        btnGenerarConstancia.setText("Generar Constancia");
        btnGenerarConstancia.setEnabled(false);
        btnGenerarConstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarConstanciaActionPerformed(evt);
            }
        });
        pnlCaptura.add(btnGenerarConstancia);

        pnlIzquierdo.add(pnlCaptura, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlIzquierdo, java.awt.BorderLayout.WEST);

        pnlDerecho.setLayout(new java.awt.BorderLayout(0, 10));

        pnlLista.setLayout(new java.awt.BorderLayout());

        lblCoincidencias.setText("Coincidencias:");
        pnlLista.add(lblCoincidencias, java.awt.BorderLayout.NORTH);

        lstCoincidencias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCoincidencias.setFixedCellWidth(380);
        lstCoincidencias.setVisibleRowCount(5);
        lstCoincidencias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCoincidenciasValueChanged(evt);
            }
        });
        scrollCoincidencias.setViewportView(lstCoincidencias);

        pnlLista.add(scrollCoincidencias, java.awt.BorderLayout.CENTER);

        pnlDerecho.add(pnlLista, java.awt.BorderLayout.NORTH);

        pnlZona.setLayout(new java.awt.BorderLayout());

        lblZona.setText("Datos de confirmación:");
        pnlZona.add(lblZona, java.awt.BorderLayout.NORTH);

        pnlTarjetas.setLayout(new java.awt.CardLayout());

        pnlDatosConfirmacion.setLayout(new java.awt.BorderLayout());

        txtDatos.setEditable(false);
        txtDatos.setBackground(new java.awt.Color(255, 255, 255));
        txtDatos.setColumns(40);
        txtDatos.setLineWrap(true);
        txtDatos.setRows(9);
        txtDatos.setWrapStyleWord(true);
        pnlDatosConfirmacion.add(txtDatos, java.awt.BorderLayout.CENTER);

        pnlTarjetas.add(pnlDatosConfirmacion, "datos");

        pnlConstancia.setLayout(new java.awt.BorderLayout());

        txtConstancia.setEditable(false);
        txtConstancia.setColumns(40);
        txtConstancia.setLineWrap(true);
        txtConstancia.setRows(9);
        txtConstancia.setWrapStyleWord(true);
        pnlConstancia.add(txtConstancia, java.awt.BorderLayout.CENTER);

        pnlTarjetas.add(pnlConstancia, "constancia");

        pnlZona.add(pnlTarjetas, java.awt.BorderLayout.CENTER);

        pnlDerecho.add(pnlZona, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlDerecho, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        controlador.buscarAlumnos(txtId.getText().trim());
    }//GEN-LAST:event_txtIdKeyReleased

    private void lstCoincidenciasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCoincidenciasValueChanged
        AlumnoDTO seleccionado = lstCoincidencias.getSelectedValue();
        if (!evt.getValueIsAdjusting() && seleccionado != null) {
            controlador.seleccionarAlumno(seleccionado.getId());
        }
    }//GEN-LAST:event_lstCoincidenciasValueChanged

    private void btnGenerarConstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarConstanciaActionPerformed
        controlador.generarConstancia();
    }//GEN-LAST:event_btnGenerarConstanciaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConstancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarConstancia;
    private javax.swing.JLabel lblCoincidencias;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblZona;
    private javax.swing.JList<AlumnoDTO> lstCoincidencias;
    private javax.swing.JPanel pnlCaptura;
    private javax.swing.JPanel pnlConstancia;
    private javax.swing.JPanel pnlDatosConfirmacion;
    private javax.swing.JPanel pnlDerecho;
    private javax.swing.JPanel pnlIzquierdo;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JPanel pnlTarjetas;
    private javax.swing.JPanel pnlZona;
    private javax.swing.JScrollPane scrollCoincidencias;
    private javax.swing.JTextArea txtConstancia;
    private javax.swing.JTextArea txtDatos;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
