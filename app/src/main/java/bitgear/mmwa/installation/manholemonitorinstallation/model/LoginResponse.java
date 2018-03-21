package bitgear.mmwa.installation.manholemonitorinstallation.model;

/**
 * Created by ila on 20.3.18..
 */

public class LoginResponse {

    private String name;
    private String api_token;
    private Integer token_created_at;

    public LoginResponse(String name, String api_token, Integer token_created_at) {
        this.name = name;
        this.api_token = api_token;
        this.token_created_at = token_created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public Integer getToken_created_at() {
        return token_created_at;
    }

    public void setToken_created_at(Integer token_created_at) {
        this.token_created_at = token_created_at;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "name='" + name + '\'' +
                ", api_token='" + api_token + '\'' +
                ", token_created_at=" + token_created_at +
                '}';
    }
}
