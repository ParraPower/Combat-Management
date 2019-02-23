/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common.AppConfig;

/**
 *
 * @author Ahmed
 */
public final class AppSetting {
    public AppSetting() {
        
    }
    public AppSetting(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public String name = "";
    public String value = "";
}
