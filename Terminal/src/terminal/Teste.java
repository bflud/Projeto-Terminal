/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

/**
 *
 * @author Lucas
 */
public class Teste {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        System.out.println(sdf.format(new Date()));
        
        String path = "/home/teste/teste/caramba/mais_um_teste/oi/agora_sim";
        
        System.out.println(path);
        
        String[] tmp = path.split("/");
        
        for (String t : tmp){
            System.out.println(t);
        }
        
        System.out.println(tmp[tmp.length - 2]);
        
        String nome = "";
        
        for (int i = 0; i < tmp.length - 2; i++){
            nome = nome + tmp[i] + "/";
        }
        
        System.out.println(nome);
        
        
        /*String[] teste = path.split("//");
        String desejo = "oi";
        
        System.out.println("Tamanho do Vetor: " + teste.length);
        
        for (String percorre : teste){
            if (percorre.equals(desejo)){
                System.out.println("Achei o carai do Diretorio: " + percorre.toString());
                break;
            }else{
                System.out.print("Ainda não: " + percorre.toString());
            }
        }*/
    }
    
}
