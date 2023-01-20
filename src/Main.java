import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        File f = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file with the players");
        String filename = scanner.nextLine();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            Map<String, List<Card>> map = new HashMap<>();
            while ((line = bufferedReader.readLine())!=null){
                String[] items = line.split(",");
                String name = items[0];
                List<Card> list = new ArrayList<>();
                for (int i = 1; i < items.length; i+=2) {
                    int number = Integer.parseInt(items[i]);
                    int suit = Integer.parseInt(items[i+1]);
                    Card card = new Card(number,suit);
                    list.add(card);
                }
                map.put(name, list);

            }
            List<KeyAndList<String, Card>> list = Util.transform(map);
            Collections.sort(list);
            writeToFile(list);
            System.out.println(list);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found");
            System.exit(1);
        } catch (IOException ioException) {
            // para ver donde se ha cometido el error puedes poner ex.printStackTrace();
            System.err.println("Error writing file");
            System.exit(1);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();

            }
        }
    }

    public static void writeToFile(List<KeyAndList<String,Card>> list) throws IOException{
        ObjectOutputStream objectOutputStream = null;
        try{
            objectOutputStream= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.dat")));
            for (KeyAndList<String, Card> kl : list ) {
                objectOutputStream.writeObject(kl);


            }

        }catch(IOException ex){
            System.err.println("Error reading file");
            System.exit(1);

        }finally {
            if (objectOutputStream != null){
                objectOutputStream.close();
            }
        }


    }
}
