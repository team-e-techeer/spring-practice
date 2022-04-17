package net.schoolvery.schoolveryserver.domain.user.repository;

import com.sun.istack.NotNull;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserLoginDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.GetUserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

// 정확히 말하면 User Dao라고 볼수 있는 내용

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // User Create
    public int createUser(@NotNull UserCreateDto userCreateDto) {
        String createQuery = "insert into User(name, nickname, phone, student_id, school, email, password) VALUES(?,?,?,?,?,?,?)";
        Object[] createUserParams = new Object[]{userCreateDto.getName(), userCreateDto.getNickname(), userCreateDto.getPhone(), userCreateDto.getStudent_id()
                , userCreateDto.getSchool(), userCreateDto.getEmail(), userCreateDto.getPassword()};

        this.jdbcTemplate.update(createQuery, createUserParams);

        String lastInsertIdQuery = "select Last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
    }

    // User Login
    public User getPwd(@NotNull UserLoginDto userLoginDto) {
        String getPwdQuery = "select * from User where login_id = ?";
        String getPwdParams = userLoginDto.getEmail();

        return this.jdbcTemplate.queryForObject(getPwdQuery,
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("nickname"),
                        rs.getInt("phone"),
                        rs.getInt("student_id"),
                        rs.getString("school"),
                        rs.getString("email"),
                        rs.getString("password")),
                getPwdParams
        );
    }


    // User update (닉네임만)
    public int modifyUserName(UserUpdateDto userUpdateDto) {
        String modifyUserQuery = "update User set nickname = ? where id = ? ";
        Object[] modifyUserParams = new Object[]{userUpdateDto.getNickname(), userUpdateDto.getId()};
        return this.jdbcTemplate.update(modifyUserQuery, modifyUserParams);
    }

    // User Read
    public List<GetUserResponseDto> getUser() {
        String getUserQuery = "SELECT id, name, nickname, phone, student_id, school, email, password FROM User";

        return this.jdbcTemplate.query(getUserQuery,
                (rs, rowNum) -> new GetUserResponseDto(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("nickname"),
                        rs.getInt("phone"),
                        rs.getInt("student_id"),
                        rs.getString("school"),
                        rs.getString("email"),
                        rs.getString("password")
                ));

    }

    public int deleteUser(int id) {
        String deleteUserQuery = "DELETE FROM User WHERE id = ?";
        int getUserParams = id;

        return this.jdbcTemplate.update(deleteUserQuery, getUserParams);
    }






}
