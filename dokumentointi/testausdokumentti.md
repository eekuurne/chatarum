Peliä on testattu käsin pelaamalla sitä aina, kun uusi ominaisuus on lisätty. Uusia toimintoja lisätessä hyödynsin
paljon printtausta eri asioiden tapahtuessa. Käsin testaaminen on teknisten bugien löytämisen lisäksi auttanut
hahmottamaan pelin peliteknisiä ongelmia paremmin kuin automaattinen testaus.

Automaattiset JUnit testit auttoivat alussa pariin kertaan hahmottamaan, miten jonkun metodin on käyttäydyttävä,
mutta niiden kirjoittaminen tuntui lähinnä hidastavan projektin etenemistä, minkä takia niitä on käytetty melko
vähän. Ohjelman rakenne on elänyt kokoajan sen verran, että JUnit testeihin jouduttiin tekemään kokoajan muutoksia.
Aion hyödyntää niitä enemmän, kunhan lopullinen perusrakenne on varmistunut. Se tulee vielä muuttumaan ainakin
korttien osalta (JButtonin tai muun Componentin hyödyntäminen).

Olen testannut rajatapaukset kaikista tapahtumista, missä on ollut riskejä mennä esimerkiksi indeksien ulkopuolelle
tai tapahtua jotain mitä ei pitäisi.

Esimerkkejä testitapauksista:

- Korttien valitseminen hiirellä, kun niihin on varaa tai niillä on vuoro käyttämättä
- Korttien valitseminen hiirellä, kun niihin ei ole varaa kädessä tai niillä ei ole vuoroa pöydässä
- Watchmanin pelaaminen pöydän reunoihin
- Kahden Watchmanin ympäröivän minionin hyökkääminen
- Vierekkäisten Watchmanien hyökkääminen
- Watchmanin pelaaminen minkä vain muun kortin viereen
- Kortin pelaaminen Watchmanin viereen
- Voodoo Priestin pelaaminen reunoihin
- Voodoo Priestin pelaaminen kun vasemmalla/oikealla/molemmilla puolilla on minion
- Puppet Masterin pelaaminen, kun vastustajan pöytä on tyhjä / minioneita eri määriä eri sloteissa
- Puppet Masterin pelaaminen, kun oma pöytä on täysi / tyhjä / minioneita eri määriä eri sloteissa
- Influencen ja resourcejen vaihtuminen oikein ja tekstien ja palkkien toiminta
- Pelin skaalaaminen resoluution mukaan
- Melee/ranged/mounted/deadly/worker -perusominaisuuksien toiminnan testaaminen erilaisissa tapauksissa
- Kaikkien klikattavien käyttöliittymäobjektien klikkaaminen kuvan reunimmaisesta pikselistä ja sen viereisestä
pikselistä kaikilta neljältä eri puolelta
- Valitun kortin clearaaminen kun painetaan mihin vaan paitsi valittavaa korttia tai vuoron loppua
- Vuoron loppuminen ja alkaminen oikein
- Assassinin hyökkäys, puolustus ja vuoron lopetus
- Militia korttien nosto tyhjästä pakasta
- Kaikkien korttien piirtyminen oikeille paikoille oikein
- Hiiren ja näppäimistön kuuntelu toimii kuten pitää

