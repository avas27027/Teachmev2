package teach.edu.pe.demo01back.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import teach.edu.pe.demo01back.model.Clase;

public interface ClasesRep extends JpaRepository<Clase,Long>{
    public List<Clase> findByNombre(String nombre);
    public List<Clase> findByProfesor(String profesor);
    public List<Clase> findByAlumno(String alumno);
    //@Query("SELECT c FROM TBCLASES c WHERE UPPER(c.nombre) LIKE UPPER(%:nombre1%) AND c.estado=:estado1")
    public List<Clase> findByNombreContainingIgnoreCaseAndEstado(String nombre,boolean estado);
    public List<Clase> findByProfesorContainingIgnoreCaseAndEstado(String profesor, boolean estado);
    @Transactional
    public long deleteByID(Long ID);

}
