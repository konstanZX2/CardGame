import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainReadFile {
    public static void main(String[] args) {

    }
    public static KeyAndList<String,Card>[] readFromFile(String filename) throws IOException {
        ObjectInputStream objectInputStream = null;
        KeyAndList<String,Card>[] arrayKV;
        List<KeyAndList<String,Card>> list = new ArrayList<>();
        try{
           objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
           while(true){


               KeyAndList<String,Card> kl = (KeyAndList<String, Card>) objectInputStream.readObject();
               list.add(kl);
           }
           arrayKV = new KeyAndList<String,Card>[list.size()];
           return (KeyAndList<String, Card>[]) list.toArray();
        }catch (ClassNotFoundException classNotFoundException){
        System.exit(1);

    }catch (EOFException ex) {
            System.exit(1);

        }finally{
            if (objectInputStream!=null){
                objectInputStream.close();
            }
        }
    }
}
