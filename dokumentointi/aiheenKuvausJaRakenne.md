**Aihe:** Korttipeli

Harjoitustyössä toteutettiin korttipeli, jossa kaksi pelaajaa pelaavat toisiaan vastaan pakallisella (30) Minion-kortteja.
Pelaajat nostavat pelin alussa pakastaan 5 korttia käteensä ja jokaisen vuoron alussa yhden. Vuorollaan pelaajat voivat
pelata kädestään kortteja pöytään niin paljon kuin resurssit riittävät ja hyökätä pöydässä olevilla korteilla vastustajan 
pöydässä olevia kortteja. Maksimiresurssit kasvavat joka vuoro 10:llä 80:een asti + pöydässä olevat Worker-kortit. 
Minion-korteilla on Attack- ja Health-arvot, joiden perusteella ne tekevät ja kestävät vahinkoa. Kortti ei voi lähtökohtaisesti 
hyökätä samalla vuorolla kuin se on pelattu pöytään. Vuoron lopuksi jos jokin pöydässä oleva kortti ei ole käyttänyt hyökkäysvuoroaan, 
menettää vastustaja Influencea kortin Attack-valuen verran. Kun toisen pelaajan Influence tippuu 0:aan, hän häviää ja peli loppuu.

Pelaajan vuorolla vastustajan kortit ovat aina piilossa. Vuoron loputtua molempien kortit ovat piilossa, kunnes aloitetaan
seuraava vuoro, jotta näytön äärellä olevaa pelaajaa voidaan vaihtaa ilman, että vastustajan kortit paljastuvat.

Minion-korteilla voi olla erilaisia erikoisominaisuuksia, joista yleisimpiä ovat:

- Melee: ottaa vahinkoa itse hyökätessään
- Ranged: ei ota vahinkoa itse hyökätessään
- Mounted: voi hyökätä samalla vuorolla kuin se on pelattu pöytään
- Guardian: viereisiä kortteja ei voi hyökätä niin kauan kuin Guardian on hengissä
- Deadly: tappaa yhdellä hyökkäyksellä minkä vaan toisen Minionin, mutta ei tee Influence-vahinkoa vastustajaan
- Worker: kasvattaa maksimiresursseja niin kauan kuin Worker on hengissä

Lisäksi Minioneilla voi olla uniikkeja ominaisuuksia esim. pelatessa se pöytään tai sen kuollessa. Tässä versiossa:

- Puppet Master varastaa toiselta pelaajalta satunnaisen kortin pöydästä omaan pöytään 
- Voodoo Priest laittaa pöytään 2 Zombie-korttia kun se pelataan pöytään

Minioneita:

- Archer (ranged)
- Assassin (melee, deadly)
- Axethrower (ranged)
- Militia (melee)
- Moonblade (melee, mounted)
- Peasant (worker)
- Puppet Master (ranged, special)
- Raider (melee, mounted)
- Swordman (melee)
- Voodoo Priest (ranged, special)
- Watchman (melee, guardian)
- Zombie (melee)


**Käyttäjät:** pelaaja 1, pelaaja 2

**Pelaajan toiminnot:**

- Valitse kortti kädestä
- Pelaa valittu kortti pöytään
- Valitse kortti pöydästä
- Hyökkää valitulla kortilla vastustajan korttia
- Lopeta vuoro
- Aloita vuoro


**Laajennusmahdollisuuksia:**

- Korttien zoomaus kun hiirtä pidetään sen yläpuolella
- Valikko, jossa voidaan säätää asetuksia, luoda omia korttipakkoja, valita pelimuoto jne.
- Yksinpeli tekoälyä vastaan
- Moninpeli verkon yli
- Sankarit (Champion), joilla on omia taitoja käytettäväksi
- Ryhmittymät (Faction), joilla on omia uniikkeja kortteja
- Taitokortit (Skill Card)
- Lisää Minion-kortteja
- Animaatiot
- Äänet
- Koodin refaktorointia: esim. hiiren toiminta ei ole kovin optimaalisella tavalla toteutettu. Peli vaatisi myös statet.
- Korttien luominen ohjelmalla elementeistä kokonaan itse piirtämisen sijaan (korttitausta, luvut, tekstit, iconit...)
- Em. mahdollistaisi myös Card editorin luomisen, jolla pelaaja voi itse luoda kortteja halutessaan


**Rakennekuvaus:**

Launcher-luokka pitää sisällään pelin main-metodin ja sen tehtävänä on käynnistää peli. Se luo pelin pohjana toimivan
Runnable rajapintaa hyödyntävän Game-luokan ja antaa sille parametreinä ikkunan koon, pelin nimen ja tehdäänkö
ikkunasta full screen vai windowed. Game siis luo komponentit eli JFrame-kehyksen pelille, UserInterfacen, MouseInputin
ja KeyBoardInputin. Sen tehtävänä on myös kutsua Assets ja Locations -luokkien init()-metodeja, jotka lataavat assetit
ja määrittelevät pelin mittasuhteet. Assets hyödyntää ImageLoaderia lataamaan kuvat tiedostosta ja SpriteSheetiä croppaamaan
yksittäiset kortinkuvat sprite sheeteistä. Assets ja Locations sisältävät paljon public static muuttujia, joita muut luokat
hyödyntävät pelin kuvien ja mittasuhteiden pitämiseen oikeina, eikä niistä tehdä koskaan olioita. 

KeyBoardInput lisätään JFrameen kuuntelemaan näppäimiä ja MouseInput UserInterfaceen kuuntelemaan hiiren painalluksia.
UserInterface pitää huolen pelin graafisten elementtien päivittämisestä ruudulle eli se toimii piirtoalustana. Se hyödyntää 
JPanelia, ja kutsumalla sen repaint()-metodia ruutu päivittyy. Se luo pelin logiikasta vastaavan LogicHandlerin ja välittää
sille hiiren ja näppäimistön inputin.

LogicHandler luo pelin alussa 2 Player oliota pelin pelaajiksi ja DeckBuilderin, jolla se rakentaa Deckit molemmille
pelaajille. LogicHandlerin tehtävänä on hoitaa kaikki pelin logiikka: se saa UserInterfacelta inputtia ja tekee toimintoja
Playereille sen perusteella. Playereillä on parametrinä saadun Deckin lisäksi myös Hand ja Table, jotka kaikki 3 voivat 
sisältää kortteja (Card). Card on abstrakti luokka, jonka tarkoitus on toimia rajapintana Minion-korttien ja myöhemmin
lisättävien muiden korttien välillä. Se voisi olla Interface, mutta se tullaan muuttamaan Componentiksi myöhemmin.
Minion on myös abstrakti luokka, jonka yksittäiset pelin Minion-kortit perivät.
