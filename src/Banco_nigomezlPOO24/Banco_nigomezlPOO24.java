/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco_nigomezlpoo24;
import java.util.*;

public class Banco_nigomezlPOO24 {

    public static void main(String[] args) {
        ArrayList<Cliente> Clientes = new ArrayList();
        ArrayList<Cuenta> Cuentas = new ArrayList();
        boolean Sistema = true;
        Scanner s = new Scanner(System.in);
        while (Sistema){
            System.out.println("Ingrese 1 para crear una cuenta"); 
            System.out.println("Ingrese 2 para ingresar a una cuenta"); 
            int Accion = s.nextInt();
            if (Accion == 1){
                System.out.println("Ingrese su nombre");
                String nombre = s.nextLine();
                nombre = s.nextLine();
                System.out.println("Ingrese su numero de identificacion");
                int dni = s.nextInt();
                Cliente Cliente = new Cliente(nombre, dni);
                if (0 < Clientes.size()){
                    for (int i = 0; i < Clientes.size(); i++){
                        if (Clientes.get(i).getDNI() == dni){
                            if (Clientes.get(i).getNombre().equals(nombre)){
                                Cliente cliente = Clientes.get(i);
                                System.out.println("Ingrese su contraseña solo enteros");
                                int Contraseña = s.nextInt();
                                Cuenta Cuenta = new Cuenta(Cliente, Contraseña);
                                Cuentas.add(Cuenta);
                                int Tamaño = Cuentas.size() - 1;
                                System.out.println("El numero de tu cuenta es: " + Tamaño);
                                break;
                            } else {
                                System.out.println("El dni y el nombre no concuerdan");
                                break;
                            }
                        } else if(i == Clientes.size()-1){
                            Clientes.add(Cliente);
                            System.out.println("Ingrese su contraseña solo enteros");
                            int Contraseña = s.nextInt();
                            Cuenta Cuenta = new Cuenta(Cliente, Contraseña);
                            Cuentas.add(Cuenta);
                            int Tamaño = Cuentas.size() - 1;
                            System.out.println("El numero de tu cuenta es: " + Tamaño);
                            break;
                        }
                    }
                } else {
                    Clientes.add(Cliente);
                    System.out.println("Ingrese su contraseña solo enteros");
                    int Contraseña = s.nextInt();
                    Cuenta Cuenta = new Cuenta(Cliente, Contraseña);
                    Cuentas.add(Cuenta);
                    int Tamaño = Cuentas.size() - 1;
                    System.out.println("El numero de tu cuenta es: " + Tamaño);
                }
            } else if (Accion == 2) {
                System.out.println("Ingrese el numero de su cuenta"); 
                int numeroCuenta = s.nextInt();
                if (numeroCuenta < Cuentas.size()){
                    System.out.println("Ingrese la contrsaeña de su cuenta"); 
                    int Clave = s.nextInt();
                    if (Cuentas.get(numeroCuenta).Verificacion(Clave)){
                        System.out.println("Ingrese 1 para consignar dinero"); 
                        System.out.println("Ingrese 2 para retirar dinero");
                        System.out.println("Ingrese 3 para transferir dinero");
                        System.out.println("Ingrese 4 para consultar su saldo");
                        System.out.println("Ingrese 5 para consultar movimientos");
                        Accion = s.nextInt();
                        if (Accion == 1){
                            System.out.println("Ingrese valor a consignar");
                            int dinero = s.nextInt();
                            if (Cuentas.get(numeroCuenta).consignacion(dinero)){
                                System.out.println("Su consignacion por un valor de "+dinero+" ha sido completado");
                            }
                        } else if (Accion == 2){
                            System.out.println("Ingrese valor a retirar");
                            int dinero = s.nextInt();
                            if (Cuentas.get(numeroCuenta).retiro(dinero)){
                                System.out.println("Su retiro por un valor de "+dinero+" ha sido completado");
                            }
                        } else if (Accion == 3){
                            System.out.println("Ingrese numero de cuenta del destinatario");
                            int destino = s.nextInt();
                            System.out.println("Ingrese valor a transferir");
                            int dinero = s.nextInt();
                            if (Cuentas.get(numeroCuenta).transferencia(dinero, Cuentas.get(destino))){
                                System.out.println("La transferencia con un valor de "+dinero+" a la cuenta "+destino+" de "+Cuentas.get(destino).getTitular()+" ha sido completada");
                            }
                        } else if (Accion == 4){
                            System.out.println("Su saldo es "+Cuentas.get(numeroCuenta).getSaldo());
                        } else if (Accion == 5){
                            System.out.println(Cuentas.get(numeroCuenta).getTransferencias());
                        }
                    }
                }
            } 
        }    
    }
}
