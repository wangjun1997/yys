package cn.wangjun.yys.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.HtmlEmail;

public class SendMailUtil {
 
    private static final String from = "962903632@qq.com";
 
    private static final String fromName = "��֤��";
 
    private static final String charSet = "utf-8";
 
    private static final String username = "962903632@qq.com";
 
    private static final String password = "zzfwacigaffjbbce";
 
    private static final String subject = "��֤��";
 
    private static Map<String, String> hostMap = new HashMap<String, String>();
    static {
        // 126
        hostMap.put("smtp.126", "smtp.126.com");
        // qq
        hostMap.put("smtp.qq", "smtp.qq.com");
 
        // 163
        hostMap.put("smtp.163", "smtp.163.com");
 
        // sina
        hostMap.put("smtp.sina", "smtp.sina.com");
 
        // tom
        hostMap.put("smtp.tom", "smtp.tom.com");
 
        // 263
        hostMap.put("smtp.263", "smtp.263.net");
 
        // yahoo
        hostMap.put("smtp.yahoo", "smtp.mail.yahoo.com");
 
        // hotmail
        hostMap.put("smtp.hotmail", "smtp.live.com");
 
        // gmail
        hostMap.put("smtp.gmail", "smtp.gmail.com");
        hostMap.put("smtp.port.gmail", "465");
 
        // sygongzhi.com
        hostMap.put("smtp.sygongzhi", "smtp.mxhichina.com");
 
    }
 
    private static boolean validate = true;// �Ƿ���Ҫ�����֤
 
    public static Properties getProperties() throws Exception {
        Properties p = new Properties();
        p.put("mail.smtp.host", getHost(from));
        p.put("mail.smtp.port", getSmtpPort(from));
        p.put("mail.smtp.auth", validate ? "true" : "false");
        return p;
    }
 
    public static String getHost(String email) throws Exception {
        Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
        Matcher matcher = pattern.matcher(email);
        String key = "unSupportEmail";
        if (matcher.find()) {
            key = "smtp." + matcher.group(1);
        }
        if (hostMap.containsKey(key)) {
            return hostMap.get(key);
        } else {
            throw new Exception("unSupportEmail");
        }
    }
 
    public static int getSmtpPort(String email) throws Exception {
        Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
        Matcher matcher = pattern.matcher(email);
        String key = "unSupportEmail";
        if (matcher.find()) {
            key = "smtp.port." + matcher.group(1);
        }
        if (hostMap.containsKey(key)) {
            return Integer.parseInt(hostMap.get(key));
        } else {
            return 25;
        }
    }
 
    /**
     * ������ͨ�ʼ�
     * 
     * @param toMailAddr
     *            �����˵�ַ
     * @param subject
     *            email����
     * @param message
     *            ����email��Ϣ
     */
    public static void sendCommonMail(String toMailAddr, String subject, String message) {
        HtmlEmail hemail = new HtmlEmail();
        try {
            hemail.setHostName(getHost(from));
            hemail.setSmtpPort(getSmtpPort(from));
            hemail.setCharset(charSet);
            hemail.addTo(toMailAddr);
            hemail.setFrom(from, fromName);
            hemail.setAuthentication(username, password);
            hemail.setSubject(subject);
            hemail.setMsg(message);
            hemail.send();
            System.out.println("email send true!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("email send error!");
        }
 
    }
 
    // @SuppressWarnings("unchecked")
    public static String getAppPath(Class<?> cls) {
        // ����û�����Ĳ����Ƿ�Ϊ��
        if (cls == null)
            throw new IllegalArgumentException("��������Ϊ�գ�");
        ClassLoader loader = cls.getClassLoader();
        // ������ȫ������������
        String clsName = cls.getName() + ".class";
        // ��ô���������ڵİ�
        Package pack = cls.getPackage();
        String path = "";
        // ���������������������ת��Ϊ·��
        if (pack != null) {
            String packName = pack.getName();
            // �˴����ж��Ƿ���Java������⣬��ֹ�û�����JDK���õ����
            if (packName.startsWith("java.") || packName.startsWith("javax."))
                throw new IllegalArgumentException("��Ҫ����ϵͳ�࣡");
            // ����������У�ȥ�������Ĳ��֣��������ļ���
            clsName = clsName.substring(packName.length() + 1);
            // �ж������Ƿ��Ǽ򵥰���������ǣ���ֱ�ӽ�����ת��Ϊ·����
            if (packName.indexOf(".") < 0)
                path = packName + "/";
            else {// �����հ�������ɲ��֣�������ת��Ϊ·��
                int start = 0, end = 0;
                end = packName.indexOf(".");
                while (end != -1) {
                    path = path + packName.substring(start, end) + "/";
                    start = end + 1;
                    end = packName.indexOf(".", start);
                }
                path = path + packName.substring(start) + "/";
            }
        }
        // ����ClassLoader��getResource�������������·����Ϣ�����ļ���
        java.net.URL url = loader.getResource(path + clsName);
        // ��URL�����л�ȡ·����Ϣ
        String realPath = url.getPath();
        // ȥ��·����Ϣ�е�Э����"file:"
        int pos = realPath.indexOf("file:");
        if (pos > -1)
            realPath = realPath.substring(pos + 5);
        // ȥ��·����Ϣ���������ļ���Ϣ�Ĳ��֣��õ������ڵ�·��
        pos = realPath.indexOf(path + clsName);
        realPath = realPath.substring(0, pos - 1);
        // ������ļ��������JAR���ļ���ʱ��ȥ����Ӧ��JAR�ȴ���ļ���
        if (realPath.endsWith("!"))
            realPath = realPath.substring(0, realPath.lastIndexOf("/"));
        /*------------------------------------------------------------
         ClassLoader��getResource����ʹ����utf-8��·����Ϣ�����˱��룬��·��
          �д������ĺͿո�ʱ���������Щ�ַ�����ת�����������õ�����������������Ҫ
          ����ʵ·�����ڴˣ�������URLDecoder��decode�������н��룬�Ա�õ�ԭʼ��
          ���ļ��ո�·��
        -------------------------------------------------------------*/
        try {
            realPath = java.net.URLDecoder.decode(realPath, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("realPath----->" + realPath);
        return realPath;
    }
}
