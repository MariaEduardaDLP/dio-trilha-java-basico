import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, insira o número da conta:");
        int numeroConta = sc.nextInt();

        sc.nextLine(); // Ler a quebra de linha do código anterior 

        System.out.println("Por favor, insira sua agência:");
        String agencia = sc.nextLine();
        
        System.out.println("Por favor, insira o nome do cliente:");
        String nome = sc.nextLine();

        System.out.println("Por favor, insira seu saldo inicial:");
        Double saldo = sc.nextDouble();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.\n", nome, agencia, numeroConta, saldo);

        sc.close();
    }
}
