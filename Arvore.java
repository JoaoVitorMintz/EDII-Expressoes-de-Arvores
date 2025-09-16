public class Arvore {
    private Node raiz;

    public Arvore() {
        this.raiz = null;
    }
    
    // TODO: DESENVOLVER TODOS OS CÓDIGOS NECESSÁRIOS:
    // Os métodos obrigatórios, de acordo com o professor, já está com o método construido, porém, é necessário 
    //mais métodos para manipular os dados presentes no arquivo de texto "arquivo.txt" como método inserir e etc.

    public void exibirArvore() {
        exibirArvore(this.raiz, 0);
    }

    private void exibirArvore(Node no, int nivel) {
        // TODO: Realizar código para exibir a árvore
    }

    public boolean EhBST() {
        // TODO: Realizar o código para verificar se é uma árvore de busca, retorna TRUE se for sim de busca
        return true; // retornando algo só pra não dar mensagem de erro...
    }

    public boolean EhAVL() {
        // TODO: Realizar código para verificar se a árvore é balanceada, retorna TRUE se for sim balanceada
        return true; // retornando algo só pra não dar mensagem de erro...
    }

    public int alturaArvore() {
        // TODO: REalizar código para verificar a altura da árvore, devolvendo sua altura
        return 1; // retornando algo só pra não dar mensagem de erro...
    }

    public void preOrdem() {
        preOrdem(this.raiz);
    }

    private void preOrdem(Node no) {
        // TODO REalizar código para exibir a sequência de folhas em PRE ORDEM
    }

}
