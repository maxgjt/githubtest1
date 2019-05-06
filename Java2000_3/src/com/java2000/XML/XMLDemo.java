package com.java2000.XML;

import com.sun.org.apache.xerces.internal.dom.ChildNode;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class XMLDemo {
    @Test
    public void saxParseXML() throws ParserConfigurationException, SAXException, IOException {
        //1.创建一个SAX 解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        //2.通过工厂对象创建一个SAX解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();

        //3.创建一个数据解析器
        PersonHandler personHandler = new PersonHandler();

        //4.开始解析
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/XML/person.xml");
        saxParser.parse(is, personHandler);
        List<Person> persons = personHandler.getPersons();
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    @Test
    public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
//        1.	创建一个DOM 解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        2.	通过工厂对象创建解析器对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//        3.	解析文档
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/XML/person.xml");
        Document doc = documentBuilder.parse(is);
//        4.从内存中读取数据;
        NodeList personNodeList = doc.getElementsByTagName("person");
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        //此循环会迭代两次
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);
            p = new Person();
            //获取节点的属性值
            String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
            //获取当前节点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if ("name".equals(nodeName)) {
                    p.setName(item.getFirstChild().getNodeValue());
                } else if ("address".equals(nodeName)) {
                    p.setAddress(item.getFirstChild().getNodeValue());
                } else if ("tel".equals(nodeName)) {
                    p.setTel(item.getFirstChild().getNodeValue());
                } else if ("fax".equals(nodeName)) {
                    p.setFax(item.getFirstChild().getNodeValue());
                } else if ("email".equals(nodeName)) {
                    p.setEmail(item.getFirstChild().getNodeValue());
                }
            }

            persons.add(p);
        }
        System.out.println("结果。。。");
        System.out.println(Arrays.toString(persons.toArray()));
    }

    //JDOM 解析XML
    @Test
    public void jdomParseXML() throws JDOMException, IOException {
        //创建JDOM解析器
        SAXBuilder builder = new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/XML/person.xml");

        org.jdom2.Document build = builder.build(is);
        Element rootElement = build.getRootElement();
        ArrayList<Person> list = new ArrayList<>();
        Person person = null;
        List<Element> children = rootElement.getChildren();
        for (Element element : children) {
            person = new Person();
            String personid = element.getAttributeValue("personid");
            person.setPersonid(personid);

            List<Element> children1 = element.getChildren();
            for (Element e : children1) {
                String tag = e.getName();
                if ("name".equals(tag)) {
                    person.setName(e.getText());
                } else if ("address".equals(tag)) {
                    person.setAddress(e.getText());
                } else if ("tel".equals(tag)) {
                    person.setTel(e.getText());
                } else if ("fax".equals(tag)) {
                    person.setTel(e.getText());
                } else if ("email".equals(tag)) {
                    person.setEmail(e.getText());
                }
            }
            list.add(person);
        }
        System.out.println("结果。。。");
        System.out.println(Arrays.toString(list.toArray()));
    }

    //使用dom4j 解析
    @Test
    public void dom4jParseXML() throws DocumentException {
        //1 创建DOM4J 的解析器对象
        SAXReader reader = new SAXReader();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/java2000/XML/person.xml");
        org.dom4j.Document doc = reader.read(is);
        org.dom4j.Element rootElement = doc.getRootElement();
        Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
        ArrayList<Person> persons = new ArrayList<>();
        Person p =null;
        while (iterator.hasNext()){
            p = new Person();
            org.dom4j.Element e =  iterator.next();
            p.setPersonid(e.attributeValue("personid"));
            Iterator<org.dom4j.Element> iterator1 = e.elementIterator();
            while (iterator1.hasNext()){
                org.dom4j.Element next = iterator1.next();
                String tag = next.getName();
                if ("name".equals(tag)) {
                    p.setName(next.getText());
                } else if ("address".equals(tag)) {
                    p.setAddress(next.getText());
                } else if ("tel".equals(tag)) {
                    p.setTel(next.getText());
                } else if ("fax".equals(tag)) {
                    p.setTel(next.getText());
                } else if ("email".equals(tag)) {
                    p.setEmail(next.getText());
                }
            }
            persons.add(p);
        }
        System.out.println("结果。。。。");
        System.out.println(Arrays.toString(persons.toArray()));
    }

    // 把对象转成XML 文件写入：
    @Test
    public void xmlEncoder() throws FileNotFoundException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        Person person = new Person();
        person.setPersonid("1212");
        person.setAddress("北京");
        person.setEmail("maxgong@yeah.net");
        person.setTel("13247262987");
        person.setFax("13247262987");
        person.setName("maxgong");
        xmlEncoder.writeObject(person);
        xmlEncoder.close();

    }
    //从XML文件中读取对象
    @Test
    public void xmlDecoder() throws FileNotFoundException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.xml"));
        XMLDecoder decoder = new XMLDecoder(in);
        Person p = (Person) decoder.readObject();
        System.out.println(p);
    }
}