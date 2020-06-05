package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class Bill {
    private int id;

    private String product_name;

    private String product_desc;

    private int product_count;

    private BigDecimal total_price;

    private short is_payment;

    private int provider_id;

    private String creator;

    private Date create_time;

}
