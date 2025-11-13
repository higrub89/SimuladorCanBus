package com.automocion.can;

// Usamos 'extends Ecu' para establecer la Herencia
public class EcuMotor extends Ecu { 
    
    // Constructor: Llama al constructor de la clase padre (Ecu)
    public EcuMotor(String nombre) {
        super(nombre); 
        System.out.println(nombre + " ha sido inicializada y conectada.");
    }

    // Usamos @Override para sobrescribir el método del padre (Polimorfismo)
    @Override
    public void recibirMensaje(MensajeCAN mensaje) {
        // Lógica de Filtrado: Solo procesa el ID que le interesa
        if (mensaje.id == 0x10A) {
            String datos = new String(mensaje.datos);
            System.out.println(">>> " + this.getNombre() + ": ¡ATENCIÓN! Leído ID 0x10A. RPM/Temp: " + datos);
        }
    }
}