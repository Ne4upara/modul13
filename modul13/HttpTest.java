package ua.goit.sergey.modul13;

import ua.goit.sergey.modul13.todo.Address;
import ua.goit.sergey.modul13.todo.Company;
import ua.goit.sergey.modul13.todo.Geo;
import ua.goit.sergey.modul13.todo.User;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class HttpTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User(3, "Putin Huylo", "PNH", "putin@huylo.com",
                new Address("putin gandonovi4", "Fck. 666", "moskovVogne", "66554-2211",
                new Geo(-55.6677, 99.8877)),"(097) 546-44-33", "darkside.gom",
                new Company("Prigogin petushara", "Multi-layered client-server neural-net", "russian stupid people"));

        HttpSend.createUser(user);

        HttpSend.putUser(user, 3 );

        HttpSend.deleteUser(6);

        HttpSend.sendGetAllUsers();

        HttpSend.sendGetUserId(3);

        HttpSend.sendGetUsername("Maxime_Nienow");

        HttpSendForTask2.allCommentsLastId(5);

        HttpSendForTask3.openTaskForUser(5);

    }
}
