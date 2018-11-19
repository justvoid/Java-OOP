package net.ukr.just_void;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Map<Character,String[]> charMap = new HashMap<>();
		fillCharMap(charMap, generateAsciiArray());
		drawText(textInput(), charMap);
	}
	
	public static void fillCharMap(Map<Character,String[]> charMap, String[][] asciiArr) {
		for (int i = 0; i < 26; i++) {
			charMap.put((char)('a' + i), asciiArr[i]);
		}
	}
	
	public static String textInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text:");
		return sc.nextLine();
	}
	
	public static void drawText(String str, Map<Character,String[]> charMap) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String[]> chars = str.toLowerCase()
									.chars()
									.mapToObj(n -> (Character.valueOf((char) n)))
									.map(n -> n == ' '?getSpace():charMap.get(n))
									.collect(Collectors.toCollection(ArrayList::new));
		
		for (int i = 0; i < 5; i++) {
			for (String[] strings : chars) {
				sb.append(strings[i]).append("  ");
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}
	
	public static String[][] generateAsciiArray() {
		String[][] arr = new String[26][5];
		arr[0] = getA();
		arr[1] = getB();
		arr[2] = getC();
		arr[3] = getD();
		arr[4] = getE();
		arr[5] = getF();
		arr[6] = getG();
		arr[7] = getH();
		arr[8] = getI();
		arr[9] = getJ();
		arr[10] = getK();
		arr[11] = getL();
		arr[12] = getM();
		arr[13] = getN();
		arr[14] = getO();
		arr[15] = getP();
		arr[16] = getQ();
		arr[17] = getR();
		arr[18] = getS();
		arr[19] = getT();
		arr[20] = getU();
		arr[21] = getV();
		arr[22] = getW();
		arr[23] = getX();
		arr[24] = getY();
		arr[25] = getZ();
		return arr;
	}
	
	public static String[] getA() {
		return new String[]	{	"  *  ",
								" * * ",
								"*   *", 
								"*****",
								"*   *" };
	}
	
	public static String[] getB() {
		return new String[]	{	"**** ",
								"*   *",
								"**** ", 
								"*   *",
								"**** " };
	}
	
	public static String[] getC() {
		return new String[]	{	" ****",
								"*    ",
								"*    ", 
								"*    ",
								" ****" };
	}
	
	public static String[] getD() {
		return new String[]	 {	"**** ",
								"*   *",
								"*   *", 
								"*   *",
								"**** " };
	}
	
	public static String[] getE() {
		return new String[]	{	"*****",
								"*    ",
								"***  ", 
								"*    ",
								"*****" };

	}
	
	public static String[] getF() {
		return new String[]	{	"*****",
								"*    ",
								"***  ", 
								"*    ",
								"*    " };
	}
	public static String[] getG() {
		return new String[]	{	" ****",
								"*    ",
								"*  **", 
								"*   *",
								" ****" };
	}
	public static String[] getH() {
		return new String[] {	"*   *",
								"*   *",
								"*****", 
								"*   *",
								"*   *" };		

	}
	public static String[] getI() {
		return new String[]	{	"*****",
								"  *  ",
								"  *  ", 
								"  *  ",
								"*****" };
	}
	public static String[] getJ() {
		return new String[]	{	"*****",
								"   * ",
								"   * ", 
								"*  * ",
								" **  " };
	}
	public static String[] getK() {
		return new String[]	{	"*   *",
								"*  * ",
								"***  ", 
								"*  * ",
								"*   *" };
	}
	public static String[] getL() {
		return new String[]	{	"*    ",
								"*    ",
								"*    ", 
								"*    ",
								"*****" };
	}
	public static String[] getM() {
		return new String[]	{	"*   *",
								"** **",
								"* * *", 
								"*   *",
								"*   *" };
	}
	public static String[] getN() {
		return new String[]	{	"*   *",
								"**  *",
								"* * *", 
								"*  **",
								"*   *" };
	}
	public static String[] getO() {
		return new String[]	{	" *** ",
								"*   *",
								"*   *", 
								"*   *",
								" *** " };
	}
	public static String[] getP() {
		return new String[]	{	"**** ",
								"*   *",
								"**** ", 
								"*    ",
								"*    " };
	}
	public static String[] getQ() {
		return new String[]	{	" *** ",
								"*   *",
								"* * *", 
								"*  * ",
								" ** *" };
	}
			
	public static String[] getR() {
		return new String[]	{	"**** ",
								"*   *",
								"**** ", 
								"*   *",
								"*   *" };
	}
			
	public static String[] getS() {
		return new String[]	{	" ****",
								"*    ",
								" *** ", 
								"    *",
								"**** " };
	}
			
	public static String[] getT() {
		return new String[]	{	"*****",
								"  *  ",
								"  *  ", 
								"  *  ",
								"  *  " };
	}
			
	public static String[] getU() {
		return new String[]	{	"*   *",
								"*   *",
								"*   *", 
								"*   *",
								" *** " };
	}
			
	public static String[] getV() {
		return new String[]	{	"*   *",
								"*   *",
								"*   *", 
								" * * ",
								"  *  " };
	}
			
	public static String[] getW() {
		return new String[]	{	"*   *",
								"*   *",
								"* * *", 
								"** **",
								"*   *" };
	}
			
	public static String[] getX() {
		return new String[]	{	"*   *",
								" * * ",
								"  *  ", 
								" * * ",
								"*   *" };
	}
			
	public static String[] getY() {
		return new String[]	{	"*   *",
								" * * ",
								"  *  ", 
								"  *  ",
								"  *  " };
	}
			
	public static String[] getZ() {
		return new String[]	{	"*****",
								"   * ",
								"  *  ", 
								" *   ",
								"*****" };
	}
	
	public static String[] getSpace() {
		return new String[]	{	"     ",
								"     ",
								"     ", 
								"     ",
								"     " };
	}
			
			
}

