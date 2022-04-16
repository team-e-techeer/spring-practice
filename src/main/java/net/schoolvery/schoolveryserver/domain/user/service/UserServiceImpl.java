package net.schoolvery.schoolveryserver.domain.user.service;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateRequestDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateRequestDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.repository.UserRepository;
import net.schoolvery.schoolveryserver.global.common.dto.PageRequestDto;
import net.schoolvery.schoolveryserver.global.common.dto.PageResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto create(UserCreateRequestDto dto) {
        User entity = dtoToEntity(dto);
        return entityToDto(userRepository.save(entity));
    }

    @Override
    public PageResultDto<UserResponseDto, User> getAllUser(PageRequestDto requestDto) {

        Pageable pageable = requestDto.getPageable(Sort.by("firstName").descending());

        //        List<UserResponseDto> result = userRepository.findAll
        //                .mapper(result::entityToDto); //mapper 함수로 처리해주기
        //        return result;
        Page<User> result = userRepository.findAll(pageable);

        Function<User, UserResponseDto> fn = (entity -> entityToDto(entity));

        return new PageResultDto<>(result, fn);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto dto) {
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
