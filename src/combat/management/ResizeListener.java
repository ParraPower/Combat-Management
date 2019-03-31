/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Ahmed
 */
public class ResizeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Recalculate the variable you mentioned
            UsersPanel userPanel = (UsersPanel)e.getComponent();
            userPanel.rebuildGrid();
        }
}
