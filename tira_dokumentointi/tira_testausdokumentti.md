**Lista käsin tehdyistä testeistä jokaiselle luokalle:**

Luokka AI:

- playTableRandomly hyökkää kaikkiin mahdollisiin slotteihin eikä aiheuta erroreita
- playHandRandomly pelaa minioneita kaikkiin mahdollisiin slotteihin eikä aiheuta erroreita
- checkTableDamage toimii
- checkHandMountedDamage toimii
- playMountedMinions toimii (mutta voisi olla parempi - ei vielä optimoi suurinta mahdollista damagea joka voidaan pelata)
- checkLethal-metodi osaa viimeistellä pelin, kun mahdollista (huom. playMountedMinions kommentti) eikä aiheuta erroreita
- checkEmptyTableSlots palauttaa oikeat tyhjät slotit ja sitä hyödyntävät metodit käyttävät sitä oikein
- checkFilledTableSlots palauttaa oikeat tyhjät slotit ja sitä hyödyntävät metodit käyttävät sitä oikein


Luokka SimpleAI:

- Luokka ei aiheuta erroreita pelattaessa
- (Hyödyntää vain isäntäluokan metodeja)

Luokka MediumAI:

- Luokka ei aiheuta erroreita pelattaessa

Luokka AdvancedAI:

- playWarriors, playWorkers, playDeadlys ja playRangeds toimii kuten pitää
- checkHandCost laskee käden hinnan oikein



Luokka AITester:

- Luokka ei aiheuta erroreita pelattaessa
- Pelaa vuoroja niin kuin pelissä kuuluu
- Antaa oikean palautteen

Muut luokat:

- Pienet koodinpätkät LogicHandlerissa ja Launcherissa liittävät uudet AI-luokat ja AITesterin 
näppärästi peliin: ne eivät aiheuta erroreita ja toimivat kuten pitää