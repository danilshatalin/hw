import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DataFormatParseException extends Exception {
    public DataFormatParseException(String message) {
        super(message);
    }
}

public class PersonalDataProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные в произвольном порядке (фамилия, имя, отчество, дата рождения,номер телефона, пол): ");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: неверное количество данных!");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            validateDataFormats(surname, name, patronymic, birthDate, phoneNumber, gender);
            String output = surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
            writeToFile(surname, output);
            System.out.println("Данные успешно записаны в файл " + surname + ".txt");
        } catch (DataFormatParseException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void validateDataFormats(String surname, String name, String patronymic, String birthDate,
                                            String phoneNumber, String gender) throws DataFormatParseException {
        // Проверка форматов данных с использованием регулярных выражений
        if (!surname.matches("[A-Za-zА-Яа-я]+") ||
                !name.matches("[A-Za-zА-Яа-я]+") ||
                !patronymic.matches("[A-Za-zА-Яа-я]+") ||
                !birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}") ||
                !phoneNumber.matches("\\d+") ||
                !(gender.equals("f") || gender.equals("m"))) {
            throw new DataFormatParseException("Неверный формат данных!");
        }
    }

    private static void writeToFile(String fileName, String data) throws IOException {
        try (FileWriter writer = new FileWriter(fileName + ".txt", true)) {
            writer.write(data + System.lineSeparator());
        }
    }
}
