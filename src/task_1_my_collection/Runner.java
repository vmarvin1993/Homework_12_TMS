package task_1_my_collection;

/**
 * Представим, что в Java нет коллекции типа ArrayList.
 * Создать свой класс, симулирующий работу класса динамической коллекции - т.е. создать свою кастомную коллекцию.
 * В основе коллекции будет массив.
 * Кастомная коллекция должна хранить элементы разных классов(т.е. это generic).
 * Предусмотреть операции добавления элемента, удаления элемента, получение элемента по индексу, проверка есть ли элемент в коллекции, метод очистки все коллеции.
 * Предусмотреть конструктор без параметров - создает массив размером по умолчанию.
 * Предусмотреть конструктор с задаваемым размером внутреннего массива.
 * Предусамотреть возможность автоматического расширения коллекции при добавлении элемента в том случае, когда коллекция уже заполнена.
 */
public class Runner {

    public static void main(String[] args) {

        MyIMyCustomArray myArray = new MyIMyCustomArray();

        myArray.add("Test 1");
        myArray.add("Test 2");
        myArray.add("Test 3");
        myArray.add("Test 4");
        myArray.add("Test 5");
        myArray.add("Test 6");
        myArray.add("Test 7");
        myArray.add("Test 8");
        myArray.add("Test 9");
        myArray.add("Test 10");

        System.out.println(myArray.toString());
        System.out.println("before remove index: 2");
        // Remove element
        myArray.remove(2);
        System.out.println(myArray.toString());
        System.out.println("before remove all collection");
        //Remove collection
        myArray.removeCollection();

        System.out.println(myArray.toString());

    }
}
//[Test 1, Test 2, Test 3, Test 4, Test 5, Test 6, Test 7, Test 8, Test 9, Test 10, null]
//        before remove index: 2
//        [Test 1, Test 2, Test 4, Test 5, Test 6, Test 7, Test 8, Test 9, Test 10, null, null]
//        before remove all collection
//        [null, null, null, null, null, null, null, null, null, null]