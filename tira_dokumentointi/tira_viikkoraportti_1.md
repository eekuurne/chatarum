**Viikkoraportti 1: 21.3.2015 - 27.3.2015:**

**Mitä olen tehnyt tällä viikolla?**

Viikon tavoitteena oli koodata ensimmäinen toimiva tekoäly, toiminnallisuus millä tekoälyn 
voi liittää peliin sekä keino testata tekoälyjä vastakkain helposti niiden arvioimiseksi.
Työskentelinkin koko viikon näiden ominaisuuksien parissa, ja käytin aikaa n. 22h tasaisesti 
jaettuna ympäri viikkoa.

**Miten ohjelma on edistynyt?**

Ohjelma edistyi huomattavasti viikon aikana: koodasin ja kommentoin loppuun isäntäluokan AI:lle,
tein ensimmäisen AI:n jonka nimesin SimpleAI:ksi, muutin LogicHandlerin ja Launcherin rakennetta niin, 
että AI voidaan helposti lisätä peliin (toistaiseksi) muokkaamalla Launcherin parametrejä ja koodasin
AITester-luokan, joka pyörittää suuria määriä pelejä, joissa AI:t pelaavat keskenään ja antaa palautteena
molempien voittojen määrät. Lisäksi tein paljon testejä tällä toteutuksella, ja vaihtelin pelin arvoja
tasapainottaakseni aloittavan ja toisen pelaajan voittoja.

AI-luokka on siis abstrakti luokka, jonka kaikki peliin lisättävät AI:t perivät. Peli kutsuu AI-luokan
playTurn()-metodia pelaajan lopettaessa vuoronsa, ja metodin tehtävänä on pelata vuoro. AI-luokkaan
on myös lisätty protected metodeja, joita moni erilainen AI-toteutus saattaisi hyödyntää, sekä muutama
oliomuuttuja, jotka kaikilla AI:lla on.

SimpleAI on ensimmäinen käytännön tekoälyn toteutus. Se tekee kaikki valintansa perustuen satunnaisuuteen,
ja osaa pelata Minion-kortteja pöytään. Päätin tässä vaiheessa jättää uudet ja vielä hyvin vajaat ja
vähän testatut Spell-kortit kokonaan pois pelistä tämän kurssin ajaksi selkeyden vuoksi.

AITester luokka tarjoaa metodin runTests(int amount), joka pelaa parametrina annetun luvun verran matseja
konstruktorissa annetuiden tekoälyjen välillä, ja tulostaa molempien voitot ja voitto-häviö-ratiot. Luokka
pyörittää peliä ilman käyttöliittymää, ja se pystyy suorittamaan noin 1 000 000 peliä / 30s. Pyörittelin
AITesterillä testejä, joissa SimpleAI:t pelasivat keskenään ja vaihtelin pelin eri arvoja tasapainottaakseni
peliä hieman. Aloin pitää päiväkirjaa tekemistäni testeistä, ja niistä löytyy tarkemmin tiedostosta 
"AITester-paivakirja". Totesin testien lopuksi pelaajan 1 ja 2 olevan erittäin hyvin tasapainossa näillä AI:lla.

Aloitin myös seuraavan tekoälyn koodausta, ja teinkin metodin nimeltä checkLethal(), joka tarkistaa voiko
AI voittaa sillä vuorolla ja voittaa jos mahdollista. Se lisäsi voittoprosenttia hieman testeissä, ja sitä
voisi optimoida vielä laskemalla optimaalisen yhdistelmän kädestä pelattavia Mounted-kortteja maksimidamagen
saavuttamiseksi.

**Mitä opin tällä viikolla?**

Ennen tätä viikkoa en osannut vielä täysin ajatella miten tekoäly voitaisiin käytännössä liittää peliini ja
miten niitä voitaisiin testata hyvin keskenään. Kokeilemalla useita ratkaisuja viikon aikana sain kuitenkin
aikaan mielestäni erittäin hyvät toteutukset, ja tämän oppiminen oli mielestäni viikon tärkein saavutus.

**Mikä jäi epäselväksi tai tuottanut vaikeuksia?**

Suurin haaste tuntuisi olevan siinä, että luomani peli on vielä niin alkuvaiheessa, sen tasapainosta ei ole
kovin hyvää näyttöä enkä itsekään osaa sanoa mikä olisi optimaalisin pelityyli. Tekoälyä oli vaikea opettaa
pelaamaan, kun ei itsekään osaa vielä.

**Mitä teen seuraavaksi?**

Seuraavaksi alan toteuttaa järkevämpää tekoälyä, joka ottaa jo huomioon pelissä tapahtuvia asioita, mutta ei ole
vielä kovin hyvä pelissä. Tämä tekoäly tulee sitten toimimaan pohjana seuraaville toteutuksille.

Dokumentointia ja testausta pitää myös lisätä ennen palautusta.