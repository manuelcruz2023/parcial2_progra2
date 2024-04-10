package co.edu.uptc.parcial2_progra2.controllers;

import java.io.IOException;

import co.edu.uptc.parcial2_progra2.services.ManagerTxt;
import co.edu.uptc.text.ManagerProperties;

public class ControllerManagerTxt {
    public void showManagerTxt() {
        ManagerProperties managerProperties = new ManagerProperties();
        managerProperties.setFileName("data.properties");
        ManagerTxt managerTxt = new ManagerTxt();
        managerTxt.setPath(managerProperties.getValue("content"));
        managerTxt.setSeparator(managerProperties.getValue("separator"));
        managerTxt.setLineBreak(managerProperties.getValue("lineBreak"));
        managerTxt.setComma(managerProperties.getValue("comma"));
        try {
            managerTxt.setFileName(managerProperties.getValue("early_childhood"));
            managerTxt.createFile(managerTxt.personToStringList(managerTxt.earlyChildhood()));
            managerTxt.setFileName(managerProperties.getValue("childhood"));
            managerTxt.createFile(managerTxt.personToStringList(managerTxt.childhood()));
            managerTxt.setFileName(managerProperties.getValue("adolescence"));
            managerTxt.createFile(managerTxt.personToStringList(managerTxt.adolescence()));
            managerTxt.setFileName(managerProperties.getValue("youth"));
            managerTxt.createFile(managerTxt.personToStringList(managerTxt.youth()));
            managerTxt.setFileName(managerProperties.getValue("adulthood"));
            managerTxt.createFile(managerTxt.personToStringList(managerTxt.adulthood()));
            managerTxt.setFileName(managerProperties.getValue("old_age"));
            managerTxt.createFile(managerTxt.personToStringList(managerTxt.oldAge()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
