package cs102.pz;


public class Knjiga {
    private int ID;
    private String naziv;
    private String autor;
    private String godinaIzdanja;

    public Knjiga(int ID, String naziv, String autor, String godinaIzdanja) {
        this.ID = ID;
        this.naziv = naziv;
        this.autor = autor;
        this.godinaIzdanja = godinaIzdanja;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(String godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    @Override
    public String toString() {
        return "Knjiga{" + "ID=" + ID + ", naziv=" + naziv + ", autor=" + autor + ", godinaIzdanja=" + godinaIzdanja + '}';
    }
    
    

}