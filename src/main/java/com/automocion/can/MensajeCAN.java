package com.automocion.can;

public class MensajeCAN {
	public int id;
	public byte[] datos;
	
	public MensajeCAN(int id, byte[] datos) {
		this.id = id;
		this.datos = datos;
	}
	
	public void imprimir() {
		String s = new String(datos);
		System.out.println("-> ID: 0x" + Integer.toHexString(id) + " | Contenido: " + s);
	}
}

