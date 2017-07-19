package ru.skroznikov.library.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skroznikov.library.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {


}
