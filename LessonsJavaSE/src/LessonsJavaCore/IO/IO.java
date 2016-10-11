package LessonsJavaCore.IO;

import java.io.*;
import java.util.*;

/**
 * Когда используются символьные, а когда байтовые потоки ввода/вывода:
 *
 * По сети вы можете передавать только байты и ничего кроме байтов. Вы не можете передать символы абстрактно.
 * Они должны быть кодированы в байты для передачи по сети или записи в файл.
 *
 * В последствии они должны быть прочитаны как байты и перекодированы обратно в символы.
 *
 * До тех пор пока таблица кодировки используемая при превращеии в байты совпадает с той что используется получателем
 * (или читателем файла) всё действительно будет "так же читабельно". Например если вы с виндового компьютера на
 * виндовый передаёте, в java-машине кодировка по умолчанию в 90% случаев будет одинаковая, поэтому проблемы вы
 * не заметите. Но вполне возможно что вам позвонит гневный пользователь и скажет "а у меня на macbook ваш гуанософт
 * ни хрена не работает, это безобразие" и т.п.
 *
 * Т.е. если вы планируете что-то сохранять в файлы или передавать по сети, нужно обязательно с самого начала решить
 * какую кодировку вы будете использовать. Собственно utf-8 лучше большинства прочих распространённых тем что позволяет
 * кодировать практически любой юникодовый символ в то время как виндовые кодировки имеют таблицу лишь из 256 символов
 * и обычно привязаны к конкретному языку (русскому, европейскому) а с китайским они вообще не совладают. Правда если
 * текст целиком из не английских символов сообщение в utf-8 конечно длиннее раза в два.
 *
 * (а вообще если передавать большой текст то может оказаться удобным вообще его сжать в zip - благо в java для
 * этого есть API - и передавать уже сжатый)
 *
 * * * * * * * * * * * * * * * * * * * * * *
 *
 * Классы, производные от базовых классов InputStream или Reader, имеют методы с именами read() для чтения отдельных
 * байтов или массива байтов (отвечают за ввод данных). Классы, производные от классов OutputStream или Write, имеют
 * методы с именами write() для записи одиночных байтов или массива байтов (отвечают за вывод данных).
 */

public class IO {

    private File file;

    public IO(File file) {
        this.file = file;
    }

    /**
     * Запись в файл
     */
    public void writer() throws IOException {
        // Инициализируем класс для записи и вносим в параметры класса экземпляр файла
        FileWriter writer = new FileWriter(file);

        // Внести символы можно с помощью метода append(). Этот метод перегружен тремя вариантами:

        // 1. Вносим символы, какие хотим записать в файл.
//            writer.append("e");

        // Этот класс очень похож на строку, но он работает как массив символов.
        CharSequence chars = "Hello World!!!";

        // 2. Принимает CharSequence
//            writer.append(chars);

        // 3. Принимает CharSequence, и еще два параметра какие принимают начало строки и конец,
        // какие нужно записать. В примере ниже будет записано слово Hello
        writer.append(chars, 0, 5);

        // Запись в файл происходит после вызова метода flush()
        writer.flush(); // Используется если работаем с буферизацией

        // После окончания работы закрываем поток записи в файл
        writer.close();
    }

    /**
     * Чтение из файла (Символьный поток)
     */
    public void reader() throws IOException {
        // Инициализируем класс для чтения с файла
        FileReader reader = new FileReader(file);

        // Данный класс буферизирует всё что мы хотим считать с файла
        BufferedReader bufferedReader = new BufferedReader(reader);

        // В данную переменную будет записано всё что считает с файла
        String line;

        // Для чтения с файла есть специальный метод в классе BufferedReader, под названием readLine()
        // Соответственно, чтобы считать с файла все строки, нужно воспользоваться циклом.

        // Проходим по каждой строчке в файле, записываем в переменную line и выводим,
        // до тех пор пока файл не закончится
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // После окончания работы нужно закрыть поток
        reader.close();
        bufferedReader.close();
    }

    /**
     * Получаем все слова из файла в виде массива строк (Символьный поток)
     */
    public void readerSplit() throws IOException {
        FileReader reader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        List<String> list = new ArrayList<>();
        // Записываем в line все символы с n строки файла, и если это не конец файла то двигаемся дальше
        while ((line = bufferedReader.readLine()) != null) {
            // Пробел будет считаться разделителем для символов.
            // С помощью него символы распределяются на элементы массива.
            String[] strings = line.split(" ");

            Collections.addAll(list, strings); // Добавляем весь массив strings в коллекцию лист
        }

        // Выводим весь список в одну строку
        for (String string : list) {
            System.out.print(string + " ");
        }

        reader.close();
        bufferedReader.close();
    }

    /**
     * Запись в файл (Байтовый поток)
     */
    public void output() throws IOException {
        OutputStream output = new FileOutputStream(file);

        output.write(5); // Информация, какая пойдет в файл
        output.flush(); // Запись

        output.close();
    }

    /**
     * Чтение с файла (Байтовый поток)
     */
    public void input() throws IOException {
        InputStream input = new FileInputStream(file);

        int num = input.read();

        System.out.println("Num: " + num);

        input.close();
    }

    public static void filter(InputStream input, OutputStream output, int buffSize) throws IOException {
        final int ZERO_STATE = 1;
        final int NUMBERS_STATE = 0;
        byte[] buffer = new byte[buffSize];
        int count;
        while ((count = input.read(buffer)) != -1) {
            int state = ZERO_STATE;
            int start = 0, end = 0;
            for (int index = 0; index < count; index++) {
                switch (state) {
                    case ZERO_STATE:
                        if (buffer[index] == 1) {
                            start = index; end = index;
                            state = NUMBERS_STATE;
                        }
                        break;
                    case NUMBERS_STATE:
                        if (buffer[index] == 0) {
                            output.write(buffer, start, end);
                            start = 0; end = 0;
                            state = ZERO_STATE;
                        } else {
                            end = index;
                        }
                        break;
                }
            }
            if (state == NUMBERS_STATE)
                output.write(buffer, start, end);
        }
        output.flush();
    }

    public static void main(String[] args) {
        try {
//            // Инициализируем класс и вводим путь к файлу.
//            // Если написать только имя файла, то файл будет создан в корневой папке проекта.
//            IO io = new IO(new File("D://Downloads/Удали меня.txt"));
//
//            /**
//             * Символьные потоки ввода/вывода
//             */
////            FileWriter - записывает в файл
////            FileReader - читает с файла
//
////            io.writer();
////            io.reader();
//            io.readerSplit();
//
//            /**
//             * Байтовые потоки ввода/вывода
//             */
////            OutputStream - записывает в файл
////            InputStream - читает с файла
//
//            IO io1 = new IO(new File("D://Downloads/Удали меня2.txt"));
//
//            io1.output();
//
//            io1.input();

            /**
             * Фильтрация данных в байтовом потоке. Происходит запись только единиц.
             */

            final int BUFFER_LENGTH = 4;
            final byte[] buffer = {0, 1, 1, 0, 0, 1, 1, 1};
            final byte[] filteredBuffer = new byte[buffer.length];

            InputStream input = new ByteArrayInputStream(buffer);
            OutputStream outputByte = new ByteArrayOutputStream(buffer.length);
            OutputStream outputFile = new FileOutputStream(new File("D://Downloads/Удали меня3.txt"));

            IO.filter(input, outputByte, BUFFER_LENGTH);

            input.close();
            outputByte.close();
            outputFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
