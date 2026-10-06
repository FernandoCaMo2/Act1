package modelo;

public class Cliente {
    private int numero;
    private String nombre;
    private int edad;
    private double puntos;

    public Cliente(int numero, String nombre, int edad, double puntos) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPuntos() {
        return puntos;
    }
}