package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class User {
  int ID;
  String email;
  String fullName;
  LocalDateTime lastLogin;
  String workInfo = "";
//  String password;
  String photo;


  public User(int ID, String email, String fullName, String workInfo, LocalDateTime lastLogin, String photo) {
    this.ID = ID;
    this.email = email;
    this.fullName = fullName;
    this.workInfo = workInfo;
    this.lastLogin = lastLogin;
    this.photo = photo;
  }
  public String getFullName(){
    return this.fullName;
  }

  public String getPhoto(){
    return this.photo;
  }

  public int getID() {
    return ID;
  }

  public String getLastLogin() {
    return lastLogin.toLocalDate().toString();
  }

  public String getWorkInfo() {
    return workInfo;
  }

  public String daysAfterLogin(){
    return String.valueOf(DAYS.between(this.lastLogin.toLocalDate(), LocalDate.now()));
  }
}
