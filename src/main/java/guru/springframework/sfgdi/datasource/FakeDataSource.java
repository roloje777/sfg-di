package guru.springframework.sfgdi.datasource;

public class FakeDataSource {
    private String username;
    private String password;
    private String jdbUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("***" + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbUrl() {
        return jdbUrl;
    }

    public void setJdbUrl(String jdbUrl) {
        this.jdbUrl = jdbUrl;
    }
}
