package net.codejava.dto;

import java.util.Date;
import lombok.Data;
/**
 *
 * @author JCarlosC
 */

@Data
public class IMCDTO 
{
    
    private int id;
    private int idUsuario;
    private float estatura;
    private float peso;
    private float imc;
    private String nivelPeso;
    private Date fecha;

    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}
    public float getEstatura() {return estatura;}
    public void setEstatura(float estatura) {this.estatura = estatura;}
    public float getPeso() {return peso;}
    public void setPeso(float peso) {this.peso = peso;}
    public float getImc() {return imc;}
    public void setImc(float imc) {this.imc = imc;}
    public String getNivelPeso() {return nivelPeso;}
    public void setNivelPeso(String nivelPeso) {this.nivelPeso = nivelPeso;}
    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}
}
