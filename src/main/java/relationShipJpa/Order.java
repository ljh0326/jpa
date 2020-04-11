package relationShipJpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList();

    @Enumerated(EnumType.STRING)
    OderStatus status;

    Date orderDate;

    //연관관계 편의 메서드
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OderStatus getStatus() {
        return status;
    }

    public void setStatus(OderStatus status) {
        this.status = status;
    }
}
