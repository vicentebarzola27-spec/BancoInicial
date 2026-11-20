package pe.edu.unsch.dominio;


import java.math.BigDecimal;

public class CuentaBancaria {

    private final String titular;
    private BigDecimal saldo;

    public CuentaBancaria(String titular, BigDecimal saldoInicial) {

        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException(
                    "El titular es obligatorio"
            );
        }

        if (saldoInicial == null ||
                saldoInicial.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "El saldo inicial no puede ser negativo"
            );
        }

        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(BigDecimal monto) {

        validarMonto(monto);

        saldo = saldo.add(monto);
    }

    public void retirar(BigDecimal monto) {

        validarMonto(monto);

        if (monto.compareTo(saldo) > 0) {
            throw new IllegalArgumentException(
                    "Fondos insuficientes"
            );
        }

        saldo = saldo.subtract(monto);
    }

    private void validarMonto(BigDecimal monto) {

        if (monto == null ||
                monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero"
            );
        }
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
