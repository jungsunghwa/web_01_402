package kr.hs.dgsw.web_01_402.Service;

import kr.hs.dgsw.web_01_402.Domain.User;
import kr.hs.dgsw.web_01_402.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User viewUser() {
        return this.userRepository.findAll().get(0);
    }

    @Override
    public User addUser(User user) {
        return (User) this.userRepository.findByEmail(user.getEmail()).map(found -> null).orElse(this.userRepository.save(user));
    }

    /**
     * jpa 영속성 컨텍스트
     *
     */
    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        return this.userRepository
                .findById(id)
                .map(found -> {
                    found.changeUserData(user);
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteUser(Long id) {
        return this.userRepository.findById(id).map(found -> {
            this.userRepository.delete(found);
            return true;
        }).orElse(false);
    }

}
