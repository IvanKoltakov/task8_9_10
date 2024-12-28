package tusk9_10.service;

import tusk9_10.entity.BookEntity;
import tusk9_10.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public BookEntity updateBook(UUID ID, String title, String avtor){
        Optional<BookEntity> bookOpt = bookRepository.findById(ID);

        BookEntity book = bookOpt.orElse(null);

        book.setTitle(title);
        book.setAvtor(avtor);

        return bookRepository.save(book);
    }

    @Transactional
    public BookEntity addNewBook(String title, String avtor){
        BookEntity book = new BookEntity();
        book.setID(UUID.randomUUID());
        book.setTitle(title);
        book.setAvtor(avtor);

        return bookRepository.save(book);
    }

    @Transactional
    public void delBookById(UUID ID){
        bookRepository.deleteById(ID);
    }

}
