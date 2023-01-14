package com.example.study;

import com.example.study.user.UserServiceImpl;
import com.example.study.user.dto.UserCreateDto;
import com.example.study.user.dto.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudyApplication.class, args);

		testSomeJpa(context);
	}

	public static void testSomeJpa(ApplicationContext context) {
		UserServiceImpl service = context.getBean(UserServiceImpl.class);

		for (int i = 1; i <= 5; i++) {
			UserCreateDto userCreateDto = new UserCreateDto();
			userCreateDto.setFirstName("FirstName_" + i);
			userCreateDto.setLastName("LastName_" + i);
			userCreateDto.setBirthday(LocalDate.of(1960 + i, 1, 5));

			service.create(userCreateDto);
		}

		UserDto userDto = new UserDto(1L,
				"vasa",
				"ivanov",
				LocalDate.of(2000,1,1),
				LocalDate.of(2022, 1, 1));

		System.out.println(service.readById(1L));

		System.out.println(service.update(userDto));

		System.out.println(service.readById(1L));
	}

}
