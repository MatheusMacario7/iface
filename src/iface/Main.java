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
            System.out.println("2 - CRIAR / EDITAR PERFIL");
            System.out.println("3 - ADICIONAR AMIGOS");
            System.out.println("4 - ENVIAR MENSAGEM");
            System.out.println("5 - CRIAR COMUNIDADE");
            System.out.println("6 - PARTICIPAR DE UMA COMUNIDADE");
            System.out.println("7 - BUSCAR");
            System.out.println("8 - CRIAR UM POST NO FEED DE NOTÍCIAS");
            System.out.println("9 - REMOVER CONTA");
            System.out.println("0 - SAIR");
            System.out.println("-------------------------------------");
            System.out.print("Digite o número: ");
            key = input.nextInt(); 

            switch (key) { 
                case 1:
                    u.newUser();
                    break;
            
                default:
                    break;
            }
    
        } while (key != 0);
        input.close();
        
    }
}
