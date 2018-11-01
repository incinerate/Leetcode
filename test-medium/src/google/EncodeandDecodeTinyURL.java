package google;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * inyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need to
 * ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Oct 23, 2018 1:19:58 PM
 */
public class EncodeandDecodeTinyURL {
	
	/*
	 * explain:ͨ����˵����longurl��encode��decode�������ݿ�Ĵ洢�ϣ�shorten longURL���Լ��ٴ洢�ռ䣬�����ȡ��
	 * ������encodeʱֻҪ��֤codeֵΨһ���ɣ����⻹Ҫ����code��ĳ��ȣ��᲻���г�ͻ�ȵȡ��������ַ���ʵ�֣�һ�ֽм򵥣�������
	 * industry; ��һ�ֽ�����hashcode������
	 */

	ArrayList<String> urls = new ArrayList<>();
	HashMap<Integer,String> map = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		urls.add(longUrl);
		return String.valueOf(urls.size() - 1);
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int index = Integer.valueOf(shortUrl);
		return (index < urls.size()) ? urls.get(index) : "";
	}
	
	//approach 2(using hashcode)
	public String encode1(String longUrl) {
		map.put(longUrl.hashCode(), longUrl);
		return "http://tinyURL.com/"+longUrl.hashCode();
	}
	
	// Decodes a shortened URL to its original URL.
	public String decode1(String shortUrl) {
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyURL.com/", "")));
	}
	
	public static void main(String[] args) {
		EncodeandDecodeTinyURL tinyURL = new EncodeandDecodeTinyURL();
		System.out.println(tinyURL.encode1("https://leetcode.com/problems/design-tinyurl"));
		int hashCode = "https://leetcode.com/problems/design-tinyurl".hashCode();
		System.out.println(tinyURL.decode1("http://tinyURL.com/"+String.valueOf(hashCode)));
	}
}
