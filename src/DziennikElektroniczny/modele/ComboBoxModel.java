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
public class ComboBoxModel extends DefaultComboBoxModel<String> {

    public ComboBoxModel(String[] listaKlas) {
       super(listaKlas);
    }
    
    @Override
    public String getSelectedItem() {
        String wybranaKlasa = (String) super.getSelectedItem();
        return wybranaKlasa;
    }
}
