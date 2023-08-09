package test.java01;

/** ParamMap
Map의 기능을 활용하여 다음과 같은 타입을 만들고자 함.
	- 외부에서 객체생성 시 new가 아닌 init() 함수를 이용하여 객체생성할 수 있도록 설정
	  ParamMap paramMap = new ParamMap()
	  ParamMap paramMap = ParamMap.init()
	  
	- Map에서 키는 String만 사용하고자 함.
	  paramMap.put("key1","value1")
	  
	- String getString(String key) 신규생성하여 만들고자 함.
	  String val = paramMap.getString("key1")
	  
	- Integer getInteger(String key) 해당 키의 값을 Integer로 반환하여 주는 함수
	  paramMap.put("key2", 12)
	  int val2 = paramMap.getInteger("key2")
	  
	- 특정한 키를 부여 시 동적으로 반환타입을 고려하여 반환하는 함수
	  StringBuffer sb = new StringBuffer();
	  sb.append("test");
	  paramMap.put("key3", sb);
	  
	  StringBuffer val3 = paramMap.get("key3", StringBuffer.class)
*/

public class ParamMap {
	private ParamMap() {}
	public ParamMap init() {
		return new ParamMap();
	}
	

}
