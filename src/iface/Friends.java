package iface;

public class Friends {
    private User userRequest;
    private User friendRequested;



    public Friends (User userRequest, User friendRequested ) {
        this.userRequest = userRequest;
        this.friendRequested = friendRequested;
    }
    
    
    public User getUserRequest() {
        return userRequest;
    }

    public User getFriendRequested() {
        return friendRequested;
    }

}
