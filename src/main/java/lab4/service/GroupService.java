package lab4.service;

import lab4.entity.Group;

public interface GroupService extends Service<Group> {

    Group findByName(String name);

}
