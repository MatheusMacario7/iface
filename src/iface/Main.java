package iface;

import java.util.Scanner;

public class Main {
    static Scanner input =  new Scanner(System.in);
    static Profile p = new Profile();

    static User nUser = new User();
    


    public static void clear(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){
            e.getStackTrace();
        }
        
    }
    public static void main(String[] args) throws Exception{
        homeMenu();
    }   

    public static void homeMenu() throws InterruptedException{
    int key;
    clear();
    System.out.println("--------------- IFACE ---------------");
    System.out.println("1 - CADASTRAR NOVO USUÁRIO");
    System.out.println("2 - FAZER LOGIN");
    System.out.println("0 - FECHAR APP");
    System.out.println("-------------------------------------");
    System.out.print("==> Digite uma opção: ");
    key = input.nextInt();
    input.nextLine();
    
    switch (key) { 
        case 1:
            newUserMenu();
            break;

        case 2:
            accessMenu();
            break;
        case 0:
            System.out.println("FECHANDO APLICATIVO...");
            Thread.sleep(2000);
            break;
        default:
            System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
            Thread.sleep(3000);
            break;
    }   

}
    


public static void newUserMenu() throws InterruptedException{
    clear();
    System.out.println("\n----- CADASTRO DE NOVO USUÁRIO -----");
    System.out.print("E-mail: ");
    String email = input.nextLine();

    System.out.print("Senha: ");
    String password = input.nextLine();
    
    System.out.print("Nome de usuário: ");
    String userName = input.nextLine();

    nUser = new User(email, password, userName);
    System.out.println("\nCadastro de " + userName + " realizado com sucesso!");
    Registers.insertUser(nUser);
    Thread.sleep(2000);
    homeMenu();
}

    public static void accessMenu() throws InterruptedException {
        clear();
        System.out.println("\n--------------- IFACE ---------------");
        System.out.print("Login: ");
        String login = input.nextLine();
        System.out.print("Senha: ");
        String pass = input.nextLine();
        if (Registers.search(login, pass) == 1){
            System.out.println("Login realizado com sucesso!");
            Thread.sleep(2000);
            menuLogin(Registers.search(login));
        }else{  System.out.println("Usuário e/ou senha incorretos!");
                Thread.sleep(2000);
                accessMenu();
            }
    }

    public static void friendMenu(User u) throws InterruptedException{
        clear();
        int op;
        System.out.println("       ZONA DE AMIZADE");
        System.out.println("-------------------------------");
        System.out.println("1 - Adicionar um amigo");
        System.out.println("2 - Solicitação de amizade");
        System.out.println("0 - VOLTAR");
        System.out.println("-------------------------------");
        System.out.print("==> Digite uma opção: ");
        op = input.nextInt();

    switch (op) {
        case 1:
            clear();
            Registers.usersRegister();
            System.out.println("0 - VOLTAR");
            System.out.println("------------------------------------------------------------");
            System.out.print("==> Digite uma opção para enviar a solicitação de amizade: ");
            int resp = input.nextInt();
            if (resp != 0 && resp <= Registers.userList.size()) {
                resp--;
                User friend = Registers.userList.get(resp);
                
                System.out.println("Solicitação de amizade enviada para " + friend.getUserName()+ "!");
                Thread.sleep(2000);
            }else if (resp > Registers.userList.size()) {
                System.out.println("Opção inválida!");
                Thread.sleep(2000);
            }
            friendMenu(u);

            break;
        case 2:
            break;

        case 0:
            menuLogin(u);
            break;

        default:

            break;
    }

}

public static void menuLogin(User u) throws InterruptedException{
    int num;
    
    clear();
    System.out.println("--------------- IFACE ---------------");
    System.out.println("Welcome, " + u.getUserName() + "!");
    System.out.println("---------------- MENU ----------------");
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
    System.out.print("==> Digite uma opção: ");
    num = input.nextInt();
    input.nextLine();

    switch (num) {
        case 1:
            u.editProfile(u);
            break;
        case 2:
            friendMenu(u);
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
}
    
}
