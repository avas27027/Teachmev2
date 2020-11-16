package teach.edu.pe.demo01back.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/miCuenta")
public class MiCuenta {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(Model model, HttpServletRequest req){
        String nombre=String.valueOf(req.getSession().getAttribute("nombre"));
        String apellido= String.valueOf(req.getSession().getAttribute("apellido"));
        String usuario= String.valueOf(req.getSession().getAttribute("usuario"));
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        model.addAttribute("usuario", usuario);

        return "miCuenta";
    }
}
