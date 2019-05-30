package spring.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleIoc {
    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIoc(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + name);
        }
        return bean;
    }

    private void loadBeans(String location) throws Exception {
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                // 加载 beanclass = null;
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                    return;
                }

                Object bean = beanClass.newInstance();
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for(int j =0; j < propertyNodes.getLength(); j++){
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() > 0) {
                            declaredField.set(bean, value);
                        }else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0){
                                throw  new IllegalArgumentException("ref config error");
                            }

                            declaredField.set(bean,getBean(ref));
                        }

                        registerBean(id, bean);




                    }
                }

            }
        }

    }

    private void registerBean(String id, Object bean){
        beanMap.put(id, bean);
    }

    public static void main(String[] args) throws Exception {
//        String location = SimpleIoc.class.getClassLoader().getResource("spring-test.xml").getFile();
        SimpleIoc bf = new SimpleIoc("/Users/kunzhang/work/algorithm/src/main/java/spring/ioc/spring-test.xml");
        Wheel wheel = (Wheel) bf.getBean("wheel");

        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}


