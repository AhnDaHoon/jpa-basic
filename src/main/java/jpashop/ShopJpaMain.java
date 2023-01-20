package jpashop;

import jpashop.domain.Book;
import jpashop.domain.Member;
import jpashop.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ShopJpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
        tx.begin(); // 트랜잭션 시작

        try {
            Member member = new Member();
            member.setUsername("m1");
            em.persist(member);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member.getId());
            
            System.out.println("refMember = " + refMember.getClass());
            em.detach(refMember);
            em.close();
            em.clear();

            refMember.getUsername();
            System.out.println("refMember.getUsername() = " + refMember.getUsername());

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
