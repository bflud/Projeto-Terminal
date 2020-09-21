/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BRUNOFERNANDODASILVA
 */
public class Arquivo {
    
    Diretorio Path;
    String nome;
    String proprietario;
    int permissao;
    Date datacriaco;
    Date datamodificao;
    Date ultimoacesso;
    String conteudo;
    ArrayList<Permissoes> Permissao_Usuarios;

    public ArrayList<Permissoes> getPermissao_Usuarios() {
        return Permissao_Usuarios;
    }

    public void setPermissao_Usuarios(Permissoes Permissao_Usuarios) {
        this.setDatamodificao(new Date());
        this.Permissao_Usuarios.add(Permissao_Usuarios);
    }

    public Diretorio getPath() {
        return Path;
    }

    public void setPath(Diretorio Path) {
        this.Path = Path;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Date getDatacriaco() {
        return datacriaco;
    }

    public void setDatacriaco(Date datacriaco) {
        this.datacriaco = datacriaco;
    }

    public Date getDatamodificao() {
        return datamodificao;
    }

    public void setDatamodificao(Date datamodificao) {
        this.datamodificao = datamodificao;
    }

    public Date getUltimoacesso() {
        return ultimoacesso;
    }

    public void setUltimoacesso(Date ultimoacesso) {
        this.ultimoacesso = ultimoacesso;
    }

    public String getConteudo() {
        this.setUltimoacesso(new Date());
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.setDatamodificao(new Date());
        this.conteudo = conteudo;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public Arquivo(Diretorio Path, String nome, String proprietario, int permissao, String conteudo) {
        this.Path = Path;
        this.nome = nome;
        this.proprietario = proprietario;
        this.permissao = permissao;
        this.datacriaco = new Date();
        this.datamodificao = new Date();
        this.ultimoacesso = new Date();
        this.conteudo = conteudo;
        this.Permissao_Usuarios = new ArrayList<>();
    }
}