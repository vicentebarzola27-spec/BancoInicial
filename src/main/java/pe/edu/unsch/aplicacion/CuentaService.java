package pe.edu.unsch.aplicacion;


import pe.edu.unsch.dominio.CuentaBancaria;

import java.math.BigDecimal;

public class CuentaService {

    private CuentaBancaria cuenta;
    private final MovimientoRepository repository;

    public CuentaService(MovimientoRepository repository) {
        this.repository = repository;
    }

    public void registrarCuenta(
            String titular,
            BigDecimal saldoInicial) {

        if (cuenta != null) {
            throw new IllegalStateException(
                    "Ya existe una cuenta activa"
            );
        }

        cuenta = new CuentaBancaria(titular, saldoInicial);

        repository.guardar(
                "Cuenta creada | Titular: " + titular +
                        " | Saldo inicial: S/ " + saldoInicial
        );
    }

    public void depositar(BigDecimal monto) {

        verificarCuenta();

        cuenta.depositar(monto);

        repository.guardar(
                "Titular: " + cuenta.getTitular() +
                        " | Deposito: S/ " + monto +
                        " | Saldo actual: S/ " + cuenta.getSaldo()
        );
    }

    public void retirar(BigDecimal monto) {

        verificarCuenta();

        cuenta.retirar(monto);

        repository.guardar(
                "Titular: " + cuenta.getTitular() +
                        " | Retiro: S/ " + monto +
                        " | Saldo actual: S/ " + cuenta.getSaldo()
        );
    }

    public CuentaBancaria consultarSaldo() {

        verificarCuenta();

        return cuenta;
    }

    private void verificarCuenta() {

        if (cuenta == null) {
            throw new IllegalStateException(
                    "Primero debe registrar una cuenta"
            );
        }
    }
}
