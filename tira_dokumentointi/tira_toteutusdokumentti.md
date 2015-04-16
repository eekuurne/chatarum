(Pelin yleisrakenne löytyy dokumentointikansiosta.)

**AI**

Kaikki pelin tekoälyt perivät abstraktin luokan AI, jolta löytyy metodi playTurn(). Tekoäly lisätään pelin Launcher-luokassa 
pelaajalle/pelaajille ja se välitetään Game:n ja UserInterfacen kautta logiikasta vastaavalle LogicHandler-luokalle, 
joka pelin alussa lisää tekoälyt pelaajille (Player) metodilla setupAI(). Jos pelaajalle on lisätty tekoäly, niin
pelaajan vuoron alussa LogicHandler kutsuu AI:n playTurn()-metodia eli pelaa vuoron ja antaa vuoron takaisin toiselle
pelaajalle (metodi playAI LogicHandlerissa).

(Luokalla on vielä kaksi metodia, jotka käyttävät ArrayListiä. Nämä tullaan muuttamaan omiksi toteutuksiksi kunhan kerkeän.)

**SimpleAI**

SimpleAI on tekoälyn toteutus, joka tekee kaikki päätökset perustuen satunnaisuuteen. Sen käyttämät playTableRandomly ja
playHandRandomly -metodit on toteutettu AI-luokassa, jotta muutkin tekoälyt voivat hyödyntää niitä. 

SimpleAI aloittaa vuoron hyökkäämällä pöydässä olevilla korteillaan satunnaisia kohteita. Sitten se pelaa kortteja kädestä
pöytään siinä järjestyksessä missä ne on nostettu käteen (mikä tapahtuu Randomilla). Lopuksi se vielä hyökkää pöydässä
olevilla Mounted-korteilla satunnaisia kohteita.

**MediumAI**

MediumAI on toinen tekoälyn toteutus, joka osaa jo jotain. Se eroaa SimpleAI:sta siten, että vuoron alussa se tarkistaa 
checkLethal()-metodilla voiko se voittaa tällä vuorolla ja se viimeistelee pelin jos mahdollista, ja pelatessaan kortteja
pöytään se osaa sijoittaa ne paikkoihin, joka suosii optimaalista Guardianien sijoittamista suojaamaan muita, ja jos pöydässä
on Guardian se pelaa muun Minionin sen viereen, ja jos pöydässä on muu Minion, se pelaa Guardianin sen viereen.

MediumAI pelaa tavalla, joka muistuttaa huonoa ihmispelaajaa. Testaamalla sitä SimpleAI:ta vastaan se kuitenkin voittaa
enemmän pelejä (voitto-häviö-ratio n. 1,19). Tulen todennäköisesti muuttamaan vielä pöydässä olevien Minionien hyökkäysmetodia
sellaiseksi, joka ei perustu satunnaisuuteen.

**AdvancedAI**

(Tämä luokka tullaan toteuttamaan seuraavaksi. Keskeneräinen kehitys tapahtuu luokassa TestAI.)

AdvancedAI ottaa huomioon pöydässä olevat omat ja vastustajan Minionit, ja se tekee sen perusteella päätökset miten se pelaa.
Se voi pelata vuoronsa neljällä eri tavalla, joka riippuu siitä onko oma ja vastustajan pöytä tyhjiä.

**AITester**

Tekoälyjä voidaan testata vastakkain vaihtamalla Launcherissa ehtolauseke true:ksi, jolloin peli ei käynnistä
käyttöliittymää lainkaan vaan pelaa tekoälyillä toisiaan vastaan ja antaa molempien voitot palautteena. Tämä tehdään
AITester-luokan avulla, jolla on metodi runTests(int amount). Parametrilla määritellään siis pelattavien pelien määrä.
Toimiakseen molemmille pelaajille pitää olla annettu tekoälyt.