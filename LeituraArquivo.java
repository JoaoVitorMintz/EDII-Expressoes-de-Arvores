import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {
    public static void main(String[] args) {
        String caminho = "arquivo.txt";
        Arvore ar = new Arvore();

        System.out.print("Lendo 'arquivo.txt' e inserindo seus valores na árvore:\n");
        
        // Leitura do arquivo e leitura de cada linha (também verifica se deu erro ou não).
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                construirArvore(linha, ar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void construirArvore(String expressao, Arvore ar) {
        int i = 0;


        while (i < expressao.length()) {
            char atual = expressao.charAt(i);

            if (Character.isDigit(atual)) {
                int numero = 0;
                while (i < expressao.length() && Character.isDigit(atual)) {
                    numero = numero * 10 + Character.getNumericValue(atual);
                    i++;
                }
                ar.inserir(numero);
            } else {
                i++;
            }
        }
    }
}