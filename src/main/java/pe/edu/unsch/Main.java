
package pe.edu.unsch;

import pe.edu.unsch.aplicacion.CuentaService;
import pe.edu.unsch.dominio.CuentaBancaria;
import pe.edu.unsch.infraestructura.ArchivoMovimientoRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Crear el repositorio concreto
        ArchivoMovimientoRepository repository =
                new ArchivoMovimientoRepository();

        // Inyectar el repositorio en el servicio
        CuentaService banco = new CuentaService(repository);

        int opcion;

        do {

            System.out.println("\n=== SISTEMA BANCARIO ===");
            System.out.println("1. Registrar cuenta");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");

            try {

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:

                        System.out.print("Ingrese titular: ");
                        String titular = scanner.nextLine();

                        System.out.print("Ingrese saldo inicial: ");
                        BigDecimal saldoInicial =
                                new BigDecimal(scanner.nextLine());

                        banco.registrarCuenta(
                                titular, saldoInicial
                        );

                        System.out.println("Cuenta registrada");
                        break;

                    case 2:

                        System.out.print("Monto a depositar: ");
                        BigDecimal deposito =
                                new BigDecimal(scanner.nextLine());

                        banco.depositar(deposito);

                        System.out.println("Deposito exitoso");
                        break;

                    case 3:

                        System.out.print("Monto a retirar: ");
                        BigDecimal retiro =
                                new BigDecimal(scanner.nextLine());

                        banco.retirar(retiro);

                        System.out.println("Retiro exitoso");
                        break;

                    case 4:

                        CuentaBancaria cuenta =
                                banco.consultarSaldo();

                        System.out.println(
                                "Titular: " + cuenta.getTitular()
                        );

                        System.out.println(
                                "Saldo: S/ " + cuenta.getSaldo()
                        );

                        break;

                    case 5:

                        System.out.println(
                                "Saliendo del sistema..."
                        );

                        break;

                    default:

                        System.out.println("Opcion invalida");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: ingrese un numero valido"
                );

                opcion = 0;

            } catch (IllegalArgumentException |
                     IllegalStateException e) {

                System.out.println("Error: " + e.getMessage());

                opcion = 0;

            } catch (RuntimeException e) {

                System.out.println("Error: " + e.getMessage());

                opcion = 0;
            }

        } while (opcion != 5);

        scanner.close();
    }
}
