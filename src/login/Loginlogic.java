package login;
import dao.LoginDAO;

public class Loginlogic{
	public boolean execute(User user) {
		LoginDAO logindao = new LoginDAO();
		boolean result = logindao.login(user.getName(),user.getPass());
		if(result){
			return true;
		}
		return false;
	}
}
