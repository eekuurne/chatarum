Pelin voi käynnistää Launcher-luokasta, jossa luotavalle Gamelle voidaan syöttää parametreinä haluttu resoluutio ja
halutaanko pelata fullscreeninä (true) vai windowed (false). Pelistä pääsee pois painamalla Esc tai sulkemalla sen 
ikkunan raksilla.

Pelissä on 11 erilaista pelattavaa korttia ja 1 kortti, jonka toinen kortti luo. Kortteja on pelaajilla tasaisesti
30:n kortin pakassa, josta niitä nostetaan satunnaisesti. DeckBuilder-luokassa voi itse määritellä pakkoihin tulevat
kortit. Kortit löytyvät cards.minions kansiosta omina luokkinaan.

(Lue aihemäärittelystä perusidea)

Pelissä kortteja voidaan valita kädestä hiirellä, jos niihin riittää resurssit. Kortin hinta näkyy keskellä alareunassa.
Kädestä valittu kortti voidaan pelata pöytään painamalla omalla puolella pöytää olevaa vapaata paikkaa. Pöydässä olevia
minioneita, joilla on miekankuva oikeassa yläreunassa, voidaan valita hiirellä. Valitulla minionilla voi hyökätä vastustajan
minionia painamalla sitä. Jos minionilla on kilven kuva sen vasemmassa yläreunassa, sitä hyökätessä minion hyökkääkin sen
vieressä olevaa guardiania (Watchman). Damage on vasen alakulma, health oikea alakulma. Healthin yläpuolella näkyy, jos
minion on menettänyt healthia.

Vuoron voi päättää painamalla END TURN-nappia. Tämän jälkeen seuraava pelaaja voi aloittaa vuoronsa painamalla START TURN 
samasta kohtaa. Resource-cap kasvaa 10 joka vuoro ja valmiiksi vuoron alussa pöydässä olevat workerit (Peasant) kasvattavat
sitä. Lopullinen resource-cap on 80, workerien kanssa 100. Jos minion ei käytä vuoroaan, vastustaja menettää Influencea. 
Kun influence menee 0:aan, ruudulle tulee lopputeksti ja pelin voi sulkea itse. 
