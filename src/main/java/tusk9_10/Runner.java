package tusk9_10;

import tusk9_10.entity.BookEntity;
import tusk9_10.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {

    private final BookService bookService;

    public Runner(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        BookEntity newBook = bookService.addNewBook("основы програмирования", "Столяров");

        UUID bookUuid = newBook.getID();

        System.out.println("Добавлена новая книга с ID: " + bookUuid);

        bookService.updateBook(bookUuid, "основы програмитрования_2", "Столяров");
        System.out.println("Заменили книгу");

       bookService.delBookById(bookUuid);
      System.out.println("Продали книгу");
    }
}