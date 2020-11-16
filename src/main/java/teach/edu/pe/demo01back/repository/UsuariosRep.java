package teach.edu.pe.demo01back.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import teach.edu.pe.demo01back.model.Usuarios;


public interface UsuariosRep extends JpaRepository<Usuarios,Long>{
    public Usuarios findByUsuarioAndContrasenia(String usuario, String contrasenia);
    public Usuarios findByUsuario(String usuario);
}