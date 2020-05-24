package services;

import dao.DAO;
import dao.DAOUsersSql;
import entity.User;

import java.util.ArrayList;
import java.util.Random;

public class UserService {

  private final DAO<User> userDAO = new DAOUsersSql();

  public ArrayList<User> likedPeople(int userID){
    StringBuilder sb = new StringBuilder();
    sb.append("select u.id, u.\"e-mail\", u.\"fullName\", u.\"workInfo\" ,u.\"lastLogin\", u.prof_photo ")
            .append("from relations r ")
            .append("inner join users u on r.\"to\" = u.id ")
            .append(String.format("where r.\"from\"= %s AND r.rel = true;",userID));
    return (ArrayList<User>) userDAO.getBySQLQuery(sb.toString());
  }


  public User randomUser(int userID){
    StringBuilder sb = new StringBuilder();
    sb.append("select u.id, u.\"e-mail\", u.\"fullName\", u.\"workInfo\" ,u.\"lastLogin\", u.prof_photo from users u ")
      .append("left join relations r on u.id = r.\"from\" ")
      .append(String.format("where u.id != %s AND ",userID))
      .append("u.id NOT IN ")
      .append(String.format("(select r.\"to\" from relations r where r.\"from\"= %s);",userID));
    Random random = new Random();
    ArrayList<User> noActionUsers = (ArrayList<User>) userDAO.getBySQLQuery(sb.toString());
    return noActionUsers.get(random.nextInt(noActionUsers.size()));
  }

  public boolean containsMail(String email) {
    StringBuilder sb = new StringBuilder();
    sb.append("select u.\"e-mail\" ")
            .append("from users u ")
            .append(String.format("where u.\"e-mail\" = '%s';",email));
    return userDAO.check(sb.toString());
  }

  public boolean checkPass(String email, String password) {
    StringBuilder sb = new StringBuilder();
    sb.append("select u.\"e-mail\" ")
            .append("from users u ")
            .append(String.format("where \"e-mail\" = '%s' AND pass = '%s';",email, password));
    return userDAO.check(sb.toString());
  }

  public int getUserID(String email) {
    String sb = String.format("select u.id from users u where u.\"e-mail\" = '%s';",email);
    return userDAO.getID(sb);
  }

  public boolean relationInteraction(int currUserId, int choosesUserId, boolean b) {
    String sb = String.format("INSERT INTO public.relations (\"from\", \"to\", rel) VALUES (%s, %s, %s);",
            currUserId,
            choosesUserId,
            b ? "true" : "false");
    return userDAO.executeSQL(sb);
  }
}
