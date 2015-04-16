**Viikkoraportti 3: 3.4.2015 - 9.4.2015:**

**Mitä olen tehnyt tällä viikolla?**

Tämän viikon tavoitteena oli tehdä pelistä selkeämpi kokonaisuus poistamalla pari korttia, joiden ominaisuudet eivät
sovi peliin näin pienellä korttimäärällä, ja lisäämällä kortteja jotka sopivat paremmin pelin tähän vaiheeseen.
Tasapainotin myös kortteja vähän ja testailin miten eri korttien poistaminen toiselta pelaajalta vaikuttaa voittoprosenttiin. 
Käytin tällä viikolla aikaa n. 10 tuntia projektin parissa.

**Miten ohjelma on edistynyt?**

Poistin pelaajien pakoista Voodoo Priestit, Puppet Masterit ja Spellit. Lisäsin peliin uusia kortteja: Berserker (warrior),
Bouncer (guardian), Headhunter (deadly), Sharpshooter (ranged), Shieldmaiden (guardian) ja Trader (worker). Nyt erilaisia 
Minion-kortteja on 15 käytössä, eli 2 jokaista molempien pelaajien pakoissa. Minionien statit on helposti tarkasteltavissa
minionsheet-exceltiedostossa. En piirtänyt vielä kortteja uusille Minioneille, joten koodasin simppelin metodin joka tekee
placeholderit niille. 

Tein testejä, joissa poistin vuorotellen jokaisen kortin toisen pelaajan pakasta, ja tutkin miten se vaikuttaa voittoprosenttiin
kun MediumAI:t pelaavat vastakkain. Jotkin kortit ovat selkeästi tärkeämpiä kuin toiset, mutta vaikutukset eivät olleet kriittisen
suuria. Muutin kuitenkin paria korttia hieman, jotka olivat selkeästi liian huonoja tai hyviä: Assassin cost 35 -> 30, Axethrower
kaikki statit uusiksi (attack 2, health 1, cost 35), Peasant health 1 -> 2. Tasapainotan peliä enemmän, kun AI osaa pelata paremmin.

Tekoälyn kehittäminen ei edistynyt tällä viikolla, mutta tekemäni muutokset ovat mielestäni tärkeitä pelin kannalta: nyt se on
selkeämpi kokonaisuus, joten siihen on mukavampi kehitellä tekoälyä jatkossa.

**Mitä opin tällä viikolla?**

Opin lähinnä uutta korttien tasapainosta keskenään. Testien perusteella nähtiin, että jotkin kortit ovat parempia kuin toiset,
mutta kaikista tärkeintä tällä korttimäärällä oli se, että pakassa on mahdollisimman monipuolisesti eri hintaisia kortteja.
Lisäämällä melkein minkä vain kortin pakkaan voittoprosentti kasvoi, ja niillä joilla se laski niin se laski vähemmän kuin
toisilla nousi.

**Mikä jäi epäselväksi tai tuottanut vaikeuksia?**

Tällä viikolla ei ollut erityisemmin vaikeuksia.

**Mitä teen seuraavaksi?**

Jatkan tekoälyn kehittämistä eteenpäin.