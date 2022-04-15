package net.schoolvery.schoolveryserver.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.schoolvery.schoolveryserver.domain.user.dto.UserDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // C : User create
    @Override
    public User create(UserDto dto) {
        User entity = dtoToEntity(dto);
        return userRepository.save(entity);
    }

    // R : User findAll
    @Override
    public List<User> getAllUser() {
        List<User> result = userRepository.findAll();
//                .stream()
//                .map(entityToDto())
//                .collect(Collectors.toList());
        return result;
    }

//     R : User findById
    // user dto list 주면됨
    @Override
    public UserDto getUser(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.isPresent()? entityToDto(result.get()): null;
    }

    // U : User update
    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        Optional<User> result = userRepository.findById(id);
//        if (result.isPresent()) {
        User entity = result.get();
        entity.update(
                dto.getFirstName(),
                dto.getLastName()
        );
        User updatedEntity =  userRepository.save(entity);
        return entityToDto(updatedEntity);
    }

    // D : Delete user by id
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
