/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3_paradigmas.model;

/**
 *
 * @author Andres
 */
public class Persona {
    
     String nombre;
     String apellido1;
     String apelido2;
     String cedula;
     String fechaVencimiento;
     String provincia;

    public Persona(String nombre, String apellido1, String apelido2, String cedula, String fechaVencimiento, String provincia) {
        this.nombre = nombre.trim();
        this.apellido1 = apellido1.trim();
        this.apelido2 = apelido2.trim();
        this.cedula = cedula;
        this.fechaVencimiento = fechaVencimiento;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apelido2=" + apelido2 + ", cedula=" + cedula + ", fechaVencimiento=" + fechaVencimiento + ", provincia=" + provincia + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApelido2() {
        return apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
    
}
