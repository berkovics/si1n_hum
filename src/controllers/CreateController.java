package controllers;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import models.Database;
import models.Employee;
import views.CreateFrame;
import views.MainFrame;

public class CreateController {
    CreateFrame createFrame;
    MainFrame mainFrame;

    public CreateController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.createFrame = new CreateFrame(this.mainFrame);
        this.handleEvent();
    }

    public CreateFrame getCreateFrame() {
        return createFrame;
    }

    private void handleEvent() {
        JButton addButton = this.createFrame.getAddButton();
        addButton.addActionListener(e -> {
            startAdding();
        });
    }

    private void startAdding() {
        System.out.println("hozzáadása...");
        String NameStr = createFrame.getNamePanel().getValue();
        String CityStr = createFrame.getCityPanel().getValue();
        String SalaryStr = createFrame.getSalaryPanel().getValue();
        Double salary = Double.parseDouble(SalaryStr);
        Employee emp = new Employee(NameStr, CityStr, salary);
        new Database().insertEmployee(emp);
        Vector<String> empStr = new Vector<>();
        // TODO: Az insertEmployee() nem adja vissza
        // az id-t. Ha meg van akkor feltölthető a
        // Vector
        this.mainFrame.getModel().addRow(empStr);
        JOptionPane.showMessageDialog(createFrame, "Az hozzáadás megtörtént");
    }
}
