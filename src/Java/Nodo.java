package Java;

public class Nodo {
    private int id;
    private float g;

    public Nodo(int id, float g) {
        this.id = id;
        this.g = g;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    @Override
    public boolean equals(Object obj) {
        Nodo act = (Nodo) obj;
        return this.getId() == act.getId();
    }
}
