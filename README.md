# Space Invaders

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/dokumentaatio/vaatimusmaarittely.md)

[Tuntiaikakirjanpito](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/dokumentaatio/arkkitehtuuri.md)

## Releaset

[Viikko 5](https://github.com/ngaphi/ot-harjoitustyo/releases)

[Viikko 6](https://github.com/ngaphi/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

### Projektin suoritus
Projektin koodin suoritetaan komennolla 

* mvn compile exec:java -Dexec.mainClass=spaceinvaders.ui.Starter

### Testaus

Testit suoritetaan komennolla

* mvn test

Testikattavuusraportti luodaan komennolla

* mvn test jacoco:report

Kattavuusraporttia voi tarkastella avaamalla selaimella *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Komento

* mvn package

generoi hakemistoon *target* suoritettavan jar-tiedoston *SpaceInvaders-1.0-SNAPSHOT.jar*

### JavaDoc

JavaDoc generoidaan komennolla

* mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto *target/site/apidocs/index.html*

### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

* mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html

