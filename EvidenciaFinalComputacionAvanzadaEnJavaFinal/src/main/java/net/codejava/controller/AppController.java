package net.codejava.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import net.codejava.NivelPeso;
import net.codejava.Form;
import net.codejava.dto.IMCDTO;
import net.codejava.dto.UserDTO;
import net.codejava.entity.IMC;
import net.codejava.entity.User;
import net.codejava.services.IMCService;
import net.codejava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author JCarlosC
 * Desarrollo final
 */

@Controller
public class AppController 
{
    @Autowired
    private IMCService imcService;
    
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) 
    {
       
            if (session.getAttribute("mySessionAttribute") != null) 
            {
               
                User loggedUser = (User) session.getAttribute("usuarioAutenticado");
                ArrayList<User> sessionUser = new ArrayList<>();
                sessionUser.add(loggedUser);
                model.addAttribute("sessionUser", sessionUser);

              
                List<IMC> imcCompleto = (List<IMC>) imcService.getImc();
                ArrayList<IMC> listImc = new ArrayList<>();
                for(int x=0; x<imcCompleto.size(); x++)
                {
                    IMC imcIndex = imcCompleto.get(x);
                    int usuario = imcIndex.getIdUsuario();
                    
                    if(usuario == loggedUser.getId())
                    {listImc.add(imcIndex);}
                }

               
                model.addAttribute("listImc", listImc);
                return "index";
            } 
            else 
            {
                
                model.addAttribute("formulario", new Form());
                return "login";
            }
        }
       
    @RequestMapping("/login")
    public String login(HttpSession session, @ModelAttribute("formulario") Form formulario) 
    {
       
            List<User> listUsuarios = userService.getUsuario();
            session.setAttribute("listUsuarios", listUsuarios);
            String email = formulario.getEmail();
            String contraseña = formulario.getPassword();
            User usuarioIndex = formulario.searchUser(listUsuarios,email,contraseña);

            
            if (usuarioIndex != null)
            {
                session.setAttribute("mySessionAttribute", "login");
                session.setAttribute("usuarioAutenticado", usuarioIndex);
                return "redirect:/";
            }
            
            else
            {
                session.setAttribute("mySessionAttribute", null);
                return "login";
            }
        }
       

    @RequestMapping("/newImc")
    public String showNewImcPage(HttpSession session, Model model) 
    {
      
            
            User loggedUser = (User) session.getAttribute("usuarioAutenticado");
            IMCDTO imcDTO = new IMCDTO();
            int idUsuario = loggedUser.getId();
            imcDTO.setIdUsuario(idUsuario);

            
            model.addAttribute("imc", imcDTO);

            
            return "new_imc";
        }
      
    
    
    @RequestMapping("/newUsuario")
    public String showNewUserPage(Model model) 
    {
     
            
            UserDTO usuarioDTO = new UserDTO();
            
            
            model.addAttribute("usuario", usuarioDTO);

            
            return "new_usuario";
        }
    
    
    @RequestMapping(value = "/saveImc", method = RequestMethod.POST)
    public String saveImc(@ModelAttribute("imc") IMC imc) 
    {
        
            
            float estatura = imc.getEstatura();
            float peso = imc.getPeso();

            
            NivelPeso methods = new NivelPeso();
            float calculoImc = methods.calculaImc(estatura, peso);

            
            imc.setImc(calculoImc);

            
            String nivelPeso = methods.nivelPeso(calculoImc);        
            imc.setNivelPeso(nivelPeso);

            
            imcService.guardarImc(imc);
            return "redirect:/";
        }
        

    @RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
    public String saveUsuario(@ModelAttribute("usuario") User usuario) 
    {
       
            
            userService.guardarUsuario(usuario);
            return "redirect:/";
       
    }
    
    @RequestMapping("/changePassword/{id}")
    public ModelAndView showChangePasswordPage(@PathVariable(name = "id") int id) 
    {
        ModelAndView mav = new ModelAndView("change_password");
        Optional<User> user = userService.getUsuarioById(id);
        mav.addObject("user", user);
        return mav;
    }
    
    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditUsuarioPage(@PathVariable(name = "id") int id) 
    {
       
        ModelAndView mav = new ModelAndView("edit_usuario");
        Optional<User> changedUser = userService.getUsuarioById(id);
        mav.addObject("changedUser", changedUser);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteImc(@PathVariable(name = "id") int id) 
    {
       
            imcService.borrarImc(id);
            return "redirect:/";
        }
       
    
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) 
    {
        
           
            session.setAttribute("mySessionAttribute", null);
            return "redirect:/";
        }
        
    }
