
package teach.edu.pe.demo01back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.edu.pe.demo01back.repository.ClasesRep;

@Controller
@RequestMapping("/confirmacion")
public class confirmacion {   
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){     
        return "confirmacion";
}
    
    /* @RequestMapping(value = "/delete/{y}", method = RequestMethod.POST)
    public String borrarClase(@PathVariable("y") String y){
        System.out.println(y);
        Long y1 = Long.parseLong(y);
        cRep.deleteByID(y1);
        return "redirect:/home/";
    }*/
}

