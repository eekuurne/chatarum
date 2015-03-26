**Tekoälyille tehtyjä testejä:**

**22.3.2015:**

Testasin ensimmäistä, täysin satunnaisuuteen perustuvaa tekoälyä itseään vastaan. Tavoitteena oli tehdä havaintoja
tasapainosta pelaajien 1 ja 2 välillä. Massatestauksessa oli jonkin verran ongelmia, ja StackOverFlowErroria tuli
aina jos yritin tehdä liian monta testiä kerralla. Pitänee optimoida pelin restarttausta jotenkin, jotta voidaan
suorittaa enemmän testejä kerralla.

Testin tulokset:

Pelaaja 1: 909 voittoa

Pelaaja 2: 1000 voittoa

Pelaajien asetelma tuntuisi olevan siis yllättävän tasainen tällä hetkellä.

**23.3.2015:**

Koodasin uuden tavan testata tekoälyjä vastakkain ja pääsin eroon StackOverFlowErroreista. Nyt tekoälyn testaus
voidaan suorittaa launcherista suoraan kutsumalla AITester-luokkaa ja antaa parametrina tehtävien testien määrä sekä
käytettävät tekoälyt.

Käyttämälläni tietokoneella testipelejä voidaan pelata nyt noin 1 000 000 / 30 sec. Tehtyäni useita testejä tällä määrällä
sekä suuremmilla, totesin että miljoonan testin lopputulos on vakiintunut jo niin lähelle keskiarvoa, että sitä voidaan
käyttää tulevaisuuden testauksessa.

Testin tulokset 10 000 000:lla

Pelaaja 1: 4733002 voittoa

Pelaaja 2: 5266998 voittoa

Pelaajan 1 voitto-häviö ratio: ~0.8986

Pelaajan 2 voitto-häviö ratio: ~1.1128

Peli siis todellakin tuntuu olevan melko tasainen aloitusvuorosta riippumatta. Uusien tekoälyjen kehittämistä voidaan siis
jatkaa tällä asetelmalla, ja kun ollaan päästy tarpeeksi tyydyttävään tekoälyyn, voidaan sen kanssa tehtyjen testien avulla
lähteä tasapainottamaan peliä tarkemmin.
