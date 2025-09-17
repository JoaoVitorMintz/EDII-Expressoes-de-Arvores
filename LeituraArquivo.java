import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class LeituraArquivo {
    public static void main(String[] args) {
        String caminho = "arquivo.txt";
        
        // Leitura do arquivo e leitura de cada linha (também verifica se deu erro ou não).
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            lerExpressao(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void lerExpressao(String linha) {
        Stack<Character> p = new Stack<>();
        for (int i = 0; i < linha.length(); i++) {
            char current = linha.charAt(i);
            if (!p.isEmpty()) {
                char last = p.peek();
                if (ehPar(last, current)) {
                    p.pop();
                    continue;
                }
            }
            p.push(current);
        }
    }

    private boolean ehPar(char atual, char ultimo) {
        return (ultimo == '(' && atual == ')');
    }
}