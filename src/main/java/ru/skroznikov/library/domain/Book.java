package ru.skroznikov.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "book", catalog = "library")
@SelectBeforeUpdate
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@DynamicInsert
@DynamicUpdate
public class Book {

    public Book(){}

    public Book(Author author, Genre genre, Publisher publisher, Vote vote, String name, Integer pageCount, String isbn, Long genreId, Long authorId, Integer publishYear, Long publisherId, Integer avgRating, Long totalVoteCount, Long totalRating, Long viewCount, String descr) {
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.vote = vote;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genreId = genreId;
        this.authorId = authorId;
        this.publishYear = publishYear;
        this.publisherId = publisherId;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.totalRating = totalRating;
        this.viewCount = viewCount;
        this.descr = descr;
    }

    public Book(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    private Vote vote;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @Lob  // ленивая загрузка контента и много еще чего в JPA
    @Column(updatable = false)
    private byte[] content;

    @Column(name = "page_count")
    private Integer pageCount;

    private String isbn;

    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "publish_year")
    private Integer publishYear;

    @Column(name = "publisher_id")
    private Long publisherId;

    private byte[] image;

    @Column(name = "avg_rating")
    private Integer avgRating;

    @Column(name = "total_vote_count")
    private Long totalVoteCount;

    @Column(name = "total_rating")
    private Long totalRating;

    @Column(name = "view_count")
    private Long viewCount;

    private String descr;

    @Override
    public String toString(){return name;}
}
