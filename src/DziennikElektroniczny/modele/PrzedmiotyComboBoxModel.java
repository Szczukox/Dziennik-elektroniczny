/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.modele;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author patry
 */
public class PrzedmiotyComboBoxModel extends DefaultComboBoxModel<String> {

    public PrzedmiotyComboBoxModel(String[] listaPrzedmiotow) {
        super(listaPrzedmiotow);
    }

    @Override
    public String getSelectedItem() {
        String wybranyPrzedmiot = (String) super.getSelectedItem();
        return wybranyPrzedmiot;
    }
}
