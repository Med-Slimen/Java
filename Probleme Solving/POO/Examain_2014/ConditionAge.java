public class ConditionAge implements ConditionAcces {
    private int ageMin;
    public ConditionAge(int ageMin) {
        this.ageMin = ageMin;
    }
    public boolean accesPossible(Pers p) {
        if(p.getAge()<this.ageMin){
            return false;
        }
        return true;
    }
    public int getAgeMin() {
        return ageMin;
    }
}
