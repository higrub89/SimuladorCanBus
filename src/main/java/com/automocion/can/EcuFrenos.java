package com.automocion.can;

public class EcuFrenos extends Ecu {

    // Constructor
    public EcuFrenos(String nombre) {
        super(nombre);
        System.out.println(nombre + " ha sido inicializada y conectada.");
    }

    // Polimorfismo: Sobreescribe el método con su propia lógica
    @Override
    public void recibirMensaje(MensajeCAN mensaje) {
        // Lógica de Filtrado: Solo procesa el ID que le interesa
        if (mensaje.id == 0x200) {
            String datos = new String(mensaje.datos);
            System.out.println(">>> " + this.getNombre() + ": ¡ALARMA! Leído ID 0x200. Estado: " + datos);
        }
    }
}