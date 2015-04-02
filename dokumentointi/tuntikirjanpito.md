**14.1.2015:** 
- Satunnaista ideointia päivän mittaan

**15.1.2015:** 4h 
- GitHubin asentelua ja opettelua, ideointia ja aihemäärittelyn kirjoittaminen

**19.1.2015-21.1.2015:** 
- Satunnaista pelimekaniikan ja korttien ideointia

**22.1.2015:** 3h 
- Ensimmäisen viikkopalautteen perusteella tehdyt korjaukset, alustavan luokkakaavion tekeminen, koodausta, ideointia

**23.1.2015:** 1,5h 
- Koodausta ja pieniä muutoksia luokkakaavioon

**28.1.2015:** 3h 
- Koodausta (Deck-luokka jne) ja pitin fiksaaminen toimimaan

**29.1.2015:** 4h 
- Koodausta (Hand-luokka jne) ja githubin kanssa taistelua (Windows sovellus - never again)

**30.1.2015:** 2h 
- Uuden luokkakaavion tekeminen ja koodausta

**31.1.2015-2.2.2015:** 4-6h?
- Satunnaista korttien, pelimekaniikan ja pelilaudan ideointia ja piirtelyä

**3.2.2015:** 4h
- Korttibalanssin ja pelimekaniikan suunnittelua
- Käyttöliittymän tekemisen opettelua, valmiin frameworkin lisääminen projektiin myöhempää käyttöä varten

**4.2.2015:** 4h
- Satunnaista koodausta, JavaDocin lisääminen luokkiin, uusia luokkia

**8.2.2015:** 7h
- Perus graafisen käyttöliittymän ja siihen liittyvän logiikan harjoittelua ja koodaamista

**12.2.2015:** 7h
- Lisää käyttöliittymän ja logiikan koodaamista, ensimmäisen spritesheetin tekeminen ja niihin liittyvän logiikan lisääminen jne.

**13.2.2015:** 6h
- JavaDocit ajan tasalle, sekvenssikaaviot pelin aloittamiselle ja (alustava) matsin aloittamiselle, pieniä lisäyksiä koodiin ja testeihin
- Ensimmäisen version spritejen piirtäminen spritesheettiin

**16.2.2015:** 1h
- Suunnittelua paperille

**18.2.2015:** 1h
- Assettien toiminnan testausta ja lisäilyä

**19.2.2015:** 9,5h
- Keyboardin toiminnallisuuden lisääminen (esc-näppäin sulkee pelin, q-näppäin omaa testausta varten)
- Alussa tapahtuvan korttienjaon koodaaminen
- Player, hand, deck, champion, background, end turn -button ja table slotsien renderöinnin koodaaminen ja puuttuvien kuvien piirtäminen
- Pientä refaktorointia

**20.2.2015:** 4h
- Uusia sekvenssikaavioita: Rendering Game State, 
- JavaDoc päivittämistä
- Render Table

**21.2.2015:** 6h
- Refaktorointia, Font-luokkaan tutustuminen ja hyödyntäminen vuoron renderöinnissä
- Locations luokka koordinaattien hallintaan
- Mouse controllerin koodaamisen yrittämistä, ei onnistunut

**22.2.2015:** 9h
- Aloitin projektin koodaamisen alusta, kuitenkin hyödyntämällä joitain aiemmin tekemiäni komponentteja 
- Päivän päätteeksi projekti oli samassa kunnossa kuin edellisessä toteutuksessa, paitsi että siinä on toimiva
mouse input, parempi keyboard input, moni luokka on selkeämpi ja ruudulle piirretään vain kun jotain tapahtuu
jatkuvan loopin sijaan
- Aihemäärittely meni uusiksi kurssin osalta: Factionit, championit ja skill-cardit jää pois kokonaan, ainoa pelimuoto
tulee olemaan local multiplayer jne.

**23.2.2015:** 14h
- Tablen koodaus, korttien valitseminen kädestä, piirtelyä, 
- Vuoron vaihtumiseen ja pelaajien statteihin liittyvää koodailua, resource ja influence metodien ja baarien säätämistä
- Korttien pelaaminen kädestä pöytään, vuoron vaihtuessa vuoronsa käyttämättömät minionit pöydällä vähentävät
vastustajan influencea, testattu että production ja mounted minionit toimii niin kuin pitää
- Päivän päätteeksi pelaajat pystyvät valitsemaan kädestään kortteja joihin riittää resurssit ja asettamaan sen pöydälle.
Kortin valinta peruuntuu, jos pelaaja painaa minne vain muualle kuin kyseistä korttia tai pöytää. Vuoroa voi vaihtaa 
END TURN -napilla, jolloin resurssit ja influencet päivittyy niin kuin pitää. Esc sulkee pelin.
- Testinäppäimiä Q, W, E, A, S, D, Z, X, C - muuttelevat influenceja ja resourceja tällä hetkellä.

