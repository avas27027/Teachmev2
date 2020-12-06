package teach.edu.pe.demo01back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teach.edu.pe.demo01back.model.Clase;
import teach.edu.pe.demo01back.model.Pagar;


public interface PagoRep extends JpaRepository<Pagar,Long>{
    public Pagar findByIde(Long ide);
}
