package com.automocion.can;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("--- INICIO DE SIMULACIÓN CAN BUS CON FILTRADO (POO) ---");
        
        BusCAN busPrincipal = new BusCAN();

        // 1. Instanciar y conectar módulos ESPECÍFICOS (Herencia)
        Ecu ecuLuces = new Ecu("ECU Luces"); // Objeto de la clase base
        EcuMotor motor = new EcuMotor("ECU Motor"); // Objeto de la clase hija
        EcuFrenos frenos = new EcuFrenos("ECU Frenos"); // Objeto de la clase hija
        
        busPrincipal.conectarECU(ecuLuces); 
        busPrincipal.conectarECU(motor);
        busPrincipal.conectarECU(frenos);

        System.out.println("\n--- Mensaje 1: Velocidad del Motor (ID 0x10A) ---");
        byte[] datosRPM = "4500 RPM".getBytes();
        MensajeCAN msgRPM = new MensajeCAN(0x10A, datosRPM);
        busPrincipal.transmitir(msgRPM); 
        // Resultado esperado: SOLO ECU Motor debe reaccionar

        System.out.println("\n--- Mensaje 2: Estado del Pedal de Freno (ID 0x200) ---");
        byte[] datosFreno = "Pedal al 50%".getBytes();
        MensajeCAN msgFreno = new MensajeCAN(0x200, datosFreno);
        busPrincipal.transmitir(msgFreno);
        // Resultado esperado: SOLO ECU Frenos debe reaccionar
        
        System.out.println("\n--- SIMULACIÓN EXITOSA ---");
    }
}