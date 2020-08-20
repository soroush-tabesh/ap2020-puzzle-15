package ir.soroushtabesh.puzzle_game.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.soroushtabesh.puzzle_game.model.Config;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigLoader {

    public static final String DEFAULT_CONFIG = "default";
    private static final ConfigLoader instance = new ConfigLoader();
    private Gson gson;
    private Config currentConfig;

    private ConfigLoader() {
        initGson();
    }

    public static ConfigLoader getInstance() {
        return instance;
    }

    private void initGson() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Config loadConfig() {
        return loadConfig(DEFAULT_CONFIG);
    }

    public Config loadConfig(String name) {
        currentConfig = new Config();
        try {
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("configs/").toURI().resolve(name + ".json"));
            String json = Files.readString(path);
            currentConfig = gson.fromJson(json, Config.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentConfig;
    }

    public Config getCurrentConfig() {
        if (currentConfig == null)
            loadConfig();
        return currentConfig;
    }

    public void writeConfig(Config config) {
        try {
            String json = gson.toJson(config);
            URI resolve = getClass().getClassLoader()
                    .getResource("configs").toURI().resolve(config.getName() + ".json");
            System.out.println(resolve);
            Path path = Paths.get(resolve);
            Files.write(path, json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
