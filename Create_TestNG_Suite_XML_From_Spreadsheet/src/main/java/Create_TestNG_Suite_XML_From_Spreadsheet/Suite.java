package Create_TestNG_Suite_XML_From_Spreadsheet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "suite")
public class Suite {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "test")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List < Test > tests;

    public Suite(String name) {
        this.name = name;
        this.tests = new ArrayList < Suite.Test > ();
    }
    
    public void addTest(String testname, String paramName, String paramValue, String className) {
        Test test = new Test(testname);
        test.addParam(paramName, paramValue);
        Pattern.compile(",").splitAsStream(className).forEach(test::addClass);
        this.tests.add(test);
    }

    class Test {

        @JacksonXmlProperty(isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "parameter")
        private Parameter param;

        @JacksonXmlProperty(localName = "classes")
        private Classes klasses;

        public Test(String name) {
            this.name = name;
            klasses = new Classes();
        }

        public void addParam(String name, String value) {
            param = new Parameter(name, value);
        }

        public void addClass(String name) {
            klasses.assClasses(name);
        }

    }

    class Parameter {
        @JacksonXmlProperty(isAttribute = true)
        private String name;

        @JacksonXmlProperty(isAttribute = true)
        private String value;

        public Parameter(String name, String value) {
            this.name = name;
            this.value = value;
        }

    }

    class Classes {

        @JacksonXmlProperty(localName = "class")
        @JacksonXmlElementWrapper(useWrapping = false)
        private List < Class > classes;

        public Classes() {
            this.classes = new ArrayList < Suite.Class > ();
        }

        public void assClasses(String name) {
            this.classes.add(new Class(name));
        }
    }

    class Class {

        @JacksonXmlProperty(isAttribute = true)
        private String name;

        Class(String name) {
            this.name = name;
        }

    }

}