package assignment1.dto.mapper;

import assignment1.dto.DoctorDto;
import assignment1.entities.Doctor;

public class DoctorMapper {

    public static Doctor convertToEntity(DoctorDto caregiverDto) {
        return new Doctor(
                caregiverDto.getId(),
                caregiverDto.getUsername(),
                caregiverDto.getGender(),
                caregiverDto.getAddress(),
                caregiverDto.getName(),
                caregiverDto.getBirthDate()
        );
    }

    public static DoctorDto convertToDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getUsername(),
                doctor.getGender(),
                doctor.getAddress(),
                doctor.getName(),
                doctor.getBirthDate(),
                doctor.getRole()
        );
    }
}
