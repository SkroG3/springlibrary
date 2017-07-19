package ru.skroznikov.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity  //будем работать с базой данных через JPA
@Table(name="author", catalog = "library") //явно указываем, какую таблицу берем в каком каталоге. Благодаря этому, можем писать другое название класса - не совпадающее с названием таблицы
@EqualsAndHashCode(of = "id") //Автоматически дописывает метод EQUALS и HashCode - рутинные процессы автоматизируем с помощью lombok
@Getter @Setter // Ломбок также сам создает геттеры и сеттеры
@DynamicUpdate // Таблица может обновиться в одном значении без переделки всех полей
@DynamicInsert // В таблицу можно вставить значение без переделки всех полей (экономим время)
@SelectBeforeUpdate // сначала проверяем, нужно ли обновление, если поле имеет другое значение, то обновляем, если нет, то нет
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // выбираем тип генерации главного поля - инкрементный
    @Id //это главное поле
    private Long id;

    private String fio;

    private Date birthday;

    @Basic(fetch = FetchType.LAZY)  // Зачем нам при каждом авторе всегда подгружать все его книги? Ленивая (LAZY) подгрузка книг будет работать только при непосредственном обращении к author.books и будет возвращать List<Book> список книг
    @OneToMany(mappedBy = "author") // Один автор может написать много книг
    private List<Book> books;

    @Override
    public String toString() {return fio;} //Переписываем метод тустринг, чтобы он возвращал ФИО автора

}
