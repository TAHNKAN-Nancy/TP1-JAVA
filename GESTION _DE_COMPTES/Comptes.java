public class CompteBancaire{
    private String numero;
    private String titulaire;
    private double solde;

    public CompteBancaire(String numero, String titulaire, double solde){
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde;
    }
    public void deposer(double montant){
        if(montant > 0){
            solde += montant;
            system.out.println("Depot effectue avec succes.");
        } else{
            system.out.println("Erreur: le montant doit etre superieur a 0.");
        }
    }
    public boolean retirer(double montant){
        if(montant > 0 && solde >= montant){
            solde -= montant;
            system.out.println("retrait effectuer avec succes.");
            return true;
        }else{
            system.out.println("Erreur: solde insuffisant.");
            return false;
        }
    }
    public void afficher(){
        system.out.println("compte" +numero+ "-" +titulaire+ ":" +solde+ "FCFA");
    }
    public String getNumero(){
        return this.numero;
    }
    public String getTitulaire(){
        return this.titulaire;
    }
    public double getSolde(){
        return this.solde;
    }
    public String setTitulaire(String titulaire){
        this.titulaire= titulaire;;
    }
}