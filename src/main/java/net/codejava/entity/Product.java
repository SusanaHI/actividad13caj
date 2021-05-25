package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    
    private Long id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    public int edad;
    private String genero;
    public double peso;
    public double estatura;
    private double imc;
    private String resultado;
    private String fecha;

    public Product() {
    }

    protected Product(Long id, String nombre, String apellidoP, String apellidoM, int edad, String genero, double peso, double estatura, double imc, String resultado, String fecha) {
        super();
        this.id = id;                
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
        this.imc = imc;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    
    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
    
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}