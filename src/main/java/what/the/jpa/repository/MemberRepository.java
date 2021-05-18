package what.the.jpa.repository;

import org.springframework.stereotype.Repository;
import what.the.jpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 컴포넌트 스캔의 대상
 * 스피링 빈으로 등록
 */
@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member memeber) {
        em.persist(memeber);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
