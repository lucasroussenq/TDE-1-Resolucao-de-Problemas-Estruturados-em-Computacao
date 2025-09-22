package estruturas;

public class FilaSimples<T> {
    private static class N<T>{
        T v; N<T> prox;
        N(T v){ this.v=v; }
    }

    private N<T> ini,fim;
    private int tamanho;

    public void entra(T v){
        N<T> n=new N<>(v);
        if(fim!=null) fim.prox=n;
        fim=n;
        if(ini==null) ini=n;
        tamanho++;
    }

    public T sai(){
        if(vazia()) throw new RuntimeException("Fila vazia");
        T v=ini.v;
        ini=ini.prox;
        if(ini==null) fim=null;
        tamanho--;
        return v;
    }

    public boolean vazia(){ return tamanho==0; }
    public int tamanho(){ return tamanho; }
}
