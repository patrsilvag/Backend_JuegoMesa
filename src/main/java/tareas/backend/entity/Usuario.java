package tareas.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario") 
public class Usuario {

    @Id
    @Email
    @NotBlank
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "usuario", nullable = false)
    private String usuario;

    @NotBlank
    @Size(min = 6, max = 18)
    @Column(name = "clave", nullable = false)
    private String clave;

    // ✅ rol como enum restringido (admin/cliente)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Rol rol;

    // ✅ opcional / nullable
    @Column(name = "direccion", nullable = true)
    @Size(max = 255)
    private String direccion;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    // ✅ "status" 
    @NotBlank
    @Pattern(regexp = "active|inactive")
    @Column(name = "status", nullable = false)
    private String status = "active";

    // ===== Getters y setters =====

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
