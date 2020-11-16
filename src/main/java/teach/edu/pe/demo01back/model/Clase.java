package teach.edu.pe.demo01back.model;
import javax.persistence.Column;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Table(name="TBCLASES")
public class Clase {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long ID;
    
    private String precio;
  
    public String nombre;
    
    private String rubro;
    
    private String horario;
    
    private String profesor;
   
    private boolean estado;

    private String alumno;
}
