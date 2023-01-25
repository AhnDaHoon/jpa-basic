package jpql;

import jpashop.domain.Address;
import jpashop.domain.AddressEntity;
import jpashop.domain.Member;
import jpashop.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
        tx.begin(); // 트랜잭션 시작

        try {
            JpqlTeam team = new JpqlTeam();
            team.setName("teamA");
            em.persist(team);

            JpqlMember member = new JpqlMember();
            member.setUsername("member1");
            member.setAge(10);
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String query = "select m.username, 'HELLO', TRUE From JpqlMember m";
            List<JpqlMember> result = em.createQuery(query, JpqlMember.class)
                    .getResultList();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
}
