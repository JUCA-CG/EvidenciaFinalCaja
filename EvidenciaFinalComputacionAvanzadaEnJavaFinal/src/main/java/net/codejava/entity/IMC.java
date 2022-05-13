package net.codejava.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import net.codejava.dto.IMCDTO;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author JCarlosC
 */

@Entity
@Table(name = "CalculosIMC")
@Data
public class IMC 
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private int id;

    @Column(name="idUsuario")
    private int idUsuario;

    @Column(name="estatura")
    @NotNull(message = "Favor de ingresar una estatura")
    @Min(value=1, message="Favor de ingresar una altura mayor a 1m")
    @Max(value=(long) 2.5, message="Favor de ingresar una altura menor a 2.5m")
    private float estatura;
    
    @Column(name="peso")    
   @NotNull(message = "Favor de ingresar un peso")
     @Min(value=30, message="Favor de ingresar un peso mayor a 30")
    @Max(value= 200, message="Favor de ingresar un peso menor a 200")
    private float peso;
    
    @Column(name="imc")
    private float imc;
    

    @Column(name="nivelPeso")
    private String nivelPeso;

    @Column(name="fecha")
    @CreationTimestamp
    private Date fecha;
    
  
    public IMC() {}
    
  
    public IMC(IMCDTO imcDTO) 
    {
        this.id = imcDTO.getId();
        this.nivelPeso = imcDTO.getNivelPeso();
        this.peso = imcDTO.getPeso();
        this.idUsuario = imcDTO.getIdUsuario();
        this.imc = imcDTO.getImc();
        this.estatura = imcDTO.getEstatura();
        this.fecha = imcDTO.getFecha();
    }

 
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNivelPeso() {return nivelPeso;}
    public void setNivelPeso(String nivelPeso) {this.nivelPeso = nivelPeso;}
    public float getPeso() {return peso;}
    public void setPeso(float peso) {this.peso = peso;}
    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}
    public float getImc() {return imc;}
    public void setImc(float imc) {this.imc = imc;}
    public float getEstatura() {return estatura;}
    public void setEstatura(float estatura) {this.estatura = estatura;}
    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;} 
}