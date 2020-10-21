package pl.am.configuration;

import org.springframework.stereotype.Component;
import pl.am.model.Czytelnik;
import pl.am.model.Ksiazka;
import pl.am.model.Autor;
import pl.am.repositories.CzytelnikRepository;
import pl.am.repositories.AutorRepository;
import pl.am.repositories.KsiazkaRepository;
import javax.annotation.PostConstruct;

@Component
public class DbInitalizer {
    private final CzytelnikRepository czytelnikRepository;
    private final AutorRepository autorRepository;
    private final KsiazkaRepository ksiazkaRepository;

    public DbInitalizer(CzytelnikRepository czytelnikRepository, AutorRepository autorRepository, 
    		KsiazkaRepository ksiazkaRepository) {
		this.czytelnikRepository = czytelnikRepository;
		this.autorRepository = autorRepository;
		this.ksiazkaRepository = ksiazkaRepository;
    }
    
    @PostConstruct
    private void initialize() {
            czytelnikRepository.save(createCzytelnik(1,"msowins", "msowins", "Magdalena Sowińska", "Kraków", "30-362", "ul. Ceglarska 4/101", "msowins@wp.pl","(012)) 664 46 99"));
            czytelnikRepository.save(createCzytelnik(2,"mbabik", "mbabik", "Małgorzata Babik", "Kraków", "31-466", "ul. Akacjowa 4", "mbabik@wp.pl", "609 101 101"));
            czytelnikRepository.save(createCzytelnik(3,"mfibak", "mfibak", "Marta Fibak", "Zielonki", "32-087", "Zielonki 4", "mfibak@wp.pl", "(012)) 622 22 85"));
            czytelnikRepository.save(createCzytelnik(4,"dniemcz", "dniemcz", "Damian Niemczyk", "Słomniki", "32-090", "ul. Niecała 9", "dniemcz@wp.pl", "(012)) 444 44 57"));
            czytelnikRepository.save(createCzytelnik(5,"gurbanik", "gurbanik", "Grzegorz Urbanik", "Wieliczka", "32-020", "ul. Kwiatowa 33", "gurbanik@wp.pl", "609 506 606"));
            czytelnikRepository.save(createCzytelnik(6,"pjurecz", "pjurecz", "Paweł Jureczek", "Wieliczka", "32-020", "ul. Legionów 4/53", "pjurecz@wp.pl","707-709-121"));
            czytelnikRepository.save(createCzytelnik(7,"msrokiew", "msrokiew", "Marcin Srokiewicz", "Kraków", "30-362", "ul. Ceglarska 45/12", "msrokiew@wp.pl", "609 102 102"));
            czytelnikRepository.save(createCzytelnik(8,"bzameck", "bzameck", "Beata Zamecka", "Kraków", "31-450", "ul. Ułanów 21/64", "bzameck@wp.pl", "609 102 105"));
            czytelnikRepository.save(createCzytelnik(9,"gkiwi", "gkiwi", "Gabriela Kiwi","Kraków", "31-464", "ul. Majowa 45/2", "gkiwi@wp.pl", "(012)) 630 00 12"));
            czytelnikRepository.save(createCzytelnik(10,"jkajdeck", "jkajdeck", "Jan Kajdecki", "Krzeszowice", "32-065", "ul. Piastowska 22/45", "jkajdeck@wp.pl", "(012)) 655 77 98"));
            czytelnikRepository.save(createCzytelnik(11,"acygan", "acygan", "Andrzej Cygan", "Kraków", "30-838", "ul. Heleny 24/1", "acygan@wp.pl", "0 609 200 300"));
            czytelnikRepository.save(createCzytelnik(12,"ztylutek", "ztylutek", "Zofia Tylutek", "Kraków", "30-034", "ul. Kościelna 45/100", "ztylutek@wp.pl", "502156877"));
            czytelnikRepository.save(createCzytelnik(13,"msitarz", "msitarz", "Marcin Sitarz", "Wieliczka", "32-020", "ul. Kwiatowa 2", "msitarz@wp.pl", "609 100 101"));
            czytelnikRepository.save(createCzytelnik(14,"ppsiarek", "ppsiarek", "Paulina Psiarek", "Niepołomice", "32-005", "ul. Wielicka 56", "ppsiarek@wp.pl", "0 607 200 201")); 
            czytelnikRepository.save(createCzytelnik(15,"Ilipska", "Ilipska", "Iwona Lipska", "Wieliczka", "32-020", "ul. Urocza 8/7", "Ilipska@wp.pl","515800900")); 
            czytelnikRepository.save(createCzytelnik(16,"mmoraw", "mmoraw", "Małgorzata Morawiec","Krzeszowice", "32-065", "ul. Miła 576/5", "mmoraw@wp.pl", "606874125"));
            czytelnikRepository.save(createCzytelnik(17,"abazarek", "abazarek", "Anna Bazarek", "Kraków", "31-546", "ul. Aleja Pokoju 21/23", "abazarek@wp.pl", "(012)) 611 11 23"));
            czytelnikRepository.save(createCzytelnik(18,"msowin", "msowin", "Marek Sowiński", "Kraków", "30-362", "ul. Ceglarska 4/101", "msowin@wp.pl", "777 401 897"));
            czytelnikRepository.save(createCzytelnik(19,"mpalka", "mpalka", "Monika Pałka", "Kraków", "31-335", "ul. Chabrowa 43", "mpalka@wp.pl","0 502 322 323"));
            czytelnikRepository.save(createCzytelnik(20,"jmichno", "jmichno", "Jacek Michno", "Wieliczka", "32-020", "ul. Urocza 85/7", "jmichno@onet.pl", "(012)) 433 55 56"));
            czytelnikRepository.save(createCzytelnik(21,"llipecki", "llipecki", "Łukasz Lipecki", "Wieliczka", "32-020", "ul. Urocza 7/66", "llipecki@onet.pl", "605 200 200"));
            czytelnikRepository.save(createCzytelnik(22,"dkopera", "dkopera", "Dorota Kopera", "Słomniki", "32-090", "ul. Niecała 6", "dkopera@onet.pl", "620 541 788")); 
            czytelnikRepository.save(createCzytelnik(23,"lwitek", "lwitek", "Łukasz Witek", "Niepołomice", "32-005", "ul. Mała 2", "lwitek@onet.pl", "707 519 873"));
            czytelnikRepository.save(createCzytelnik(24,"bzamecka", "bzamecka", "Barbara Zamecka","Kraków", "31-450", "ul. Ułanów 21/64", "bzamecka@onet.pl","(012)) 634 77 09"));
            czytelnikRepository.save(createCzytelnik(25,"mrusinek", "mrusinek", "Magdalena Rusinek", "Kraków", "30-362", "ul. Ceglarska 78/6", "mrusinek@onet.pl", "505814744"));
            czytelnikRepository.save(createCzytelnik(26,"kkot", "kkot", "Karol Kot","Kraków", "30-383", "ul. Obozowa 44/122", "kkot@onet.pl", "(012)) 677 88 80"));
            czytelnikRepository.save(createCzytelnik(27,"akulfon", "akulfon", "Anna Kulfon", "Krzeszowice", "32-065", "ul. Miła 22/66", "akulfon@onet.pl", "508147741"));
            czytelnikRepository.save(createCzytelnik(28,"ksowa", "ksowa", "Karolina Sowa","Skawina", "32-050", "ul. Miła 3", "ksowa@onet.pl", "(012)) 444 44 44"));
            czytelnikRepository.save(createCzytelnik(29,"azarek", "azarek", "Artur Żarek","Kraków", "30-059", "ul. Aleja A. Mickiewicza 46/75", "azarek@onet.pl", "600485631"));
            czytelnikRepository.save(createCzytelnik(30,"rkapusta", "rkapusta", "Ryszard Kapusta","Kraków", "31-464", "ul. Majowa 1", "rkapusta@onet.pl", "(012)) 645 45 49"));
            czytelnikRepository.save(createCzytelnik(31,"azator", "azator", "Adam Zator", "Kraków", "31-450", "ul. Ułanów 27/52", "azator@onet.pl","(012)) 634 77 09"));
            czytelnikRepository.save(createCzytelnik(32,"gkopicz", "gkopicz", "Grzegorz Kopiczyński","Wieliczka", "32-020", "ul. Os. Kościuszki 12", "gkopicz@onet.pl", "0 502 400 487"));
            czytelnikRepository.save(createCzytelnik(33,"kkorzec", "kkorzec", "Katarzyna Korzecka", "Kraków", "30-383", "ul. Obozowa 57/6", "kkorzec@onet.pl", "(012)) 677 88 88"));
            czytelnikRepository.save(createCzytelnik(34,"wzakon", "wzakon", "Waldemar Zakoniecki", "Skawina", "32-050", "ul. Wrześniowa 44", "wzakon@onet.pl", "(012)) 677 88 89"));
            czytelnikRepository.save(createCzytelnik(35,"akopicz", "akopicz", "Anna Kopiczyńska", "Wieliczka", "32-020", "ul. Os. Kościuszki 12", "akopicz@onet.pl", "0 502 400 487"));
            czytelnikRepository.save(createCzytelnik(36,"mmisiek", "mmisiek", "Maciej Misiek", "Niepołomice", "32-005", "ul. Rynek 5/17", "mmisiek@onet.pl", "(012)) 651 51 52"));
            czytelnikRepository.save(createCzytelnik(37,"kkowal", "kkowal", "Konrad Kowal", "Wieliczka", "32-020", "ul. OSP Trąbki 52", "kkowal@onet.pl", "741589654"));
            czytelnikRepository.save(createCzytelnik(38,"kderen", "kderen", "Karolina Dereń", "Kraków", "30-838", "ul. Heleny 5/23", "kderen@onet.pl", "521 154 444"));
            czytelnikRepository.save(createCzytelnik(39,"zkamien", "zkamien", "Zofia Kamień", "Kraków", "31-990", "ul. Wadowicka 45/22", "zkamien@interia.pl", "606417523"));
            czytelnikRepository.save(createCzytelnik(40,"pzegadlo", "pzegadlo", "Piotr Zegadło", "Bochnia", "32-701", "ul. Wygoda 13/13", "pzegadlo@interia.pl", "(014)) 557 55 66"));
            czytelnikRepository.save(createCzytelnik(41,"pkoper", "pkoper", "Paweł Koper", "Kraków", "30-650", "ul. Makowa 1/19", "pkoper@interia.pl", "0 608 350 334"));
            czytelnikRepository.save(createCzytelnik(42,"mkon", "mkon", "Mariola Kot", "Bochnia", "32-701", "ul. Wygoda 29/1", "mkon@interia.pl", "0 502 100 222"));
            czytelnikRepository.save(createCzytelnik(43,"rrusinek", "rrusinek", "Robert Rusinek", "Kraków", "30-362", "ul. Ceglarska 78/6", "rrusinek@interia.pl", "(012)) 664 44 45"));
            czytelnikRepository.save(createCzytelnik(44,"posa", "posa", "Paulina Osa", "Skawina", "32-050", "ul. Krakowska 4", "posa@interia.pl", "(012)) 442 78 78"));
            czytelnikRepository.save(createCzytelnik(45,"aenglert", "aenglert", "Anna Englert", "Kraków", "31-990", "ul. Wadowicka 3/67", "aenglert@interia.pl", "610 458 732"));
            autorRepository.save(createAutor(1,"Adam", "Mickiewicz"));
            autorRepository.save(createAutor(2,"Juliusz", "Słowacki"));
            autorRepository.save(createAutor(3,"Witold", "Gombrowicz"));
            autorRepository.save(createAutor(4,"Czesław", "Miłosz"));
            autorRepository.save(createAutor(5,"Wisława", "Szymborska"));
            autorRepository.save(createAutor(6,"Władysław", "Reymont"));
            autorRepository.save(createAutor(7,"Olga", "Tokarczuk"));
            autorRepository.save(createAutor(8,"Lew", "Tołstoj"));
            autorRepository.save(createAutor(9,"Michaił", "Bułhakow"));
            autorRepository.save(createAutor(10,"Gustaw", "Flaubert"));
            autorRepository.save(createAutor(11,"Mark", "Twain"));
            autorRepository.save(createAutor(12,"William", "Shakespeare"));
            autorRepository.save(createAutor(13,"Marcel", "Proust"));
            autorRepository.save(createAutor(14,"George", "Orwell"));
            autorRepository.save(createAutor(15,"Gabriel", "Marquez"));
            autorRepository.save(createAutor(16,"James", "Joyce"));
            autorRepository.save(createAutor(17,"Franz", "Kafka"));
            autorRepository.save(createAutor(18,"J.R.R.", "Tolkien"));
            autorRepository.save(createAutor(19,"Andrzej", "Sapkowski"));
            autorRepository.save(createAutor(20,"Dante", "Alighieri"));
            autorRepository.save(createAutor(21,"Ernest", "Hemingway"));
            autorRepository.save(createAutor(22,"Stephen", "Hawking"));
            autorRepository.save(createAutor(23,"Paulo", "Coelho"));
            autorRepository.save(createAutor(24,"Dan", "Brown"));
            ksiazkaRepository.save(createKsiazka(1,"Pan Tadeusz","Adam", "Mickiewicz",2010));
            ksiazkaRepository.save(createKsiazka(2,"Konrad Wallenrod","Adam"," Mickiewicz",1998));
            ksiazkaRepository.save(createKsiazka(3,"Grażyna","Adam", "Mickiewicz",1998));
            ksiazkaRepository.save(createKsiazka(4,"Oda do wolności","Juliusz", "Słowacki",1996));
            ksiazkaRepository.save(createKsiazka(5,"Poezje","Juliusz", "Słowacki",2008));
            ksiazkaRepository.save(createKsiazka(6,"Ferdydurke","Witold", "Gombrowicz",2012));
            ksiazkaRepository.save(createKsiazka(7,"Dolina Issy","Czesław", "Miłosz",2001));
            ksiazkaRepository.save(createKsiazka(8,"Wiersze","Wisława", "Szymborska",1994));
            ksiazkaRepository.save(createKsiazka(9,"Chłopi","Władysław", "Reymont",1991));
            ksiazkaRepository.save(createKsiazka(10,"Ziemia Obiecana","Władysław", "Reymont",1995));
            ksiazkaRepository.save(createKsiazka(11,"Księgi Jakubowe","Olga", "Tokarczuk",2014));
            ksiazkaRepository.save(createKsiazka(12,"Wojna i pokój","Lew", "Tołstoj",2010));
            ksiazkaRepository.save(createKsiazka(13,"Anna Karenina","Lew", "Tołstoj",2011));
            ksiazkaRepository.save(createKsiazka(14,"Mistrz i Małgorzata","Michaił", "Bułhakow",2012));
            ksiazkaRepository.save(createKsiazka(15,"Pani Bovary","Gustaw", "Flaubert",1996));
            ksiazkaRepository.save(createKsiazka(16,"Przygody Tomka Sawyera","Mark", "Twain",1984));
            ksiazkaRepository.save(createKsiazka(17,"Hamlet","William", "Shakespeare",2010));
            ksiazkaRepository.save(createKsiazka(18,"Romeo i Julia","William", "Shakespeare",1995));
            ksiazkaRepository.save(createKsiazka(19,"Makbet","William", "Shakespeare",1989));
            ksiazkaRepository.save(createKsiazka(20,"W poszukiwaniu straconego czasu","Marcel", "Proust",2002));
            ksiazkaRepository.save(createKsiazka(21,"Rok 1984","George", "Orwell",2012));
            ksiazkaRepository.save(createKsiazka(22,"Folwark zwierzęcy","George", "Orwell",2012));
            ksiazkaRepository.save(createKsiazka(23,"Sto lat samotności","Gabriel", "Marquez",2015));
            ksiazkaRepository.save(createKsiazka(24,"Ulisses","James", "Joyce",1992));
            ksiazkaRepository.save(createKsiazka(25,"Proces","Franz", "Kafka",1994));
            ksiazkaRepository.save(createKsiazka(26,"Władca Pierścieni","J.R.R.", "Tolkien",2017));
            ksiazkaRepository.save(createKsiazka(27,"Hobbit, czyli tam i z powrotem","J.R.R.", "Tolkien",2015));
            ksiazkaRepository.save(createKsiazka(28,"Wiedźmin","Andrzej", "Sapkowski",2018));
            ksiazkaRepository.save(createKsiazka(29,"Boska komedia","Dante", "Alighieri",1994));
            ksiazkaRepository.save(createKsiazka(30,"Stary człowiek i morze","Ernest", "Hemingway",1996));
            ksiazkaRepository.save(createKsiazka(31,"Krótka historia czasu","Stephen", "Hawking",2010));
            ksiazkaRepository.save(createKsiazka(32,"Alchemik","Paulo", "Coelho",2012));
            ksiazkaRepository.save(createKsiazka(33,"Kod Leonarda da Vinci","Dan", "Brown",2014));
    }
  
