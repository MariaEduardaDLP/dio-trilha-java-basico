import java.util.Scanner;

public class ContaBancaria {
    
    private Double saldo;
    private Double chequeEspecial;
    private Double taxa = 0.0;

    public ContaBancaria(Double saldo) {
        
        this.chequeEspecial = (saldo <= 500) ? saldo*0.1 : saldo*0.5;
        
        this.saldo = saldo;

    }

    public void consultarSaldo() {
        System.out.printf("Saldo da conta: R$%.2f\n", this.saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Valor total do cheque especial: R$%.2f\n", this.chequeEspecial);
        
        System.out.printf("Valor utilizado do cheque especial: R$%.2f\n", (this.saldo >= 0) ? 0 : -(this.saldo));
        
        System.out.printf("Valor disponível do cheque especial: R$%.2f\n", (this.saldo >= 0) ? this.chequeEspecial : (this.saldo + this.chequeEspecial));

        System.out.printf("Valor da taxa associada ao cheque especial: R$%.2f\n", this.taxa);
    }

    public void depositar(Double valor) {
        this.saldo += valor;
    }

    public void sacar(Double valor) {
        if ((this.saldo + this.chequeEspecial) >= valor) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
        else {
            System.out.println("Você não possui saldo disponível!");
        }

        cobrarTaxa();
    }

    public void pagarBoleto(Double valor) {
        if ((this.saldo + this.chequeEspecial) >= valor) {
            this.saldo -= valor;
            System.out.println("Boleto pago com sucesso!");
        }
        else {
            System.out.println("Você não possui saldo disponível!");
        }

        cobrarTaxa();
    }

    public void cobrarTaxa() {
        if (this.saldo < 0)
            this.taxa += -(this.saldo)*0.2;

        System.out.printf("O valor da taxa é de R$%.2f\n", this.taxa);
    }

    public void verificarUsoChequeEspecial() {
        System.out.println((this.saldo < 0) ? 
        "Você está usando o cheque especial. Para mais informações, use a opção 1." : 
        "Você não está usando o cheque especial");
    }

    private void gerarTextoMenu() {
        System.out.println("==========Banco==========\n" +
        "(0) Consultar Saldo\n" +
        "(1) Consultar cheque especial\n" +
        "(2) Depositar dinheiro\n" +
        "(3) Sacar dinheiro\n" +
        "(4) Pagar um boleto\n" +
        "(5) Verificar se a conta está usando cheque especial\n" +
        "(6) Sair");
    }

    public void criarMenu() {
        Scanner sc = new Scanner(System.in);

        gerarTextoMenu();

        int opcao = sc.nextInt();

        while(opcao != 6) {

            switch (opcao) {
                case 0:
                    consultarSaldo();
                    break;
                case 1:
                    consultarChequeEspecial();
                    break;
                case 2:
                    System.out.println("Informe um valor:");
                    depositar(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Informe um valor:");
                    sacar(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Informe um valor:");
                    pagarBoleto(sc.nextDouble());
                    break;
                case 5:
                    verificarUsoChequeEspecial();
                    break;
                case 6:
                    break;
                default:
                    gerarTextoMenu();
            }

            opcao = sc.nextInt();

        }
        
        sc.close();
    }

    public static void main(String[] args) {
        System.out.println("Iniciando sistema...");
        
        /* Valor de exemplo */
        ContaBancaria contaBanco = new ContaBancaria(600.0);

        contaBanco.criarMenu();
    }

}
