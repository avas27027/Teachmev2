
package teach.edu.pe.demo01back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class errorController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "error_borrar";
    }
    
    @RequestMapping(value = "/buscarClase", method = RequestMethod.POST)
    public String ir() {
        return "redirect:/explorar/";
    }
    
}
