# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla että manuaalisesti tapahtunein 
järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoitujen testien ytimen muodostavat sovelluslogiikkaa, eli pakkauksen [spaceinvaders.controller](https://github.com/ngaphi/ot-harjoitustyo/tree/master/SpaceInvaders/src/main/java/spaceinvaders/controller)
luokkia testaavat integraatiotestit [InvaderServiceTest](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/test/java/spaveinvaders/controller/InvaderServiceTest.java) ja 
[PlayerServiceTest](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/test/java/spaveinvaders/controller/PlayerServiceTest.java).

### Testikattavuus

Käyttöliittymän, ja luokkien *BulletService* ja *FileService* lukuunottamatta sovelluksen testauksen rivikattavuus on 62%.

<img src="https://user-images.githubusercontent.com/48474978/81495771-60469700-92bb-11ea-9e87-4fb576bfa691.png" width="800">

### Järjestelmätestaus

Sovelluksen järjestelmä testaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/dokumentaatio/kayttoohje.md) kuvaamalla tavalla sekä OSX- että Linux ympäristöön.

Sovellusta on testattu tilanteissa, joissa tallettava tiedosto on jo olemassa ja joissa sitä ei ole ollut, jolloin ohjelma on luonut se itse.

### Toiminnallisuudet

Testauksessa on käyty läpi yli puolet [määrittelydokumentin](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/dokumentaatio/vaatimusmaarittely.md) 
ja käyttöohjeen listaamat toiminnallisuudet.
Kaikkien toiminnallisuuksien yhteydessä on syötekentät yritetty täyttää myös virheellisillä arvoilla.

### Sovellukseen jääneet laatuongelmat

Sovellus ei anna tällä hetkellä järkeviä virheilmoituksia.

