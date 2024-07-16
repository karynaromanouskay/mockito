import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.ManagerPoster;

public class ManagerPosterTest {
    @Test
    public void shouldShowAll() {
        ManagerPoster manager = new ManagerPoster();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентельмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли. Мировой тур");
        manager.addNewMovie("Номер один");


        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентельмены", "Человек-невидимка", "Тролли. Мировой тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastBeforeManuallySetLimit() {
        ManagerPoster manager = new ManagerPoster(7);

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентельмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли. Мировой тур");
        manager.addNewMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastBeforeCurrentLimit() {
        ManagerPoster manager = new ManagerPoster();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентельмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли. Мировой тур");
        manager.addNewMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}