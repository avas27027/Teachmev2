
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
    
}

