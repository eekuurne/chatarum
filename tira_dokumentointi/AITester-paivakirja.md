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

Pelaajan 1 voitto-häviö-ratio: ~0.8986

Pelaajan 2 voitto-häviö-ratio: ~1.1128

Peli siis todellakin tuntuu olevan melko tasainen aloitusvuorosta riippumatta. Uusien tekoälyjen kehittämistä voidaan siis
jatkaa tällä asetelmalla, ja kun ollaan päästy tarpeeksi tyydyttävään tekoälyyn, voidaan sen kanssa tehtyjen testien avulla
lähteä tasapainottamaan peliä tarkemmin.

**24.3.2015:**

Tein lisää testejä SimpleAI:lla ja kokeilin saisiko peliä vielä tasapainotettua pienillä muutoksilla. Totesin mm. että 
pelaajan 2 5 enemmän resursseja joka vuoro on erittäin hyvä tasoittava tekijä, sillä poistamalla sen saatiin tulokset:

Pelaaja 1: 722055

Pelaaja 2: 277945

Pelaajan 1 voitto-häviö-ratio: 2.597834

Pelaajan 2 voitto-häviö-ratio: 0.38493606

Vähentämällä molempien pelaajien aloituskortteja yhdellä:

Pelaaja 1: 447335 voittoa

Pelaaja 2: 552665 voittoa

Pelaajan 1 voitto-häviö-ratio: 0.8094144

Pelaajan 2 voitto-häviö-ratio: 1.2354611

Ottamalla pois pelaajan 2 ylimääräisen aloituskortin saatiin seuraavat tulokset:

Pelaaja 1: 604888 voittoa

Pelaaja 2: 395112 voittoa

Pelaajan 1 voitto-häviö-ratio: 1.5309279

Pelaajan 2 voitto-häviö-ratio: 0.6531986

Muuttamalla maxInfluenceksi 15, 25, 30 tai 35 ei ollut mitään vaikutusta pelaajien tasapainoon. 20:llä pelien pituus tuntuisi
sopivalta, joten se pidettäköön toistaiseksi.

Lisäämällä molempien pelaajien aloituskortteja yhdellä (pelaaja 1: 8, pelaaja 2: 9):

Pelaaja 1: 500190 voittoa

Pelaaja 2: 499810 voittoa

Pelaajan 1 voitto-häviö-ratio: 1.0007603

Pelaajan 2 voitto-häviö-ratio: 0.9992403

Kauheasti tämän tasaisemmaksi ei peli enää voi mennä, ja suuri aloituskorttien määrä vähentää myös tuurin osuutta pelin 
lopputuloksesta. Näillä arvoilla jatketaan siis pelin kehittämistä eteenpäin:

Max influence: 20

Max resources: 100

Max turn resources: 80

Pelaajan 1 aloituskortit: 8

Pelaajan 2 aloituskortit: 9

Resurssien kasvu per vuoro: 10

Pelaajan 1 aloitusresurssit: 10

Pelaajan 2 aloitusresurssit: 15

**25.3.2015:**

**Voittovuoron tarkistus: checkLethal**

Tein ominaisuuden, jolla tekoäly tarkistaa aina vuoron alussa voiko se voittaa sillä vuorolla ja se viimeistelee 
pelin jos mahdollista. Testasin antaa ominaisuuden pelaajalle 1 seuraavilla tuloksilla:

Pelaaja 1: 5081432 voittoa

Pelaaja 2: 4918568 voittoa

Pelaajan 1 voitto-häviö-ratio: 1.033112

Pelaajan 2 voitto-häviö-ratio: 0.9679492

Ja pelaajalle 2 seuraavilla tuloksilla:

Pelaaja 1: 4956593 voittoa

Pelaaja 2: 5043407 voittoa

Pelaajan 1 voitto-häviö-ratio: 0.98278666

Pelaajan 2 voitto-häviö-ratio: 1.0175148

Molemmille pelaajille:

Pelaaja 1: 5028758 voittoa

Pelaaja 2: 4971242 voittoa

Pelaajan 1 voitto-häviö-ratio: 1.0115697

Pelaajan 2 voitto-häviö-ratio: 0.9885626

Näiden testien perusteella voidaan todeta, että checkLethal selvästi parantaa AI:n voittomahdollisuuksia, ja se antaa 
hieman enemmän etua aloittavalle pelaajalle. Testien perusteella voidaan todeta ominaisuus kannattavaksi, ja se annetaan
jatkossa kaikille uusille AI:lle (SimpleAI pysyy ennallaan, koska sen tarkoitus on perustua täysin satunnaisuuteen). 
Loogisesti ajateltuna "jos pelaaja voi voittaa tällä vuorolla, niin voita" on myöskin perus käytäntö pelissä kuin pelissä,
ja tekoäly vaikuttaisi hölmöltä ilman sitä. Se myös lyhentää pelejä.

Tässä vaiheessa checkLethal metodi on melko optimaalinen, mutta siihen voitaisiin vielä lisätä ominaisuus, jossa omia
pienen damagen kortteja tuhotaan pöydästä ja tehdään tilaa paremmille mounted-korteille, mutta tapaukset joissa tästä
on hyötyä ovat erittäin harvinaisia. Tällä tuskin olisi suurta vaikutusta, se hidastaisi testejä ja se on myös toimintaa
jota moni pelaajakaan ei itse tajuaisi tehdä. Sen lisäystä voidaan harkita lopulliselle parhaalle tekoälylle.

Toinen mahdollinen lisäys olisi optimoida mounted-minionien tekemä damage etsimällä paras mahdollinen yhdistelmä kädestä.
Se tullaan varmasti lisäämään paremmille tekoälyille.

