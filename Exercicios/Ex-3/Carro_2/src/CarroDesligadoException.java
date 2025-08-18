public class CarroDesligadoException extends RuntimeException {

    public CarroDesligadoException () {
        super("Você precisa ligar o carro primeiro!");
    }

}
