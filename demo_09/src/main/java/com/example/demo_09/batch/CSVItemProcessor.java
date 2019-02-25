package com.example.demo_09.batch;

import com.example.demo_09.bean.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * @Auther: zhangliang
 * @Date: 2019/1/18 16:16
 * @Description:
 */
public class CSVItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException {
        return super.process(item);
    }
}
