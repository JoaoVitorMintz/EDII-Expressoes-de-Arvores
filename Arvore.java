public class Arvore {
    private Node raiz;

    public Arvore() {
        this.raiz = null;
    }
    
    // TODO: DESENVOLVER TODOS OS CÓDIGOS NECESSÁRIOS:
    // Os métodos obrigatórios, de acordo com o professor, já está com o método construido, porém, é necessário 
    //mais métodos para manipular os dados presentes no arquivo de texto "arquivo.txt" como método inserir e etc.

    public void inserir(int elemento) {
        Node no = new Node();
        no.valor = elemento;

        if (raiz == null) {
            raiz = no;
            return;
        }

        Node atual = raiz;
        Node pai;

        while (true) {
            pai = atual;
            if (elemento <= atual.valor) {
                atual = atual.esquerda;
                if (atual == null) {
                    pai.esquerda = no;
                    return;
                }
            } else {
                atual = atual.direita;
                if (atual == null) {
                    pai.direita = no;
                    return;
                }
            }
        }
    }

    public void excluirArvore() {
        this.raiz = null;
    }

    public void exibirArvore() {
        exibirArvore(this.raiz, 0);
    }

    private void exibirArvore(Node no, int nivel) {
        if(no != null) {
            exibirArvore(no.direita, nivel + 1);
            for(int r = 1; r <= nivel; r++)
              System.out.print(" - ");
            System.out.println(no.valor);
            exibirArvore(no.esquerda, nivel + 1);
        }
    }

    public boolean EhBST() {
        return EhBST(this.raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean EhBST(Node no, int min, int max) {
        if (no == null) return true;
        if (no.valor <= min || no.valor >= max) return false;
        return EhBST(no.esquerda, min, no.valor) &&
               EhBST(no.direita, no.valor, max);
    }

    public boolean EhAVL() {
        return verificarAVL(this.raiz) != -1;
    }

    private int verificarAVL(Node no) {
        if (no == null) return 0;

        int altEsq = verificarAVL(no.esquerda);
        if (altEsq == -1) return -1;

        int altDir = verificarAVL(no.direita);
        if (altDir == -1) return -1;

        if (Math.abs(altEsq - altDir) > 1) return -1;

        return 1 + Math.max(altEsq, altDir);
    }

    public int alturaArvore() {
        return altura(this.raiz);
    }

    private int altura(Node no) {
        if (no == null) return 0;
        return 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    public void preOrdem() {
        preOrdem(this.raiz);
        System.out.println();
    }

    private void preOrdem(Node no) {
        // TODO REalizar código para exibir a sequência de folhas em PRE ORDEM
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    // Método para acessar a raiz externamente
    public Node getRaiz() {
        return raiz;
    }

    // Método auxiliar: construir árvore a partir da expressão do arquivo
    public static Node construirExpressao(String[] tokens, int[] pos) {
        if (pos[0] >= tokens.length) return null;

        String token = tokens[pos[0]++];

        // Se for nulo
        if (token.equals("*")) return null;

        // Se não for "(", é mal-formada
        if (!token.equals("(")) throw new RuntimeException("Expressão mal-formada!");

        // Próximo deve ser o valor
        if (pos[0] >= tokens.length) throw new RuntimeException("Expressão mal-formada!");
        int valor = Integer.parseInt(tokens[pos[0]++]);

        Node no = new Node();
        no.valor = valor;

        // Constrói filho esquerdo
        no.esquerda = construirExpressao(tokens, pos);

        // Constrói filho direito
        no.direita = construirExpressao(tokens, pos);

        // Espera um ")"
        if (pos[0] >= tokens.length || !tokens[pos[0]].equals(")")) {
            throw new RuntimeException("Expressão mal-formada!");
        }
        pos[0]++; // consome ")"

        return no;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }
}
