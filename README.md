# Generar constancia de alumno inscrito

Aplicación de escritorio desarrollada en Java Swing para localizar alumnos por su ID, consultar si tienen una inscripción vigente y generar una constancia con sus datos escolares.

## Funcionalidades

- Búsqueda de alumnos por coincidencia parcial del identificador.
- Presentación de coincidencias para seleccionar al alumno.
- Consulta de carrera, periodo, semestre, materias, créditos y estatus.
- Validación de inscripción vigente antes de permitir la generación.
- Generación de una constancia con folio consecutivo y fecha de emisión.
- Mensajes para búsquedas vacías, sin resultados o alumnos sin inscripción vigente.

## Requisitos

- Java Development Kit (JDK) 24.
- Apache Maven 3.9 o Maven integrado en NetBeans 26.
- NetBeans 26 (opcional, recomendado para abrir y ejecutar el formulario Swing).

El proyecto establece `vista.FrmConstancia` como clase principal en `pom.xml`.

## Ejecutar con NetBeans

1. Abre NetBeans.
2. Selecciona **File > Open Project** y abre la carpeta del proyecto.
3. Espera a que Maven termine de cargar la configuración.
4. Ejecuta el proyecto.

Si NetBeans solicita una clase principal, selecciona `vista.FrmConstancia`.

## Compilar con Maven

Desde la carpeta raíz del proyecto, ejecuta:

```powershell
mvn clean compile
```

Para ejecutar la interfaz con Maven:

```powershell
mvn process-classes org.codehaus.mojo:exec-maven-plugin:3.1.0:exec `
  "-Dexec.mainClass=vista.FrmConstancia"
```

Si se usa otro JDK instalado, configura `JAVA_HOME` para que apunte a un JDK compatible con la versión 24 del proyecto.

## Cómo utilizar la aplicación

1. Escribe todo o parte del ID en el campo **ID del alumno**.
2. Revisa la lista de coincidencias.
3. Selecciona un alumno.
4. Confirma los datos de inscripción que aparecen.
5. Si tiene inscripción vigente, pulsa **Generar Constancia**.
6. Revisa el folio, la fecha y los datos del documento generado.

El botón de generación solo se habilita cuando el alumno seleccionado tiene una inscripción con estatus `Inscrito`.

### Datos de prueba

| ID | Alumno | Resultado |
|---|---|---|
| `00245123` | Ana López Ruiz | Inscripción vigente; permite generar constancia. |
| `00241876` | Luis Pérez Soto | Inscripción vigente; permite generar constancia. |
| `00249134` | María Gómez Díaz | Inscripción vigente; permite generar constancia. |
| `00243301` | Carlos Ramírez Mora | Inscripción vigente; permite generar constancia. |
| `00246712` | Sofía Torres Vega | Inscripción vigente; permite generar constancia. |
| `00240245` | Jorge Medina Salas | Estatus `Baja`; no permite generar constancia. |
| `00254890` | Daniela Cruz Ortiz | No tiene un registro de inscripción; no permite generar constancia. |

Los IDs pueden buscarse parcialmente; por ejemplo, `0024` presenta varios resultados.

## Organización del código

```text
src/main/java/
├── controlador/
│   └── ControlConstancia.java
├── modelo/
│   ├── ConstanciaBO.java
│   └── DTOs.java
└── vista/
    ├── FrmConstancia.form
    └── FrmConstancia.java
```

### Patrón MVC

- **Vista — `vista.FrmConstancia`:** crea la ventana Swing, escucha la entrada del usuario y muestra listas, mensajes, confirmaciones y constancias.
- **Controlador — `controlador.ControlConstancia`:** recibe las acciones de la vista, coordina las llamadas al modelo y solicita a la vista que muestre los resultados.
- **Modelo — `modelo.ConstanciaBO`:** realiza la búsqueda, valida el estatus de inscripción y prepara la constancia.
- **Objetos de transferencia — `modelo.DTOs`:** agrupa `AlumnoDTO`, `InscripcionDTO` y `ConstanciaDTO`, usados para pasar resultados entre capas.

Flujo de búsqueda:

```text
FrmConstancia → ControlConstancia → ConstanciaBO
FrmConstancia ← ControlConstancia ← lista de AlumnoDTO
```

Flujo de selección y generación:

```text
FrmConstancia → ControlConstancia → ConstanciaBO
FrmConstancia ← ControlConstancia ← InscripcionDTO / ConstanciaDTO
```

Los eventos de teclado, selección y clic se observan mediante listeners de Swing. Estos listeners notifican a la vista, que delega la operación al controlador.

## Alcance y limitaciones

- La aplicación utiliza arreglos de datos definidos en `ConstanciaBO`; no tiene conexión a una base de datos.
- Los cambios y folios consecutivos solo existen durante la ejecución actual.
- Al cerrar la aplicación, los datos de prueba y el consecutivo vuelven a su valor inicial.
- Es un proyecto académico de demostración, no un sistema institucional para emitir documentos oficiales.

## Repositorio y demostración

- Código fuente: [GitHub](https://github.com/anagastelum268096-oss/GenerarConstanciaAlumnoInscrito)
- Video de demostración: **agregar el enlace cuando esté publicado**
