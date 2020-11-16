package teach.edu.pe.demo01back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import teach.edu.pe.demo01back.model.*;
import org.springframework.ui.Model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import teach.edu.pe.demo01back.repository.ClasesRep;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/misContenidos")
public class MisContenidos {

    private ClasesRep cRep;
    @Autowired
    public void userController(ClasesRep cRep){
        this.cRep = cRep;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(Model model, HttpServletRequest req){
        /*List<Clase> listaClase = cRep.findAll();
        model.addAttribute("darClases", listaClase);*/
        String usuario = String.valueOf(req.getSession().getAttribute("usuario")); 
        System.out.println(usuario);
        List<Clase> listaClase = cRep.findByProfesor(usuario);//lista las clases que dicta
        List<Clase> listaClaseToma = cRep.findByAlumno(usuario);//lista las clases que tomó

        model.addAttribute("darClases", listaClase);
        if (listaClase != null) {
            model.addAttribute("darClases", listaClase);
        }
        if (listaClase != null) {
            model.addAttribute("tomaClases", listaClaseToma);
        }
        return "misContenidos";
        //return "misContenidos";
    }
    @RequestMapping(value = "/delete/{y}", method = RequestMethod.POST)
    public String borrarClase(@PathVariable("y") String y){
        System.out.println(y);
        Long y1 = Long.parseLong(y);
        cRep.deleteByID(y1);
        return "redirect:/misContenidos/";
    }

}
