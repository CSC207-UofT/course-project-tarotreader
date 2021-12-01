import entities.User;
import org.junit.Test;
import java.io.*;

// using the data from the user class to test if data is serializable and deserializable.
// focusing on the creation of a user and checking whether the data is stored in the .ser file

public class UserTest {
    User u = new User();

    public UserTest() {

    }

    @Test
    public void TestSerializableUser(){

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(u);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/user.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Test
    public void TestDeserializableUser(){
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            u = (User) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("User not found");
            e.printStackTrace();
            return;
        }

        System.out.println("Deserialized User...");
        System.out.println("Name: " + u.getUsername());
        System.out.println("Birthday: " + u.getBirthday());
        System.out.println("Password: " + u.getPassword());
    }
}
