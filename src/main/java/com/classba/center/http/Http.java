package com.classba.center.http;

import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Http
{
	protected String url = "http://www.baidu.com";

	@Test
	public void inputStream()
	{
		try {
			URL url = new URL(this.url);
			try {
				URLConnection connection = url.openConnection();
				connection.connect();
				byte[]                buffer       = new byte[1024];
				int                   len          = 0;
				InputStream           inputStream  = connection.getInputStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				while ((len = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, len);
				}
				outputStream.close();
				String data = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
				System.out.println(data);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void jsoup()
	{
		try {
			String data = Jsoup.parse(new URL(url), 3000).toString();
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * InputStreamReader
	 * BufferedReader
	 */
	@Test
	public void read()
	{
		try {
			URL url = new URL(this.url);
			try {
				URLConnection connection = url.openConnection();
				connection.connect();
				byte[]         buffer         = new byte[1024];
				int            len            = 0;
				InputStream    inputStream    = connection.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String         txt            = "";
				StringBuilder  sb             = new StringBuilder();
				while ((txt = bufferedReader.readLine()) != null) {
					sb.append(txt);
				}
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void urlEncode()
	{
		Map<String, String> data = new HashMap<>();
		data.put("name", "lwenjim");
		data.put("age", "22");
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, ?> i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String txt = sb.toString();
		txt = txt.substring(0, txt.length() - 1 - 1);
		System.out.println(txt);
	}
}
