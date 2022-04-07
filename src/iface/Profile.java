package iface;

import java.util.Scanner;

public class Profile {
    private String firstName;
    private String lastName;
    private int age;
    private String genre;
    private String relationship;
    private String cellPhone;

    
    Scanner input =  new Scanner(System.in);


    public void editProfile(String username) {
        int key = 0;
        do {
            System.out.println("Perfil de " + username);
            System.out.println("---------------------------------");
            System.out.println("1 - Primeiro nome: " + getFirstName());
            System.out.println("2 - Último nome: " + getLastName());
            System.out.println("3 - Idade: " + getAge());
            System.out.println("4 - Gênero: " + getGenre());
            System.out.println("5 - Relacionamento: " + getRelationship());
            System.out.println("6 - Telefone: " + getCellPhone());
            System.out.println("0 - VOLTAR");
            System.out.println("---------------------------------");
            System.out.print("Digite a opção que deseja editar: ");
            key = input.nextInt();

            switch (key) {
                case 1:
                    System.out.print("Digite seu primeiro nome: ");
                    setFirstName(input.next());
                    break;
                case 2:
                    System.out.print("Digite seu último nome: ");
                    setLastName(input.next());
                    break;    
                case 3:
                    System.out.print("Digite sua idade: ");
                    setAge(input.nextInt());
                    break;
                case 4:
                    System.out.print("Digite seu gênero: ");
                    setGenre(input.next());
                    break;

                case 5:
                    System.out.print("Digite o estado de relacionamento: ");
                    setRelationship(input.next());
                    break;

                case 6:
                    System.out.print("Digite seu número de telefone: ");
                    setCellPhone(input.next());
                    break;

                case 0:
                    
                    break;
                default:
                    break;
            }

        } while (key != 0);
        
        input.close();
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getCellPhone() {
        return cellPhone;
    }
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

}
