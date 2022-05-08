package iface;

import java.util.ArrayList;

public class Registers {

    static ArrayList<User> userList = new ArrayList<>();
    
    
    static void insertUser(User newUser){
        userList.add(newUser); 
    }
    
    static void usersRegister(){
        System.out.println("Usuários cadastrados");
        System.out.println("-----------------------");
        int i = 1;
        for (User u : userList) {
            System.out.print(i++ + " -");
            u.viewUserName();
        }
    }

    static int search(String login, String pass){
        for (User user : userList) {
            if (user.getEmail().equals(login) && user.getPassword().equals(pass)){
                return 1;
            }
        }
        return 0;
    }
    static User search(String login){
        for (User user : userList) {
            if (user.getEmail().equals(login)){
               return user; 
            }
        }
        return null;
    }
}
