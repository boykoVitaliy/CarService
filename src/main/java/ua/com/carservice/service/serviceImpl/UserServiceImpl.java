package ua.com.carservice.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.carservice.constants.Errors;
import ua.com.carservice.dto.GoodsDto.GoodsAddUserDto;
import ua.com.carservice.dto.UserDto.UserDto;
import ua.com.carservice.dto.UserDto.UserSaveDto;
import ua.com.carservice.dto.UserDto.UserUpdateDto;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.Goods;
import ua.com.carservice.entity.User;
import ua.com.carservice.exception.NotFoundException;
import ua.com.carservice.repository.CarRepository;
import ua.com.carservice.repository.GoodsRepository;
import ua.com.carservice.repository.UserRepository;
import ua.com.carservice.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final GoodsRepository goodsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CarRepository carRepository, GoodsRepository goodsRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<User> findAll() {
        return modelMapper.map(userRepository.findAll(),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public List<User> findByCars(Car car) {
        List<User> findByCars = userRepository.findByCars(car);

        if(findByCars.isEmpty()){
            throw new NotFoundException(Errors.DATA_NOT_FOUND+car);
        }

        return modelMapper.map(userRepository.findByCars(car),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public List<User> findByNumber(Long number) {
        List<User> findByNumber = userRepository.findByNumber(number);

        if(findByNumber.isEmpty()){
            throw new NotFoundException(Errors.DATA_NOT_FOUND+number);
        }

        return modelMapper.map(userRepository.findByNumber(number),new TypeToken<List<UserDto>>(){}.getType());
    }

    @Override
    public List<User> findByEmail(String email)  {
        List<User> findByEmail = userRepository.findByEmail(email);

        if(findByEmail.isEmpty()){
            throw new NotFoundException(Errors.DATA_NOT_FOUND+email);
        }
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
    public User update(Long userId, UserUpdateDto userUpdateDto) {
        return userRepository.findById(userId).map(user -> {
            user.setEmail(userUpdateDto.getEmail());
            user.setFirstName(userUpdateDto.getFirstName());
            user.setLastName(userUpdateDto.getLastName());
            user.setNumber(userUpdateDto.getNumber());
            return userRepository.save(user);
        }).orElseThrow(()->new NotFoundException("NOT_FOUND_THIS_ID--"+userId));
    }


}
