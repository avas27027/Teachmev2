
package teach.edu.pe.demo01back.controller;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;

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
        //String usuarioId= String.valueOf(req.getSession().getAttribute("usuarid"));
        List<Clase> lHorarios = cRep.findByProfesor(usuario);
        for (Clase h : lHorarios){
            if(h.getHorario().equals(convFec(fc.camp3))) {
                return "/crear/";
            }
        }

        Clase clase =  new Clase();
        clase.setPrecio(fc.camp1);
        clase.setNombre(fc.camp2);
        clase.setHorario(convFec(fc.camp3));
        //user.setTipo(f.campo4);
        clase.setRubro(fc.camp4);
        clase.setEstado(true);
        clase.setProfesor(usuario);
        //clase.setUsuarid(Integer.parseInt(usuarioId));
        cRep.saveAndFlush(clase);
        
        System.out.printf("Clase creada: ", clase);
        return "redirect:/home/";

    }
    
    public String convFec(String num){
        System.out.println(num);
        String fec="";
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm",Locale.UK);
        SimpleDateFormat formateador2 = new SimpleDateFormat("dd/mm/yyyy hh:mm a");
        try{
        Date fecha = formateador.parse(num);
        fec=formateador2.format(fecha);
        System.out.println(fec);
        }catch (ParseException e)
        {
            System.out.println("error de fecha\t"+e);
        }
        return fec;
    }
     
}
