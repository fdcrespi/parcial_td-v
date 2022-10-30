package Java;

import Exceptions.energiaNegativaException;

public class Arco {
    private Nodo i;
    private Nodo j;
    private float w;

    public Arco(Nodo i, Nodo j, float w) throws energiaNegativaException {
        this.i = i;
        this.j = j;
        if (w > 0) this.w = w;
        else throw new energiaNegativaException();
    }

    public Nodo getI() {
        return i;
    }

    public void setI(Nodo i) {
        this.i = i;
    }

    public Nodo getJ() {
        return j;
    }

    public void setJ(Nodo j) {
        this.j = j;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void setExtremos(Nodo nodo_i, Nodo nodo_j, float e) {
        this.i = nodo_i;
        this.j = nodo_j;
        this.w = e;
    }

    @Override
    public boolean equals(Object obj) {
        Arco tmp = (Arco) obj;
        return tmp.getI().equals(this.getI()) && tmp.getJ().equals(this.getJ());
    }
}
