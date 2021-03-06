package pl.dmichalski.c12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.dmichalski.c12.entity.Employee;
import pl.dmichalski.c12.entity.Phone;
import pl.dmichalski.c12.repository.EmployeeRepository;
import pl.dmichalski.c12.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class Runner {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/spring-data.xml", "spring/spring-general.xml");

        EmployeeRepository employeeRepository =
                context.getBean("employeeRepository", EmployeeRepository.class);
        PhoneRepository phoneRepository =
                context.getBean("phoneRepository", PhoneRepository.class);

        Employee employee = new Employee();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        employee.setFirstName("Thom");
        employee.setLastName("Long");
        employee.setSalary(15000.0);

        phone1.setType("Mobile");
        phone1.setNumber("32 372 88 10");
        phone1.setEmployee(employee);
        phone2.setType("Home");
        phone2.setNumber("23 233 43 23");
        phone2.setEmployee(employee);

        List<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);
        employee.setPhones(phones);

        employeeRepository.save(employee);
        phoneRepository.save(phone1);
        phoneRepository.save(phone2);

    }

}
