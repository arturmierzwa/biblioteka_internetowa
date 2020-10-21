package pl.am.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Czytelnik {
	
	@Id
    Integer id;
	String login;
    String haslo;
    String imie_nazwisko;
    String miasto;
    String ulica;
    String kod;
    String email;
    String telefon;

    @OneToMany(mappedBy = "czytelnik")
    List<Zamowienia> lista_zamowien = new ArrayList<>();
    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    
    
    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie_nazwisko() {
		return imie_nazwisko;
	}

	public void setImie_nazwisko(String imie_nazwisko) {
		this.imie_nazwisko = imie_nazwisko;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Zamowienia> getLista_zamowien() {
		return lista_zamowien;
	}

	public void setLista_zamowien(List<Zamowienia> lista_zamowien) {
		this.lista_zamowien = lista_zamowien;
	}

	@Override
	public String toString() {
		return "Czytelnik [id=" + id + ", login=" + login + ", haslo=" + haslo + ", imie_nazwisko=" + imie_nazwisko
				+ ", miasto=" + miasto + ", ulica=" + ulica + ", kod=" + kod + ", email=" + email + ", telefon="
				+ telefon + ", lista_zamowien=" + lista_zamowien + "]";
	}
}