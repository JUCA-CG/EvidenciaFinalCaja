package net.codejava;

import java.util.List;

import net.codejava.entity.User;
/**
 *
 * @author JCarlosC
 * Desarrollo final
 */
public class Form 
{
    
    private String email;
    private String password;

    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    
    public User searchUser(List<User> listUsuarios, String email, String contraseña)
    {
        
        User usuario = new User();

        
        boolean encontrado = listUsuarios.stream().anyMatch(x -> 
                x.getEmail().equals(email) && x.getContraseña().equals(contraseña));
        
        if(encontrado == true)
        {
            for(int x=0; x<listUsuarios.size(); x++)
            {
                User usuarioIndex = listUsuarios.get(x);
                String emailIndex = usuarioIndex.getEmail();
                if(emailIndex.equals(email))
                {usuario = listUsuarios.get(x);}
            }
        }

        return usuario;
    }
}