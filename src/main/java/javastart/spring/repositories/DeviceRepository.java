package javastart.spring.repositories;

import javastart.spring.entities.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device,Long> {
}
