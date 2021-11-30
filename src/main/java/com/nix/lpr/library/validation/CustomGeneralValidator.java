package com.nix.lpr.library.validation;

import com.nix.lpr.library.entity.Author;
import java.util.Set;
import javax.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("customValidator")
@AllArgsConstructor
public class CustomGeneralValidator implements Validator {

    private javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // java validation
        Set<ConstraintViolation<Object>> verifications = validator.validate(o);

        for (ConstraintViolation<Object> constraintViolation : verifications) {
            String propertyName = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();

            errors.rejectValue(propertyName,  message);
        }

        // Spring validation
        Author author = new Author();
        if (author.getNickName() == null || author.getNickName().isEmpty()) {
            errors.reject("nickName", "The nickName should contain value");
        }
    }
}
