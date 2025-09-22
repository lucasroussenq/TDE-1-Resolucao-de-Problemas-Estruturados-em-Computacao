package estruturas;

public class PilhaSimples<T> {
    private static class N<T> {
        T v; N<T> prox;
        N(T v, N<T> prox){ this.v=v; this.prox=prox; }
    }

    private N<T> topo;
    private int tamanho;

    public void empilha(T v){
        topo = new N<>(v, topo);
        tamanho++;
    }

    public T desempilha(){
        if (vazia()) throw new RuntimeException("Pilha vazia");
        T v = topo.v;
        topo = topo.prox;
        tamanho--;
        return v;
    }

    public boolean vazia(){ return tamanho==0; }
    public int tamanho(){ return tamanho; }
}
