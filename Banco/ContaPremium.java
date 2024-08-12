//Subclasse 2

public class ContaPremium extends Conta {

    public ContaPremium(double saldoInicial) {
        super(saldoInicial);
    }

    @Override //sobrescrevendo um método
    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}

// :p
