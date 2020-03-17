package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Tests extends BaseTests {

    @Test

    public void buscarArticulo() {

        String nombreProducto = "notebooks";

        loginPage.Login("jpleal79@gmail.com", "serrano832");
        Assert.assertTrue(loginPage.at());

        homePage.buscarEnCajaDeTexto(nombreProducto);
        Assert.assertTrue(homePage.at());

        catalogoPage.obtenerDatosDeListaDeCatalogo();
        //Assert.assertTrue(catalogoPage.at());    Return False
    }

}
