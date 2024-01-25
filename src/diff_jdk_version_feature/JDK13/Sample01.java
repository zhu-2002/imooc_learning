package diff_jdk_version_feature.JDK13;

public class Sample01 {
    public static void main(String[] args) {
        String str = "<html>\n\t<head>\n\t</head>\n\t我是文本\n\t</body>\n</html>" ;
        System.out.println(str);
        String str2 = """
                <html>
                	<head>
                	</head>
                	我是文本
                	</body>
                </html> 
                """;
        System.out.println(str2);
    }
}
