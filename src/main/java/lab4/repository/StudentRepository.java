package lab4.repository;

import lab4.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGroupId(Long groupId);

    List<Student> findBySurname(String surname);

}
