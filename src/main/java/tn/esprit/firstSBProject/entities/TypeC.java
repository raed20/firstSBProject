package tn.esprit.firstSBProject.entities;

public enum TypeC {
    SINGLE(1),
    DOUBLE(2),
    SUITE(3);

    private final int capacite;

    TypeC(int capacite) {
        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }
}
