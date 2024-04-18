package lab4.service.impl;

import lab4.entity.Group;
import lab4.entity.Student;
import lab4.repository.GroupRepository;
import lab4.repository.StudentRepository;
import lab4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Student> readByGroupId(Long groupId) {
        return studentRepository.findByGroupId(groupId);
    }

    @Override
    public List<Student> readBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }

    @Override
    public Student read(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> read() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student entity) {
        Group group = entity.getGroup();
        Long id = group.getId();
        group = groupRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        entity.setGroup(group);
        group.getStudents().add(entity);
        groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void edit(Student entity) {
        Group group = entity.getGroup();
        Long groupId = group.getId();
        Long studentId = entity.getId();
        group = groupRepository.findById(groupId).orElseThrow(IllegalArgumentException::new);
        Student student = group.getStudents().stream()
                .filter(s -> studentId.equals(s.getId()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        student.setGroup(group);
        student.setName(entity.getName());
        student.setSurname(entity.getSurname());
        student.setPhoneNumber(entity.getPhoneNumber());
        group.getStudents().add(student);
        studentRepository.save(student);
    }

}
