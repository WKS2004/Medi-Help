package lk.sliit.project.onlinemedicalstore.medihelp.config;

public class AppConfig {
    private static AppConfig instance;
    private String basePath;

    private AppConfig() {}

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public void setBasePath(String path) {
        this.basePath = path;
    }

    public String getBasePath() {
        return this.basePath;
    }
}
