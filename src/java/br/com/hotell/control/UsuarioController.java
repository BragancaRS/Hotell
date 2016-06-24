package br.com.hotell.control;

import br.com.hotell.model.DAO.UsuarioDAO;
import br.com.hotell.model.OB.Usuario;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael Bragança
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

    Usuario usuario = readCookie();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String autenticar() {
        if (UsuarioDAO.autenticar(usuario)) {
            usuario = UsuarioDAO.consultarUsuario(usuario);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
            if (usuario.getPerfil() == 1) {
                return "/view/newjsf";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuário ou Senha Inválido", ""));
        }
        return "/view/index";
    }

    public String cadastrarUsuario() {
        return "sucesso";
    }

    //Inserir cookie 
    public void inserirCookie(String login) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            //Cria cookie  
            Cookie ck = new Cookie("login", login);
            ck.setMaxAge(0); //Apos este tempo, em segundos, o cookie expirará automaticamente
            //Adiciona  
            ((HttpServletResponse) context.getExternalContext().getResponse()).addCookie(ck);
        }
    }

    public Usuario readCookie() {
        //Obter cookie    
        Usuario u = new Usuario();
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (ctx != null) {
            Map<String, Object> cookies = ctx.getExternalContext().getRequestCookieMap();
            Cookie cookie = (Cookie) cookies.get("login");
            if (cookie != null) {
                String login = cookie.getValue();
                u.setLogin(login);
                
            }
        }
        return u;
    }

}
