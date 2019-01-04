package ru.job4j.uml;

public class Doc extends Profession {
    public void treat(Patient patient){};
    public Diagnose heal(Patient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
