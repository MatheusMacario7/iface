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
            key = input.nextInt();

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
                    p.setCellPhone(input.next());
                    break;

                case 0:
                    Main.menuLogin(u);
                    return;
                default:
                    System.out.println("OPÇÃO INVÁLIDA! Por favor digite uma das opções acima.");
                    Thread.sleep(3000);
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
