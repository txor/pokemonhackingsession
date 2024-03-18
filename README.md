# Simple Pokémon Catcher App

Hacking session for Pokemon exercice.
Simple _**Pokémon Catcher App**_, intended to be used for TDD Katas.

## Requirements

The App should provide a REST endpoint that fetches a _random_ Pokémon from [PokéAPI v2](https://pokeapi.co/docs/v2) and returns its _name_.  
Request:  
```
GET /pokemon
```
Response:  
```json
{
  "name": "pikachu"
}
```

### Secuence diagram
<td> <img src="docs/assets/sequence.png" style="width: 400px;" alt="Sequence diagram"/>

## PokéAPI

Use the [PokéAPI v2 /pokemon endpoint](https://pokeapi.co/docs/v2#pokemon) to fetch Pokemon data
given a **pokemon id**

```
GET https://pokeapi.co/api/v2/pokemon/{id}
```

> **_HINTS:_**  
> - Using the first first 1000 Pokemons is far enough.  
> - We are only interested on the _name_ field of the JSON answer.

## Tech stack and included tools

This project is based on Java 17 and Spring Boot 3, it already provides:

- spring-web
- Testcontainers
- Lombok

To simplify the session the following code is already written:

| Files                                                                                                                                                            | Usage                                                                                             |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| [MockServerTestContainer.java](src/test/java/com/wefox/playground/pokemoncatcher/utils/MockServerTestContainer.java)                                             | MockServer and MockServerClient configuration for Testcontainers                                  |
| [FileUtils.java](src/test/java/com/wefox/playground/pokemoncatcher/utils/FileUtils.java)                                                                         | A class that allows reading files from test resources                                             |
| [pokeapi_answer.json](src/test/resources/pokeapi_answer.json)                                                                                                    | A JSON sample of PokéAPI _/pokemon_ answer                                                        |
| [PokemoncatcherIntegrationTest.java](src/test/java/com/wefox/playground/pokemoncatcher/PokemoncatcherIntegrationTest.java)                                       | A pre-made happy path (red) integration test.                                                     |
| [PokeApiClient.java](src/main/java/com/wefox/playground/pokemoncatcher/PokeApiClient.java)                                                                       | A pre-made HTTP client _@Component_ already wired with RestTemplate                               |
| [PokeApiClientTest.java](src/test/java/com/wefox/playground/pokemoncatcher/PokeApiClientTest.java)                                                               | A pre-made @RestClientTest client test with RestTemplate already wired and PokeApi mocking method |
| [PokeApiClientConfig.java](src/main/java/com/wefox/playground/pokemoncatcher/PokeApiClientConfig.java) and [application.yml](src/main/resources/application.yml) | A production ready configuration for RestTemplate                                                 |

## After the implementation

Once it is implemented, you should be able to start the App and get Pokemons
on http://localhost:8080/pokemon.  
*Notice that on every call you get a different one!* ;)