/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author BRUNOFERNANDODASILVA
 */
public class Terminal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        SO so = new SO();
        boolean sair = false;
        
        // inicialmente teremos um usuario root criado com a senha 123 logado por padrao
        while(sair != true){
            SO.Diretorio_Atual.atualiza();
            System.out.print(SO.getUsuario_atual().getNome() + "@" + SO.getHostname() + ":" + SO.getPath_atual() + "$");
            String comandos = entrada.nextLine();
            SO.recebe_comandos(comandos.split(" "));
        }
    }
    
}
