package com.javastart.spring.devicerent4.components.device;

import com.javastart.spring.devicerent4.components.device.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends CrudRepository<Device,Long> {
    List<Device> findAllByNameContainingIgnoreCase(String name);
}
