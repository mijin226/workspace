package condingTest;
public class Test {
	public static void main(String[] args) {
		String word = "  strawberry cake "; // 	문자열로 변환할 String 값
		
		char[] charArray1 = word.toCharArray(); // 	String(word)형태에서 Char(알파벳)로 변환
		for (int i = 0; i < charArray1.length; i++) {				
			System.out.println("charArray1 ["+ i +"] : " + charArray1[i]); //	N번째 인덱스의 값 출력
		}
		System.out.println(charArray1);
		
		char[] charArray2 = word.trim().toCharArray(); // 	String(word)형태에서 Char(알파벳)로 변환
		for (int i = 0; i < charArray2.length; i++) {				
			System.out.println("charArray2 ["+ i +"] : " + charArray2[i]); //	N번째 인덱스의 값 출력
		}
		System.out.println(charArray2);
	}
}