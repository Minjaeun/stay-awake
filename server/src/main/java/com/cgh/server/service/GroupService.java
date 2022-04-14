package com.cgh.server.service;

import com.cgh.server.domain.Group;
import com.cgh.server.domain.Member;
import com.cgh.server.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findGroupByMember(Member member){
        return groupRepository.findByMember(member);
    }

    public void save(Group group) {
        groupRepository.save(group);
    }
}
