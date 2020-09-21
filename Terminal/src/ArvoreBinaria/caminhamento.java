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
public class caminhamento {
    public void prefixado(No no) {
    if(no != null){
        System.out.print(no.valor + " ");
        prefixado(no.esquerda);
        prefixado(no.direita);
    }
}
}
