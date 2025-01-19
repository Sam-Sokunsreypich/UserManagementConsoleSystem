package controller;

import model.User;
import model.UserModel;
import notify.TelegramNotification;
import view.UserView;

import java.util.List;
import java.util.Scanner;


public class UserController {
    private final UserModel model;
    private final UserView view;

    public UserController(UserModel model,UserView view){
        this.model = model;
        this.view = view;
    }

    public void createUser(String name,String email){
        model.addNewUser(name,email);
        view.displayMessage("User created successfully!");
    }

    public void searchUser(String uuid){
        User user = model.findUserByUuid(uuid);
        if(user != null){
            view.displayMessage(user.toString());
        }else{
            view.displayMessage("User not found!");
        }
    }

    public void updateUser(String uuid,String name, String email, boolean isDeleted){
        if(model.updateUser(uuid, name, email, isDeleted)){
            view.displayMessage("User update successfully!");
        }else{
            view.displayMessage("User not found.");
        }
    }

    public void deleteUser(String uuid){
        if(model.deletedUser(uuid)){
            view.displayMessage("User deleted successfully!");
        }else{
            view.displayMessage("User not found!");
        }
    }

    public void listUser(int page){
        List<User> users = model.getAllActiveUser(page, 5);
        if(!users.isEmpty()){
            view.displayTable(users, page, 5);
        }else{
            view.displayMessage("No users to display.");
        }
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n"+"=".repeat(10)+" User Management System "+"=".repeat(10));
            System.out.println("1. Create User");
            System.out.println("2. Search User by ID");
            System.out.println("3. Update User by UUID");
            System.out.println("4. Deleted User by uuid");
            System.out.println("5. Display All User");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice){
                case 1 ->{
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    createUser(name, email);
                }
                case 2 ->{
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter UUID: ");
                    String uuid = sc.nextLine();
                    searchUser(uuid);
                }
                case 3 ->{
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter UUID ");
                    String uuid = sc.nextLine();
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String email = sc.nextLine();
                    System.out.print("Mark as deleted (true/false): ");
                    boolean isDeleted = sc.nextBoolean();
                    updateUser(uuid, name, email, isDeleted);
                }
                case 4 ->{
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter UUID ");
                    String uuid = sc.nextLine();
                    deleteUser(uuid);
                }
                case 5 ->{
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter page number: ");
                    int page = sc.nextInt();
                    listUser(page);
                }
                case 6 ->{
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.Please try again.");
            }
        }
    }

}
