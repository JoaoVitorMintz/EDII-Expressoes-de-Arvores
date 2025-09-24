import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeituraArquivo {
    public static void main(String[] args) {
        String caminho = "arquivo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean continuar = true;

            while ((linha = br.readLine()) != null && continuar) {
                System.out.println("\nExpressão presente no arquivo: " + linha);

                Arvore ar = new Arvore();
                Node raiz = null;
                try {
                    String[] tokens = linha.replace("(", " ( ")
                                           .replace(")", " ) ")
                                           .trim()
                                           .split("\\s+");
                    int[] pos = {0};
                    raiz = Arvore.construirExpressao(tokens, pos);

                    // se ainda sobraram tokens -> mal-formada
                    if (pos[0] != tokens.length) {
                        throw new RuntimeException("Expressão mal-formada!");
                    }

                    ar.setRaiz(raiz);
                } catch (Exception e) {
                    System.out.println("Expressão mal-formada!");
                    continue;
                }

                if (raiz == null) {
                    System.out.println("Expressão mal-formada!");
                } else {
                    ar.exibirArvore();
                    System.out.print("Sequência em pré-ordem: ");
                    ar.preOrdem();

                    if (ar.EhBST() && ar.EhAVL()) {
                        System.out.println("Esta é uma árvore binária de busca balanceada (AVL).");
                    } else if (ar.EhBST()) {
                        System.out.println("Esta é uma árvore binária de busca.");
                    } else {
                        System.out.println("Esta é uma árvore binária (não de busca).");
                    }
                }

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
