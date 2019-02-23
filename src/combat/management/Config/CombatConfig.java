/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Config;

import Common.AppConfig.AppConfig;
import Common.AppConfig.AppSetting;
/**
 *
 * @author Ahmed
 */
public final class CombatConfig {
    public static String UserImagesDirectory() { 
        AppSetting userImageDirectory = AppConfig.findAppSetting("userImagesDirectory");
        if (AppConfig.findAppSetting("userImagesDirectory") != null) {
            return userImageDirectory.value;
        }
        
        return null;
    }
}
