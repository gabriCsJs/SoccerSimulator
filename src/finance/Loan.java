package finance;

public class Loan {

    double value;
    int dataDePedido;
    int prazo;
    double juros;
    boolean atraso;

    Loan(double value, int dataDePedido, int prazo, double juros){
        double add = value * 0.2;
        this.value = value + add;
        this.dataDePedido = dataDePedido;
        this.prazo = prazo;
        this.juros = juros;
        this.atraso = false;
    }

}
