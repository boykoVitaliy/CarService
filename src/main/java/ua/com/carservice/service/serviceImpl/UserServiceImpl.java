package ua.com.carservice.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.dto.UserDto.UserDto;
import ua.com.carservice.dto.UserDto.UserSaveDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.User;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<User> findAll() {
        return modelMapper.map(userRepository.findAll(),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public List<User> findByCars(Car car) {
        return modelMapper.map(userRepository.findByCars(car),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public List<User> findByNumber(Long number) {
        return modelMapper.map(userRepository.findByNumber(number),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public List<User> findByEmail(String email)  {
        return modelMapper.map(userRepository.findByEmail(email),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public User save(UserSaveDto userDto) {
        return userRepository.save(modelMapper.map(userDto,User.class));
    }



    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long userId, UserDto userDto) {
        return userRepository.findById(userId).map(user -> {
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
        }).orElseThrow(()->new NotFoundException("NOT_FOUND_THIS_ID--"+userId));
    }


}
