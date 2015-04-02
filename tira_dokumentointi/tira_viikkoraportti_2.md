**Viikkoraportti 2: 28.3.2015 - 2.4.2015:**

**Mitä olen tehnyt tällä viikolla?**

Tämän viikon tavoitteena oli luoda seuraava tekoäly, tehdä lisää testejä, päivittää JavaDoc ja refaktoroida
vanhoja metodeja. Työskentelin näiden ominaisuuksien parissa ja käytin viikon aikana n. 15-20h aikaa. 

**Miten ohjelma on edistynyt?**

Ohjelma edistyi taas hyvin ja sain valmiiksi seuraavan tekoälyn: MediumAI. Päivitin myös tekoälyyn liittyvien
luokkien JavaDocit ja muut kommentit, refaktoroin vanhoja metodeja, kirjoitin AITester-päiväkirjaa ja tein 
testausdokumentin, koska JUnit testejä en ole päässyt paljoa hyödyntämään. AITester ajaa periaatteessa 
osittain JUnit testien virkaa ja sen voisi toteuttaa myös JUnit testinä kokonaan, mutta olen tehnyt sen omana 
luokkanaan jotta se voitaisiin helpommin lisätä ominaisuudeksi esim. valikkoon, kun saan sellaisen toteutettua.
Sen käyttö Launcherin kautta on myös erittäin kätevää.

MediumAI on tekoäly, joka näyttää jo pelaajalle siltä, että se tietää miten kortteja kuuluu käyttää. Se asettaa
muut kortit Guardian-korttien suojaan ja Guardian-kortit suojaamaan muita kortteja. Se osaa viimeistellä pelin
heti kun vuorolla on mahdollista voittaa. Se ei kuitenkaan osaa pelata kovin hyvin, kuten määritelty, ja se
pelaa kortit kädestä ja hyökkää satunnaisesti.

Testipäiväkirjasta löytyy tarkemmin uusien ominaisuuksien testauksesta, mutta viikon lopputuloksena todettakoon,
että vanha SimpleAI vs. MediumAI päättyi seuraavaan lopputulokseen 100 000 000 testillä:

MediumAI:n voitto-häviö-ratio: ~1.19

Uusi tekoäly siis selvästi voittaa enemmän pelejä. Pelasin itse myös useita pelejä tekoälyä vastaan, ja totesin sen 
käyttäytyvän juuri niin kuin halusinkin, ja yksinpelikin alkoi olla jo melko mielenkiintoista. Sanoisin että viikon
tavoitteisiin on siis päästy.

**Mitä opin tällä viikolla?**

Opin paljon lisää siitä, mitä tekoäly voisi tässä korttiepelissä tehdä voittaakseen, ja mielessäni on jo useita
toteutuksia seuraavalle tekoälylle, jotka aion toteuttaa seuraavan viikon aikana. 

**Mikä jäi epäselväksi tai tuottanut vaikeuksia?**

Sama vaikeus kuin edellisellä viikolla, eli sen määritteleminen mitä tekoälyn tulisi käytännössä tehdä.

Kysymys: Tarvitseeko muuttaa kielletyt valmiit tietorakenteet (tässä tapauksessa ArrayListit) pois myös pelin muista
luokista, joita osa tekoälyn toiminnallisuudesta käyttää, vai riittääkö että omat tietorakenteet luodaan vain 
tällä kurssilla luoduille luokille?

**Mitä teen seuraavaksi?**

Jotta tekoälyn opettaminen ei olisi niin hakuammuntaa, niin aion tehdä lopullisen määrittelyn pelin ominaisuuksille
eli poistaa muutaman kortin käytöstä kurssin ajaksi ja lisätä muutaman kortin lisää. Tällöin pelin idea selkeytyy
huomattavasti ja monimutkaiset ominaisuudet eivät ole irrallisena mukana. Poistetaan Spellit, Puppet Master ja
Voodoo Priest. Lisätään 1-2 Guardiania, 1 Worker, 1-2 Warrioria, 0-1 Mountedia ja 0-1 Deadlyä peliin. Korteille
voidaan luoda simppelit placeholderit jos en ehdi piirtämään, koska tämän kurssin aikana niitä ei tulla pahemmin
katselemaan muutenkaan.

Aion kokeilla tehdä hieman JUnit testejä myös AI-luokille, vaikkakin ne tulee testattua hyvin muutenkin. AITesterin 
takia nähdään ettei ominaisuudet aiheuta Erroreita pitkässäkään juoksussa ja muut mahdolliset sudenkuopat tulee 
testattua käsin kun pelaan peliä.

Aion muuttaa ArrayListit pois parista metodista.

Alan tekemään jo seuraavaa tekoälyä, jonka tarkoituksena on huomioida myös vastustajan pöytä. Se siis osaa lyödä oikeita
kortteja pöytään riippuen pöydän tilanteesta ja hyökätä pöydässä olevilla Minioneilla niin, että saadaan maksimimäärä
vahinkoa tehtyä minimimäärällä kuolleita omia Minioneita. Muuten sen ominaisuudet tullaan kopioimaan MediumAI:lta.
Veikkaan että näiden ominaisuuksien seurauksena voittoprosentti tulee nousemaan huomattavasti.
