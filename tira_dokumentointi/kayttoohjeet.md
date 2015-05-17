Pelin peruskäyttöohjeet ja säännöt löytyvät dokumentointi-kansiosta. 

Tekoälyjä voidaan käyttää vaihtamalla Launcher-luokassa player1AI ja player2AI joko 
halutuksi tekoälyksi tai nulliksi jolloin pelaaja pelaa itse.

AITester toimii niin, että jos Launcherin if-lausekkeeseen vaihdetaan true ja molemmat playerAI:t
eivät ole null, niin tester.runTests voidaan antaa parametriksi testien määrä. Silloin ohjelma
pyörittää pelejä tekoälyjen välillä ja tulostaa lopputuloksen.

Peliä voi pelata itse vaihtamalla Launcherissa if-lausekkeen falseksi. Tekoälyä voi vaihtaa else-lausekeen
sisällä Gamen parametreihin voi asettaa resoluution ja true/false fullscreenille. Pelin voi sulkea Escillä
tai raksista jos windowed.
