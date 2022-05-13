

package net.codejava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import net.codejava.entity.IMC;
import net.codejava.repositories.IMCRepository;


/**
 *
 * @author JCarlosC
 */

@Service
public class IMCService 
{
    @Autowired
    IMCRepository imcRepository;

    public Iterable<IMC> getImc() {return imcRepository.findAll();}
    
    public Optional<IMC> getImcById(Integer id) {return imcRepository.findById(id);}

    public IMC guardarImc(IMC imc) {return imcRepository.save(imc);}

    public IMC actualizarImc(Integer id, IMC imc) 
    {
        imc.setId(id);
        return imcRepository.save(imc);
    }

    public void borrarImc(Integer id) 
    {
        Optional<IMC> imc = imcRepository.findById(id);
        imcRepository.delete(imc.get());
    }
}
