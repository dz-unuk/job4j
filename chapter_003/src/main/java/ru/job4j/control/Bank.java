package ru.job4j.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 *Класс содержит отображение с ключами в виде пользователей и значениями в виде
 * списка принадлежащих данному пользователю счетов. А также методы для работы
 * с этим отображением.
 * @author Denis
 * @since 25.02.19
 */
public class Bank {
    /**
     *отображение с ключами в виде пользователей и значениями в виде
     * списка принадлежащих данному пользователю счетов.
     */
    private Map<User, List<Account>> userMap = new HashMap<>();
    /**
     * добавление нового пользователя. если такой пользователь есть, отображение не изменится
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        this.userMap.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * удаление данного пользователя
     * @param user пользователь для удаления
     */
    public void deleteUser(User user) {
        this.userMap.remove(user);
    }
    /**
     * Добавление нового счета пользователю. Пользователь задается по паспорту.
     * @param passport номер паспорта
     * @param account счет для добавления
     */
    public void addAccountToUser(String passport, Account account) {
        getUserAccounts(passport).add(account);
    }
    /**
     *  Удаление нового счета пользователю. Пользователь задается по паспорту.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);
    }
    /**
     * Закрытый метод для получения списка счетов пользователя, который задается по паспорту.
     * Сделал метод закрытым, т.к. он используется как вспомогательный в классе
     * и передает ссылку на закрытые поля класса
     * @param passport номер паспорта
     * @return список всех счетов пользователя
     */
    private List<Account> getUserAccounts(String passport) {
        List<Account> accounts = null;
        for (Map.Entry<User, List<Account>> e : this.userMap.entrySet()) {
            if (e.getKey().getPassport().equals(passport)) {
                accounts = e.getValue();
            }
        }
        return accounts;
    }
    /**
     * Закрытый метод. Возвращает заданный счет заданного пользователя. Счет задается
     * по полю requisites, а пользователь по паспорту.
     * @param passport номер паспорта
     * @param requisites реквизиты счета
     * @return заданный счет заданного пользователя
     */
    private Account getActualAccount(String passport, String requisites) {
        List<Account> list = getUserAccounts(passport);
        Account account = null;
        for (int i = 0; i < list.size(); i++) {
            if (requisites.equals(list.get(i).getReqs())) {
                account = list.get(i);
            }
        }
        return account;
    }
    /**
     * Открытый метод перевода заданной суммы с заданного счета на другой заданный счет.
     * Счета могут совпадать.
     * @param srcPassport паспорт пользователя счета, у которого снимаются деньги
     * @param srcRequisite реквизиты счета, с которого снимаются деньги
     * @param destPassport паспорт получателя денег
     * @param dstRequisite счет-получатель
     * @param amount сумма перевода
     * @return прошла ли операция.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        Account srcAccount = getActualAccount(srcPassport, srcRequisite);
        Account dstAccount = getActualAccount(destPassport, dstRequisite);
        return (srcAccount != null) && (dstAccount != null)
                && srcAccount.transfer(dstAccount, amount);
    }
    public String getUserAccToStr(String passport) {
        return getUserAccounts(passport).toString();
    }
    @Override
    public String toString() {
        return "Bank{"
                + "userMap=" + userMap
                + '}';
    }
}