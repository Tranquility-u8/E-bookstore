package com.my.bookstore_backend.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_logs")
public class OrderLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 关联用户

    @Column(name = "order_id")
    private Long orderId; // 关联订单的ID

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "is_success")
    private boolean isSuccess;

    @Column(name = "error_message")
    private String errorMessage;

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }
}