**26.3.2015:**

Testasin vielä miten tekoäly käyttäytyy jos siltä poistaa toisen playTablen alusta, jolloin välillä voi käydä niin että
pöytä on täynnä -> ei pelata kortteja kädestä -> pöytä tyhjenee kun minionit hyökkää, mutta enää ei pelata kortteja.
Poistettiin pelaajalta 1:

Pelaaja 1: 491689 voittoa

Pelaaja 2: 508311 voittoa

Pelaajan 1 voitto-häviö-ratio: 0.9672995

Pelaajan 2 voitto-häviö-ratio: 1.033806

Silläkin on siis selvästi vaikutusta. Toisaalta jos playTablen poistaa lopusta, eli mounted minionit ei koskaan hyökkää
sillä vuorolla minioneita kun ne pelataan:

Pelaaja 1: 391971 voittoa

Pelaaja 2: 608029 voittoa

Pelaajan 1 voitto-häviö-ratio: 0.6446584

Pelaajan 2 voitto-häviö-ratio: 1.5512091

Sillä on jo suurempi vaikutus.

**31.3.2015:**

**Minioneiden järjestys pöydällä**

(Testit 100 000 000 pelillä).

Alkuperäinen MediumAI vs. MediumAI pelaajan 1 voitto-häviö-ratio: 1.0115697

Koodasin metodin, jolla minionit laitetaan pöytään tietyssä järjestyksessä satunnaisuuden sijaan: järjestys lisää todennäköisyyttä
että Guardian suojaa muita minioneita, mutta ei tee sitä vielä optimaalisesti. Se kuitenkin antoi seuraavat tulokset aiempaa
MediumAI toteutusta vastaan:

Pelaajan 1 voitto-häviö-ratio: 1.1545196

Eli ero on jo huomattava. Seuraavaksi koodattiin mukaan vielä ominaisuus, joka tarkistaa guardiania laitettaessa onko ennalta määrätyn
paikan vieressä oikeasti toinen minion:

Pelaajan 1 voitto-häviö-ratio: 1.1594834

Sitten lisättiin vielä muille minioneille ominaisuus, että ne pelataan guardianin viereen jos mahdollista:

Pelaajan 1 voitto-häviö-ratio: 1.1598407


**1.4.2015:**

Testailin lisää MediumAI:n metodeja vaihtelemalla tehtävien asioiden järjestystä jne. Kaikki toimenpiteet
kuitenkin huononsivat voittoprosenttia, joten jätin muutokset tekemättä.


**2.4.2015:**

Testasin vielä tehdyn MediumAI-toteutuksen vanhaa SimpleAI:ta vastaan seuraavilla tuloksilla:

MediumAI:n voitto-häviö-ratio: 1.1899377

**17.4.2015:**

Kehitin seuraavaa AI:ta ja testasin playTurnia, jossa minionit pyrkivät aluksi hyökkäämään kohteita joiden health on sama kuin
hyökkääjän attack ja sitten vasta jäljellejääneet hyökkäävät randomilla. Korttien pelaaminen pöytään tapahtui järjestyksessä ABEmpty:

TestAI:n voitto-häviö-ratio MediumAI:ta vastaan: 1.7367374

Kehityksessä ollaan siis selvästi menty oikeaan suuntaan.

Lisäsin ominaisuuden, jolla hyökkääjä yrittää hyökätä kohdetta, joka ei tapa hyökkääjää jos em. ei onnistu:

TestAI:n voitto-häviö-ratio MediumAI:ta vastaan: 1.6594691

Tämä ei siis selvästi ole hyvä juttu, joten se jätetään toteuttamatta. Seuraavaksi kokeilin ominaisuutta, jossa em. jälkeen yritetään
hyökätä vielä minioneita, joiden health on vähemmän kuin hyökkääjän attack:

TestAI:n voitto-häviö-ratio MediumAI:ta vastaan: 1.8439664

Poistin random hyökkäyksen tableAttackin ja playABEmptyn välistä:

TestAI:n voitto-häviö-ratio MediumAI:ta vastaan: 1.8464086

Poistin sen myös vuoron lopusta:

TestAI:n voitto-häviö-ratio MediumAI:ta vastaan: 1.844671

Kun lisättiin ominaisuus, että AI pelaa ensisijaisesti mounted minionit, jos ne voivat sillä vuorolla tappaa toisen minionin. Voittprosentti laski
1.820409:een, mutta ominaisuus kuitenkin vaikuttaa hyvältä. Kokeillaan vielä pelata AI:lla jolla se on AI:ta vastaan jolla sitä ei ole. Aloitetaan
kokeilemalla miten pelaajien 1 ja 2 voittoprosentit käyttäytyvät tällä toteutuksella (ilman mounted ominaisuutta):

Pelaajan 1 voitto-häviö-ratio: 1.0209941

Pelaajan 2 voitto-häviö-ratio: 0.9794376

Vaihdetaan pelaajalle 2 playMountedToKill-ominaisuus:

Pelaajan 1 voitto-häviö-ratio: 0.8753391

Pelaajan 2 voitto-häviö-ratio: 1.1424145

Tässä testissä nähdäänkin, että ominaisuus paransi huomattavasti tekoälyä, kun ne muuten ovat identtiset. Pidetään siis ominaisuus. 

Päivän päätteeksi kokeilin vielä kehityksen tässä vaiheessa olevaa AdvancedAI:ta vanhaa SimpleAI:ta vastaan:

Pelaajan 1 voitto-häviö-ratio: 2.266045 (AdvancedAI)

Pelaajan 2 voitto-häviö-ratio: 0.44129747 (SimpleAI)








