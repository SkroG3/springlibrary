package ru.skroznikov.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;

@Entity
@javax.persistence.Table(name = "vote", catalog = "library")
@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = "id")
@SelectBeforeUpdate
public class Vote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Integer value;

    @Column(name = "book_id")
    private Date bookId;

    private String username;

}
