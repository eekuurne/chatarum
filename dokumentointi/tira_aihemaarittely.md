**Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit -kurssin aihemäärittely**

(Itse pelin aihemäärittely löytyy dokumentoinnista nimellä "aiheenKuvausJaRakenne" ja muu dokumentointi samasta kansiosta.)

Tällä kurssilla peliin tullaan lisäämään tekoäly. Tavoitteena on siis luoda toiminnallisuus, jonka avulla voidaan kumpi vain
pelaaja tai molemmat vaihtaa tekoälyn pelaamaksi.

Ensimmäisenä tavoitteena on luoda "tyhmä" tekoäly, joka pelaa kortteja aina niin monta kuin mahdollista joka vuoro ja laittaa
ne satunnaisiin paikkoihin pöydällä. Vuoron lopuksi tekoäly arpoo mitä vastustajan kohteita omassa pöydässä olevat minionit
hyökkäävät.

Kun ensimmäinen tekoäly on saavutettu, se säilytetään yhtenä vaihtoehtona (Easy?) ja luodaan järkevämpi tekoäly, joka ottaa
huomioon erilaisia asioita pelin tilanteesta ja tekee päätöksiä sen perusteella. Kun tämä tekoäly on luotu, voidaan sitä
testata alkuperäistä tekoälyä vastaan peluuttamalla niitä vastakkain.

Tavoitteena olisi luoda vielä kolmaskin (tai useampi) tekoäly, joka eroaa käyttäytymiseltään jotenkin toisen tekoälyn kanssa.
Testaamalla tekoälyjä toisiaan vastaan sekä pelaajia vastaan voidaan päättää niille eri vaikeusasteet.

Koska pelissä ei ole (vielä) animaatioita, joiden perusteella voisi nähdä mitä toinen pelaaja tekee, tullaan käyttöliittymään
lisäämään jonkinlainen logi, josta näkee mitä kaikkea on tapahtunut.

**Muuta**

Tulen kehittämään kurssin aikana pelin muitakin ominaisuuksia mikäli mahdollista. Esimerkiksi yksinkertainen menu, josta voidaan
valita resoluutio, pelaajat/tekoälyt sekä käytettävät pakat. Myös kortteja tullaan lisäämään ja käyttöliittymän viimeistely (ollut
ensimmäisillä viikoilla työn alla, en aloittanut tekoälyä vielä muuta kuin suunnittelun tasolla).

Mikäli aikaa riittää, voidaan myös verkon yli tapahtuva moninpeli lisätä, mutta todennäköisesti se jää tehtäväksi kurssin jälkeen.