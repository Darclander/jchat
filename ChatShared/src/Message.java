import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public final class Message implements Serializable {

    private String msg;
    private User sender;
    private String id;

    public Message(User sender, String msg) {
        this.sender = sender;
        this.msg = msg;
        this.id = UUID.randomUUID().toString().substring(0,8);
    }

    public String getID() { return this.id; };

    public String getMsg() {
        return this.msg;
    }

    public User getSender() {
        return this.sender;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Message other = (Message)o;
        return msg.equals(other.msg) && sender.equals(other.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg,sender);
    }


    @Override
    public String toString() {
        return (String.format("(id:%s)<%s>:%s\n",this.id,this.sender.getName(),this.msg));
    }

}
