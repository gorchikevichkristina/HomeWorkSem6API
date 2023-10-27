import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем контакты и телефоны
        addContact(phoneBook, "Иван", "1234567890");
        addContact(phoneBook, "Мария", "9876543210");
        addContact(phoneBook, "Иван", "5555555555"); // Добавляем второй номер для Ивана

        // Сортируем телефоны по убыванию числа телефонов
        phoneBook.values().forEach(Collections::sort);
        phoneBook.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry -> {
                    String name = entry.getKey();
                    List<String> phones = entry.getValue();
                    System.out.println(name + ": " + phones);
                });
    }

    // Метод для добавления контакта и номера в телефонную книгу
    public static void addContact(Map<String, List<String>> phoneBook, String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }
}