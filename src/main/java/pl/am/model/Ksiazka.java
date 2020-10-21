package pl.am.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Ksiazka {
	@Id
    Integer id;
	String tytul;
    String autor_imie;
    String autor_nazwisko;
	Integer rok_wydania;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    Czytelnik czytelnik;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getTytul() {
		return tytul;
	}


	public void setTytul(String tytul) {
		this.tytul = tytul;
	}


	public String getAutor_imie() {
		return autor_imie;
	}


	public void setAutor_imie(String autor_imie) {
		this.autor_imie = autor_imie;
	}


	public String getAutor_nazwisko() {
		return autor_nazwisko;
	}


	public void setAutor_nazwisko(String autor_nazwisko) {
		this.autor_nazwisko = autor_nazwisko;
	}


	public Integer getRok_wydania() {
		return rok_wydania;
	}


	public void setRok_wydania(Integer rok_wydania) {
		this.rok_wydania = rok_wydania;
	}


	public Czytelnik getCzytelnik() {
		return czytelnik;
	}


	public void setCzytelnik(Czytelnik czytelnik) {
		this.czytelnik = czytelnik;
	}


	@Override
	public String toString() {
		return "Ksiazka [id=" + id + ", tytul=" + tytul + ", autor_imie=" + autor_imie + ", autor_nazwisko="
				+ autor_nazwisko + ", rok_wydania=" + rok_wydania + ", czytelnik=" + czytelnik + "]";
	}

}