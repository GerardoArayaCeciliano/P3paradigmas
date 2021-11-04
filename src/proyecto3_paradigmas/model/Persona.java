/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3_paradigmas.model;

import java.util.Date;

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
     String estadoCedula;

    public Persona(String nombre, String apellido1, String apelido2, String cedula, String fechaVencimiento) {
        this.nombre = nombre.trim();
        this.apellido1 = apellido1.trim();
        this.apelido2 = apelido2.trim();
        this.cedula = cedula;
        this.fechaVencimiento = fechaVencimiento;
        this.provincia = addProvincia(cedula);
        this.estadoCedula = addEstadoCedula(fechaVencimiento);
       
        
        
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
    
    public String addProvincia(String ced){
         if(cedula.startsWith("1")){
            return "San José";
        }
        else if(cedula.startsWith("2")){
            return "Alajuela";
        }
         
          else if(cedula.startsWith("3")){
            return "Cartago";
        }
         
          else if(cedula.startsWith("4")){
            return "Heredia";
        }
          else if(cedula.startsWith("5")){
            return "Guanacaste";
        }
         else if(cedula.startsWith("6")){
            return "Puntarenas";
            
        } else if(cedula.startsWith("7")){
            return "Limón";
        }
         
          else if(cedula.startsWith("8")){
            return "Extranjero";
        }
         return "Casos Especiales";
    }
    
    public String addEstadoCedula(String fechaVenc){
        String estado = ""; 
        String mes;
        String año;
        
        Date fechaActual = new Date();
        
        mes = String.valueOf(fechaVenc.charAt(4))+
                String.valueOf(fechaVenc.charAt(5));
        
        año = String.valueOf(fechaVenc.charAt(0))+
                String.valueOf(fechaVenc.charAt(1))+
                String.valueOf(fechaVenc.charAt(2))+
                String.valueOf(fechaVenc.charAt(3));
        
        if( (Integer.valueOf(año)  == (fechaActual.getYear()+1900)) &
                ((Integer.valueOf(mes) - (fechaActual.getMonth()+1)) ==1 )){
           
             return "Esta proxima a vencer";
        }
        
        else{
            return "No esta proxima a vencer";
        }
       
        
            
        
    }
    
}
