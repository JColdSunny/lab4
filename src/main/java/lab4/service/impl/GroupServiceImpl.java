package lab4.service.impl;

import lab4.entity.Group;
import lab4.entity.Speciality;
import lab4.repository.GroupRepository;
import lab4.repository.SpecialityRepository;
import lab4.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Group findByName(String name) {
        return groupRepository.findByGrName(name);
    }

    @Override
    public Group read(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public List<Group> read() {
        return groupRepository.findAll();
    }

    @Override
    public void save(Group entity) {
        Speciality speciality = entity.getSpeciality();
        Long id = speciality.getId();
        speciality = specialityRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        entity.setSpeciality(speciality);
        speciality.getGroups().add(entity);
        specialityRepository.save(speciality);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void edit(Group entity) {
        groupRepository.save(entity);
    }

}
