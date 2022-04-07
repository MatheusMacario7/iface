package iface;

import java.util.Scanner;

public class User { 
    private String email;
    private String password;
    private String userName;
    private String login;
    private String pass;

    Profile p = new Profile();

    Scanner input =  new Scanner(System.in);
    

    public void newUser() {
         
        System.out.println("\n----- CADASTRO DE NOVO USUÁRIO -----");
        System.out.print("E-mail: ");
        setEmail(input.nextLine());
        System.out.print("Senha: ");
        setPassword(input.nextLine());
        System.out.print("Nome de usuário: ");
        setUserName(input.nextLine());
        System.out.println("\nO Login é " + this.email);
        System.out.println("A senha é " + this.password);
        System.out.println("Nome de usuário é " + this.userName);
         
    }
    

    public void login() {
        int flag = 0;
        do {
            flag = 0;
            System.out.println("\n--------------- IFACE ---------------");
            System.out.print("Login: ");
            setLogin(input.nextLine());
            System.out.print("Senha: ");
            setPass(input.nextLine());

            if (this.email.equals(getLogin()) && this.pass.equals(getPassword())) {
                System.out.println("Login realizado com sucesso!");
            } else{
                System.out.println("Endereço de E-mail ou senha incorreto!");
                flag = 1;  
            }

        } while (flag == 1);
        menuLogin();

    }
    
    public void menuLogin() {
        int num;
        System.out.println("--------------- IFACE ---------------");
        System.out.println("Welcome, " + getUserName() + "!");
        System.out.println("---------- MENU ----------");
        System.out.println("1 - EDITAR PERFIL");
        System.out.println("2 - ADICIONAR AMIGOS");
        System.out.println("3 - ENVIAR MENSAGEM");
        System.out.println("4 - CRIAR COMUNIDADE");
        System.out.println("5 - PARTICIPAR DE UMA COMUNIDADE");
        System.out.println("6 - BUSCAR");
        System.out.println("7 - CRIAR UM POST NO FEED DE NOTÍCIAS");
        System.out.println("8 - REMOVER CONTA");
        System.out.println("0 - SAIR");
        System.out.println("-------------------------------------");
        System.out.print("Digite o número: ");
        num = input.nextInt();

        switch (num) {
            case 1:
                p.editProfile(getUserName());
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:

                break;
            case 5:
            
                break;
            case 6:
            
                break;
            case 7:
            
                break;
            case 8:
            
                break;
            case 0:
            
                break;
        
            default:
                break;
        }
        input.close();
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
