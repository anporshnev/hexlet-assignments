package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        storage.forEach((k, v) -> {
            set(k, v);
        });
    }

    @Override
    public void set(String key, String value) {
        var storage = getStorage();
        storage.put(key, value);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        var storage = getStorage();
        storage.remove(key);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        var storage = getStorage();
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return getStorage();
    }

    private Map<String, String> getStorage() {
        return Utils.unserialize(Utils.readFile(path));
    }
}
// END
