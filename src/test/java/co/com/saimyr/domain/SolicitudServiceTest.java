package co.com.saimyr.domain;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudServiceTest {
    private SolicitudService solicitudService;
    private List<Solicitud> solicituds;

    @BeforeEach
    void setUp() {
        solicitudService = new SolicitudService();
        solicituds = solicitudService.getAll();
    }

    @AfterEach
    void tearDown() {
        solicitudService = null;
    }

    @Test
    void esNull() {
        assertNotNull(solicitudService);
    }

    @Test
    void getAll() {
        assertTrue( 2 == solicituds.size(), "Tiene el tamaño esperado");
    }



    @Nested
    class TodasLasPruebas {
        @Test
        @DisplayName("Se comprueba que el tamaño del grupo, si sea mayor que 2 integrantes")
        void tamanoGrupo() {
            assertTrue( 1 < solicitudService.tamanoGrupo(solicituds.get(0)), "Tamaño del grupo familiar mínimo de dos personas");
        }


        @Test
        void parentezco() {
            assertTrue(solicitudService.parentezco(solicituds.get(0)), "Si contiene un jefe");
        }

        @Test
        void ingresos() {
            assertTrue( 877802*4 > solicitudService.ingresos(solicituds.get(0)) , "Ingresos");
        }

        @Test
        void puntaje() {
            assertTrue(57 >= solicitudService.puntaje(solicituds.get(1)), "Puntaje sisben");
        }
    }

}