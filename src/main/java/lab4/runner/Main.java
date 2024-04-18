package lab4.runner;

import lab4.entity.Group;
import lab4.entity.Speciality;
import lab4.entity.Student;
import lab4.service.GroupService;
import lab4.service.SpecialityService;
import lab4.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories("lab4.repository")
@ComponentScan("lab4.service")
@EntityScan("lab4.entity")
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        GroupService groupService = ctx.getBean(GroupService.class);
        StudentService studentService = ctx.getBean(StudentService.class);
        SpecialityService specialityService = ctx.getBean(SpecialityService.class);

        Speciality speciality = new Speciality();
        speciality.setName("new speciality");
        speciality.setCode("1");
        specialityService.save(speciality);

        System.out.println(specialityService.read());

        Long id = 1L;
        Group gr = new Group();
        gr.setId(id);
        gr.setSpeciality(specialityService.read(1L));
        gr.setGrName("New Group Name");
        groupService.save(gr);
        Student student = new Student();
        student.setName("name");
        student.setGroup(gr);
        studentService.save(student);

        Group group = new Group();
        group.setGrName("Some Group");
        group.setSpeciality(speciality);
        groupService.save(group);

        Student student1 = new Student();
        student1.setId(id);
        student1.setName("New name");
        student1.setSurname("novalocal");
        student1.setPhoneNumber("111111");
        student1.setGroup(gr);
        studentService.edit(student1);

        List<Group> groups = groupService.read();
        groups.forEach(System.out::println);

        Group group1 = groupService.read(1L);
        group1.setGrName("New Group Name");
        groupService.edit(group1);

        groupService.delete(2L);

        Group grp = groupService.findByName("S");
        System.out.println(grp);

        studentService.delete(17L);

        speciality.setGroups(Set.of(gr));

        System.out.println(specialityService.read());

        specialityService.delete(1L);

        System.out.println(specialityService.read());

        ctx.close();
    }

}
