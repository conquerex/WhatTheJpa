package what.the.jpa.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import what.the.jpa.domain.Order;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    // 아래 방법은 비추천이라 생략
    // public List<Order> findAllByString(OrderSearch orderSearch)
    // public List<Order> findAllByCriteria(OrderSearch orderSearch)

    public List<Order> findAll(OrderSearch orderSearch) {
        // todo : QueryDSL로 동적쿼리를 짜야 함. 이후에 다룰 예정. 아래는 동적이지 않다.
        return em.createQuery("select o from Order o join o.member m " +
                "where o.status = :status " +
                "and m.name like :name", Order.class)
                .setParameter("status", orderSearch.getOrderStatus())
                .setParameter("name", orderSearch.getMemberName())
                .setMaxResults(1000) // 최대 1000건
                .getResultList();
    }
}