    private Czytelnik createCzytelnik(Integer id,String login,String haslo,String imie_nazwisko,String miasto,String kod,String ulica,String email,String telefon){
        Czytelnik czytelnik = new Czytelnik();
        czytelnik.setId(id);
        czytelnik.setLogin(login);
        czytelnik.setHaslo(haslo);
        czytelnik.setImie_nazwisko(imie_nazwisko);
        czytelnik.setMiasto(miasto);
        czytelnik.setUlica(ulica);
        czytelnik.setKod(kod);
        czytelnik.setEmail(email);
        czytelnik.setTelefon(telefon);
        return czytelnik;
    }
    
    private Autor createAutor(Integer id, String imie, String nazwisko) {
    	Autor autor = new Autor();
    	autor.setId(id);
    	autor.setImie(imie);
    	autor.setNazwisko(nazwisko);
    	return autor;
    }
    
    private Ksiazka createKsiazka(Integer id, String tytul, String autor_imie, String autor_nazwisko, Integer rok_wydania) {
    	Ksiazka ksiazka = new Ksiazka();
    	ksiazka.setId(id);
    	ksiazka.setTytul(tytul);
    	ksiazka.setAutor_imie(autor_imie);
    	ksiazka.setAutor_nazwisko(autor_nazwisko);           
    	ksiazka.setRok_wydania(rok_wydania);
    	return ksiazka;
    }
}