**24.2.2015:** 6h
- Koodikatselmointi
- Minioneiden attackin suunnittelu ja koodausta

**25.2.2015:** 8h
- Korttien käsittely hiirellä ohjelmoitu uudestaan ja viimeistelty: nyt kortteja voi valita kädestä tai pöydästä ja minionit 
voivat hyökätä. Korttia ei voi valita kädestä, jos resurssit ei riitä. Korttia ei voi valita pöydästä, jos sillä ei ole vuoroa
käytettävissä.
- Guardianien suojaamille minioneille ilmestyy kilven kuva kortin vasempaan yläreunaan. Minionit, joilla on vuoro käyttämättä näkyy
miekan kuva kortin oikeassa yläreunassa. Jos minion on menettänyt healthia, mutta ei kuollut, näkyy healthin yläpuolella punaisella
menetetty määrä.

**26.2.2015:** 11h
- Pelin resoluution skaalauksen koodaaminen: toimii nyt millä vain resoluutiolla sekä windowed että fullscreenissä.  Vaihdetaan 
launcherista (toistaiseksi) käsin koodista. Testattu Windowsilla ja Ubuntulla.
- Uusien korttien lisäämistä (Puppet Master, Assassin, Axethrower, Voodoo Priest, Zombie, Moonblade). Mukana uusia ominaisuuksia
minioneille: toisten minioneiden summonaaminen viereisiin slotteihin pelatessa kortti pöytään, satunnaisen vastustajan minionin 
varastaminen, deadly-ominaisuus(tappaa hyökättävän kohteen aina, mutta deadly minion ei tee influence damagea). 
- Kaikkia on testattu pelaamalla ja kokeilemalla erilaisia skenaarioita (esim. summonerin laittaminen reunoille, muiden korttien 
viereen jne, Puppet Masterin pelaaminen täyteen omaan pöytään tai vihollisen tyhjään pöytään jne...)

**27.2.2015:** 9h
- Pelin demoaminen
- Testien tekemistä ja pientä korjailua
- Dokumentaation päivittäminen palautuskuntoon
- Kuvien latauksen korjaaminen niin, että luotu .jar tiedosto toimii


**10.3.2015:** 2h
- Tietorakenteet ja algoritmit hajoitustyön aiheen suunnittelu

**14.3.2015:** 3h
- Pelaajan oman käden Hoverin koodaaminen

**15.3.2015:** 4h
- Hoverin optimointia, Volleyn ja Rain of Firen viimeistely

**19.3.2015:** 2h
- Aihemäärittelyn kirjoittaminen, suunnittelua

**20.3.2015:** 3h
- Ensimmäisen tekoälyn koodauksen aloittaminen

**21.3.2015:** 4h
- SimpleAI-tekoälyn viimeisteleminen ja tekoälyn mahdollisuuden lisääminen peliin

**22.3.2015:** 2h
- Tekoälyn testauksen koodausta ja ensimmäiset tehdyt testit: pelaaja 1 voitti 909 ja pelaaja 2 1000 SimpleAI:lla

**23.3.2015:** 3h
- AITester luokan koodaus ja testien tekeminen: nyt testejä voi tehdä n. 1 000 000 / 30 sec vauhtia, SimpleAI:lla
player 1 win-loss ratio näyttäisi vakiintuvan n. 0,898 paikkeille.

**24.3.2015:** 3h
- Tekoälyjen koodausta lisää
- Testejä muuttamalla pelin eri ominaisuuksia, kuten maxInfluence, aloituskortteja jne.'
- Nyt simpleAI:t voittaa yhtä paljon molemmilla puolilla

**25.3.2015:** 5h
- Background-kuvan hiomista
- checkLethal ominaisuuden koodaus, testaus ja dokumentointi
- Javadocin täydentäminen

**25.3.2015:** 1h
- Lisää testausta

**TÄSTÄ ETEENPÄIN TUNTIKIRJANPITO VIIKKORAPORTEISSA**