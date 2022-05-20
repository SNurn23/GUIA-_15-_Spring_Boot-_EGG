package egg.education.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book", indexes = {@Index(name = "idx_book_tittle", columnList = "tittle")})
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //@NotBlank(message = "Isbn is required")
    //@Pattern(regexp = "^(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$", message = "The isbn format is incorrect")
    @Column(name = "isbn", nullable = false)
    private String isbn;

    //@NotBlank(message = "Tittle is required")
    @Column(name = "tittle", nullable = false)
    private String tittle;

    //@NotNull(message = "Year is required")
    @Column(name = "yearB", columnDefinition = "YEAR", nullable = false)
    private Integer yearB;

   // @NotNull(message = "Copies is required")
    @Column(name = "copies", nullable = false)
    private Integer copies;

   // @NotNull(message = "Borrowed Copies is required")
    @Column(name = "borrowed_Copies", nullable = false)
    private Integer borrowedCopies;

  //  @NotNull(message = "Remaining Copies is required")
    @Column(name = "remaining_Copies", nullable = false)
    private Integer remainingCopies;

    @Column(name = "discharge", nullable = false)
    private boolean discharge;
}
