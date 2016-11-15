package ru.hotelinno.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.hotelinno.domain.Book;

@Component
public class SearchDataValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.isAssignableFrom(aClass); //TODO book
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "required.genre", "Genre is required.");
        //TODO сделать валидацию на отсутствие "точки с запятой"
    }
}