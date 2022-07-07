package iface;

import java.util.Scanner;

public class Main {
    static Scanner input =  new Scanner(System.in);
    static Profile p = new Profile();

    static User nUser = new User();

    public static int loadInput() throws InterruptedException {
        Scanner input =  new Scanner(System.in);
        boolean correctInput = false;
        int key = -1;
        while (!correctInput) {
            try {
                key = Integer.parseInt(input.next());
                
                correctInput = true;
                
            } catch (Exception e) {
                System.out.println("ENTRADA INVÁLIDA. Digite apenas uma das opções!");
                Thread.sleep(2000);
                return key;
            }
            
        }
        return key;
    }
    


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
    key = loadInput();

    if (key == -1) {
        homeMenu();
    }
    else{
        switch (key) { 
            case 1:
                newUserMenu();
                break;
    
            case 2:
                accessMenu();
                break;
            case 0:
                System.out.print("FECHANDO APLICATIVO");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(800);
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
                Thread.sleep(3000);
                homeMenu();
                break;
        }
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
                homeMenu();
            }
    }

    



public static void menuLogin(User u) throws InterruptedException{
    int num;
    
    clear();
    System.out.println("--------------- IFACE ---------------");
    System.out.println("Welcome, " + u.getUserName() + "!");
    System.out.println("---------------- MENU ----------------");
    System.out.println("1 - EDITAR PERFIL");
    System.out.println("2 - PÁGINA DE AMIGOS");
    System.out.println("3 - PÁGINA DE MENSAGENS");
    System.out.println("4 - PÁGINA DE COMUNIDADES");
    System.out.println("5 - FEED DE NOTÍCIAS");
    System.out.println("6 - REMOVER CONTA");
    System.out.println("0 - SAIR");
    System.out.println("-------------------------------------");
    System.out.print("==> Digite uma opção: ");
    num = loadInput();

    if (num == -1) {
        menuLogin(u);
    }

    switch (num) {
        case 1:
            u.editProfile(u);
            break;
        case 2:
            u.friendMenu(u);
            break;
        case 3:
            u.menuMessage(u);
            break;
        case 4:

            break;
        case 5:
        
            break;
        case 6:
            System.out.println("Tem certeza que deseja DELETAR sua conta?");
            System.out.print("Digite S para sim e N para não: ");
            String op = input.nextLine().toUpperCase();
            char carac = op.charAt(0);
            if (carac == 'S') {
                Registers.userList.remove(u);
                System.out.print("DELETANDO SUA CONTA");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(800);
                homeMenu();
            }
            else if (carac == 'N') {
                System.out.println("Conta não removida! Obrigado(a) por continuar no Iface!");
                Thread.sleep(2000);
                menuLogin(u);
            }else{
                System.out.println("Digite apenas S ou N");
                Thread.sleep(2000);
                menuLogin(u);
            }
            break;
        case 0:
            System.out.print("SAINDO");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(800);
            homeMenu();
            break;
    
        default:
            System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
            Thread.sleep(3000);
            menuLogin(u);
            break;
    }
}
    
}
