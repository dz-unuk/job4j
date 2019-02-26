package ru.job4j.control;

/**
 * Класс банковского счета пользователя.
 * Содержит стандартные методы и метод перевода суммы.
 */
public class Account {

    private double value;
    private String requisites;

    public Account(double values, String requisites) {
        this.value = values;
        this.requisites = requisites;
    }
    public String getReqs() {
        return this.requisites;
    }
    /**
     * Метод осуществляет перевод указанной суммы с текущего счета
     * на счет, переданный в параметрах
     * @param destination счет-получатель
     * @param amount сумма перевода
     * @return успех
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount <= this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }
    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='" + requisites + '\''
                + '}';
    }
}