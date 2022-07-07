package iface;

public class Message {
    private User messager;
    private String messageText;
    private User targetUser;


    public Message(User messager, String messageText, User targetUser) {
        this.messager = messager;
        this.messageText = messageText;
        this.targetUser = targetUser;
    }


    public User getMessager() {
        return messager;
    }

    public String getMessageText() {
        return messageText;
    }

    public void showMessage(){
        System.out.println("Mensagem de " + messager.getUserName() + ":");
        System.out.println("----------------------------------------");
        System.out.println("Mensagem: " + messageText);
        System.out.println("========================================");
    }
}
