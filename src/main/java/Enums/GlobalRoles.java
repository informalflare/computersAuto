package Enums;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ozaporozhets on 13-Apr-16.
 */
public enum  GlobalRoles {;

  private String value;
  private String email;
  private String password;

  GlobalRoles(String value, String email, String password) {
    this.value = value;
    this.email = email;
    this.password = password;
  }

  public String getValue() {
    return value;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }


  public static String SetPassword()  {
    Properties props = new Properties();
    try {
      props.load(new FileInputStream("src/main/resources/project.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return props.getProperty("password");
  }

}
