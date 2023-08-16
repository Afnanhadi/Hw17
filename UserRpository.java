package com.example.hw17.Repostere;

import com.example.hw17.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserRpository extends JpaRepository<User,Integer> {
}
