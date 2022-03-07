package com.example.mentoringv1ex2.Repository;

import com.example.mentoringv1ex2.model.Device;
import com.example.mentoringv1ex2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Override
    Optional<Device> findById(Long aLong);

    List<Device> findDevicesByUser(User user);

}
