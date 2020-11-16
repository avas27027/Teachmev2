
package teach.edu.pe.demo01back.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.edu.pe.demo01back.model.Clase;
import teach.edu.pe.demo01back.model.FormuClase;
import teach.edu.pe.demo01back.repository.ClasesRep;


@Controller
@RequestMapping("/Pago")
public class Pago {  
   
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "Pago";
}
    
   
}



    