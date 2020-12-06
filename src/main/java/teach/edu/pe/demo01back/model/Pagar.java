
package teach.edu.pe.demo01back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBPAGO")
public class Pagar {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long ide;
    
    private Integer numTarjeta;
  
    public String nombreTitular;
    
    private String fechaCaducidad;
    
    private String contraseña;
    
    private String usuario;

    public Pagar() {
    }

    public Pagar(Long ide, Integer numTarjeta, String nombreTitular, String fechaCaducidad, String contraseña, String usuario) {
        this.ide = ide;
        this.numTarjeta = numTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaCaducidad = fechaCaducidad;
        this.contraseña = contraseña;
        this.usuario = usuario;
    }
    
    public Long getIde() {
        return ide;
    }

    public void setIde(Long ide) {
        this.ide = ide;
    }

    public Integer getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(Integer numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
