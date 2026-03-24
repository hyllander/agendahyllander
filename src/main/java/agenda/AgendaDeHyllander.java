import java.io.IOException;
import java.util.*;

public class AgendaHyllander implements Agenda {

    private HashMap<String, Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaHyllander() {
        contatos = new HashMap<>();
        gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (!contatos.containsKey(nome)) {
            contatos.put(nome, new Contato(nome, dia, mes));
            return true;
        }
        return false;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        List<Contato> lista = new ArrayList<>();

        for (Contato c : contatos.values()) {
            if (c.getDia() == dia && c.getMes() == mes) {
                lista.add(c);
            }
        }
        return lista;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            return true;
        }
        throw new ContatoInexistenteException("Contato não encontrado");
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarDados(contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        contatos = gravador.recuperarDados();
    }
}
