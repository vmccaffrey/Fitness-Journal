public class Pair<Username,Password> {
    private Username name;
    private Password pass;
	
    public Pair(Username name, Password pass){
        this.name = name;
        this.pass = pass;
    }
	
    public Username getUsername(){ return name; }
    public Password getPassword(){ return pass; }
	
    public void setUsername(Username name){ this.name = name; }
    public void setPassword(Password pass){ this.pass = pass; }
}