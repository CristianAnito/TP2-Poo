package ar.edu.unlu.poo.danza;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Asistencia {
    private Comision comision;
    private Date fecha;
    private List<Alumno> alumnosPresentes;

    public Asistencia(Comision comision, Date fecha) {
        this.comision = comision;
        this.fecha = fecha;
        this.alumnosPresentes = new ArrayList<>();
    }

    public void registrarAsistencia(Credencial credencial){
        if (credencial.getComision().getNumero() == this.comision.getNumero()){
            alumnosPresentes.add(credencial.getAlumno());
        }else {
            System.out.println("El alumno no pertenece a esta comision.");
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public Comision getComision() {
        return comision;
    }

    public List<Alumno> getAlumnosPresentes() {
        return alumnosPresentes;
    }
}
