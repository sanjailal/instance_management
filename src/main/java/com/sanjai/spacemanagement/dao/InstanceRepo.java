package com.sanjai.spacemanagement.dao;

import com.sanjai.spacemanagement.models.Instance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface InstanceRepo extends JpaRepository<Instance,Integer> {
    @Query("SELECT p FROM Instance p WHERE p.name LIKE %?1%")
    public List<Instance> search(String keyword);

}
