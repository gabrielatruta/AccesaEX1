package com.example.mentoringv1ex2.Repository;

import com.example.mentoringv1ex2.model.Device;
import com.example.mentoringv1ex2.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Override
    Optional<Sensor> findById(Long aLong);

    Sensor findSensorsByDevice(Device device);

}
