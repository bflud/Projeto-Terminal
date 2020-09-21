/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Comandos {

    public static void Comandos() {
    }

    public static void imprime_dir(int i, Diretorio dir) {
        /*for (Iterator iterator = dir.getDiretorios().iterator(); iterator.hasNext();) {
            Diretorio d = (Diretorio) iterator.next();
            if (iterator.hasNext()) {
                if (i == 0) {
                    System.out.println(d.getNome());
                } else {
                    for (int x = 0; x < i; x++) {
                        System.out.print("\t");
                    }
                    System.out.println(d.getNome());
                }
            }
        }*/

        for (Diretorio dire : dir.getDiretorios()) {
            if (i == 0) {
                System.out.println(dir.getNome());
            } else {
                for (int x = 0; x < i; x++) {
                    System.out.print("\t");
                }
                System.out.println(dir.getNome());
            }
        }
    }

    public static void tree(int i, Diretorio diretorio) {
        String print = "";

        print = print + "\n " + diretorio.getNome();

        if (!(diretorio.getDiretorios().isEmpty())) {
            //System.out.println(diretorio.getNome());
            for (Iterator iterator = diretorio.getDiretorios().iterator(); iterator.hasNext();) {
                if (iterator.hasNext()) {
                    Diretorio d = (Diretorio) iterator.next();
                    i++;
                    tree(i, d);
                }
            }
        }
        System.out.println(print);
    }

    public static void exit() {
        System.exit(0);
    }

    public static void mkdir(String path) {
        Diretorio local;
        String[] path_quebrado = path.split("");

        if (path_quebrado[0].equals("/")) {
            String[] temp = path.split("/");
            if (temp.length == 2) {
                boolean ok = true;
                for (Iterator it = SO.getRaiz().getDiretorios().iterator(); it.hasNext();) {
                    Diretorio d = (Diretorio) it.next();
                    if (d.getNome().equals(temp[temp.length - 1])) {
                        ok = false;
                    }
                }
                if (ok == true) {
                    SO.getRaiz().getDiretorios().add(new Diretorio(temp[temp.length - 1], SO.getRaiz().getPath_unico() + "/" + temp[temp.length - 1], SO.getRaiz(), "root", "1", SO.getRaiz().getPath_unico() + "/" + temp[temp.length - 1]));
                } else {
                    System.out.println("Diretorio Existente.");
                }

            } else {
                local = navega(path, "0");
                String[] pathSimples = path.split("/");
                if (local != null) {
                    boolean ok = true;
                    for (Iterator it = local.getDiretorios().iterator(); it.hasNext();) {
                        Diretorio d = (Diretorio) it.next();
                        if (d.getNome().equals(temp[temp.length - 1])) {
                            ok = false;
                        }
                    }
                    if (ok == true) {
                        local.getDiretorios().add(new Diretorio(pathSimples[pathSimples.length - 1], local.getPath_unico() + "/" + pathSimples[pathSimples.length - 1], local, "root", "1", local.getPath_unico() + "/" + pathSimples[pathSimples.length - 1]));
                    } else {
                        System.out.println("Diretorio Existente.");
                    }
                } else {
                    System.out.println("Diretorio Não Encontrado.");
                }
            }
        } else {
            String[] pathSimples = path.split("/");
            if (pathSimples.length == 1) {
                boolean ok = true;
                for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
                    Diretorio d = (Diretorio) it.next();
                    if (d.getNome().equals(pathSimples[pathSimples.length - 1])) {
                        ok = false;
                    }
                }
                if (ok == true) {
                    SO.getDiretorio_Atual().getDiretorios().add(new Diretorio(path, SO.getPath_atual() + "/" + pathSimples[0], SO.Diretorio_Atual, "root", "1", SO.getPath_atual() + "/" + pathSimples[0]));
                } else {
                    System.out.println("Diretorio Existente.");
                }
            } else if (pathSimples.length >= 2) {
                local = navega(path, "0");
                if (local != null) {
                    boolean ok = true;
                    for (Iterator it = local.getDiretorios().iterator(); it.hasNext();) {
                        Diretorio d = (Diretorio) it.next();
                        if (d.getNome().equals(pathSimples[pathSimples.length - 1])) {
                            ok = false;
                        }
                    }
                    if (ok == true) {
                        local.getDiretorios().add(new Diretorio(pathSimples[pathSimples.length - 1], SO.getPath_atual() + "/" + path, local, "root", "1", SO.getPath_atual() + "/" + path));
                    } else {
                        System.out.println("Diretorio Existente.");
                    }
                } else {
                    System.out.println("Diretorio Não Encontrado.");
                }
            }
        }
    }

    public static void adduser(String nome) {

        // verifica a existencia do /home
        Diretorio local = navega("/home", null);
        if (local == null) {
            SO.getRaiz().getDiretorios().add(new Diretorio("home", "/home", SO.Diretorio_Atual, "root", "1", "/home"));
        }

        boolean ok = false;
        for (Iterator it = SO.getUsers().iterator(); it.hasNext();) {
            Usuario u = (Usuario) it.next();
            if (u.getNome().equals(nome)) {
                ok = true;
            }
        }

        if (ok == false) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Informe a senha: ");
            String senha = teclado.nextLine();

            System.out.print("Confirme a senha: ");
            String confirm = teclado.nextLine();

            if (senha.equals(confirm)) {
                SO.setUsers(new Usuario(nome, senha));
                mkdir("/home/" + nome);
            } else {
                System.out.println("As senhas não conferem.");
            }
        } else {
            System.out.println("Usuário existente.");
        }
    }

    public static void passwd(String nome) {
        boolean ok = false;
        Usuario u = null;
        for (Iterator it = SO.getUsers().iterator(); it.hasNext();) {
            u = (Usuario) it.next();
            if (u.getNome().equals(nome)) {
                ok = true;
            }
        }

        if (ok != false) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Informe a senha antiga: ");
            String senhaAntiga = teclado.nextLine();

            System.out.print("Informe anova senha: ");
            String senha = teclado.nextLine();

            System.out.print("Confirme a senha: ");
            String confirm = teclado.nextLine();

            if (senha.equals(confirm) && senhaAntiga.equals(u.getSenha())) {
                u.setSenha(senha);
            } else {
                System.out.println("As senhas não conferem.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void crfile(String nome) {

        String[] tmp = nome.split("/");
        Diretorio local;
        String tm = "";

        if (tmp.length >= 2) {
            for (int i = 0; i < tmp.length - 1; i++) {
                tm = tm + tmp[i] + "/";
            }
            local = navega(tm, null);

            boolean ok = false;
            for (Iterator it = local.getArquivos().iterator(); it.hasNext();) {
                Arquivo a = (Arquivo) it.next();
                if (a.getNome().equals(nome)) {
                    ok = true;
                }
            }

            if (ok == false) {
                Scanner teclado = new Scanner(System.in);
                System.out.print("Informe o Conteudo: ");
                String conteudo = teclado.nextLine();

                local.getArquivos().add(new Arquivo(local, tmp[tmp.length - 1], SO.getUsuario_atual().toString(), 2, conteudo));
            } else {
                System.out.println("Arquivo Ja existe.");
            }
        } else if (tmp.length == 1) {
            boolean ok = false;
            for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
                Arquivo a = (Arquivo) it.next();
                if (a.getNome().equals(nome)) {
                    ok = true;
                }
            }

            if (ok == false) {
                Scanner teclado = new Scanner(System.in);
                System.out.print("Informe o Conteudo: ");
                String conteudo = teclado.nextLine();

                SO.getDiretorio_Atual().getArquivos().add(new Arquivo(SO.getDiretorio_Atual(), tmp[tmp.length - 1], SO.getUsuario_atual().toString(), 2, conteudo));
            } else {
                System.out.println("Arquivo Ja existe.");
            }
        }

    }

    public static void cd(String path) {
        if (path.equals("..")) {
            if (SO.getDiretorio_Atual().getPai() != null) {
                SO.setDiretorio_Atual(SO.getDiretorio_Atual().getPai());
                SO.setPath_atual(SO.getDiretorio_Atual().getPath_unico());
            } else {
                Diretorio novo_atual = navega(path, "cd");
                if (novo_atual != null) {
                    SO.setDiretorio_Atual(novo_atual);
                    SO.setPath_atual(novo_atual.getPath_unico());
                }
            }
        } else {
            Diretorio novo_atual = navega(path, "cd");
            if (novo_atual != null) {
                SO.setDiretorio_Atual(novo_atual);
                SO.setPath_atual(novo_atual.getPath_unico());
            }
        }
    }

    public static void removeuser(String nome) {
        int i = 0;
        boolean ok = false;
        Usuario u = null;
        for (Iterator it = SO.getUsers().iterator(); it.hasNext();) {
            u = (Usuario) it.next();
            if (u.getNome().equals(nome)) {
                ok = true;
                break;
            }
            i++;
        }

        if ((ok != false) && (u != null)) {
            // removendo o /home do usuario
            Diretorio local = navega("/home", null);
            Diretorio remover = null;

            for (Iterator ite = local.getDiretorios().iterator(); ite.hasNext();) {
                remover = (Diretorio) ite.next();
                if (remover.getNome().equals(u.getNome())) {
                    break;
                }
            }

            local.getDiretorios().remove(remover);
            SO.getUsers().remove(u);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void ren(String[] path) {
        boolean ok = true;
        for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
            Diretorio d = (Diretorio) it.next();
            if (path[2].equals(d.getNome())) {
                ok = false;
            }
        }
        
        if (ok == true){
            for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
                Diretorio d = (Diretorio) it.next();
                if (path[1].equals(d.getNome())) {
                    d.setNome(path[2]);
                }
            }
        }else{
            System.out.println("Diretorio destino em duplicidade.");
        }
        
        ok = true;

        for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
            Arquivo a = (Arquivo) it.next();
            if (path[2].equals(a.getNome())) {
                ok = false;
            }
        }
        
        if (ok == true){
            for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
                Arquivo a = (Arquivo) it.next();
                if (path[1].equals(a.getNome())) {
                    a.setNome(path[2]);
                }
            }
        }else{
            System.out.println("Arquivo destino já existente.");
        }
    }

    public static String rm(String path) {
        Diretorio d = null;
        Arquivo a = null;
        for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
            d = (Diretorio) it.next();
            if (path.equals(d.getNome())) {
                SO.getDiretorio_Atual().getDiretorios().remove(d);
                return "";
            }
        }

        for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
            a = (Arquivo) it.next();
            if (path.equals(a.getNome())) {
                SO.getDiretorio_Atual().getArquivos().remove(a);
                return "";
            }
        }

        return "";
    }

    public static void append(String path) {
        Arquivo a = null;
        for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
            a = (Arquivo) it.next();
            if (path.equals(a.getNome())) {
                Scanner entrada = new Scanner(System.in);
                String valores = entrada.nextLine();
                a.setConteudo(a.getConteudo() + " " + valores);
            }
        }
    }

    public static void chmod(String permissao, String usuario, String caminho) {
        Diretorio d;
        Arquivo a;
        int per = Integer.parseInt(permissao);
        for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
            d = (Diretorio) it.next();
            if (d.getNome().equals(caminho)) {
                d.getPermissao_Usuarios().add(new Permissoes(usuario, per));
            }
        }

        for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
            a = (Arquivo) it.next();
            if (a.getNome().equals(caminho)) {
                a.getPermissao_Usuarios().add(new Permissoes(usuario, per));
            }
        }
    }

    public static void properties(String arquivo) {
        Diretorio d;
        Arquivo a;
        for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
            d = (Diretorio) it.next();
            if (d.getNome().equals(arquivo)) {
                for (Iterator ite = d.getPermissao_Usuarios().iterator(); ite.hasNext();) {
                    Permissoes per = (Permissoes) ite.next();
                    System.out.println("\t" + per.getUsuario() + " : " + per.getPermissao());
                }
            }
        }

        for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
            a = (Arquivo) it.next();
            if (a.getNome().equals(arquivo)) {
                for (Iterator ite = a.getPermissao_Usuarios().iterator(); ite.hasNext();) {
                    Permissoes per = (Permissoes) ite.next();
                    System.out.println("\t" + per.getUsuario() + " : " + per.getPermissao());
                }
            }
        }
    }

    public static void cat(String arquivo) {
        Arquivo a;
        for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
            a = (Arquivo) it.next();
            if (a.getNome().equals(arquivo)) {
                System.out.println("\n" + a.getConteudo() + "\n");
            }
        }
    }

    public static void hostname(String nome) {
        SO.setHostname(nome);
    }

    public static void format() {
        SO.zera_raiz();
    }

    // funcao para encontrar o endereco desejado e fazer as operacoes praticamente um cd (retorno dessa funcao)
    public static Diretorio navega(String path_desejado, String comando) {
        try {
            String[] path_quebrado = path_desejado.split("");
            Diretorio destino = null, origem = SO.getDiretorio_Atual();
            if (path_desejado.equals("/")) {
                return SO.getRaiz();
            } else if (path_quebrado[0].equals("/")) {
                String[] pathSimples = path_desejado.split("/");
                origem = SO.getRaiz();
                int indice = 0;
                boolean sair = false;
                while (sair != true) {
                    for (Iterator it = origem.getDiretorios().iterator(); it.hasNext();) {
                        Diretorio d = (Diretorio) it.next();
                        if (d.getNome().equals(pathSimples[indice])) {
                            destino = d;
                            origem = d;
                            break;
                        }
                    }
                    indice++;
                    if (indice >= pathSimples.length) {
                        sair = true;
                    }
                }
                return destino;
            } else if (path_quebrado[0].equals("..")) {
                String[] pathSimples = path_desejado.split("/");
                if (pathSimples.length >= 2) {
                    int indice = 0;
                    boolean sair = false;
                    while (sair != true) {
                        if (pathSimples[indice].equals("..")) {
                            if (origem.getPai() != null) {
                                destino = origem.getPai();
                            }
                        } else {
                            for (Iterator it = origem.getDiretorios().iterator(); it.hasNext();) {
                                Diretorio d = (Diretorio) it.next();
                                if (d.getNome().equals(pathSimples[indice])) {
                                    destino = d;
                                    origem = d;
                                    break;
                                }
                            }
                        }
                        indice++;
                        if (indice >= pathSimples.length) {
                            sair = true;
                        }
                    }
                    if (destino == null) {
                        System.out.println("Destino Nao Encontrado.");
                    } else {
                        return destino;
                    }
                }
            } else {
                String[] pathSimples = path_desejado.split("/");
                if (pathSimples.length == 1 && !comando.equals("cd")) {
                    // Aqui ele ira retornar o local a ser adicionado a nova pasta
                    return SO.getDiretorio_Atual();
                } else if (pathSimples.length >= 2 || (pathSimples.length == 1 && comando.equals("cd"))) {
                    int indice = 0;
                    boolean sair = false;
                    while (sair != true) {
                        for (Iterator it = origem.getDiretorios().iterator(); it.hasNext();) {
                            Diretorio d = (Diretorio) it.next();
                            if (d.getNome().equals(pathSimples[indice])) {
                                destino = d;
                                origem = d;
                                break;
                            }
                        }
                        indice++;
                        if (indice >= pathSimples.length) {
                            sair = true;
                        }
                    }
                    if (destino == null) {
                        System.out.println("Destino Nao Encontrado.");
                    } else {
                        return destino;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Diretório/Parametros incorretos.");
        }

        return null;
    }

    public static void ls(String path) {
        if (path.equals("null")) {
            for (Iterator it = SO.getDiretorio_Atual().getDiretorios().iterator(); it.hasNext();) {
                Diretorio d = (Diretorio) it.next();
                System.out.println("dir \t" + d.getNome());
            }

            for (Iterator it = SO.getDiretorio_Atual().getArquivos().iterator(); it.hasNext();) {
                Arquivo a = (Arquivo) it.next();
                System.out.println("\t" + a.getNome());
            }
        } else {
            Diretorio local = navega(path, null);
            if (local != null) {
                for (Iterator it = local.getDiretorios().iterator(); it.hasNext();) {
                    Diretorio d = (Diretorio) it.next();
                    System.out.println("dir \t" + d.getNome());
                }

                for (Iterator it = local.getArquivos().iterator(); it.hasNext();) {
                    Arquivo a = (Arquivo) it.next();
                    System.out.println("\t" + a.getNome());
                }
            }
        }
    }
}