//package relationShipJpa;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class RelationJpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        //실제 코드 작성하는곳 , jpa트렌젝션 단위엄청좋아해, jpa변경관련된거 다 트렌젝션 안에서 진행해야
//
//        //스프링과 함께쓰면 이걸 에러케치를 다 해줌
//        try{
//
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());
//
//            tx.commit();
//        }catch(Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//            emf.close();
//        }
//    }
//}