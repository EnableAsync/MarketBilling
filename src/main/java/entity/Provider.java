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
public class Provider {
    private int id;

    private String name;

    private String desc;

    private String tel;

    private String address;

    private String creator;

    private Date create_time;
}
