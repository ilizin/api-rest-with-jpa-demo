package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao.MotorcycleRepository;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyTypeMotorcycle;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Motorcycle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleService implements IMotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @Override
    public List<MotorcycleOutDto> findAll() {
        List<Motorcycle> cars = motorcycleRepository.findAll();
        return cars
                .stream()
                .map(this::mapMotorcycleToMotorcycleOutDto)
                .toList();
    }

    @Override
    public MotorcycleOutDto findById(int id) {
        Optional<Motorcycle> motorcycle = motorcycleRepository.findById(id);
        if (motorcycle.isEmpty()) {
            return null;
        }
        return mapMotorcycleToMotorcycleOutDto(motorcycle.get());
    }

    @Transactional
    @Override
    public MotorcycleOutDto save(MotorcycleInDto motorcycleInDto) {
        Motorcycle motorcycle = mapMotorcycleInDtoToMotorcycle(motorcycleInDto);
        Motorcycle savedMotorcycle = motorcycleRepository.save(motorcycle);
        return mapMotorcycleToMotorcycleOutDto(savedMotorcycle);
    }

    @Override
    public MotorcycleOutDto update(MotorcycleInDto motorcycleInDto, int motorcycleId) {
        Motorcycle motorcycle = mapMotorcycleInDtoToMotorcycle(motorcycleInDto);
        motorcycle.setId(motorcycleId);
        Motorcycle savedMotorcycle = motorcycleRepository.save(motorcycle);
        return mapMotorcycleToMotorcycleOutDto(savedMotorcycle);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        motorcycleRepository.deleteById(id);
    }

    private MotorcycleOutDto mapMotorcycleToMotorcycleOutDto(Motorcycle motorcycle) {
        MotorcycleOutDto motorcycleOutDto = new MotorcycleOutDto();
        motorcycleOutDto.setId(motorcycle.getId());
        motorcycleOutDto.setMake(motorcycle.getMake());
        motorcycleOutDto.setBodyType(BodyTypeMotorcycle.valueOf(motorcycle.getBodyType()));
        motorcycleOutDto.setMileage(motorcycle.getMileage());
        motorcycleOutDto.setFuelType(FuelType.valueOf(motorcycle.getFuelType()));
        motorcycleOutDto.setFirstRegistrationFrom(motorcycle.getFirstRegistrationFrom());
        motorcycleOutDto.setGearBox(GearBox.valueOf(motorcycle.getGearBox()));
        motorcycleOutDto.setModel(motorcycle.getModel());
        motorcycleOutDto.setPower(motorcycle.getPower());
        motorcycleOutDto.setPrice(motorcycle.getPrice());
        return motorcycleOutDto;
    }

    private Motorcycle mapMotorcycleInDtoToMotorcycle(MotorcycleInDto motorcycleInDto) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setMake(motorcycleInDto.getMake());
        motorcycle.setBodyTypeMotorcycle(motorcycleInDto.getBodyType().toString());
        motorcycle.setMileage(motorcycleInDto.getMileage());
        motorcycle.setFuelType(motorcycleInDto.getFuelType().toString());
        motorcycle.setFirstRegistrationFrom(motorcycleInDto.getFirstRegistrationFrom());
        motorcycle.setGearBox(motorcycleInDto.getGearBox().toString());
        motorcycle.setModel(motorcycleInDto.getModel());
        motorcycle.setPower(motorcycleInDto.getPower());
        motorcycle.setPrice(motorcycleInDto.getPrice());
        return motorcycle;
    }
}
