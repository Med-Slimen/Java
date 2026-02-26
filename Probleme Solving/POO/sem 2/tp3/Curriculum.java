import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Curriculum {
    private String id;
    private HashMap<String,Integer > Mod_Coef;
    public Curriculum(String s) {
        id=s;
        Mod_Coef= new HashMap<String,Integer >();
    }
    public String getId() {
        return id; }
    public HashMap<String, Integer> getMod_Coef() {
        return Mod_Coef;
    }
    public void addModCoef(String nom,int i){
        Mod_Coef.put(nom,i);
    }
    public int getCoefMod(String s){
        return Mod_Coef.get(s);
    }
    public Set<String> getModSet(){
        return this.getMod_Coef().keySet();
    }
    public String toString(){
        Set<Map.Entry<String,Integer>> set = this.getMod_Coef().entrySet();
        String msg=id+"\n List Des Module avec leurs coefficient : \n";
        for(Map.Entry<String,Integer> e:set){
            msg+=e.getKey()+":"+e.getValue()+" | ";
        }
        return msg;
    }
}
