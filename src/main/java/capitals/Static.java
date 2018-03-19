package capitals;

import credit.Credit;

import static java.lang.Math.pow;

public class Static extends Credit {

    private float kwotaDoSplaty;
    private float kwotaKapitalu;
    private float kwotaOdsetek;
    private float stalaOdsetkowa;
    private float kwotaRaty;

    private float nrRaty;

    public Static(float amount, float fixedFee, float interest, int numberOfInstallments) {
        this.kwota=amount;
        this.liczbaRat = numberOfInstallments*12;
        this.oprocentowanie=interest;
        this.oplataStala=fixedFee;
        this.kwotaDoSplaty=amount;
    }

    public void obliczenia(){
        this.kwotaOdsetek= (float) (kwota*((pow(stalaOdsetkowa,liczbaRat)-(pow(stalaOdsetkowa,(nrRaty-1))))/((pow(stalaOdsetkowa,liczbaRat)-1))*oprocentowanie/(100*12)));
        this.kwotaKapitalu=kwotaRaty-kwotaOdsetek;
    }

    public float getStalaOdsetkowa(){
        this.stalaOdsetkowa = (((oprocentowanie)/100)/12) + 1;
        return stalaOdsetkowa;
    }

    public float getWysokoscRaty(){
        this.kwotaRaty = (float) (kwota*pow(stalaOdsetkowa,liczbaRat) * ((stalaOdsetkowa -1)/ (pow(stalaOdsetkowa,liczbaRat)-1)))+oplataStala;
        return kwotaRaty;
    }



    public float getKwotaOdsetek(){
    return kwotaOdsetek;
    }

    public float getKwotaRaty(){
        return kwotaRaty;
    }
    public void setNrRaty(float nrRaty) {
        this.nrRaty = nrRaty;
    }

    public float getKwotaKapitalu(){

        return kwotaKapitalu;
    }


}
