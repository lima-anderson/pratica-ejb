package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDAO;

    public List<Mensagem> listar() {
        return mensagemDAO.listar();
    }

    public void inserir(long id, String mensagem) {
        Mensagem novaMensagem = new Mensagem(id, mensagem);
        mensagemDAO.inserir(novaMensagem);
        if (id==3L) {
            throw new RuntimeException("Menor de idade não permitido!");
        }
        if (id == 4L) {
            novaMensagem.setMensagem(mensagem + " alterado");
        }
    }

    public Mensagem pesquisarPorId(long id) {
        return mensagemDAO.pesquisarPorId(id);
    }
}