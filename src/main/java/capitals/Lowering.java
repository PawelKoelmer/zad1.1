package capitals;


import credit.Credit;

public class Lowering extends Credit{

    private float kwotaDoSplaty;
    private float kwotaKapitalu;
    private float kwotaOdsetek;

    public Lowering(float amount, float fixedFee, float interest, int numberOfInstallments) {
        this.kwota=amount;
        this.liczbaRat = numberOfInstallments*12;
        this.oprocentowanie=interest;
        this.oplataStala=fixedFee;
        this.kwotaDoSplaty=amount;
    }


    public float getCapitalAmount() {
        this.kwotaKapitalu=kwota/(liczbaRat);
        return kwotaKapitalu ;
    }

    public float getInterestAmount(int nrRaty) {
        this.kwotaOdsetek=kwotaKapitalu*(1+(liczbaRat-nrRaty+1)*((oprocentowanie/100)/12)) - kwotaKapitalu;
        return kwotaOdsetek;
    }

    public float getKwotaRaty(){
        return kwotaOdsetek+getCapitalAmount()+oplataStala;
    }

}
