package net.codejava.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import net.codejava.entity.User;
import net.codejava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author JCarlosC
 */

@Service
public class UserService 
{
    @Autowired
    UserRepository userRepository;

    public List<User> getUsuario() {return (List<User>) userRepository.findAll();}
    
    public Optional<User> getUsuarioById(Integer id) {return userRepository.findById(id);}
    
    public User guardarUsuario(User usuario) {return userRepository.save(usuario);}

    public User actualizarUsuario(Integer id, User usuario) 
    {
        usuario.setId(id);
        return userRepository.save(usuario);
    }

    public void borrarUsuario(Integer id) 
    {
        Optional<User> usuario = userRepository.findById(id);
        userRepository.delete(usuario.get());
    }
}
