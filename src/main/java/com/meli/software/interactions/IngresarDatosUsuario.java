package com.meli.software.interactions;

import com.meli.software.models.UsuarioGenerico;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.meli.software.userinterfaces.PaginaInicioSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarDatosUsuario implements Interaction {

    private final String firstName;
    private final String lastName;
    private final String age;
    private final String country;

    public IngresarDatosUsuario(String firstName, String lastName, String age, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    @Override
    @Step("#actor ingresa las información del usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(USERNAME_FIELD),
                Enter.theValue(lastName).into(PASSWORD_FIELD),
                Enter.theValue(age).into(AGE_FIELD),
                Click.on(COUNTRY_SELECT_FIELD),
                Click.on(COUNTRY_ITEMSELECTED_FIELD),
                Click.on(BUTTON_SIGN_IN)
        );
    }

    public static Performable conModelo(UsuarioGenerico usuarioGenerico) {
        return instrumented(IngresarDatosUsuario.class, usuarioGenerico.getFirstName(), usuarioGenerico.getLastName(), usuarioGenerico.getAge(), usuarioGenerico.getCountry());
    }
}
