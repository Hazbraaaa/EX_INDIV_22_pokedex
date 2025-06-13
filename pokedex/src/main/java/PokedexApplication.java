import java.io.IOException;

public class PokedexApplication {
    public static void main(String[] args) {
        try {
            String jsonContent = PokedexParser.readJsonFile("src/main/resources/pokedex.json");

            PokedexParser.parsePokedex(jsonContent);
            PokedexParser.howManyPokemons();
            PokedexParser.whoIsFat(10);
            PokedexParser.sortFatties();
            PokedexParser.whoIsNext(Bulbasaur);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
