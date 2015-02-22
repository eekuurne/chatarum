# Chatarum
The working title comes from the Latin word for a card game (ludus chatarum).

(Currently the sourcecode is in English and the documentation is in Finnish - will change it all to English when I have time)

**23.2.2015, 00:20:**
Statuspäivitys: olen koodannut tänään koko projektin alusta, hyödyntäen joitain komponentteja edellisestä
toteutuksesta. Uusi toteutus pohjautuu periaatteeseen, että ruutu päivitetään vain kun jotain tapahtuu. Pelistä
tuli näin huomattavasti kevyempi ja loogisemmin käsiteltävä kokonaisuus koodattavaksi.

Koska aikaa ei ole liikaa ja projektista oli tulossa erittäin laaja, päätin jättää suosiolla muutamia ominaisuuksia
kokonaan kurssin aikana tehtävästä toteutuksesta. Niiden lisäämisen mahdollisuus on kuitenkin otettu huomioon
pelin toteutuksessa.
- Factionit, championit ja skill-cardit jää pois kokonaan
- Pelimuotona ainoastaan local multiplayer

Tällä hetkellä vuoroa voi vaihtaa painamalla hiirellä End turn -nappia ja pelaaja1 voi nostaa kortteja Q:lla ja
tuhota kortteja kädestään E:llä. Näin nähdään miten korttien piirtäminen käsiin tapahtuu pöydällä.

**20.2.2015, 12:00:** 
Peli ei ole vielä aivan demottavassa kunnossa ja JUnit testit laahaa jäljessä, 
mutta viikonlopun jälkeen pelin pitäisi olla pelattavissa ja testit kunnossa. Tällä hetkellä peli
renderöi 1920x1080 resoluutiolla pelin alkutilanteen, pelistä pääsee pois escillä ja vuoroa voi
vaihtaa Q:lla (simuloi kumpi pelaajista näkyy local multiplayerissä).

Koodaus jatkuu perjantai-illalla, kun muiden kurssien deadlinet on alta pois. Lauantai varattu kokonaan
tälle, jolloin viimeistään lisätään mouse controller ja aletaan koodaamaan korttien pelaamista pöytään
jne. Sunnuntai ja maanantai myös melkein koko päivät omistettu tälle. Teen lisää sekvenssikaavioita
ja päivitän luokkakaavion, kun lopullinen toiminnallisuus on selkeä.

= uskon että saan projektin valmiiksi deadlineen ja demoon mennessä, vaikka olen hieman jäljessä.

**Koodikatselmoija:** 
Projekti tulee etenemään paljon päivittäin deadlineen asti eli valitse itse kuinka
valmista projektia haluat kommentoida. Jos kuitenkin teet katselmoinnin aikaisessa vaiheessa, toivoisin
saavani palautteen heti, eikä esim. palautetta pelin perjantaisesta kunnosta tiistaina... Kiitos :)