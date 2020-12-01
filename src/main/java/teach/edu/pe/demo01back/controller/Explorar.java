package teach.edu.pe.demo01back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import teach.edu.pe.demo01back.model.*;
import teach.edu.pe.demo01back.repository.*;
import teach.edu.pe.demo01back.repository.ClasesRep;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/explorar")
public class Explorar{
    private ClasesRep cRep;
    private UsuariosRep uRep;
    @Autowired
    public void userController(ClasesRep cRep, UsuariosRep uRep){
        this.cRep = cRep;
        this.uRep = uRep;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "Explorar";
    }
    
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String buscar(Model model,String tipo, String busqueda){
        
        System.out.print(tipo+" | "+busqueda+"\n");
        if(tipo.equals("1")){// 1 es clase 2 es profesor
            List<Clase> clasesC=cRep.findByNombreContainingIgnoreCaseAndEstado(busqueda, true);
            // Se imprimen los valores que encuentra, colocar estos valores en el html
            model.addAttribute("clases",clasesC);
            System.out.println("------------------");
            System.out.println(clasesC.get(0).nombre);
        }else{
            Usuarios usua = uRep.findByNombreContainingIgnoreCase(busqueda);
            List<Clase> clasesC=cRep.findByProfesorContainingIgnoreCaseAndEstado(usua.getUsuario(), true);
            
            // Se imprimen los valores que encuentra, colocar estos valores en el html
            model.addAttribute("clases",clasesC);
        }
        
        return "Explorar";
    }
    
    @RequestMapping(value = "/seleccionar/{y}", method = RequestMethod.POST)
    public String seleccionarClase(@PathVariable("y") String y){
        
        System.out.println("**************************************************");
        System.out.println(y);
        Long y1 = Long.parseLong(y);
        System.out.println(y1);
        return "redirect:/Pago/" + y;
    }
}