# Space Invaders

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/ngaphi/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntiaikakirjanpito](https://github.com/ngaphi/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

### Projektin suoritus
Projektin koodin suoritetaan komennolla 

* mvn compile exec:java -Dexec.mainClass=spaceinvaders.Starter

### Testaus

Testit suoritetaan komennolla

* mvn test

Testikattavuusraportti luodaan komennolla

* mvn test jacoco:report

Kattavuusraporttia voi tarkastella avaamalla selaimella *target/site/jacoco/index.html*
