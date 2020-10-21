package pl.am.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;  //GetMapping, PostMapping i inne

import pl.am.repositories.AutorRepository;
import pl.am.repositories.CzytelnikRepository;
import pl.am.repositories.KsiazkaRepository;
import pl.am.repositories.ZamowieniaRepository;
import pl.am.model.Czytelnik;
import pl.am.model.Ksiazka;
import pl.am.model.Zamowienia;
import pl.am.model.Autor;

@RestController
@RequestMapping(path="/biblioteka") // This means URL's start with /biblioteka (after Application path)

public class IndexController {
    private final CzytelnikRepository czytelnikRepository;
    private final AutorRepository autorRepository;
    private final KsiazkaRepository ksiazkaRepository;
    private final ZamowieniaRepository zamowieniaRepository;

    public IndexController( CzytelnikRepository czytelnikRepository, AutorRepository autorRepository, KsiazkaRepository ksiazkaRepository,
    		ZamowieniaRepository zamowieniaRepository) {    
        this.czytelnikRepository = czytelnikRepository;
        this.autorRepository = autorRepository;
        this.ksiazkaRepository = ksiazkaRepository;
        this.zamowieniaRepository = zamowieniaRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "Witaj w bibliotece!" + "<br>"
        		+ "STRONA STARTOWA BIBLIOTEKI: localhost:8080/biblioteka/index.html" + "<br>"
        		+ "STRONA STARTOWA PROJEKTU: localhost:8080";     		
    }
    
    @GetMapping("/czytelnik")
    public Iterable<Czytelnik> czytelnicy() {
        return czytelnikRepository.findAll();
    }
    
    @GetMapping("/autor")
    public Iterable<Autor> autorzy() {
        return autorRepository.findAll();
    }
    
    @GetMapping("/ksiazka")
    public Iterable<Ksiazka> ksiazki() {
        return ksiazkaRepository.findAll();
    }
    
    @GetMapping("/zamowienia")
    public Iterable<Zamowienia> zamowienia() {
        return zamowieniaRepository.findAll();
    }
    
    
    @GetMapping(value = "/autor-ksiazka")
    public Map<String, List<String>> autorzyIKsiazki() {
        Map<String, List<String>> autorzy = new HashMap<>();
        for (Ksiazka ksiazka : ksiazkaRepository.findAll()) {
            String autor = ksiazka.getAutor_imie() + " " + ksiazka.getAutor_nazwisko();
            List<String> ksiazki = autorzy.computeIfAbsent(autor, (key) -> new ArrayList<>());
            ksiazki.add("id: " + ksiazka.getId() + " Tytuł: " + ksiazka.getTytul());
        }
        return autorzy;
    }
        
        @PostMapping("/zamowienia/potwierdzenie")
        public void PostZamowienie(
                @RequestParam("id_czytelnik") Integer idCzytelnik,
                @RequestParam("id_ksiazka") Integer idKsiazka,
                @RequestParam("data_zamowienia") String dataZamowienia,
                @RequestParam("data_odbioru") String dataOdbioru,
                @RequestParam("data_zwrotu") String dataZwrotu,
                HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	PrintWriter out = response.getWriter();
        		
        	Optional<Czytelnik> czytelnik = czytelnikRepository.findById(idCzytelnik);
            if (czytelnik.isEmpty()) {
            	out.println("BLAD! Nie ma czytelnika o numerze ID: " + idCzytelnik);
            	out.println("Zamówienie NIE ZOSTALO przyjete!");
            	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
            	return;
            }
            
            Optional<Ksiazka> ksiazka = ksiazkaRepository.findById(idKsiazka);
            if (ksiazka.isEmpty()) {
            	out.println("BLAD! Nie ma książki o numerze ID: " + idKsiazka);
            	out.println("Zamówienie NIE ZOSTALO przyjete!");
            	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
            	return;
            }
            
            out.println("Potwierdzenie detali zamówienia:");
        	out.println("ID czytelnika: " + idCzytelnik);
        	out.println("ID ksiazki: " + idKsiazka);
        	out.println("Data zamówienia: " + dataZamowienia);
        	out.println("Data odbioru: " + dataOdbioru);
        	out.println("Data zwrotu: " + dataZwrotu);
        
    		Zamowienia zamowienia = new Zamowienia();
    		zamowienia.setCzytelnik(czytelnik.get());
            zamowienia.setKsiazka(ksiazka.get());
            zamowienia.setData_zamowienia(dataZamowienia);
            zamowienia.setData_odbioru(dataOdbioru);
            zamowienia.setData_zwrotu(dataZwrotu);
            zamowieniaRepository.save(zamowienia);
    		out.println("Zamówienie zostalo przyjete! UWAGA: Ksiazke nalezy odebrac w dniu: "+ dataOdbioru +" !");
    		out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
        }
    	
