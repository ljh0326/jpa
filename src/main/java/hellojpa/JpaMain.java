package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //실제 코드 작성하는곳 , jpa트렌젝션 단위엄청좋아해, jpa변경관련된거 다 트렌젝션 안에서 진행해야

        //스프링과 함께쓰면 이걸 에러케치를 다 해줌
        try{
            //삽입
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            em.persist(member);

            //찾기
            Member findMember = em.find(Member.class, 1L);

            //삭제
            em.remove(member);
            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
