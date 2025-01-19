package model;

import notify.TelegramNotification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserModel {
    private final List<User> users = new ArrayList<>();
    private int nextId = 1;
    TelegramNotification telegramNotifier = new TelegramNotification();


    public void addNewUser(String name,String email) {
        User user = new User.Builder()
                .setId(nextId++)
                .setUuid(UUID.randomUUID())
                .setName(name)
                .setEmail(email)
                .build();
        users.add(user);

        telegramNotifier.sendNotification("New user created: Name = " + name + ", Email = " + email);

    }
    public User findUserByUuid(String uuid){
        uuid = uuid.trim();
       for (User user : users){
           if(uuid.equalsIgnoreCase(user.getUuid().toString())){
               return user;
           }
       }
       return null;
    }
    public boolean updateUser(String uuid,String name, String email, boolean isDeleted){
        User user = findUserByUuid(uuid);
        if(uuid != null){
            users.remove(user);
            User updateUser = new User.Builder()
                    .setId(user.getId())
                    .setUuid(user.getUuid())
                    .setName(name)
                    .setEmail(email)
                    .setIsDeleted(isDeleted)
                    .build();
            users.add(updateUser);
            return true;
        }
        return false;
    }
    public boolean deletedUser(String uuid){

            return updateUser(uuid,null,null,true);
    }
    public List<User> getAllActiveUser(int page,int pageSize){
        return users.stream()
                .filter(user -> !user.isDeleted())
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }
    private void sendTelegramNotification(User user){
        System.out.printf("Telegramnotification sent: New user created - %s\n", user);
    }

    public List<User> getUsers() {
        return users;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }
}
