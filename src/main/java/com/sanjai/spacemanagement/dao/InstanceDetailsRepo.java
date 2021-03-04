package com.sanjai.spacemanagement.dao;

import com.sanjai.spacemanagement.models.Instance;
import com.sanjai.spacemanagement.models.InstanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstanceDetailsRepo extends JpaRepository<InstanceDetails,Integer> {
    @Query("SELECT p FROM InstanceDetails p WHERE p.id=?1")
    public List<InstanceDetails> findById(int keyword);

    @Query("select p from InstanceDetails p where p.instance_id=?1")
    List<InstanceDetails> findAllByInstanceId(String id);

    @Query("select p  from InstanceDetails p group by p.instance_id order by p.instance_id")
    List<InstanceDetails> findByDistinctAscendingInstId();
}
