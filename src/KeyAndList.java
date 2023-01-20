import java.util.List;

public class KeyAndList <K extends Comparable,V> implements Comparable<KeyAndList<K,V>>{

    private K key;
    private List<V> values;
    public KeyAndList(K key, List<V> values){
        this.key = key;
        this.values = values;
    }
    @Override
    public String toString(){
       String result= key+" -> "+values;
       boolean first =true;
        for (V value:values) {
            if (first){
                first = false;
            }else {
                result += ", ";
            }
            result +=value;

        }
        return result;
    }
    @Override
    public int compareTo(KeyAndList<K, V> kv) {
        if(values.size()< kv.values.size()){
            return-1;
        }else{
            if (values.size() > kv.values.size()){
                return 1;
            }else{
                return key.compareTo(kv.key);
            }

        }
    }
}
