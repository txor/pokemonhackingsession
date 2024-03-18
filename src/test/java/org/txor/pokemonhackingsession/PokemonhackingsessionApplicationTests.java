package org.txor.pokemonhackingsession;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
@AutoConfigureWebTestClient(timeout = "9999999")
class PokemonhackingsessionApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
//	@Disabled
    void getHeaviest() {
        webTestClient
				.get()
				.uri("http://localhost:8080/heaviest")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody()
				// ["Celesteela"]
				.jsonPath("$[0]").isEqualTo("Celesteela")
				.jsonPath("$[1]").isEqualTo("Cosmoem")
				.jsonPath("$[2]").isEqualTo("Primal Groudon")
				.jsonPath("$[3]").isEqualTo("Eternatus")
				.jsonPath("$[4]").isEqualTo("Groudon")
		;
    }

}
