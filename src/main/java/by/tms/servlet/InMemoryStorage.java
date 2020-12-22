package by.tms.servlet;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private static List<User> users = new ArrayList<>();
     static int userId;
     public void addUser(User user){
         user.setId(userId);
         userId++;
         users.add(user);
     }

    public User getByLogin(String login)
    {
        for(User user:users)
        {
            if(user.getLogin().equals(login))
            {
                return  user;
            }
        }
        return null;
    }
}
