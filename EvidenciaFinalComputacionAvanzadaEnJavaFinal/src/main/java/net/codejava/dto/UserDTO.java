package net.codejava.dto;

import lombok.Data;
/**
 *
 * @author JCarlosC
 */

@Data
public class UserDTO 
{
  
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private char sexo;
    private String email;
    private String contraseña;

    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public char getSexo() {return sexo;}
    public void setSexo(char sexo) {this.sexo = sexo;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}    
}
