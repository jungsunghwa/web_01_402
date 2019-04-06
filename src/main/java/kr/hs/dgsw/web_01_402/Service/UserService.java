package kr.hs.dgsw.web_01_402.Service;



import kr.hs.dgsw.web_01_402.Domain.User;

import java.util.List;

public interface UserService {
    List<User> listAllUser();

    User viewUser();

    User addUser(User user);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);

}
