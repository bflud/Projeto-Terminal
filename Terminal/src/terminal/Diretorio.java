/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BRUNOFERNANDODASILVA
 */
public class Diretorio {

    private String nome;
    private String local;
    private String path_unico;
    private Date datacriacao;
    private Diretorio pai;
    private ArrayList<Arquivo> arquivos;
    private ArrayList<Diretorio> diretorios;
    private String proprietario;
    private String permissao;
    ArrayList<Permissoes> Permissao_Usuarios;

    public ArrayList<Permissoes> getPermissao_Usuarios() {
        return Permissao_Usuarios;
    }

    public void setPermissao_Usuarios(Permissoes Permissao_Usuarios) {
        this.Permissao_Usuarios.add(Permissao_Usuarios);
    }

    public Diretorio(String nome, String local, Diretorio pai, String proprietario, String permissao, String path_unico) {
        this.nome = nome;
        this.local = local;
        this.datacriacao = new Date();
        this.pai = pai;
        this.arquivos = new ArrayList<>();
        this.diretorios = new ArrayList<>();
        this.Permissao_Usuarios = new ArrayList<>();
        this.proprietario = proprietario;
        this.permissao = permissao;
        this.path_unico = path_unico;
    }

    public Diretorio getPai() {
        return pai;
    }

    public void setPai(Diretorio pai) {
        this.pai = pai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public ArrayList<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(ArrayList<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public ArrayList<Diretorio> getDiretorios() {
        return diretorios;
    }

    public void setDiretorios(ArrayList<Diretorio> diretorios) {
        this.diretorios = diretorios;
    }

    public void setPath_unico(String path_unico) {
        this.path_unico = path_unico;
    }

    public String getPath_unico() {
        String novo_path_unico = Atualiza_Path(this);
        this.setPath_unico(path_unico);
        return novo_path_unico;
    }
    
    public void atualiza(){
        setPath_unico(Atualiza_Path(this));
    }
    
    private String Atualiza_Path(Diretorio dir){
        if (dir.pai == null){
            return dir.getNome();
        }else{
            if (dir.getPai().getPai() == null){
                return Atualiza_Path(dir.getPai()) + "" + dir.getNome();
            }else{
                return Atualiza_Path(dir.getPai()) + "/" + dir.getNome();
            }
        }
    }
    
}