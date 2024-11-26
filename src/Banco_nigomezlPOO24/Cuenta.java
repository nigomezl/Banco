
package banco_nigomezlpoo24;
import java.util.*;
public class Cuenta {
    
    private String Titular;
    private int Saldo;
    private int Clave;
    ArrayList transferencias = new ArrayList();
    
    Cuenta(Cliente nombreCliente, int Contraseña) {
        Titular = nombreCliente.nombre;
        Saldo = 0;
        Clave = Contraseña;
    }


    boolean consignacion(int dinero){
        
        if(Saldo > 0 ){
                Saldo = Saldo + dinero;
                transferencias.add(dinero);
                return true;
        }else{
            System.out.println("Su cuenta se encuentra bloqueada");
            return false;
        }  
    }
    
    boolean retiro(int dinero){
             
        if(Saldo > dinero){
                Saldo = Saldo - dinero;
                transferencias.add(dinero);
                return true;
        }else{
            System.out.println("No hay suficiente saldo");
            return false;
        }  
    }
    
    boolean transferencia(int dinero, Cuenta D){
        
        if(Saldo > dinero){
                Saldo = Saldo - dinero;
                D.consignacion(dinero);
                transferencias.add(dinero);
                return true;
        }else{
            System.out.println("No hay suficiente saldo");
            return false;
        }  
    }
    
    boolean Verificacion(int contraseña){
        
        if(Clave == contraseña){
            return true;
        } else {
            return false;
        }
    }

    int getSaldo() {
        return this.Saldo;
    }
    
    String getTitular() {
        return this.Titular;
    }
    
    ArrayList getTransferencias() {
        return this.transferencias;
    }
}
