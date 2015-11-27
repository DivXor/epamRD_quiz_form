//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package kz.epam.quiz.controller.form.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import kz.epam.quiz.controller.form.validation.FieldMatch;
import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstField;
    private String secondField;

    public FieldMatchValidator() {
    }

    public void initialize(FieldMatch fieldMatch) {
        this.firstField = fieldMatch.first();
        this.secondField = fieldMatch.second();
    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            String e = BeanUtils.getProperty(o, this.firstField);
            String secondObj = BeanUtils.getProperty(o, this.secondField);
            return e == null && secondObj == null || e != null && e.equals(secondObj);
        } catch (Exception var5) {
            var5.printStackTrace();
            return true;
        }
    }
}
