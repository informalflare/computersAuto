package Utils;

import org.openqa.selenium.WebElement;

/**
 * Created by ozaporozhets on 26-Jul-16.
 */
  public class FileUpload
  {
    public  FileUpload(WebElement btnUpload, String filename) throws Exception  {
      String path = System.getProperty("mail.dir") + "/src/main/testdata/" + filename;
      System.out.println(path);
      btnUpload.sendKeys(path);
  }
}
