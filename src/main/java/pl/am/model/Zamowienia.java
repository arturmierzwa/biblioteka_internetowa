package pl.am.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id") //zamienia referencje do obiektu na identyfikator

public class Zamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String data_zamowienia;
    String data_odbioru;
    String data_zwrotu;

    @OneToOne
    Ksiazka ksiazka;
    
    @ManyToOne
    Czytelnik czytelnik;

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_zamowienia() {
        return data_zamowienia;
    }

    public void setData_zamowienia(String data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
    }

    public String getData_odbioru() {
        return data_odbioru;
    }

    public void setData_odbioru(String data_odbioru) {
        this.data_odbioru = data_odbioru;
    }

    public String getData_zwrotu() {
        return data_zwrotu;
    }

    public void setData_zwrotu(String data_zwrotu) {
        this.data_zwrotu = data_zwrotu;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

	@Override
	public String toString() {
		return "Zamowienia [id=" + id + ", data_zamowienia=" + data_zamowienia + ", data_odbioru=" + data_odbioru
				+ ", data_zwrotu=" + data_zwrotu + ", ksiazka=" + ksiazka + ", czytelnik=" + czytelnik + "]";
	}
        
}