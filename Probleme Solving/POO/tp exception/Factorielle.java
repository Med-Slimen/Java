class Factorielle
{ public static void main (String[] args)
{
    int i, nbEntiers=0, factorielle=1;
    int ancien;
    try{
        nbEntiers= Integer.parseInt(args[0]);
        if (nbEntiers < 0){
            throw new NegativeValueException("Negative value !");
        }
        else if(nbEntiers >= 20){
            throw new SuperieurA20Exception("Valeur superieur 20 !");
        }
        else{
            for (i=2;i<= nbEntiers;i++)
            {
                ancien=factorielle;
                factorielle *= i;
            }
            System.out.println(" Voila la factorielle des "+ nbEntiers +
                    " premiers entiers : "+ factorielle );
        }
    }
    catch(NegativeValueException | SuperieurA20Exception n){
        System.out.print(n.getMessage());
    }
}}