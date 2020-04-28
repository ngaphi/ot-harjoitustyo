# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakennen noudattaa kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://user-images.githubusercontent.com/48474978/80530763-2b287380-89a2-11ea-82bb-97b0b12c6382.jpg" width="200" height="300" title="r">

Pakkaus *spaceinvaders.ui* sisältää JavaFX:llä toteutetun käyttöliittymän *spaceinvaders.controller* sovelluslogiikan ja attribuutteista vastaavan koodin *spaceinvaders.data*.

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat [Player](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/main/java/spaceinvaders/data/Player.java), [Bullet](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/main/java/spaceinvaders/data/Bullet.java) ja [Invader](https://github.com/ngaphi/ot-harjoitustyo/blob/master/SpaceInvaders/src/main/java/spaceinvaders/data/Invader.java), jotka kuvaavat sovelluksen hahmoja ja niiden ominaisuuksia.

<img src="https://user-images.githubusercontent.com/48474978/80532702-316c1f00-89a5-11ea-99bf-c32339537f7b.jpg" width="600" height="200" title="a">

Toiminnallisista kokonaisuuksista vastaavat luokat PlayerService, BulletService ja InvaderService. Nämä luokat tarjoavat pelin hahmoille oman metodin. Esimerkiksi

  * void moveInvaders()
  * void movePlayer()
  * boolean collision()
  * void shoot(List)

Ohjelman luokkien suhdetta kuvaava luokka/pakkauskaavio:

<img src="https://user-images.githubusercontent.com/48474978/80530457-b3f2df80-89a1-11ea-99b5-c6593bc20e12.jpg" width="400" height="550" title="p">
