package ru.skroznikov.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre", catalog = "library")
@Setter @Getter
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = "id")
@SelectBeforeUpdate
public class Genre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;


    private String name;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "genre")
    private List<Book> books;



    @Override
    public String toString(){
        return name;
    }

}
