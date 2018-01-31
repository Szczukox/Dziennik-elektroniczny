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
public class NauczycieleComboBoxModel extends DefaultComboBoxModel<String> {

    public NauczycieleComboBoxModel(String[] listaNauczycieli) {
        super(listaNauczycieli);
    }

    @Override
    public String getSelectedItem() {
        String wybranyNauczyciel = (String) super.getSelectedItem();
        return wybranyNauczyciel;
    }
}
