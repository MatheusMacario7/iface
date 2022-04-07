package iface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input =  new Scanner(System.in);
        User u = new User();
        int key;
        do {
            System.out.println("--------------- IFACE ---------------");
            System.out.println("1 - CADASTRAR NOVO USUÁRIO");
            System.out.println("2 - FAZER LOGIN");
            System.out.println("0 - FECHAR APP");
            System.out.println("-------------------------------------");
            System.out.print("Digite o número: ");
            key = input.nextInt(); 

            switch (key) { 
                case 1:
                    u.newUser();
                    break;
                case 2:
                    u.login();

                    break;
                case 3:
                    System.out.println("FECHANDO APLICATIVO...");
                    break;
                default:
                    break;
            }
    
        } while (key != 0);
        input.close();
        
    }
}
