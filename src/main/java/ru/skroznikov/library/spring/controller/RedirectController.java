package ru.skroznikov.library.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.skroznikov.library.domain.Author;
import ru.skroznikov.library.spring.repository.AuthorRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller //это контроллер - то есть обработчик запросов, пока что он отвечает за первую обработку запросов
@Log //аннотация lambok, которая создает переменную log и позволяет к ней обращаться напрямую
public class RedirectController {

    @Autowired //реализация этого метода будет автоматически внедрена в authorRepository
    private AuthorRepository authorRepository;

    //При запуске проекта первый запрос попадает сюда
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse){

        List<Author> authorList = authorRepository.findAll();
        log.info("hellon");
        return "ok";
    }

}
