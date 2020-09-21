/**
 * Classe que implementa uma Arvore Binaria de Busca
 * 
 * A avore trabalha com elementos do tipo No
 */

public class Abb {
    private No raiz;
    
    /**
     * Construtor
     */
    public Abb()
    {
		raiz = null;
    }
    
    /**
     * verifica se a arvore esta vazia
     * em caso positivo devolve true
     * caso contrario, devolve false
     */
    public boolean isEmpty()
    {
        if(raiz == null)
            return true;
        return false;
    }

	
    /**
     * busca a chave x na arvore
     *  - devolve um ponteiro para o no que possui a chave
     * ou null caso a chave nao exista
     */
    public No busca(int x)
    {
        System.out.println("TODO");
        return null;
    }
    
    
    /**
     * insere a chave x na arvore
     */
    public void insere(int x)
    {
        System.out.println("TODO");
    }
    
    /**
     * remove a chave x da arvore
     */
    public void remove(int x)
    {
        System.out.println("TODO");
    }
    
    /**
     * realiza um percurso na arvore. O percurso
     * a ser realizado é passado por parâmetro:
     * -1 = pre-ordem
     *  0 = ordem simetrica
     *  1 = pos-ordem
     * Visitar um no, nesses metodos, equivale a imprimir 
     * o valor de sua chave. Faca a impressao de todas as 
     * chaves em uma mesma linha, passando para uma nova 
     * linha somente apos imprimir todas as chaves.
     */
    public void visita(int p)
    {
        System.out.println("TODO");
    }
    
    
    /**
     * Mostra o estado atual da arvore
     * 
     * método de autoria de Leonardo Zandoná - 2006/2     
     */    
    public void mostraArvore() {
       if (isEmpty())
       {
          System.out.println("Árvore vazia!");          
       }
       else
       {
           String separator = String.valueOf("  |__");
           System.out.println(this.raiz.getChave() + "(RAIZ)"); 
           mostraSubArvore(raiz.getEsq(),  separator);
           mostraSubArvore(raiz.getDir(), separator);
       }
   }
    
    
    
    /**
     * Metodos auxiliares:
     * aqui voce pode criar metodos para auxiliar nas
     * operacoes acima. Na maioria dos casos, por serem
     * metodos auxiliares, esses metodos devem ser privados.
     */
    private No achaPai (int x) {
        No p = raiz;
        No prev = null;
        while (p != null && !(p.getChave()==x)) {  // acha o nó p com a chave x
            prev = p;
            if (p.getChave()<x)
                p = p.getDir();
            else 
                p = p.getEsq();
        }
        if (p!=null && p.getChave()==x) 
            return prev;
        return null;
    }  

    
   private void mostraSubArvore(No pt, String separator) {
      if (pt != null) {
         No father = this.achaPai(pt.getChave());
         if (pt.equals(father.getEsq()) == true) {
            System.out.println(separator+pt.getChave()+ " (ESQ)");
         }else{
            System.out.println(separator+pt.getChave()+" (DIR)");
         }
         mostraSubArvore(pt.getEsq(),  "     "+separator);
         mostraSubArvore(pt.getDir(), "     "+separator);
      }
   }


    
}
