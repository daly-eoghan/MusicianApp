package com.example.assignment1;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MusicianFromXml {
    private final Musician[] musicians;
    private final Context context;

    public MusicianFromXml(Context context) {

        this.context = context;

        // Open the string to the XML file, a DocBuilder and a Doc.
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try {
            stream = this.context.getResources().openRawResource(R.raw.musicians);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);

        } catch (Exception e) {

        }

        //slice xmlDoc to NodeList
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList bandList = xmlDoc.getElementsByTagName("band");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList roleList = xmlDoc.getElementsByTagName("role");
        NodeList infoList = xmlDoc.getElementsByTagName("info");
        NodeList urlList = xmlDoc.getElementsByTagName("url");

        // Make People.
        musicians = new Musician[nameList.getLength()];
        for ( int i = 0; i < musicians.length; i++ ){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String band = bandList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String role = roleList.item(i).getFirstChild().getNodeValue();
            String info = infoList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            musicians[i] = new Musician(name, band, image, role, info, url);
        }
    }

    public Musician getMusician(int index){return musicians[index];}

    public Musician[] getMusicians(){return musicians;}
}
