package co.dev.kh.springbootmongodb.collection;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String address1;
    private String address2;
    private String city;
}
