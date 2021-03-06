package cn.com.webxml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2019-05-11T16:12:56.344+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://WebXml.com.cn/", name = "EnglishChineseHttpPost")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EnglishChineseHttpPost {

    /**
     * <br /><h3>中英文双向翻译（基本）String()</h3><p>输入参数：wordKey = 单词； 返回数据：一维字符串数组 String[]。</p><br />
     */
    @WebMethod(operationName = "TranslatorString")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString translatorString(
        @WebParam(partName = "wordKey", name = "wordKey", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String wordKey
    );

    /**
     * <br /><h3>中英文双向翻译（例句）String()</h3><p>输入参数：wordKey = 单词； 返回数据：一维字符串数组 String[]。</p><br />
     */
    @WebMethod(operationName = "TranslatorSentenceString")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString translatorSentenceString(
        @WebParam(partName = "wordKey", name = "wordKey", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String wordKey
    );

    /**
     * <br /><h3>中英文双向翻译 DataSet</h3><p>输入参数：wordKey = 单词； 返回数据：DataSet。（包括全部数据三个DataTable）</p><br />
     */
    @WebMethod(operationName = "Translator")
    @WebResult(name = "DataSet", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public DataSet translator(
        @WebParam(partName = "wordKey", name = "wordKey", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String wordKey
    );

    /**
     * <br /><h3>获得朗读MP3字节流</h3><p>输入参数：Mp3 = Mp3名称； 返回数据：字节数组 Byte[]。</p><br />
     */
    @WebMethod(operationName = "GetMp3")
    @WebResult(name = "base64Binary", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public byte[] getMp3(
        @WebParam(partName = "Mp3", name = "Mp3", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String mp3
    );

    /**
     * <br /><h3>获得候选词</h3><p>输入参数：wordKey = 单词； 返回数据：一维字符串数组 String[]。</p><br />
     */
    @WebMethod(operationName = "SuggestWord")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString suggestWord(
        @WebParam(partName = "wordKey", name = "wordKey", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String wordKey
    );

    /**
     * <br /><h3>中英文双向翻译（相关词条）String()</h3><p>输入参数：wordKey = 单词； 返回数据：一维字符串数组 String[]。</p><br />
     */
    @WebMethod(operationName = "TranslatorReferString")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString translatorReferString(
        @WebParam(partName = "wordKey", name = "wordKey", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String wordKey
    );
}
