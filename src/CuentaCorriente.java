public class CuentaCorriente extends CuentaBancaria {

    private double comisionPorTransaccion;
    private double limiteSobregiro;

    public CuentaCorriente(
            String numeroCuenta,
            String titular,
            String saldo,
            double comisionPorTransaccion,
            double LimiteSobregiro) {

        super(numeroCuenta, titular, saldo);

        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobregiro = limiteSobregiro;

    }
@Override
    public String describir() {
        return super.describir()
                + " | Comision por transaccion: $"
                + comisionPorTransaccion;
}

@Override
    public double calcularComision() {
        return comisionPorTransaccion;
}

@Override
    public void realizarRetiro(double monto) {
        double saldoResultante =
                getSaldo() - monto - comisionPorTransaccion;

        if (saldoResultante < -limiteSobregiro) {
            System.out.println("El retiro no se permite.");
        } else {
            setSaldo(saldoResultante);
        }
    }

}
