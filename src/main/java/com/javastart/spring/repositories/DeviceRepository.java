package com.javastart.spring.repositories;

import com.javastart.spring.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findByNameContainingIgnoreCase(String name);

}
