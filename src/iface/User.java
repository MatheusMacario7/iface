package iface;

import java.util.ArrayList;
import java.util.Scanner;

public class User { 
    private String login;
    private String password;
    private String userName;

    Scanner input =  new Scanner(System.in);
    ArrayList<User> users = new ArrayList<User>();

    public void newUser() {
        System.out.println("\n----- CADASTRO DE NOVO USUÁRIO -----");
        System.out.print("Login: ");
        setLogin(input.nextLine());
        System.out.print("Senha: ");
        setPassword(input.nextLine());
        System.out.print("Nome de usuário: ");
        setUserName(input.nextLine());
        System.out.println("\nO Login é " + this.login);
        System.out.println("A senha é " + this.password);
        System.out.println("Nome de usuário é " + this.userName);
        //input.close();
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
    
}
