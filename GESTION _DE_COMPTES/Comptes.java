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
            system.out.println("Dépôt effectué avec succès.");
        } else{
            system.out.println("Erreur: le montant doit être supérieur à 0.");
        }
    }
    public boolean retirer(double montant){
        if(montant > 0 && solde >= montant){
            solde -= montant;
            system.out.println("retrait effectué avec succès.");
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
        return numero;
    }
    public String getTitulaire(){
        return titulaire;
    }
    public double getSolde(){
        return solde;
    }
    public void setTitulaire(String titulaire){
        this.titulaire= titulaire;;
    }
    protected void debiter(double montant){
        solde -= montant;
    }
}

public class CompteEpargne extends CompteBancaire{
    private  double tauxInteret;
    public CompteEpargne(String numero, String titulaire, double solde, double tauxInteret){
        super(numero, titulaire, solde);
        this.tauxInteret = tauxInteret;
    }
    public double calculerInteret(){
        return getSolde() * tauxInteret;
    }
    public void ajouterInteret(){
        double interets= calculerInteret();
        deposer(interets);
        system.out.println("intérêts ajoutés.";)
    }
    @override
    public boolean retirer(double montant){
        if(montant > 0 && getSolde() - montant >= 10000){
            return super.retirer(montant);
            system.out.println("retrait effectué avec succès.");
        }else{
            system.out.println("Erreur: le solde à conserver est de 10.000 FCFA.");
            return false;
        }
    }
}

public class CompteCourant extends CompteBancaire{
    private double decouvertAutorise;
    public Comptecourant(String numero, String titulaire, double solde, double decouvertAutorise){
        super(numero, titulaire, solde);
        this.decouvertAutorise = decouvertAutorise;
    }
    @override
    public boolean retirer(double montant){
        if(montant > 0 && getSolde() - montant >= decouvertAutorise){
            debiter(montant);
            system.out.println("retrait effectué avec succès.");
        }else{
            system.out.println("Retrait refusé: découvert Autorisé depassé.");
            return false;
        }
    }
    @override
    public void afficher(){
        system.out.println("Type: compte courant");
        super.afficher();
        system.out.println("decouvertAutorise:" +decouvertAutorise+ "FCFA");
    }
}