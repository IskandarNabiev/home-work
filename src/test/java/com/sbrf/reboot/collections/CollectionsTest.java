package com.sbrf.reboot.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     */

    //Вопрос: Что произойдет в ArrayList, если мы в существующий массив на 0 позицию будем добавлять элементы?
    //Ответ: Если мы будем ставить элементы на 0 позиции, то все последующие эелементы будут передвигаться
    //на одну позицию, а наш элемент будет первым в массиве.

    @Test
    public void addStudentToRating() {

        List<String> students = new ArrayList<>();
        students.add("Иванов");
        students.add("Петров");
        students.add("Сидоров");
        students.add(0,"Козлов");

        assertEquals(4, students.size());
        assertEquals(students.get(0), "Козлов");
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Random random = new Random();
        Set<Integer> moneyBox = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            moneyBox.add(random.nextInt(100));
        }

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }

        List<Book> bookshelf = new ArrayList<>();
        bookshelf.add(new Book());
        bookshelf.add(new Book());
        bookshelf.add(new Book());

        assertEquals(3, bookshelf.size());
    }


}
