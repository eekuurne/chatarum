Pelin peruskäyttöohjeet ja säännöt löytyvät dokumentointi-kansiosta. 

Tekoälyjä voidaan käyttää vaihtamalla Launcher-luokassa player1AI ja player2AI joko 
halutuksi tekoälyksi tai nulliksi jolloin pelaaja pelaa itse.

AITester toimii niin, että jos Launcherin if-lausekkeeseen vaihdetaan true ja molemmat playerAI:t
eivät ole null, niin tester.runTests voidaan antaa parametriksi testien määrä. Silloin ohjelma
pyörittää pelejä tekoälyjen välillä ja tulostaa lopputuloksen.

Jos peliä haluaa pelata itse, kannattaa vaihtaa player1AI = null ja laittaa false if-lausekkeeseen.
Gamen parametreihin voi asettaa resoluution ja true/false fullscreenille. Pelin voi sulkea Escillä
tai raksista jos windowed.
