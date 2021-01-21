package university.innopolis.stc.springbestpractices.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.innopolis.stc.springbestpractices.dto.UserCreateDto;
import university.innopolis.stc.springbestpractices.dto.UserListDto;
import university.innopolis.stc.springbestpractices.entity.User;
import university.innopolis.stc.springbestpractices.logic.EntityLogic;
import university.innopolis.stc.springbestpractices.repository.UsersRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(UserCreateDto.class, User.class)
                .setPostConverter(mappingContext -> {
                    User user = mappingContext.getDestination();
                    user.setDate(LocalDate.now());
                    return user;
                });
    }

    public List<UserListDto> getAll(Optional<Integer> page,
                                    Optional<Integer> size,
                                    Optional<String> sort,
                                    Optional<String> login,
                                    Optional<String> role) {

        return EntityLogic.list(User.class, UserListDto.class, usersRepository, modelMapper)
                .withPagination(page, size, sort)
                .withFiltering()
                .field("login", login)
                .field("role", role)
                .getResult();
    }

    public UserListDto create(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        User saved = usersRepository.save(user);
        UserListDto result = modelMapper.map(saved, UserListDto.class);
        return result;
    }

    public void savePicture(Long id, byte[] bytes) {
        Optional<User> user = usersRepository.findById(id);
        user.ifPresent(u -> {
            u.setPicture(bytes);
            usersRepository.save(u);
        });
    }

    public byte[] getPicture(Long id) {
        return usersRepository.findById(id)
                .map(User::getPicture)
                .orElse(null);
    }
}
