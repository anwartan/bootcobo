package com.cobo.bootcobo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.cobo.bootcobo.entity.RoleMenu;
public interface MenuRepo extends MongoRepository<RoleMenu, String> {
//    public List<RoleMenu> findAllByOrderByCreateDateDesc(Pageable pageable);

    public List<RoleMenu> findAll();
    public List<RoleMenu> findByIsParentAndIsSystem(Integer isParent,Integer isSystem);
    public List<RoleMenu> findByParentId(Integer parentId);
    
    public List<RoleMenu> findByParentIdAndIsParent(Integer parentId,Integer isParent);
}
