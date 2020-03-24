
package com.mycompany.unicafe;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }

    @Test
    public void luodunKassapaatteenRahamaaraOikein() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void myytyjenLounaidenMaaraOikein() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty() + kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahamaaraKasvaaJosMaksuOnRiittava() {
        kassapaate.syoEdullisesti(240);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    
    @Test 
    public void myytyjenLounaidenMaaraKasvaaJosMaksuOnRiittava() {
        kassapaate.syoMaukkaasti(400);
        kassapaate.syoEdullisesti(240);
        assertEquals(2, kassapaate.edullisiaLounaitaMyyty() + kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahamaaraJaMyytyjenLounaidenMaaraEiMuutuJosMaksuEiRiittava() {
        kassapaate.syoMaukkaasti(300);
        kassapaate.syoEdullisesti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty() + kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void veloitetaanSummaKortiltaJaMyytyjenLounaidenMaaraKasvaaJosKortillaTarpeeksiRahaa() {
        kortti = new Maksukortti(10000);
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(9360, kortti.saldo());
        assertTrue(kortti.otaRahaa(640));
        assertEquals(2, kassapaate.edullisiaLounaitaMyyty() + kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortinSummaJaMyytyjenLounaidenMaaraEivatMuutuJosKortillaEiTarpeeksiRahaa() {
        kortti = new Maksukortti(100);
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
        assertFalse(kortti.otaRahaa(640));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty() + kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassassaOlevaRahamaaraEiMuutuKortillaOstaessa() {
        kortti = new Maksukortti(10000);
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattessaKortinSaldoJaKassassaSummaMuuttuvat() {
        kortti = new Maksukortti(10000);
        kassapaate.lataaRahaaKortille(kortti, 5000);
        assertEquals(15000, kortti.saldo());
        assertEquals(105000, kassapaate.kassassaRahaa());
               
    }
    
    @Test
    public void kortinSaldojaKassassaSummaEivatMuutuJosKortilleEiLadata() {
        kortti = new Maksukortti(10000);
        kassapaate.lataaRahaaKortille(kortti, -100);
        assertEquals(10000, kortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
}