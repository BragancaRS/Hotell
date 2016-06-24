package br.com.hotell.filters;

/**
 *
 * @author Raphael bragança
 */
import br.com.hotell.model.OB.Usuario;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    public Usuario pessoa;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {

            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = reqt.getSession(false);
            String reqURI = reqt.getRequestURI();
            String pagina = reqt.getPathInfo();
            
            Usuario p = (Usuario) reqt.getSession().getAttribute("user");
            System.out.println(pagina + "   -------------------------------");
            if ( "/view/index.xhtml".equals(pagina) || p!= null) {
                chain.doFilter(request, response);
                System.out.println("sdsdsd");
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
    }

    @Override
    public void destroy() {
    }
}
