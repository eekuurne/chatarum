# Chatarum
The working title comes from the Latin word for a card game (ludus chatarum).

(Currently the sourcecode is in English and the documentation is in Finnish - will change it all to English when I have time)

**24.2.2015, 03:31:**
Pelaajien influence (ent. health) ja resources toimii sekä tekstinä että palkkina niin kuin pitää. Kortteja voi valita kädestä ja pelata pöytään. Vielä kun lisään huomenna toiminnallisuuden minioneiden välisille hyökkäyksille niin peli on valmis pelattavaksi. Sen jälkeen tulee vuorojen välinen ruutu (End turn -> Start turn -> Vuoro alkaa), pelin lopetus, menu, korttien zoomaus kun hiiri päällä, äänet, deckbuilder, lisää kortteja jne. Muita uusia toiminnallisuuksia lisään kurssin jälkeen.

Korttien käsittely toimii hiirellä. Esc-illä pääsee pois pelistä. END TURN -nappi vaihtaa vuoroa. Näppäimet Q, W, E, A, S, D, Z ja X on ollut testauskäytössä, tällä hetkellä vaihtaa pelaajien influencea ja resourceja molempiin suuntiin.

**23.2.2015, 00:20:**
Statuspäivitys: olen koodannut tänään koko projektin alusta, hyödyntäen joitain komponentteja edellisestä
toteutuksesta. Uusi toteutus pohjautuu periaatteeseen, että ruutu päivitetään vain kun jotain tapahtuu. Pelistä
tuli näin huomattavasti kevyempi ja loogisemmin käsiteltävä kokonaisuus koodattavaksi.

Koska aikaa ei ole liikaa ja projektista oli tulossa erittäin laaja, päätin jättää suosiolla muutamia ominaisuuksia
kokonaan kurssin aikana tehtävästä toteutuksesta. Niiden lisäämisen mahdollisuus on kuitenkin otettu huomioon
pelin toteutuksessa.
- Factionit, championit ja skill-cardit jää pois kokonaan
- Pelimuotona ainoastaan local multiplayer

Pitää vielä päivittää aihemäärittelyyn ja luokkakaavioon muutokset.
