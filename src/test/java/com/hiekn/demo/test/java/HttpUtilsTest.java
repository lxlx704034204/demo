package com.hiekn.demo.test.java;

import javax.ws.rs.core.GenericType;

import com.hiekn.demo.bean.Student;
import com.hiekn.demo.bean.result.RestResp;
import com.hiekn.demo.util.HttpUtils;

public class HttpUtilsTest {
	public static void main(String[] args) {
		String url = "http://192.168.1.119:9080/demo/api/test/test2";
		RestResp<Student> rs = HttpUtils.sendPost(url, null, null, new GenericType<RestResp<Student>>(){});
		System.out.println(rs.getData().getRsData().get(0).getAge());
	}
}