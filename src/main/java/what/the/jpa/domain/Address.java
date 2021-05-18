package what.the.jpa.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * 값타입
 */
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zimcode;

    protected Address() {
        // 값 타입은 변경 불가능하게 설계
    }

    public Address(String city, String street, String zimcode) {
        this.city = city;
        this.street = street;
        this.zimcode = zimcode;
    }
}
