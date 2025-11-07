package com.automocion.can;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("--- Inicio de Simulación ---");
        
        // 1. Instanciamos dos módulos de control (Objetos de la clase ECU)
        Ecu ecuMotor = new Ecu("ECU Motor");
        Ecu ecuFrenos = new Ecu("ECU Frenos");

        // 2. Enviamos un mensaje desde el Motor (Instancia el objeto MensajeCAN dentro)
        byte[] datosRPM = "2500 RPM".getBytes();
        ecuMotor.enviarMensaje(0x123, datosRPM);

        // 3. Enviamos un mensaje de la central de Frenos
        byte[] datosFreno = "Freno Activo".getBytes();
        ecuFrenos.enviarMensaje(0x456, datosFreno);
        
        System.out.println("--- Fin de la Tarea ---");
    }
}