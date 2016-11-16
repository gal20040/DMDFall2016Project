package ru.hotelinno.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.hotelinno.domain.WishfulRoomData;

@Component
public class SearchDataValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
//        return B ook.class.isAssignableFrom(aClass);
        return WishfulRoomData.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is required.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "required.genre", "Genre is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cityName", "required.cityName", "City is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomType", "required.roomType", "Room type is required.");
        //TODO сделать валидацию на отсутствие "точки с запятой"
    }
}