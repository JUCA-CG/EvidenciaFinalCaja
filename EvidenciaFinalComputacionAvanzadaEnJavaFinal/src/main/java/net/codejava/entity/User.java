package net.codejava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import net.codejava.dto.UserDTO;

/**
 *
 * @author JCarlosC
 */

@Entity
@Table(name = "usuario")
@Data
public class User 
{
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private int id;
    
    @Column(name="nombre")
    @NotEmpty(message="Favor de ingresar el nombre")
    private String nombre;

    @Column(name="apellido")
    @NotEmpty(message="Favor de ingresar el apellido")
    private String apellido;
    
    @Column(name="edad")
    @Min(value=15, message="Favor de ingresar una edad mayor a 15 años")
    private int edad;
    
    @Column(name="sexo")
    private char sexo;
    
    @Column(name="email")
    @Email(message="Favor de ingresar un Email válido")
    @NotNull(message="Favor de ingresar un Email")
    private String email;
    
    @Column(name="contraseña")
    @Size(min=6, message="Favor de ingresar una contraseña con al menos 6 caracteres ")
    @NotEmpty(message="Favor de ingresar una contraseña")
    private String contraseña;

  
    public User() {}

  
    public User(UserDTO userDTO) 
    {
        this.id = userDTO.getId();
        this.nombre = userDTO.getNombre();
        this.apellido = userDTO.getApellido();
        this.edad = userDTO.getEdad();
        this.sexo = userDTO.getSexo();
        this.email = userDTO.getEmail();
        this.contraseña = userDTO.getContraseña();
    }


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
