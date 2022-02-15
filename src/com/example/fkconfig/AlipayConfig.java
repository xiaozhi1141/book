package com.example.fkconfig;

import com.example.web.OrderServlet;

import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117671073";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCx+pSv66OrkWvVT0w/s9yvHyPYChLIBLcHcZFNmKvZwUuTy6iqt2jhQI/XmVlbu8O52S3dsv/dmMxVHL4wLWRgU1fJgTIZQWVNXMqYguidSpF9At7JoH2Ti1OBZlyiOkgcVcKjfmDFOK7VoAhJNZMEFUxDPc6z5KOnbQmY5q+u9ooww9buf9TdkdL/trQrz4JBrkPGiT3D2NjmhmwtFHN6HUBhUmHE07GeFIKdh+Azg/N4DnSO8rw9l9wOkl9CKI8hVnwh0dzX6WFDksivMw37MD8MlcABnQR1pbrW7ryk/AXOYcPFm/MUClBfmCA+g7cspOI6HpORs9z/NrOsKj1VAgMBAAECggEAEV07SHaa/1Auzx7vd3+a1lMZcih5cJ5VJRrFbGaqzZH4R7ElAZLnXqKn5gcGGtcU33r66JhgMkSIGv206IplMqiu9e/u7VveAFA/S+Xpv/7YdvPivJU160E6onNUMlexVWJgnQbldhhzpk/4vvvFHi7dw+mx0wdJmDohJ5PKLC2jtYyxmwj3wLrFiR5/107jvqLR5Esuw/fGkiGJbrcGSzrWWdSgM5MmYMWbdMt7ztQlCg2L0RwJd7rjGbpwPNVxNLKu/bUdf2tBn17lR86TXxmD0muRAk+unZOulnOF7NOkEMmgFSARGNjms/3PXOFbC5Z6l0eSebkp/CRCZj0m+QKBgQDqI52UDbEV1Z/Nyc1ItTZUQeK9Uf5M0sLYI8BVblwV47Jtxtv0xmYHFi97Vrh71Ma/mu2FUpnJA2IbW36VF00zhPJdGgqKEgctgSxEad2jFCYsze7bjeEgohaverxPFdnhs7Sn4bE1jQXdEzvTXUsH5uLmqlSsmjS2PMTrdPkoywKBgQDCmJ/E2dFv7dHmTlVSkVBt6whw81awmGvSZq7iciZtrCcEECJD/MXUp0jfdpPKxgmt+Gkq3Ytf0YmjXg5Yke0iCAQ0J5BsdKhEJlA60FmIyJNIdUmgtqYnCf92k0jA+7uHddBjIIceOLQ7sMEPg767ufc5tahcThKAT6/mEEsOXwKBgQDY+epkso+B2Xb/IN0BXRUc3fW+VkagcMwpum/Ze60Qh/LpMljRrC4OsSuNVB8gel04YN1uKM7k7iKzkYVrqq1baf+j8acErpJCRCt+ttCy+NArwydwBTo0oKD/O3FYpLpGI9/tmAQ9yRM+/Tz6scD/cKKi+gP/8+OXYhdmz/66IwKBgE7Ur1x6dMqoB/EJaK0jKvbsUKYZHdQ6WuuIJ26amZCyPbf6pTbvjmDgR7gm/CYX5dHxIQF5cD2nz987egpNS0gPAUzzfiFBfOzmrHe28Z5kyq1+vg36EAMenLu3XLC5CbYNdxbBFZubkv/fUcZsM3cvFcTuHz8NbZdHMNW9Yfp3AoGBANGGaYC4OjlRZwFdUFbJ/rbt72ZPSWEDxnhNZyxR0pqKh1MAWLPhRabxWN2mWnBBJ/QKcYYbgrhESF73f8BYlNDYuvXCeHEaRnf/Z9txaBdGplq/agL2YOLJzcwjI1a856JZsXTE0TVCiwV9XjMuWVBbnsXQQNBZQaXpdppVlr8L";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh9o3dP26iUqq4VQGdF5/GeoX1Q689NJrQsXqHpFUFuemU2OH9SxCi+2CBIz22Fh0XA6DlbKlq3Ob5zOZ4uWakFpvG9B1zPe3w5nXiWhq3fN+GdctOGx3zThtBPaQ8ki5OyBDYLLoCFhCtLlku96tQXlOxwhKbR3cTkptCCsfYtYIklzaiBaJOYNP4xckCkFkUeR4VHD+YQuR4lvPOnOjGewCGIxeaER40qb/OmaDHwp1eN+Mw/8/Ju9WVQxGzJVbHP8OVYxmFw3Ufe89EP9s9WY4QPw+qmVKyma9X9UHy8s3803sPnoUvtfJs93osXSHVUl5Myynb2b3PFDpea8zGQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://"+OrderServlet.ip+":8088/book/orderServlet?action=createOrderAfter";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://"+OrderServlet.ip+":8088/book/orderServlet?action=createOrderAfter";
//    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://holer65531.wdom.net/book/orderServlet?action=createOrderAfter";
//
//    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://holer65531.wdom.net/book/orderServlet?action=createOrderAfter";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

