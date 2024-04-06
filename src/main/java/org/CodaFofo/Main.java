package org.CodaFofo;

import org.apache.commons.mail.EmailException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws EmailException {
        GmailConfig gmailConfig = new GmailConfig();
        EmailManager emailManager = new EmailManager(gmailConfig);
        List listaEmail = List.of("felipe.pinheiro@ucsal.edu.br","ian.almeida@ucsal.edu.br","fabiano.lobo@ucsal.edu.br","pauloricardo.santana@ucsal.edu.br","filipemiranda.oliveira@ucsal.edu.br","mario.pereira@pro.ucsal.br");
        List listaEmail2 = List.of("fabiano.lobo@ucsal.edu.br","filipemiranda.oliveira@ucsal.edu.br");
//        emailManager.sendSimpleEmailToMany(listaEmail2,"Email de teste do trabalho de POO avançado","Teste trabalho POO anaçado");
        emailManager.sendSimpleEmailHtmlToMany(listaEmail2,"<h1>Teste trabalho POO anaçado</h1><a href=”https://youtu.be/Sagg08DrO5U?si=-aUujh_RPQOOwX4K”>Click aqui, não é vírus</a>","teste","Teste trabalho POO avanaçado");
    }
}