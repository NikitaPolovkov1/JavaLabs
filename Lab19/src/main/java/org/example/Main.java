package org.example;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

    public Izdanie CreateIzdanie(){
        Scanner scanner  = new Scanner(System.in);
        Izdanie temp = new Izdanie();
        System.out.println("Enter title: ");
        temp.setTitle(scanner.nextLine());


        boolean flag = false;
        do {
            System.out.println("Enter type: \n1-newspaper\n2-magazine\n3-booklet");
           int chose = scanner.nextInt();
           switch (chose)
           {
               case 1:
                   temp.setType(Types.newspaper);
                   flag = true;
                   break;
               case 2:
                   temp.setType(Types.magazine);
                   flag = true;
                   break;
               case 3:
                   temp.setType(Types.booklet);
                   flag = true;
                   break;
               default:
                   System.out.println("Enter valid data");
                   break;
           }
        }while (!flag);

        System.out.println("Enter monthly: ");
        temp.setMonthly(scanner.nextLine());
        flag = false;

        do {
            System.out.println("Enter color: \n1-color\n0-uncolor");
            int chose = scanner.nextInt();
            switch (chose)
            {
                case 1:
                    temp.setColor(true);
                    if(temp.getType() == Types.newspaper)
                    {
                        System.out.println("You cant get color newspaper, please select another type");
                        break;
                    }
                    flag = true;
                    break;
                case 2:
                    temp.setColor(false);
                    flag = true;
                    break;
                default:
                    System.out.println("Enter valid data");
                    break;
            }

        }while(!flag);
        System.out.println("Enter count of pages: ");
        temp.setPages(scanner.nextInt());

        flag = false;

        do {
            System.out.println("Enter glossy: \n1-glossy\n0-unglossy");
            int chose = scanner.nextInt();
            switch (chose)
            {
                case 1:
                    temp.setGlossy(true);
                    if(temp.getType() == Types.newspaper)
                    {
                        System.out.println("You cant get glossy newspaper, please select another type");
                        break;
                    }
                    flag = true;
                    break;
                case 2:
                    temp.setGlossy(false);
                    flag = true;
                    break;
                default:
                    System.out.println("Enter valid data");
                    break;
            }

        }while(!flag);


        System.out.println("Enter subscription index: ");
        if(temp.getType() == Types.booklet)
        {
            System.out.println("You cant enter subscription index, because you chose a booklet");
        }
        else {
            temp.setSubscriptionIndex(scanner.nextLine());
        }
        return temp;
    }

    public static void CreateXmlFile() throws TransformerException, ParserConfigurationException {

        ArrayList<Izdanie> izd = new ArrayList<Izdanie>();
        izd.add(new Izdanie("Butterfly", Types.newspaper, "12 a month", false, 4, false, "22dd44", new char[]{'2','3', '4'}));
        izd.add(new Izdanie("Hasdasd", Types.magazine, "11 a month", true, 100, true, "11dd", new char[]{'5','2', '4'}));
        izd.add(new Izdanie("SDFhgbbbf", Types.booklet, "1 a month", true, 1, false, "sdf", new char[]{'s','d', '4'}));
        izd.add(new Izdanie("Glosskfiwjhf", Types.magazine, "1 a month", true, 100, true, "33ddtt", new char[]{'a','g', '4'}));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Paper");
        doc.appendChild(rootElement);

        for(Izdanie a : izd) {

            Element title = doc.createElement("Title");
            title.setTextContent(a.getTitle());
            rootElement.appendChild(title);

            Element type = doc.createElement("Type");
            type.setTextContent(String.valueOf(a.getType()));
            rootElement.appendChild(type);

            Element monthly = doc.createElement("Monthly");
            monthly.setTextContent(a.getMonthly());
            rootElement.appendChild(monthly);


            Element countPages = doc.createElement("CountPages");
            countPages.setTextContent(Integer.toString(a.getPages()));
            rootElement.appendChild(countPages);

            Element color = doc.createElement("Color");
            if (a.getColor()) {
                color.setTextContent("color");
            } else {
                color.setTextContent("Not color");
            }
            rootElement.appendChild(color);

            Element glossy = doc.createElement("Glossy");
            if (a.isGlossy()) {
                glossy.setTextContent("Glossy");
            } else {
                glossy.setTextContent("Not glossy");
            }
            rootElement.appendChild(glossy);


            if (a.getSubscriptionIndex() != null) {
                Element index = doc.createElement("SubsriptionIndex");
                index.setTextContent(a.getSubscriptionIndex());
                rootElement.appendChild(index);
            }
            Element chars = doc.createElement("Chars");
            for (char item : a.getChars()) {
                Element ittemp = doc.createElement("item");
                ittemp.setTextContent(Character.toString(item));
                chars.appendChild(ittemp);
            }
            rootElement.appendChild(chars);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result1 = new StreamResult(new File("test.xml"));
            transformer.transform(source, result1);
        }
    }

    public static void ConvertXmlDocument() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("test.xml"));

        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource(new File("test.xsl"));

        Transformer transformer = tf.newTransformer(xslt);

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        Writer writer = new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        writer.close();

    }

    public static void ReadXmlFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(new File("test.xml"));

        doc.getDocumentElement().normalize();

        System.out.println("Start element: " + doc.getDocumentElement().getNodeName() + "\n");


        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 1; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                if(node.getNodeName() == "item")
                {
                    System.out.print("\t" + node.getNodeName() + ":" + node.getTextContent() + "\n" );
                }
                else {
                    System.out.print(node.getNodeName() + ":" + node.getTextContent() + "\n");
                }
            }
        }
    }
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 - write, 2 - convert, 3 - read");
        int a = scanner.nextInt();

        switch (a)
        {
            case 1:
                CreateXmlFile();
                break;
            case 2:
                ConvertXmlDocument();
                break;
            case 3:
                    ReadXmlFile();
                    break;
            default:
                break;
        }


    }
}