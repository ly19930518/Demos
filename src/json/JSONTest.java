package json;

import net.sf.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		student student = new student();
		student.setId("Y0001");
		student.setName("小白");
		student.setAge("19");
		student.setSex("男");
		System.out.println(JSONObject.fromObject(student));
	}
}
