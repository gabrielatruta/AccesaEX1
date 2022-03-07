package com.example.mentoringv1ex2.Service;

import com.example.mentoringv1ex2.Repository.DeviceRepository;
import com.example.mentoringv1ex2.Repository.SensorRepository;
import com.example.mentoringv1ex2.Repository.UserRepository;
import com.example.mentoringv1ex2.dto.SensorDTO;
import com.example.mentoringv1ex2.mapper.SensorMapper;
import com.example.mentoringv1ex2.model.Device;
import com.example.mentoringv1ex2.model.Sensor;
import com.example.mentoringv1ex2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    public Sensor findByID(Long ID) {
        return sensorRepository.findById(ID)
                .orElseThrow(()-> new EntityNotFoundException("Sensor with ID = " + ID + " not found!"));
    }

    public List<SensorDTO> findSensorByUser(Long userID) {

        User user = userRepository.findById(userID)
                .orElseThrow(() -> new EntityNotFoundException("User with ID = " + userID + " not found!"));

        List<Device> devicesFromUser = deviceRepository.findDevicesByUser(user);

        if (devicesFromUser.isEmpty())
            return null;
        else {
            List<Sensor> sensorsFromDevices = new ArrayList<>();
            for (Sensor sensor: sensorRepository.findAll()) {
                for (Device device: devicesFromUser) {
                    if (device.getId().equals(sensor.getDevice().getId()))
                        sensorsFromDevices.add(sensor);
                }
            }
            return sensorsFromDevices.stream()
                    .map(sensorMapper::toDTO)
                    .collect(Collectors.toList());
        }
    }

    public List<SensorDTO> findAll() {
        return sensorRepository.findAll().stream()
                .map(sensorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SensorDTO create(SensorDTO sensorDTO) {
        Device device = deviceRepository.findById(sensorDTO.getDevice())
            .orElseThrow(()-> new EntityNotFoundException("Device with ID = " + sensorDTO.getDevice() + " not found!"));

        for (Sensor sensor: sensorRepository.findAll()) {
            if (sensor.getDevice().getId().equals(device.getId()))
                throw new EntityExistsException("There is already a sensor assigned to that device!");
        }

        return sensorMapper.toDTO(sensorRepository.save(sensorMapper.fromDTO(sensorDTO)));
    }

    public SensorDTO edit(Long id, SensorDTO sensorDTO) {
        Sensor actSensor = findByID(id);
        Device device = deviceRepository.findById(sensorDTO.getDevice())
                .orElseThrow(() -> new EntityNotFoundException("Device with id = " + sensorDTO.getDevice() + " doesn't exist!"));

        for (Sensor sensor: sensorRepository.findAll()) {
            if (sensor.getDevice().getId().equals(device.getId()) && !sensor.getId().equals(id))
                throw new EntityExistsException("There is already a sensor assigned to that device!");
        }

        actSensor.setDescription(sensorDTO.getDescription());
        actSensor.setMaxValue(sensorDTO.getMaxValue());
        actSensor.setDevice(device);

        return sensorMapper.toDTO(sensorRepository.save(actSensor));
    }

    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

}
