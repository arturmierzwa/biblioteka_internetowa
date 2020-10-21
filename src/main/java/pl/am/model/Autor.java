package pl.am.model;

import javax.persistence.*;

@Entity

public class Autor {
	
	@Id
    Integer id;
    String imie;
    String nazwisko;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + "]";
	}
    
}
