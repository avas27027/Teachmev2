
package teach.edu.pe.demo01back.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.edu.pe.demo01back.model.Clase;
import teach.edu.pe.demo01back.model.FormuClase;
import teach.edu.pe.demo01back.repository.ClasesRep;


@Controller
@RequestMapping("/Pago")
public class Pago {  
    private ClasesRep cRep;
    @Autowired
    public void claseController(ClasesRep cRep){
        this.cRep = cRep;
    }
    
    String id = "";
    @RequestMapping(value = "/{y}",method = RequestMethod.GET)
    public String getIndex(@PathVariable("y") String y){
        id = y;
        return "Pago";
    }
    
    @RequestMapping(value = "/seleccionar/", method = RequestMethod.POST)
    public String seleccionarClase(HttpServletRequest req){
        String usuario = String.valueOf(req.getSession().getAttribute("usuario"));
        System.out.println("**************************************************");
        Clase cla = cRep.findByIde(Long.parseLong(id));
        cla.setEstado(false);
        cla.setAlumno(usuario);
        cRep.save(cla);
        System.out.println("***************");
        System.out.println(cla);
        return "redirect:/home/";
    }
    
    /*@RequestMapping(value = "/",method = RequestMethod.POST)
    public String ingresar(@ModelAttribute FormuClase fc, HttpServletRequest req){
        String usuario= String.valueOf(req.getSession().getAttribute("usuario"));
        //String usuarioId= String.valueOf(req.getSession().getAttribute("usuarid"));
        System.out.println("**************");
        //System.out.println(usuarioId);
        Clase clase = cRep.findByUsuarid(Integer.parseInt(usuarioId));
        clase.setEstado(false);
        System.out.println(clase);
        cRep.save(clase);
        
        
        //System.out.printf("Clase creada: ", clase);
        return "redirect:/home/";

    }*/
    
   
}



    