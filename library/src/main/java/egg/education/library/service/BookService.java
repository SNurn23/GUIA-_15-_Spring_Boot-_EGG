package egg.education.library.service;

import egg.education.library.entity.Book;
import egg.education.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void createBook(Book book){
        book.setDischarge(Boolean.TRUE);
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book){
        Book b = bookRepository.findById(book.getIsbn()).get();
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
    public Book getByIsbn(int isbn) {
        return bookRepository.findById(isbn).get();
    }

    @Transactional
    public void deleteByIsbn(int isbn){
        bookRepository.deleteById(isbn);
    }
}
