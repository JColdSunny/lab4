package lab4.service;

import lab4.entity.Student;

import java.util.List;

public interface StudentService extends Service<Student> {

    List<Student> readByGroupId(Long groupId);

    List<Student> readBySurname(String surname);

}
