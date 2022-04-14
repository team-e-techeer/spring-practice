package net.schoolvery.schoolveryserver.domain.user.repository;

import net.schoolvery.schoolveryserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRopository extends JpaRepository<User, UUID> {

}