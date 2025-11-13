package com.automocion.can;

public class Ecu { // NOTA: E mayúscula
    
    // El nombre es privado (Encapsulamiento)
    private String nombre; 
    
    // Constructor para inicializar el nombre
    public Ecu(String nombre) {
        this.nombre = nombre;
    }

    // Método de acceso para que otras clases lean el nombre
    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(int id, byte[] datos) {
        MensajeCAN mensaje = new MensajeCAN(id, datos); 
        System.out.print("[" + nombre + " ENVIA] ");
        mensaje.imprimir();
    }
    
    // Este método será SOBREESCRITO en las clases hijas (Polimorfismo)
    public void recibirMensaje(MensajeCAN mensaje) {
        // La ECU genérica no tiene lógica de filtrado y no reacciona
    }
}