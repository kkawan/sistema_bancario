import java.util.Scanner;

public class CarteiraDigital {
    public static void main(String[] args) {
        ContaBasica contaBasica = new ContaBasica(1000);
        ContaPremium contaPremium = new ContaPremium(2000);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Depositar na Conta Básica");
            System.out.println("2. Sacar da Conta Básica");
            System.out.println("3. Transferir da Conta Básica para a Conta Premium");
            System.out.println("4. Depositar na Conta Premium");
            System.out.println("5. Sacar da Conta Premium");
            System.out.println("6. Transferir da Conta Premium para a Conta Básica");
            System.out.println("7. Mostrar Saldo");
            System.out.println("8. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar na Conta Básica: ");
                    double depositoBasica = scanner.nextDouble();
                    contaBasica.depositar(depositoBasica);
                    break;
                case 2:
                    System.out.print("Valor para sacar da Conta Básica: ");
                    double saqueBasica = scanner.nextDouble();
                    if (contaBasica.sacar(saqueBasica)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.print("Valor para transferir da Conta Básica para a Conta Premium: ");
                    double valorTransferenciaBasica = scanner.nextDouble();
                    if (contaBasica.transferir(contaPremium, valorTransferenciaBasica)) {
                        System.out.println("Transferência realizada com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.print("Valor para depositar na Conta Premium: ");
                    double depositoPremium = scanner.nextDouble();
                    contaPremium.depositar(depositoPremium);
                    break;
                case 5:
                    System.out.print("Valor para sacar da Conta Premium: ");
                    double saquePremium = scanner.nextDouble();
                    if (contaPremium.sacar(saquePremium)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 6:
                    System.out.print("Valor para transferir da Conta Premium para a Conta Básica: ");
                    double valorTransferenciaPremium = scanner.nextDouble();
                    if (contaPremium.transferir(contaBasica, valorTransferenciaPremium)) {
                        System.out.println("Transferência realizada com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 7:
                    System.out.println("Saldo da Conta Básica: " + contaBasica.getSaldo());
                    System.out.println("Saldo da Conta Premium: " + contaPremium.getSaldo());
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}

// :p
