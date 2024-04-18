package lab4.service.impl;

import lab4.entity.Speciality;
import lab4.repository.SpecialityRepository;
import lab4.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Speciality read(Long id) {
        return specialityRepository.findById(id).get();
    }

    @Override
    public List<Speciality> read() {
        return specialityRepository.findAll();
    }

    @Override
    public void save(Speciality entity) {
        specialityRepository.save(entity);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void edit(Speciality entity) {

    }
}
