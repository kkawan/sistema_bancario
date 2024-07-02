class Conta:
    def __init__(self, saldo=0, limite=500):
        self.saldo = saldo
        self.limite = limite
        self.extrato = ""
        self.numero_saques = 0
        self.LIMITE_SAQUES = 3

    def depositar(self, valor):
        if valor > 0:
            self.saldo += valor
            self.extrato += f"Depósito: R$ {valor:.2f}\n"
        else:
            print("Operação falhou! O valor informado é inválido.")

    def sacar(self, valor):
        if valor > self.saldo:
            print("Operação falhou! Você não tem saldo suficiente.")
        elif valor > self.limite:
            print("Operação falhou! O valor do saque excede o limite.")
        elif self.numero_saques >= self.LIMITE_SAQUES:
            print("Operação falhou! Número máximo de saques excedido.")
        elif valor > 0:
            self.saldo -= valor
            self.extrato += f"Saque: R$ {valor:.2f}\n"
            self.numero_saques += 1
        else:
            print("Operação falhou! O valor informado é inválido.")

    def mostrar_extrato(self):
        print("\n================ EXTRATO ================")
        print("Não foram realizadas movimentações." if not self.extrato else self.extrato)
        print(f"\nSaldo: R$ {self.saldo:.2f}")
        print("==========================================")

class Menu:
    def __init__(self, conta):
        self.conta = conta

    def mostrar_menu(self):
        menu = """
        [1] Depositar
        [2] Sacar
        [3] Extrato
        [4] Sair

        => """
        return input(menu)

    def executar(self):
        opcao = ""
        while opcao != "4":
            opcao = self.mostrar_menu()

            match opcao:
                case "1":
                    valor = float(input("Informe o valor do depósito: "))
                    self.conta.depositar(valor)

                case "2":
                    valor = float(input("Informe o valor do saque: "))
                    self.conta.sacar(valor)

                case "3":
                    self.conta.mostrar_extrato()

                case "4":
                    print("Saindo...")

                case _:
                    print("Operação inválida, por favor selecione novamente a operação desejada.")

if __name__ == "__main__":
    conta = Conta()
    menu = Menu(conta)
    menu.executar()
