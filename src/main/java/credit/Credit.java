package credit;

public abstract class Credit {

    public float kwota;
    public int liczbaRat;
    public float oprocentowanie;
    public float oplataStala;

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public int getLiczbaRat() {
        return liczbaRat;
    }

    public void setLiczbaRat(int liczbaRat) {
        this.liczbaRat = liczbaRat;
    }

    public float getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(float oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public float getOpłataStała() {
        return oplataStala;
    }

    public void setOpłataStała(float opłataStała) {
        this.oplataStala = opłataStała;
    }
}
