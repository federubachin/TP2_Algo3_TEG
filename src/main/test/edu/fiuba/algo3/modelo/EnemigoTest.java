package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {

    @Test
    public void losPuntosDeDanioSonIgualesALosDeSalud() {
        Enemigo enemigo = new Enemigo(10);

        assertEquals(enemigo.puntosDeDanio(), enemigo.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    public void comienzaConTantosPuntosDeDanioComoSeIndique(int puntosDeDanio) {
        Enemigo enemigo = new Enemigo(puntosDeDanio);
        assertEquals(puntosDeDanio, enemigo.puntosDeDanio());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    public void comienzaConTantosPuntosDeSaludComoSeIndique(int puntosDeSalud) {
        Enemigo enemigo = new Enemigo(puntosDeSalud);
        assertEquals(puntosDeSalud, enemigo.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void pierdePuntosDeSaludCorrectamente(int danio) {
        Enemigo enemigo = new Enemigo(10);
        int puntosDeSaludIniciales = enemigo.puntosDeSalud();

        enemigo.recibirDanio(danio);

        assertEquals(puntosDeSaludIniciales - danio, enemigo.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void luegoDeUnAtaquePierdePuntosDeDanio(int danio) {
        Enemigo enemigo = new Enemigo(10);
        int puntosDeDanioIniciales = enemigo.puntosDeDanio();

        enemigo.recibirDanio(danio);

        assertEquals(puntosDeDanioIniciales - danio, enemigo.puntosDeDanio());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 13, Integer.MAX_VALUE})
    public void siElAtaqueEsMuyAltoMuere(int danio) {
        Enemigo enemigo = new Enemigo(10);

        enemigo.recibirDanio(danio);

        assertEquals(0, enemigo.puntosDeDanio());
    }
}