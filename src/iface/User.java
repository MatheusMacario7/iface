package iface;

import java.util.ArrayList;
import java.util.Scanner;

public class User { 
    private String email;
    private String password;
    private String userName;
    private String login;
    private String pass;
    

    Profile p = new Profile();

    //ArrayLists
    private ArrayList<Friends> friendshipRequests;
    private ArrayList<User> myFriends;
    private ArrayList<Message> myMessages; 
    

    static Scanner input =  new Scanner(System.in);
    

    
    public static void clear(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public User() {
    }
    
    public User(String email, String password, String userName) {
        setEmail(email);
        setPassword(password);
        setUserName(userName);

        this.friendshipRequests = new ArrayList<>();
        this.myFriends = new ArrayList<>();
        this.myMessages = new ArrayList<>();
    }

    void viewUserName(){
        System.out.println(" " + this.userName);
    }

    public void editProfile(User u) throws InterruptedException{
        int key = 0;
        do {
            clear();
            System.out.print("Perfil de " + this.userName);
            System.out.println(showProfile());
            System.out.println("0 - VOLTAR");
            System.out.println("---------------------------------");
            System.out.print("==> Digite a opção que deseja editar: ");
            key = Main.loadInput();

            if (key == -1) {
                editProfile(u);
            }

            switch (key) {
                case 1:
                    System.out.print("Digite seu primeiro nome: ");
                    p.setFirstName(input.next());
                    break;
                case 2:
                    System.out.print("Digite seu último nome: ");
                    p.setLastName(input.next());
                    break;    
                case 3:
                    System.out.print("Digite sua idade: ");
                    p.setAge(input.next());                   
                    break;
                case 4:
                    System.out.print("Digite seu gênero: ");
                    p.setGenre(input.next());
                    break;

                case 5:
                    System.out.print("Digite o estado de relacionamento: ");
                    p.setRelationship(input.next());
                    break;

                case 6:
                    System.out.print("Digite seu número de telefone: ");
                    p.setCellPhone(input.nextLine());
                    break;

                case 0:
                    Main.menuLogin(u);
                    return;
                default:
                    System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
                    Thread.sleep(3000);
                    clear();
                    editProfile(u);
                    break;
            }
            
            input.nextLine();

        } while (key != 0);
        
        
    }

    public String showProfile() {
        return  "\n---------------------------------" + 
                "\n1 - Primeiro nome: " + p.getFirstName() +
                "\n2 - Último nome: " + p.getLastName() + 
                "\n3 - Idade: " + p.getAge() + 
                "\n4 - Gênero: " + p.getGenre() +
                "\n5 - Relacionamento: " + p.getRelationship() +
                "\n6 - Telefone: " + p.getCellPhone();
    }


    public void friendMenu(User u) throws InterruptedException{
        clear();
        int op;
        System.out.println("       PÁGINA DE AMIZADE");
        System.out.println("-------------------------------");
        System.out.println("1 - Adicionar um amigo");
        System.out.println("2 - Solicitação de amizade");
        System.out.println("3 - Meus amigos");
        System.out.println("0 - VOLTAR");
        System.out.println("-------------------------------");
        System.out.print("==> Digite uma opção: ");
        op = Main.loadInput();
        if (op == -1) {
            friendMenu(u);
        }

    switch (op) {
        case 1:
            clear();
            Registers.usersRegister();
            System.out.println("0 - VOLTAR");
            System.out.println("------------------------------------------------------------");
            System.out.print("==> Digite uma opção para enviar a solicitação de amizade: ");
            int resp = Main.loadInput();

            if (resp != 0 && resp <= Registers.userList.size()) {
                resp--;
                User friend = Registers.userList.get(resp);
                if (friend.getUserName().equals(u.getUserName())) {
                    System.out.println("Você não pode enviar uma solicitação de amizade para você mesmo. Escolha outro amigo.");
                    Thread.sleep(3000);
                    clear();
                    friendMenu(u);
                }
                if (!this.myFriends.isEmpty()){
                    for (User namefriend : myFriends) {
                      if (friend.getUserName().equals(namefriend.getUserName())) {
                        System.out.println("Vocês já são amigos! escolha outro.");
                        Thread.sleep(3000);
                        friendMenu(u);
                      }  
                    }    
                }
                Friends friendRequest = new Friends(u, friend);
                friendshipRequests.add(friendRequest);
                friend.friendshipRequests.add(friendRequest);
                System.out.println("Solicitação de amizade enviada para " + friend.getUserName()+ "!");
                Thread.sleep(2000);
            }else if (resp > Registers.userList.size()) {
                System.out.println("Opção inválida!");
                Thread.sleep(2000);
            }
            friendMenu(u);

            break;
        case 2:
            if (friendshipRequests.isEmpty()) {
                System.out.println("Você não possui nenhuma solicitação de amizade.");
                Thread.sleep(3000);
                friendMenu(u);
            }
            else {
                try {
                    for (Friends friendRequest : friendshipRequests) {
                        if (friendRequest.getFriendRequested().getUserName().equals(u.getUserName())) {
                            System.out.print("O usuário " + friendRequest.getUserRequest().getUserName() + " enviou uma solicitação de amizade.\nDigite 1 para aceitar ou 0 para recusar: ");
                            Integer answer = Main.loadInput();
                            if (answer.equals(1)) {
                                positiveAnswer(friendRequest);
                            }
                            else if (answer.equals(0)) {
                                negativeAnswer(friendRequest);
                            }
                            else{
                                System.out.println("Digite apenas '1' ou '0' ");
                            }
        
                        }
                           
                    }
                    Thread.sleep(3000);
                    friendMenu(u);
                     
                } catch (Exception e) {
                    Thread.sleep(3000);
                    friendMenu(u);
                }
            }
            break;
        case 3:
            showMyFriends();
            Thread.sleep(3000);
            friendMenu(u);
            break;
        case 0:
            Main.menuLogin(u);
            break;

        default:
            System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
            Thread.sleep(3000);
            clear();
            friendMenu(u);
            break;
    }
}

    public void positiveAnswer(Friends request){
        myFriends.add(request.getUserRequest());
        request.getUserRequest().myFriends.add(this);

        request.getFriendRequested().friendshipRequests.remove(request);
        request.getUserRequest().friendshipRequests.remove(request);
        System.out.println("Agora você e " + request.getUserRequest().getUserName() + " são amigos!");
    }

    public void negativeAnswer(Friends request){
        request.getFriendRequested().friendshipRequests.remove(request);
        request.getUserRequest().friendshipRequests.remove(request);
        System.out.println("Solicitação de amizade recusada.");
    }

    public void showMyFriends(){
        if (myFriends.isEmpty()) {
            System.out.println("Você ainda não tem amigos no Iface.");
        }
        else{
            System.out.println("      MEUS AMIGOS");
            System.out.println("-----------------------");
            int i = 1;
            for (User f : myFriends) {
            System.out.println(i++ + " - " + f.getUserName());
            }
        }
     }


    public void menuMessage(User u) throws InterruptedException {
        clear();
        int op;
        System.out.println("      PÁGINA DE MENSAGENS");
        System.out.println("-------------------------------");
        System.out.println("1 - Enviar uma mensagem");
        System.out.println("2 - Mensagens recebidas");
        System.out.println("0 - VOLTAR");
        System.out.println("-------------------------------");
        System.out.print("==> Digite uma opção: ");
        op = Main.loadInput();

        switch (op) {
            case 1:
                sendMessage(u);
                System.out.println("Mensagem enviada com sucesso!");
                Thread.sleep(3000);
                menuMessage(u);
                break;
            case 2:
                readMessages();
                System.out.println("Pressione qualquer tecla para voltar: ");
                String key = input.nextLine().toString();
                menuMessage(u);

                break;
            case 0:
                Main.menuLogin(u);
                break;
        
            default:
                System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
                Thread.sleep(3000);
                clear();
                menuMessage(u);
                break;
        }
    }

    public void sendMessage(User u) throws InterruptedException {
        clear();
        int index;
        Registers.usersRegister();
        System.out.println("0 - VOLTAR");
        System.out.println("-----------------------");
        System.out.print("Para quem você deseja enviar uma mensagem: ");
        index = Main.loadInput();

        if (index == 0) {
            menuMessage(u);
        }
        else{
            index--; 
            User targetUser = Registers.userList.get(index);
            System.out.println("Mensagem para " + targetUser.getUserName() + ": ");
            String messagetext = input.nextLine();

            Message message = new Message(u, messagetext, targetUser);
            targetUser.myMessages.add(message);
        }

    }

    public void readMessages() {
        if (myMessages.isEmpty()) {
            System.out.println("Nenhuma mensagem encontrada!");
        }
        else{
            for (Message message : myMessages) {
                message.showMessage(); 
            }
            
        }
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String login) {
        this.email = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String senha) {
        this.password = senha;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

}
