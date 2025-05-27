

import java.io.*;

public class GerarTeste {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("testes/teste3.txt"));

        // Texto: 500.000 caracteres
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            txt.append("abcde");
        }
        writer.write(txt.toString());
        writer.newLine();

        // Padrão: "abcdeabc"
        writer.write("abcdeabc");

        writer.close();
        System.out.println("teste2.txt gerado com sucesso!");
    }
}
