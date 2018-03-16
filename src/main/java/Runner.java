import db.DBHelper;
import models.Studio;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Paramount Pictures", "Los Angeles", 25000000);
        Studio studio2 = new Studio("20th Century Fox", "Los Angeles", 50000000);
        DBHelper.saveOrUpdate(studio1);
        DBHelper.saveOrUpdate(studio2);



    }
}
