/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.uned.ac.proyectotriage.dominio;

/**
 *
 */
public class Paciente {

    private int id;
    private String nombre_completo;
    private int edad;
    private String motivo_consulta;
    private double temperatura_corp;
    private double freq_card;
    private int nivel_dolor;
    private String clasificacion;   
    private String color;  

    
    public Paciente() {
    }

    
    public Paciente(int id, String nombre_completo, int edad, String motivo_consulta,
                    double temperatura_corp, double freq_card, int nivel_dolor,
                    String clasificacion, String color) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.edad = edad;
        this.motivo_consulta = motivo_consulta;
        this.temperatura_corp = temperatura_corp;
        this.freq_card = freq_card;
        this.nivel_dolor = nivel_dolor;
        this.clasificacion = clasificacion;
        this.color = color;
    }
    

    
    public Paciente(String nombre_completo, int edad, String motivo_consulta,
                    double temperatura_corp, double freq_card, int nivel_dolor,
                    String clasificacion, String color) {
        this.nombre_completo = nombre_completo;
        this.edad = edad;
        this.motivo_consulta = motivo_consulta;
        this.temperatura_corp = temperatura_corp;
        this.freq_card = freq_card;
        this.nivel_dolor = nivel_dolor;
        this.clasificacion = clasificacion;
        this.color = color;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public double getTemperatura_corp() {
        return temperatura_corp;
    }

    public void setTemperatura_corp(double temperatura_corp) {
        this.temperatura_corp = temperatura_corp;
    }

    public double getFreq_card() {
        return freq_card;
    }

    public void setFreq_card(double freq_card) {
        this.freq_card = freq_card;
    }

    public int getNivel_dolor() {
        return nivel_dolor;
    }

    public void setNivel_dolor(int nivel_dolor) {
        this.nivel_dolor = nivel_dolor;
    }
    
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

