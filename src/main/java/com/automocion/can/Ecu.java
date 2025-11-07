package com.automocion.can;

public class Ecu {
	// Atributo encapsulado
	private String nombre;
	
	// Constructor
    public Ecu(String nombre) {
        this.nombre = nombre;
        System.out.println(nombre + " ha sido inicializada y conectada.");
    }
    
    // Método para ENVIAR mensajes
    public void enviarMensaje(int id, byte[] datos) {
        MensajeCAN mensaje = new MensajeCAN(id, datos);
        System.out.print("[" + nombre + " ENVIA] ");
        mensaje.imprimir();
    }
    
    // Método para RECIBIR mensajes
    public void recibirMensaje(MensajeCAN mensaje) {
        System.out.print("[" + nombre + " RECIBE] ");
        mensaje.imprimir();
    }
}
