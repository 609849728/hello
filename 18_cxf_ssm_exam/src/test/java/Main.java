import cn.com.webxml.ArrayOfString;
import cn.com.webxml.EnglishChineseSoap;
import cn.com.webxml.TranslatorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Main {

    @Autowired
    private EnglishChineseSoap englishChineseProxy;


    @Test
    public void test01() {
        ArrayOfString red = englishChineseProxy.translatorString("手机");
        List<String> list = red.getString();
        StringBuilder sb = new StringBuilder();
        for(String s:list){
            if(s!=null && s!="") {
                sb.append(s+",");
            }
        }
        System.out.println(sb);
    }

    @Test
    public void test02() {
        ArrayOfString red = englishChineseProxy.translatorSentenceString("red");
        List<String> list = red.getString();
        for(String s:list){
            System.out.println(s);
        }
    }


}
