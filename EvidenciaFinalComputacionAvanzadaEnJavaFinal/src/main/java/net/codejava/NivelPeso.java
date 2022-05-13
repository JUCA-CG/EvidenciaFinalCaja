package net.codejava;

import static java.lang.Math.pow;
/**
 *
 * @author JCarlosC
 */

public class NivelPeso 
{
    
    public float calculaImc(float estatura, float peso)
    {
        
        float IMC = (float) (peso / pow(estatura,2.0));
        return IMC;
    }

    
    public String nivelPeso(float IMC)
    {
        
        if(IMC < 18.5)
        {return "Bajo peso";}

        else
        {
            
            if(IMC>=18.5 && IMC<=24.9)
            {return "Normal";}

            else
            {
                
                if(IMC>=25.0 && IMC<=29.9)
                {return "Sobrepeso";}

                
                else
                {return "Obesidad";}
            }
        }
    }
}