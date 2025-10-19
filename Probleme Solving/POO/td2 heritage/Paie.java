public class Paie {
    public static void main(String[] args) {
        Employe[] employees=new Employe[5];
        employees[0]=new Employe_ordinaire("Med");
        employees[0].setInfoSalaire(10,5);
        employees[1]=new Employe_responsable(60,3,"Ayoub");
        employees[2]=new Employe_commerciaux("3abd jalil",20,30);
        employees[3]=new Employe_commerciaux("mo7sen",20,30);
        employees[4]=new Employe_commerciaux("asma",20,30);
        for (Employe e: employees){
            System.out.println(e.getNom()+" gaangne "+e.getSalaireEmp()+" D");
        }

    }
}
