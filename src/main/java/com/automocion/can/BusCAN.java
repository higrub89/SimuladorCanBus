package com.automocion.can;

import java.util.ArrayList;
import java.util.List;

public class BusCAN {
    // La lista ahora guarda objetos de tipo 'Ecu' (y sus hijos, EcuMotor, EcuFrenos, etc.)
    private List<Ecu> modulosConectados = new ArrayList<>();

    public void conectarECU(Ecu modulo) { // Acepta la clase base 'Ecu'
        this.modulosConectados.add(modulo);
        // El mensaje de conexión se imprime en el constructor de la Ecu hija
    }

    public void transmitir(MensajeCAN mensaje) {
        System.out.println("\n--- Bus Transmitiendo Mensaje ---");
        mensaje.imprimir(); 

        // Iteramos sobre todos los módulos conectados
        for (Ecu modulo : modulosConectados) {
            modulo.recibirMensaje(mensaje); // ¡Aquí se ejecuta el Polimorfismo!
        }
    }
}