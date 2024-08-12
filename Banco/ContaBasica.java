//Subclasse 1
public class ContaBasica extends Conta {

    public ContaBasica(double saldoInicial) {
        super(saldoInicial);
    }

    @Override  //sobrescrevendo um método
    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}

// :p