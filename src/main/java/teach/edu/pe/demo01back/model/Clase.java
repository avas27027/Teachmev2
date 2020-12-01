package teach.edu.pe.demo01back.model;
import javax.persistence.Column;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="TBCLASES")
public class Clase {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long ide;
    
    private String precio;
  
    public String nombre;
    
    private String rubro;
    
    private String horario;
    
    private String profesor;
   
    private boolean estado;

    private String alumno;
    
    
    
    //private Integer usuarid;

    public Clase() {
        
    }

    public Clase(Long ide, String precio, String nombre, String rubro, String horario, String profesor, boolean estado, String alumno) {
        this.ide = ide;
        this.precio = precio;
        this.nombre = nombre;
        this.rubro = rubro;
        this.horario = horario;
        this.profesor = profesor;
        this.estado = estado;
        this.alumno = alumno;
    }

    public Long getIde() {
        return ide;
    }

    public void setIde(Long ide) {
        this.ide = ide;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    
    
    
    
    
}
