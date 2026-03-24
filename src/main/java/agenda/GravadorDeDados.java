import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {

    private String arquivo = "agendahyllander.dat";

    public void salvarDados(HashMap<String, Contato> contatos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(arquivo));
        out.writeObject(contatos);
        out.close();
    }

    public HashMap<String, Contato> recuperarDados() throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));
            return (HashMap<String, Contato>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
}
