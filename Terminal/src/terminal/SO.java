/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class SO {
    
    // Nome do Computador
    private static String hostname;
    
    // Usuário Atual inicialmente root
    private static Usuario usuario_atual;
    
    // Estrutura Basica de Arquivo e Diretorio
    private static ArrayList<Usuario> users;
    private static Diretorio Raiz;
    private static ArrayList<Arquivo> arquivo;
    
    private static String path_atual;
    
    // Dados essenciais para navegacao - Array
    static Diretorio Diretorio_Atual;
    
    // iniciando a estrutura de Diretorio padrao: Criando o / e o /home do root
    public SO() {
        SO.users = new ArrayList<>();
        SO.arquivo = new ArrayList<>();
        SO.hostname = "TrabalhoSO-I";
        
        inicializar();
    }
    
    public static void inicializar(){
        // neste método iremos criar o usuario root, os diretorios /, /home e o /home/root manualmente
        Usuario root = new Usuario("root", "123");
        if (SO.getUsers().isEmpty()){
            SO.setUsers(root);
            SO.setUsuario_atual(root);
        }
        
        // /
        Diretorio barra = new Diretorio("/", "/", null, "root", "1", "/");
        Raiz = new Diretorio("/", "/", null, "root", "1", "/");
        
        SO.setPath_atual("/");
        
        SO.Diretorio_Atual = Raiz;
        
        // home
        Diretorio barraHome = new Diretorio("home", "/home", SO.Diretorio_Atual, "root", "1", "/home");
        SO.getDiretorio_Atual().getDiretorios().add(new Diretorio("home", "/home", SO.Diretorio_Atual, "root", "1", "/home"));
        //SO.Diretorio_Atual.getDiretorios().add(barraHome);
        SO.setDiretorio_Atual(Diretorio_Atual.getDiretorios().get(0));
        
        // home/root
        Diretorio barraHomeBarraRoot = new Diretorio("root", "/home/root", SO.Diretorio_Atual, "root", "1", "/home/root");
        SO.getDiretorio_Atual().getDiretorios().add(new Diretorio("root", "/home/root", SO.Diretorio_Atual, "root", "1", "/home/root"));
        //SO.Diretorio_Atual.getDiretorios().add(barraHomeBarraRoot);
        SO.setDiretorio_Atual(Diretorio_Atual.getDiretorios().get(0));
        SO.setPath_atual("/home/root");
        
    }
    
    // Funcao que ira receber os Comandos
    public static String recebe_comandos(String[] args){
        if (args.length == 1){
            if(args[0].equals("exit")){
                Comandos.exit();
            }else if(args[0].equals("tree")){
                Comandos.tree(0,Raiz);
            }else if(args[0].equals("ls")){
                Comandos.ls("null");
            }else if(args[0].equals("adduser")){
                Comandos.ls(args[1]);
            }else if(args[0].equals("format")){
                Comandos.format();
            }else if(args[0].equals("crfile")){
                Comandos.crfile(args[1]);
            }else{
                System.out.println("Comando Inválido.");
            }
        }else{
            if (args[0].equals("hostname")){
                Comandos.hostname(args[1]);
            }else if (args[0].equals("cd")){
                if (args.length < 3){
                    Comandos.cd(args[1]);
                }else{
                    System.out.println("Parametros Incorretos.");
                }
            }else if (args[0].equals("adduser")){
                Comandos.adduser(args[1]);
            }else if (args[0].equals("passwd")){
                Comandos.passwd(args[1]);
            }else if (args[0].equals("removeuser")){
                Comandos.removeuser(args[1]);
            }else if (args[0].equals("ren")){
                Comandos.ren(args);
            }else if (args[0].equals("mkdir")){
                Comandos.mkdir(args[1]);
            }else if(args[0].equals("crfile")){
                Comandos.crfile(args[1]);
            }else if(args[0].equals("rm")){
                Comandos.rm(args[1]);
            }else if(args[0].equals("append")){
                Comandos.append(args[1]);
            }else if(args[0].equals("ls")){
                Comandos.ls(args[1]);
            }else if(args[0].equals("chmod")){
                Comandos.chmod(args[1], args[2], args[3]);
            }else if(args[0].equals("properties")){
                Comandos.properties(args[1]);
            }else if(args[0].equals("cat")){
                Comandos.cat(args[1]);
            }else{
                System.out.println("Comando Inválido.");
            }
        }
        return "";
    }

    public static void setHostname(String hostname) {
        SO.hostname = hostname;
    }

    public static void setUsers(Usuario user) {
        SO.users.add(user);
    }

    public static void setUsuario_atual(Usuario usuario_atual) {
        SO.usuario_atual = usuario_atual;
    }

    public static void setPath_atual(String path_atual) {
        SO.path_atual = path_atual;
    }

    public static String getPath_atual() {
        return path_atual;
    }
    
    public static void Adiciona_Diretorio_Local(Diretorio diretorio){
        Diretorio_Atual.getDiretorios().add(diretorio);
    }

    public static String getHostname() {
        return hostname;
    }

    public static Usuario getUsuario_atual() {
        return usuario_atual;
    }

    public static ArrayList<Usuario> getUsers() {
        return users;
    }

    public static ArrayList<Arquivo> getArquivo() {
        return arquivo;
    }

    public static void setUsers(ArrayList<Usuario> users) {
        SO.users = users;
    }

    public static void setArquivo(ArrayList<Arquivo> arquivo) {
        SO.arquivo = arquivo;
    }

    public static Diretorio getDiretorio_Atual() {
        return Diretorio_Atual;
    }

    public static void setDiretorio_Atual(Diretorio Diretorio_Atual) {
        SO.Diretorio_Atual = Diretorio_Atual;
    }

    public static Diretorio getRaiz() {
        return Raiz;
    }
    
    public static void zera_raiz(){
        SO.Raiz = null;
        inicializar();
    }
}