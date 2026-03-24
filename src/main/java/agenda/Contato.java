import java.io.Serializable;

public class Contato implements Serializable {
    private String nome;
    private int dia;
    private int mes;

    public Contato(String nome, int dia, int mes) {
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
    }

    public String getNome() {
        return nome;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public String toString() {
        return nome + " - " + dia + "/" + mes;
    }
}
