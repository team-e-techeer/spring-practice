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

    @Override
    public User create(UserDto dto) {
        User entity = dtoToEntity(dto);
        return userRepository.save(entity);
    }

    @Override
    public List<User> getAllUser() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        Optional<User> result = userRepository.findById(id);
        User entity = result.get();
        entity.update(
                dto.getFirstName(),
                dto.getLastName()
        );
        User updatedEntity =  userRepository.save(entity);
        return entityToDto(updatedEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
