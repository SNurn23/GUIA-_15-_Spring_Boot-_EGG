package egg.education.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "isbn")
    private Integer isbn;

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "yearB")
    private int yearB;

    @Column(name = "copies")
    private int copies;

    @Column(name = "borrowed_Copies")
    private int borrowedCopies;

    @Column(name = "remaining_Copies")
    private int remainingCopies;

    @Column(name = "discharge", nullable = false)
    private boolean discharge;

    public Book(Integer isbn, String tittle, int yearB, int copies, int borrowedCopies, int remainingCopies, boolean discharge) {
        this.isbn = isbn;
        this.tittle = tittle;
        this.yearB = yearB;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.remainingCopies = remainingCopies;
        this.discharge = discharge;
    }

    public Book() {
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getYearB() {
        return yearB;
    }

    public void setYearB(int yearB) {
        this.yearB = yearB;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(int borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }

    public int getRemainingCopies() {
        return remainingCopies;
    }

    public void setRemainingCopies(int remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public boolean isDischarge() {
        return discharge;
    }

    public void setDischarge(boolean discharge) {
        this.discharge = discharge;
    }
}
