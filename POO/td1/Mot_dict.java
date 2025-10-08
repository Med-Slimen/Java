public class Mot_dict {
    private String mot;
    private String Definition;
    public Mot_dict(String mot,String def){
        this.mot=mot;
        this.Definition=def;
    }
    public String getMot(){
        return this.mot;
    }
    public String getDefinition(){
        return this.Definition;
    }
    public void setDefinition(String def){
        this.Definition=def;
    }
    public void setMot(String mot){
        this.mot=mot;
    }
    public boolean synonyme(String def){
        return this.Definition==def;
    }
    public boolean synonyme(Mot_dict mot){
        return this.Definition==mot.Definition;
    }
}
