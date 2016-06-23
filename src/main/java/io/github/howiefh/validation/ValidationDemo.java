package io.github.howiefh.validation;

import io.github.howiefh.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author fenghao on 2016/5/23
 * @version 1.0
 * @since 1.0
 */
public class ValidationDemo {
    @Resource(name="beanValidator")
    private Validator validator;
    @Autowired
    private MessageSource messageSource;

    public static void main(String[] args) throws Exception {
        ValidationDemo demo = new ValidationDemo();
        demo.testMessageSource();
        demo.testValidate();
    }
    public void testValidate() throws Exception {
        User user = new User();
        validate(user);

        user.setUsername("name");
        System.out.println(validate(user));
    }

    public void testMessageSource(){
        String arg = messageSource.getMessage("user.userName", null, null);
        String message = messageSource.getMessage("errors.required",
                new Object [] {arg}, "Required", null);
        System.out.println(message);
    }

    public boolean validate(Object target) throws Exception {
        AbstractBindingResult result = new BeanPropertyBindingResult(target, target.getClass().getName());
        validator.validate(target, result);
        if (result.hasErrors()){
            throw new Exception(getMessage(result.getFieldError()));
        }
        return true;
    }
    public String getMessage(MessageSourceResolvable messageSourceResolvable){
        return getMessage(messageSourceResolvable, null);
    }
    public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale){
        return messageSource.getMessage(messageSourceResolvable, locale);
    }
}
