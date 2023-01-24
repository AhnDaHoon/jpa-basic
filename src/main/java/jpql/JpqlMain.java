package jpql;

import jpashop.domain.Address;
import jpashop.domain.AddressEntity;
import jpashop.domain.Member;

import javax.persistence.*;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
        tx.begin(); // 트랜잭션 시작

        try {
            JpqlMember member = new JpqlMember();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            JpqlMember result = em.createQuery("select m from JpqlMember m where m.username = :username", JpqlMember.class)
                    .setParameter("username", "member1")
                    .getSingleResult();
            System.out.println("singleResult = " + result.getUsername());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }
}
