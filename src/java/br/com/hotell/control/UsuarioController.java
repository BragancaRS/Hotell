
package br.com.hotell.control;

import br.com.hotell.model.DAO.UsuarioDAO;
import br.com.hotell.model.OB.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Raphael Bragança
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String autenticar() {
        System.out.println("sdkçlfmsçdflm");
        if (UsuarioDAO.autenticar(usuario)) {
            usuario = UsuarioDAO.consultarUsuario(usuario);
            if (usuario.getPerfil() == 1) {
                return "view/newjsf";
            }
        }
        return "view/newjsf";
    }
    
    public String cadastrarUsuario(){
        return "sucesso";
    }

}
