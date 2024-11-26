/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco_nigomezlpoo24;

public class Cliente {
    public String nombre;
    public int DNI;
    
    Cliente(String N, int ide) {
        nombre = N;
        DNI = ide;
    }
    
    String getNombre() {
        return this.nombre;
    }
    
    int getDNI() {
        return this.DNI;
    }
}
