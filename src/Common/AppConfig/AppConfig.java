/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common.AppConfig;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

/**
 *
 * @author Ahmed
 */



public final class AppConfig {
    private static Document load() {
        Document doc = null;
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse (new File("config.xml"));
        }
        catch (ParserConfigurationException pce) {
            return null;
        }
        catch (IOException ioe) {
            return null;
        }
        catch (SAXException e) {
            return null;
        }
        
        return doc;
    }
    
    private static ArrayList<AppSetting> getAppSettings() {
        Document doc = load();
        ArrayList<AppSetting> appSettings = new ArrayList<AppSetting>();
        if (doc != null) {
            NodeList appSettingsList = doc.getElementsByTagName("appSettings");
            NodeList appSettingChilds = appSettingsList.item(0).getChildNodes();
            if (appSettingsList != null) {
                for (int i = 0; i < appSettingChilds.getLength(); ++i) {
                    if (appSettingChilds.item(i).hasAttributes()) {
                        NamedNodeMap attributesList = appSettingChilds.item(i).getAttributes();
                        AppSetting appSetting = new AppSetting();

                        for (int j = 0; j < attributesList.getLength(); ++j) {
                            if (attributesList.item(j).getNodeName() == "name") {
                                appSetting.name = attributesList.item(j).getNodeValue();
                            }
                            else if (attributesList.item(j).getNodeName() == "value") {
                                appSetting.value = attributesList.item(j).getNodeValue();
                            }
                        }
                        
                        appSettings.add(appSetting);
                    }
                }
            }
        }
        
        return appSettings;
    }
    
    public static AppSetting findAppSetting(String name) {
        ArrayList<AppSetting> appSettings = getAppSettings();
        for (int i = 0; i < appSettings.size(); ++i) {
            if (appSettings.get(i).name.toLowerCase().equalsIgnoreCase(name.toLowerCase())) {
                return appSettings.get(i);
            }
        } 
        
        return null;
    }
}