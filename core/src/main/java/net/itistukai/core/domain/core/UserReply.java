package net.itistukai.core.domain.core;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by blvp on 31.03.15.
 */
@Entity
public class UserReply {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_reply_gen")
    @SequenceGenerator(name = "user_reply_gen", sequenceName = "user_reply_seq")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="reply_type")
    private ReplyType replyType;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name="date_sent")
    private DateTime dateSent;

    @Column(name="views_number")
    private Long viewsNumber;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="user_name")
    private String userName;

    @Column(name="reply_text")
    private String replyText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReplyType getReplyType() {
        return replyType;
    }

    public void setReplyType(ReplyType replyType) {
        this.replyType = replyType;
    }

    public DateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(DateTime dateSent) {
        this.dateSent = dateSent;
    }

    public Long getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(Long viewsNumber) {
        this.viewsNumber = viewsNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }
}
