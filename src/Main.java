import model.UserModel;
import controller.UserController;
import view.UserView;

import java.util.Scanner;

/**class User: id (auto generate), uuid(auto generate), name, email, isDeleted
 Create a User management console system:
 1. Create user (when create new user send notification to telegram)
 2. Search user by uuid
 3. Update user by uuid (update: name, email, isDeleted)
 4. Delete user by uuid
 5. Display all users (display as table and can paginate - one page has 5 users and display only users that have isDeleted=false)
 6. Exit*/
public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        UserView view = new UserView();
        UserController controller = new UserController(model, view);
        controller.start();
   }
}