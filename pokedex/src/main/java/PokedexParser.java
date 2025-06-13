import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokedexParser {
    private static List<Pokemon> pokemons = new ArrayList<>();

    public static String readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void parsePokedex(String jsonContent) {
        JSONObject jsonObject = new JSONObject(jsonContent);
        JSONArray pokemonArray = jsonObject.getJSONArray("pokemon");

        for (int i = 0; i < 9; i++) {
            String num = pokemonArray.getJSONObject(i).getString("num");
            String name = pokemonArray.getJSONObject(i).getString("name");
            double weight = Double.parseDouble(pokemonArray.getJSONObject(i).getString("weight").replace("kg", "").trim());
            double height = Double.parseDouble(pokemonArray.getJSONObject(i).getString("height").replace("m", "").trim());
            List<String> nextEvolution = pokemonArray.getJSONObject(i).getString("next_evolution");

            Pokemon pokemon = new Pokemon(num, name, weight, height, nextEvolution);
            pokemons.add(pokemon);
        }
    }

    public static void howManyPokemons() {
        System.out.println(pokemons.size());
    }

    public static void whoIsFat(int weight) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getWeight() > weight) {
                System.out.println(pokemon.getName());
            }
        }
    }

    public static void sortFatties() {
        pokemons.sort(Comparator.comparingDouble(Pokemon::getWeight));
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getName());
        }
    }

    public static void whoIsNext(string name) {
        Pokemon pokemon = pokemons.get();
        for (String evolution : pokemon.getNextEvolution()) {
            System.out.println(evolution);
        }
    }
}
