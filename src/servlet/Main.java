package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.GetMutterListLogic;
import login.Mutter;
import login.PostMutterLogic;
import login.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GetMutterListLogic getmutterlistlogic = new GetMutterListLogic();
		List<Mutter> mutterList = getmutterlistlogic.execute();
		request.setAttribute("mutterList", mutterList);

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginuser");

		if(loginUser == null) {
			response.sendRedirect("/docoTsubu");
		}else {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		if(text != null && text.length() != 0) {

			HttpSession session =request.getSession();
			User loginuser = (User)session.getAttribute("loginuser");

			Mutter mutter = new Mutter(loginuser.getName(),text);
			PostMutterLogic pml = new PostMutterLogic();
			//リストの参照値を渡しているため、渡した先のメソッドでリストを変更するとこちらも変更される
			pml.execute(mutter);

		}else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}

		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);


	}

}
