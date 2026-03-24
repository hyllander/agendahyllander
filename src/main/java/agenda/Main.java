import java.io.IOException;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        AgendaHyllander agenda = new AgendaHyllander();

        try {
            
            agenda.cadastraContato("Joao", 10, 5);
            agenda.cadastraContato("Maria", 10, 5);


            Collection<Contato> lista = agenda.pesquisaAniversariantes(10, 5);
            System.out.println("Aniversariantes:");
            for (Contato c : lista) {
                System.out.println(c);
            }

           
            agenda.removeContato("Joao");

          
            agenda.salvarDados();

            agenda.recuperarDados();

            System.out.println("Operações realizadas com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
