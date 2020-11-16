package teach.edu.pe.demo01back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import org.springframework.ui.Model;
import teach.edu.pe.demo01back.model.Formulario;
import teach.edu.pe.demo01back.model.Usuarios;
import teach.edu.pe.demo01back.repository.UsuariosRep;

@Controller
@RequestMapping("/crearCuenta")
public class ContRegistro{
    private UsuariosRep uRep;
    @Autowired
    public void userController(UsuariosRep uRep){
        this.uRep = uRep;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(Model model){
        model.addAttribute("formulario", new Formulario());
        return "registro";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String ingresar(@ModelAttribute Formulario f){
        if(uRep.findByUsuario(f.campo5)!=null){
            System.out.printf("Usuario ya existente:\n",uRep.findByUsuario(f.campo5));
            return "redirect:/crearCuenta/";
        }
        Usuarios user =  new Usuarios();
        user.setNombre(f.campo1);
        user.setApellido(f.campo2);
        user.setCodigo(f.campo3);
        //user.setTipo(f.campo4);
        user.setUsuario(f.campo5);
        user.setContrasenia(f.campo6);
        uRep.saveAndFlush(user);
        System.out.printf("Usuario creado: ", user);
        return "redirect:/";

    }

    @RequestMapping(value = "/formu",method = RequestMethod.POST)
    public String redRegistro(){
        return "redirect:/";
    }
}