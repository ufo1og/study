package com.example.study.user;

import com.example.study.user.dto.UserDto;
import com.example.study.user.dto.UserMapper;
import com.example.study.user.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;



import javax.persistence.Query;
import javax.persistence.criteria.*;


public class UserRepositoryImpl implements UserRepositoryCustom {
    private final UserRepository userRepository;
    private final SessionFactory sessionFactory;

    public UserRepositoryImpl(@Lazy UserRepository userRepository, SessionFactory sessionFactory) {
        this.userRepository = userRepository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Session session = sessionFactory.openSession();
        try (session) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<User> cu = cb.createCriteriaUpdate(User.class);
            Root<User> user = cu.from(User.class);
            if (!userDto.getFirstName().isEmpty()) {
                cu.set(user.get("firstName"), userDto.getFirstName());
            }
            if (!userDto.getLastName().isEmpty()) {
                cu.set(user.get("lastName"), userDto.getLastName());
            }
            if (userDto.getBirthday() != null) {
                cu.set(user.get("birthday"), userDto.getBirthday());
            }
            session.createQuery(cu).executeUpdate();
        }
        return null;
    }
}
