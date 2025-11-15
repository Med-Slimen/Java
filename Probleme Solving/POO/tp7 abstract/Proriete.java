abstract class Proriete {
    protected int id;
    protected Person responsable;
    protected String adress;
    protected double surface;
    public Proriete(int id, Person responsable, String adress, double surface) {
        this.id = id;
        this.responsable = responsable;
        this.adress = adress;
        this.surface = surface;
    }
    @Override
    public String toString() {
        return "ID : "+id+" | Responsable "+responsable+" | Adress : "+adress+" | Surface : "+surface;
    }
    abstract double calcullmport();
}
