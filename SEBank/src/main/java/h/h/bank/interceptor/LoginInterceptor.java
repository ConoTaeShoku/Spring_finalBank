package h.h.bank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// bean으로 자동 등록되는 annotation이 없기 때문에 servlet-context.xml에 등록해줘야함
public class LoginInterceptor extends HandlerInterceptorAdapter {

	// parameter에 session을 가져오려는 순간 overloading이 됨
	// 위에 autowired를 적어도 controller, repository가 아니므로 못 뽑아옴
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		// 인증되지 않았으므로 로그인 페이지로 리다이렉트 처리함
		if (loginId == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			// controller 쪽으로 보내서 다시 재호출 하라는 뜻
			return false;
		}
		// 인증이 되었으므로 요청된 경로로 진행이 가능함(true)
		return true;
	}

}
