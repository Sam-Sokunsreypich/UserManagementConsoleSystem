package model;

import java.util.UUID;

/**class User: id (auto generate), uuid(auto generate), name, email, isDeleted
 Create a User management console system:
 1. Create user (when create new user send notification to telegram)
 2. Search user by uuid
 3. Update user by uuid (update: name, email, isDeleted)
 4. Delete user by uuid
 5. Display all users (display as table and can paginate - one page has 5 users and display only users that have isDeleted=false)
 6. Exit*/

public class User {
    private int id;
    private UUID uuid;
    private String name;
    private String email;
    private boolean isDeleted ;
    //constructor
    public User (Builder builder){
        id = builder.id;
        uuid = builder.uuid;
        name = builder.name;
        email = builder.email;
        isDeleted = builder.isDeleted;
    }

    public User() {

    }

    //Create class Builder
    static class Builder{
        private int id;
        private UUID uuid;
        private String name;
        private String email;
        private boolean isDeleted;

        Builder builder(){

            return this;
        }
        Builder setId(int id){
            this.id = id;
            return this;
        }
        Builder setUuid(UUID uuid){
            this.uuid = uuid;
            return this;
        }
        Builder setName(String name){
            this.name = name;
            return this;
        }
        Builder setEmail(String email){
            this.email = email;
            return this;
        }
        Builder setIsDeleted(boolean isDeleted){
            this.isDeleted = isDeleted;
            return this;
        }

        User build(){
            return new User(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
