package SoftClub.test_pages.model;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {

    private String to;
    private String body;

    public Message() {
    }

    public Message(String to, String body) {
        this.body = body;
        this.to = to;
    }

    public String getMessage() {
        return body;
    }

    public void setMessage(String body) {
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(getTo(), message.getTo()) &&
                Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTo(), body);
    }

    @Override
    public String toString() {
        return "Message{" +
                "to='" + to + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}