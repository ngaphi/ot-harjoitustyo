# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla että manuaalisesti tapahtunein 
järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoitujen testien ytimen muodostavat sovelluslogiikkaa, eli pakkauksen [spaceinvaders.controller](https://github.com/ngaphi/ot-harjoitustyo/tree/master/SpaceInvaders/src/main/java/spaceinvaders/controller)
luokkia testaavat integraatiotestit [BulletServiceTest](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/test/java/spaveinvaders/controller/BulletServiceTest.java), 
[InvaderService](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/test/java/spaveinvaders/controller/InvaderServiceTest.java) ja 
[PlayerService](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/test/java/spaveinvaders/controller/PlayerServiceTest.java).

### Testikattavuus

### Järjestelmätestaus

Sovelluksen järjestelmä testaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi


### Toiminnallisuudet

Testauksessa on käyty läpi lähes kaikki [määrittelydokumentin](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/dokumentaatio/vaatimusmaarittely.md) 
ja käyttöohjeen listaamat toiminnallisuudet.
Kaikkien toiminnallisuuksien yhteydessä on syötekentät yritetty täyttää myös virheellisillä arvoilla.

### Sovellukseen jääneet laatuongelmat

Sovellus ei anna tällä hetkellä järkeviä virheilmoituksia.

