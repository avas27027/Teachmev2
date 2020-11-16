
package teach.edu.pe.demo01back.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.edu.pe.demo01back.model.Clase;
import teach.edu.pe.demo01back.model.FormuClase;
import teach.edu.pe.demo01back.repository.ClasesRep;


@Controller
@RequestMapping("/crear")
public class Crear {
     private ClasesRep cRep;
    @Autowired
    public void claseController(ClasesRep cRep){
        this.cRep = cRep;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(Model model){
        model.addAttribute("formuClase",new FormuClase());
        return "Crear";
}
    
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String ingresar(@ModelAttribute FormuClase fc, HttpServletRequest req){
        /*if(cRep.findByUsuario(f.campo5)!=null){
            System.out.printf("Usuario ya existente:\n",uRep.findByUsuario(f.campo5));
            return "redirect:/crearCuenta/";
        }*/
        String usuario= String.valueOf(req.getSession().getAttribute("usuario"));
        Clase clase =  new Clase();
        clase.setPrecio(fc.camp1);
        clase.setNombre(fc.camp2);
        clase.setHorario(fc.camp3);
        //user.setTipo(f.campo4);
        clase.setRubro(fc.camp4);
        clase.setEstado(true);
        clase.setProfesor(usuario);
        cRep.saveAndFlush(clase);
        
        System.out.printf("Clase creada: ", clase);
        return "redirect:/home/";

    }
    
     
}
