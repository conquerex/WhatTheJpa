package what.the.jpa.repository;

import lombok.Getter;
import lombok.Setter;
import what.the.jpa.domain.OrderStatus;

@Getter
@Setter
public class OrderSearch {
    private String memberName; // 회원이름
    private OrderStatus orderStatus; // 주문상태 (ORDER, CANCEL)
}
