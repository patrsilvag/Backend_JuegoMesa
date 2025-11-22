package tareas.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJuego;

    private String codJuego;

    @NotBlank
    private String nombre;

    @NotNull
    @PositiveOrZero
    private double precio;

    @Pattern(regexp = "S|N")
    private String descuento;

    private String imagen;
    private String alt;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    // Getters y Setters

    public Long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public String getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(String codJuego) {
        this.codJuego = codJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
