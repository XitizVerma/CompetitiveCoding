package DesignPatterns.CreationalPatterns.BuilderDesignPattern;

public class User {

    private String userId;
    private String userName;
    private String email;

    private User(UserBuilder userBuilder){
        this.userId=userBuilder.userId;
        this.userName=userBuilder.userName;
        this.email=userBuilder.email;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    static class UserBuilder{

        private String userId;
        private String userName;
        private String email;

        public UserBuilder(){

        }

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }

}
