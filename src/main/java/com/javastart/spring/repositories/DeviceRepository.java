package com.javastart.spring.repositories;

import com.javastart.spring.model.Device;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findByNameContainingIgnoreCase(String name);


    @Modifying
    @Transactional
    @Query("DELETE FROM Device d WHERE d.category.id = :id")
    void deleteAllDevicesByCategoryId(Long id);

}
