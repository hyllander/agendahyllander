import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Collection;

public class AgendaHyllanderTest {

    @Test
    public void testaCadastroEPesquisa() {
        AgendaHyllander agenda = new AgendaHyllander();

        agenda.cadastraContato("Joao", 10, 5);
        agenda.cadastraContato("Maria", 10, 5);

        Collection<Contato> lista = agenda.pesquisaAniversariantes(10, 5);

        assertEquals(2, lista.size());
    }

    @Test
    public void testaRemocao() throws Exception {
        AgendaHyllander agenda = new AgendaHyllander();

        agenda.cadastraContato("Ana", 1, 1);
        assertTrue(agenda.removeContato("Ana"));
    }

    @Test
    public void testaPersistencia() throws IOException {
        AgendaHyllander agenda = new AgendaHyllander();

        agenda.cadastraContato("Carlos", 2, 2);
        agenda.salvarDados();

        AgendaHyllander novaAgenda = new AgendaHyllander();
        novaAgenda.recuperarDados();

        Collection<Contato> lista = novaAgenda.pesquisaAniversariantes(2, 2);

        assertEquals(1, lista.size());
    }
}
