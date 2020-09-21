/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreBinaria;

/**
 *
 * @author BF
 */
public class excluir {
    public No removeValorMinimoDaArvore(No node) {
    if (node == null) {
        System.out.println("  ERRO ");
    } else if (node.esquerda != null) {
        node.esquerda = removeValorMinimoDaArvore(node.esquerda);
        return node;
    } else {
        //Se não tiver elemento esquerdo só nós resta o da direita
        return node.direita;
    }
    return null;
}
}
