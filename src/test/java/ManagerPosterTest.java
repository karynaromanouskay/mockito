import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.ManagerPoster;

public class ManagerPosterTest {


    @Test
    public void testAddZero() {
        ManagerPoster manager = new ManagerPoster();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOneMovie() {
        ManagerPoster manager = new ManagerPoster();

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddSeveralMovies() {
        ManagerPoster manager = new ManagerPoster();

        manager.addMovie("Бладшот");
        manager.addMovie("Отель Белград");
        manager.addMovie("Вперед");

        String[] expected = {"Бладшот", "Отель Белград", "Вперед"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllUnderLimit() {
        ManagerPoster manager = new ManagerPoster();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентельмены"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testShowLastBeforeSetLimit() {
        ManagerPoster manager = new ManagerPoster();

        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastBeforeManuallySetLimit() {
        ManagerPoster manager = new ManagerPoster(7);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testShowLastManuallySetLimit() {

        ManagerPoster manager = new ManagerPoster(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastManuallySetAfterLimit() {

        ManagerPoster manager = new ManagerPoster(4);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");

        String[] expected = {"Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastManuallySetOneAfterLimit() {

        ManagerPoster manager = new ManagerPoster(1);

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastManuallyZero() {

        ManagerPoster manager = new ManagerPoster(0);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAll() {
        ManagerPoster manager = new ManagerPoster();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");


        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентельмены", "Человек-невидимка", "Тролли. Мировой тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOnlyLastMoviesWithinLimit() {
        ManagerPoster manager = new ManagerPoster(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}