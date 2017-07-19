package ru.skroznikov.library.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skroznikov.library.domain.Author;

import java.util.List;


// должна стоять пометка о том, что это авторепозиторий
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    //даже если следующей строчки не будет, нам УЖЕ ДОСТУПНЫ ОСНОВНЫЕ CRUD операции с базой. Благодаря наследованию от Jpa Repository
    // Эта строка нужна нам для того, чтобы на основе метода создать автоматический hibernate-запрос и найти по полю fio (fio должно содержаться в тексте (Containing), игнорируя регистр (ignore case), сортируя результат по полю fio
    List<Author> findByFioContainingIgnoreCaseOrderByFio (String fio); //Правило наименования методов внутри репозиториев
}
