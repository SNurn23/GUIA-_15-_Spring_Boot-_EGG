package egg.education.library.service;

import egg.education.library.entity.Book;
import egg.education.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void createBook(Book book){
        book.setDischarge(Boolean.TRUE);
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book){
        Book b = bookRepository.findById(book.getId()).get();
        b.setTittle(book.getTittle());
        b.setYearB(book.getYearB());
        b.setCopies(book.getCopies());
        b.setBorrowedCopies(book.getBorrowedCopies());
        b.setRemainingCopies(book.getRemainingCopies());
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getById(int id) {
        return bookRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }
}