        @PostMapping("/czytelnik_wyszukaj")
        public void WyszukajCzytelnika(
                @RequestParam("id") Integer id,
                HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	PrintWriter out = response.getWriter();
        	System.out.println("POCZATEK");
        	
        	
        	Optional<Czytelnik> czytelnik = czytelnikRepository.findById(id);
            if (czytelnik.isEmpty()) {
            	out.println("BLAD! Nie ma takiego czytelnika " + id);
            	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
            	return;
            }
            
            czytelnikRepository.findById(id);
            out.println(czytelnikRepository.findById(id));
        }
        
        
        @PostMapping("/zamowienia/usuniecie")
        public void DeleteZamowienie(
                @RequestParam("id") Long id,
                HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	PrintWriter out = response.getWriter();
        	
        	Optional<Zamowienia> zamowienia = zamowieniaRepository.findById(id);
            if (zamowienia.isEmpty()) {
            	out.println("BLAD! Nie ma zamowienia o numerze ID: " + id);
            	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
            	return;
            }
            
            out.println("Potwierdzenie detali usuwanego zamowienia:");
        	out.println("ID zamowienia: " + id); 
        	out.println("Zamówienie o numerze ID: "+ id +" zostalo usuniete!");
    		out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
    		
    		zamowieniaRepository.deleteById(id);
        }
        
        @PostMapping("/ksiazka/dodanie")
        public void PostKsiazka(@RequestParam("id") Integer id,
                @RequestParam("tytul") String tytul,
                @RequestParam("autor_imie") String autorImie,
                @RequestParam("autor_nazwisko") String autorNazwisko,
                @RequestParam("rok_wydania") Integer rokWydania,
                HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	PrintWriter out = response.getWriter();
        	out.println("Potwierdzenie detali nowej ksiazki:");
        	out.println("ID ksiazki: "+ id);
        	out.println("Tytul ksiazki: " + tytul);
        	out.println("Autor ksiazki(imie): " + autorImie);
        	out.println("Autor ksiazki(nazwisko): " + autorNazwisko);
        	out.println("Rok wydania ksiazki: " + rokWydania);
        	      	
        	Ksiazka ksiazka = new Ksiazka();
        	ksiazka.setId(id);
        	ksiazka.setTytul(tytul);
        	ksiazka.setAutor_imie(autorImie);
        	ksiazka.setAutor_nazwisko(autorNazwisko);
        	ksiazka.setRok_wydania(rokWydania);
        	ksiazkaRepository.save(ksiazka);
        	out.println("Ksiazka o numerze ID " + id + " zostala dodana do bazy danych KSIAZKI");
        	out.println("Jesli to jest nowy autor, pamietaj o zapisaniu go w DOSTEPNE OPCJE --> DODAWANIE AUTORA DO BAZY DANYCH!");
        	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
        }
        
        @PostMapping("/autor/dodanie")
        public void PostAutor(
        		@RequestParam("id") Integer id, 
        		@RequestParam ("autor_imie") String imie,
        		@RequestParam("autor_nazwisko") String nazwisko,
                HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        		
            PrintWriter out = response.getWriter();
            out.println("Potwierdzenie detali nowego autora:");
            out.println("ID autora: "+ id);
            out.println("Imie autora: " + imie);
            out.println("Nazwisko autora: " + nazwisko);
        	
        	Autor autor = new Autor();
        	autor.setId(id);
        	autor.setImie(imie);
        	autor.setNazwisko(nazwisko);
        	autorRepository.save(autor);
        	out.println("Autor o numerze ID " + id + " zostal dodany do bazy danych AUTORZY");
        	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
        	 	
        }
        
        @PostMapping("/czytelnik/dodanie")
        public void PostCzytelnik(
        		@RequestParam("id") Integer id, 
        		@RequestParam ("login") String login,
        		@RequestParam("haslo") String haslo,
        		@RequestParam("imie_nazwisko") String imieNazwisko, 
        		@RequestParam ("miasto") String miasto,
        		@RequestParam("ulica") String ulica,
        		@RequestParam("kod") String kod, 
        		@RequestParam ("email") String email,
        		@RequestParam("telefon") String telefon,
        		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
            PrintWriter out = response.getWriter();
            out.println("Potwierdzenie detali nowego czytelnika:");
            out.println("ID: "+ id);
            out.println("Login: " + login);
            out.println("Haslo: " + haslo);
            out.println("Imie i nazwisko: " + imieNazwisko);
            out.println("Miasto: " + miasto);
            out.println("Ulica: " + ulica);
            out.println("Kod pocztowy: " + kod);
            out.println("E-mail: " + email);
            out.println("Telefon: " + telefon);
        	
        	Czytelnik czytelnik = new Czytelnik();
        	czytelnik.setId(id);
        	czytelnik.setLogin(login);
        	czytelnik.setHaslo(haslo);
        	czytelnik.setImie_nazwisko(imieNazwisko);
        	czytelnik.setMiasto(miasto);
        	czytelnik.setUlica(ulica);
        	czytelnik.setKod(kod);
        	czytelnik.setEmail(email);
        	czytelnik.setTelefon(telefon);
        	czytelnikRepository.save(czytelnik);
            	
        	out.println("Czytelnik o numerze ID " + id + " zostal dodany do bazy danych CZYTELNICY");
        	out.println("Kliknij strzalke \"WSTECZ\" zeby przejsc do poprzedniego ekranu.");
        }
}
