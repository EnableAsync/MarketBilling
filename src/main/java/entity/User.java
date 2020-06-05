package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class User {
    private int id;

    private String username;

    private String password;

    private String phone;

    private String address;

    private Date birthday;

    private short role;

}
