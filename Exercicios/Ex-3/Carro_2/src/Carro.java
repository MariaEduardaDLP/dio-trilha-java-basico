import java.util.Scanner;

public class Carro {
    private boolean estaLigado = false;
    private int marcha = 0;
    private int velocidade = 0;

    private Scanner sc = new Scanner(System.in);
    
    void ligarCarro() {
        this.estaLigado = true;

        System.out.println("-----Carro ligado-----");
    }
    
    void desligarCarro() {
        if (this.marcha == 0 && this.velocidade == 0 && this.estaLigado) {
            this.estaLigado = false;

            System.out.println("-----Carro desligado-----");
        }
    }

    void acelerarCarro() throws CarroDesligadoException {
        
        if (!this.estaLigado) {
            throw new CarroDesligadoException();
        }

        if (this.marcha == 0)
            System.err.println("Não é possível desacelerar em ponto morto. Troque a marcha do carro.");

        else if (this.marcha == 1 && (this.velocidade >= 0 && this.velocidade < 20))
            this.velocidade += 1;

        else if (this.marcha == 2 && (this.velocidade >= 20 && this.velocidade < 40))
            this.velocidade += 1;

        else if (this.marcha == 3 && (this.velocidade >= 40 && this.velocidade < 60))
            this.velocidade += 1;

        else if (this.marcha == 4 && (this.velocidade >= 60 && this.velocidade < 80))
            this.velocidade += 1;

        else if (this.marcha == 5 && (this.velocidade >= 80 && this.velocidade < 100))
            this.velocidade += 1;
            
        else if (this.marcha == 6 && (this.velocidade >= 100 && this.velocidade < 120))
            this.velocidade += 1;

        verificarVelocidade();

    }

    void desacelerarCarro() throws CarroDesligadoException {

        if (!this.estaLigado) {
            throw new CarroDesligadoException();
        }

        if (this.marcha == 0)
            System.err.println("Não é possível desacelerar em ponto morto. Troque a marcha do carro.");

        else if (this.marcha == 1 && (this.velocidade > 0 && this.velocidade <= 20))
            this.velocidade -= 1;

        else if (this.marcha == 2 && (this.velocidade > 20 && this.velocidade <= 40))
            this.velocidade -= 1;

        else if (this.marcha == 3 && (this.velocidade > 40 && this.velocidade <= 60))
            this.velocidade -= 1;

        else if (this.marcha == 4 && (this.velocidade > 60 && this.velocidade <= 80))
            this.velocidade -= 1;

        else if (this.marcha == 5 && (this.velocidade > 80 && this.velocidade <= 100))
            this.velocidade -= 1;

        else if (this.marcha == 6 && (this.velocidade > 100 && this.velocidade <= 120))
            this.velocidade -= 1;

        verificarVelocidade();
    }
    
    void trocarMarcha() throws CarroDesligadoException {
        if (!this.estaLigado) {
            throw new CarroDesligadoException();
        }
        
        System.out.printf("Marcha atual: " + this.marcha
        + "\nIr para\n"
        + "[1] Próxima marcha\n"
        + "[2] Marcha anterior\n");

        int opcao;
        do {
            System.out.println("Selecione uma opção válida:");
            opcao = (this.sc).nextInt();
        } while (!(opcao > 0 && opcao < 3));

        switch (opcao) {
            case 1 -> {
                if (this.marcha < 6) this.marcha += 1;

                else System.err.println("O carro possui apenas 6 marchas");
            }
            case 2 -> {
                if (this.marcha > 0) this.marcha -= 1;

                else System.err.println("Não existem marchas negativas");
            }
        }

    }

    void verificarVelocidade() {
        System.out.println("Velocidade atual do carro: " + this.velocidade);
    }

    void virarCarro(String direcao) throws CarroDesligadoException {
        if (!this.estaLigado) {
            throw new CarroDesligadoException();
        }
     
        if ((this.velocidade > 0 && this.velocidade <= 40)
        && (direcao.equalsIgnoreCase("esquerda") 
        || direcao.equalsIgnoreCase("direita"))) 
            System.out.println("Virando o carro para a " + direcao.toLowerCase() + "...");
        else
            System.err.println("Erro ao tentar virar o carro");
    }

    private void gerarTextoMenu() {
        System.out.println("==========Carro==========\n" +
        "(0) Ligar o carro\n" +
        "(1) Desligar o carro\n" +
        "(2) Acelerar\n" +
        "(3) Diminuir velocidade\n" +
        "(4) Virar o carro\n" +
        "(5) Verificar velocidade\n" +
        "(6) Trocar a marcha\n" +
        "(7) Sair");
    }

    public void criarMenu() {
        gerarTextoMenu();

        int opcao = (this.sc).nextInt();

        while(opcao != 7) {

            switch (opcao) {
                case 0:
                    ligarCarro();
                    break;
                case 1:
                    desligarCarro();
                    break;
                case 2:
                    acelerarCarro();
                    break;
                case 3:
                    desacelerarCarro();
                    break;
                case 4:
                    System.out.println("Informe a direção [esquerda/direita]:");
                    virarCarro(sc.next());
                    break;
                case 5:
                    verificarVelocidade();
                    break;
                case 6:
                    trocarMarcha();
                    break;
                case 7:
                    break;
                default:
                    gerarTextoMenu();
            }

            opcao = sc.nextInt();

        }
        
    }

    public static void main(String[] args) {
        System.out.println("Iniciando o sistema do carro...");
        
        Carro carro = new Carro();

        while (true) {
            try {
                carro.criarMenu();
                break;
            } catch (CarroDesligadoException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }
}
