# EDII Expressões de Árvores

## Alunos:
 - João Vitor Garcia Aguiar Mintz - RA:10440421
 - Yan Andreotti dos Santos - RA:10439766
 - Giovanni Castro - RA:10435745

## 1. Introdução:

Projeto 1 de Estrutura de Dados II consiste em desenvolver um verificador de expressões para árvores binárias.

## 2. Descrição do projeto:

O problema principal a ser solucionado é o de desenvolver um sistema que leia um arquivo entrada.txt contendo uma sequência de expressões. Cada linha do arquivo entrada.txt contém uma expressão que representa a saída em pré-ordem de uma árvore. O seu programa deve, para cada linha do arquivo de entrada decidir se ela corresponde a:

    1.Uma árvore binária de busca;
    2. Uma árvore binária (não de busca);
    3. Uma árvore binária de busca balanceada;
    4. Uma expressão mal-formada.

Cada linha do arquivo entrada.txt corresponde à visitação pré-ordem de uma árvore. O item 4 acima ocorre quando a expressão lida não corresponde a uma árvore.

## 3. Exemplo de expressão mal formada:
<div>
<img align="center" alt="malFormada" height="370" width="715" src="/imagens/mal_formada.png">
</div>

## 4. Exemplo de expressão bem fomada:
<div>
<img align="center" alt="bemFormada" height="370" width="715" src="/imagens/bem_formada.png">
</div>

### SAÍDA:
```
Esta é uma árvore binária de busca balanceada.
- - 45
- 32
- - 23
20
- - 18
- 12
- - - 9
- - 8
- - - 2
```

## 5. Observações:

Métodos adicionais podem ser incluídos. 
Não é permitido o uso de classes de coleções de dados nativas do JAVA.
O seu programa deve, OBRIGATORIAMENTE, criar a árvore binária correspondente à expressão lida, quando for uma expressão bem formada.
Fica a critério do grupo a decisão se a implementação da árvore será **unidirecional** ou **bidirecional**.
